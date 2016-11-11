package com.example.android.testsugarorm;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.testsugarorm.entities.Profile;

public class EditActivity extends AppCompatActivity {

    LinearLayout colorList;
    HorizontalScrollView colorScroll;

    Profile profile;

    EditText mProfileName;
    EditText mProfileDescription;
    EditText mProfileUrl;
    EditText mProfileApiKey;
    EditText mProfileSecret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        profile = new Profile();

        colorScroll = (HorizontalScrollView) findViewById(R.id.colorScroll);

        // Find all relevant views that we will need to read user input from
        mProfileName = (EditText) findViewById(R.id.input_profile_name);
        mProfileDescription = (EditText) findViewById(R.id.input_profile_description);
        mProfileApiKey = (EditText) findViewById(R.id.input_profile_apikey);
        mProfileSecret = (EditText) findViewById(R.id.input_profile_secret);
        mProfileUrl = (EditText) findViewById(R.id.input_profile_url);

        setupColorChooser();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    /**
     * This method is called after invalidateOptionsMenu(), so that the
     * menu can be updated (some menu items can be hidden or made visible).
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Delete Action
            case R.id.action_delete:
                deleteProfile();
                return true;
            // Save action
            case R.id.action_save:
                saveProfile();
                NavUtils.navigateUpFromSameTask(EditActivity.this);
                return true;
            // Return to MainActivity
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(EditActivity.this);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void saveProfile(){

        String name = mProfileName.getText().toString().trim();
        String description = mProfileDescription.getText().toString().trim();
        String url = mProfileUrl.getText().toString().trim();
        String apiKey = mProfileApiKey.getText().toString().trim();
        String secret = mProfileSecret.getText().toString().trim();

        profile.setName(name);
        profile.setDescription(description);
        profile.setUrl(url);
        profile.setApiKey(apiKey);
        profile.setSecret(secret);
        profile.save();

        Toast.makeText(this,"Profile: " + name + " saved successfully!",Toast.LENGTH_SHORT).show();
    }

    public void deleteProfile(){
        //TODO delete profile

        Toast.makeText(this,"Delete profile pressed",Toast.LENGTH_SHORT).show();
    }


    private void scrollToColor(int color){
        int index = 0;
        for(int i = 0; i < COLORS.length; i++ ){
            if(color == Color.parseColor(COLORS[i])){
                index = i;
                break;
            }
        }
        int width = colorList.getChildAt(0).getWidth();
        colorScroll.smoothScrollTo(width*index + width/2 - colorScroll.getWidth()/2 ,0);
    }

    private void setupColorChooser(){
        colorList = (LinearLayout) findViewById(R.id.color_chooser);
        colorList.removeAllViews();

        for(final String hex : COLORS){
            ImageView colorView = (ImageView) getLayoutInflater().inflate(R.layout.color_chooser_item, null);
            final int color = Color.parseColor(hex);
            colorView.setBackgroundColor(color);
            colorView.setPadding(2, 2, 2, 2);
            colorView.setMinimumHeight(80);
            colorView.setMinimumWidth(80);

            if(color == profile.getColor()) {
                // Selected profile color
                colorView.setImageResource(R.drawable.ic_done_white_36dp);
                Log.v("EditActivity", "Selected Color: " + color);

            }else {
                colorView.setImageResource(android.R.color.transparent);
            }

            colorView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    profile.setColor(color);
                    Log.v("EditActivity", "ProfileSetColor: " + color);

                    setupColorChooser();
                    int x = (int) view.getX() + view.getWidth()/2 - colorScroll.getScrollX();
                    colorList.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            scrollToColor(color);
                        }
                    },300);
                }
            });

            colorList.addView(colorView);
        }
    }


    public static final String[] COLORS = new String[]{
            "#1976d2",
            "#1abc9c",
            "#16a085",
            "#f1c40f",
            "#f39c12",
            "#2ecc71",
            "#27ae60",
            "#e67e22",
            "#d35400",
            "#c0392b",
            "#e74c3c",
            "#2980b9",
            "#3498db",
            "#9b59b6",
            "#8e44ad",
            "#2c3e50",
            "#34495e"
    };
}