package com.example.android.testsugarorm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.testsugarorm.R;
import com.example.android.testsugarorm.entities.Profile;
import com.example.android.testsugarorm.utils.StringUtils;

import java.util.List;

/**
 * Project: TestORM
 *
 * @package: com.example.android.testsugarorm
 * <p>
 * Created by Sven on 10.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */
public class ProfileAdapter extends ArrayAdapter<Profile> {

    /**
     * Constructs a new {@link ProfileAdapter}.
     * @param context
     * @param profiles
     */
    public ProfileAdapter(Context context, List<Profile> profiles) {
        super(context,0, profiles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.profile_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Profile currentProfile = getItem(position);

        TextView profileIconView = (TextView) listItemView.findViewById(R.id.profile_icon);

        String profileLetters = StringUtils.getFirstLetters(currentProfile.getName());

        profileIconView.setText(profileLetters);


        TextView nameView = (TextView) listItemView.findViewById(R.id.profile_name);
        nameView.setText(currentProfile.getName());
        TextView descriptionView = (TextView) listItemView.findViewById(R.id.profile_description);
        descriptionView.setText(currentProfile.getDescription());




        return listItemView;
    }

    public void getProfileColor() {}
}
