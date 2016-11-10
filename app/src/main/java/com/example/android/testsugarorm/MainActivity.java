package com.example.android.testsugarorm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.testsugarorm.entities.Profile;
import com.orm.query.Select;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /** Adapter for the list of earthquakes */
    private ProfileAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
            }

        });

        ArrayList<Profile> profiles = (ArrayList<Profile>) Select.from(Profile.class).list();


        // Find a reference to the {@link ListView} in the layout
        ListView profilesListView = (ListView) findViewById(R.id.list);

        mAdapter = new ProfileAdapter(this, profiles);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        profilesListView.setAdapter(mAdapter);
        //displayCount();
    }

    public void displayCount(){
        long numberOfProfiles = Profile.count(Profile.class, null, null);

        String count = Long.toString(numberOfProfiles);
        TextView textView = (TextView) findViewById(R.id.text_no);
        textView.setText(count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_add_demo:
                createProfiles();
                displayCount();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void createProfiles() {
        Profile p = new Profile();

        p.setName("Sven Ilenco");
        p.setDescription("Sven Descriptions ");
        p.setUrl("http://something.com");
        p.setApiKey("APIKEY12983209840932");
        p.setSecret("SECRET12983209840932");
        //p.setSecret("SECRET12983209840932");
        p.save();
    }
}
