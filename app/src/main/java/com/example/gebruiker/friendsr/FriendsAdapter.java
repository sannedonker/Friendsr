package com.example.gebruiker.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter {

    private ArrayList<Friend> friends;

    // set the list in the adapter
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // loads new items
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // get the photo and name of the items which are shown
        Friend current_friend = friends.get(position);
        ((ImageView) convertView.findViewById(R.id.PhotoFriend)).setImageResource(current_friend.getDrawableId());
        ((TextView) convertView.findViewById(R.id.NameFriend)).setText(current_friend.getName());

        return convertView;
    }
}

