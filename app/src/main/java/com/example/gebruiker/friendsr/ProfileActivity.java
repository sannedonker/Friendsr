package com.example.gebruiker.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // set the correct image, name and bio of the clicked_friend to the profile
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");
        ((ImageView) findViewById(R.id.PhotoFriendProfile)).setImageResource(retrievedFriend.getDrawableId());
        ((TextView) findViewById(R.id.NameFriendProfile)).setText(retrievedFriend.getName());
        ((TextView) findViewById(R.id.BioFriendProfile)).setText(retrievedFriend.getBio());

        // get the preferences which are saved in RatingBarChangeListener
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float saved_float = prefs.getFloat(retrievedFriend.getName(), 0);

        // if the friend is rated before set the rating to that value, else the rating default is 0
        if (saved_float != null) {
            RatingBar ratingbar = findViewById(R.id.ratingBar);
            ratingbar.setRating(saved_float);
            ratingbar.setOnRatingBarChangeListener(new RatingBarChangeListener());
        }
    }

    // safe the value of the rating when the rating is changed
    private class RatingBarChangeListener implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(retrievedFriend.getName(), ratingBar.getRating());
            editor.apply();
        }
    }

}
