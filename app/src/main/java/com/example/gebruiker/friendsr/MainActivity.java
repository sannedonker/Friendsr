package com.example.gebruiker.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // initiate a list of friends
    ArrayList<Friend> friends = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add friends to the list friends
        friends.add(new Friend("Arya", "Hi, I'm Arya",
                getResources().getIdentifier("arya", "drawable", getPackageName())));
        friends.add(new Friend("Johan", "Ik heb totaal geen affiniteit met Congo",
                getResources().getIdentifier("johan","drawable", getPackageName())));
        friends.add(new Friend("Annemijn", "Ik ben even zwaar als een ijsbeer",
                getResources().getIdentifier("annemijn","drawable", getPackageName())));
        friends.add(new Friend("Mansam", "Op weekenddagen schreeuw ik graag naar Daantjes die als koala's in de boom hangen",
                getResources().getIdentifier("mansam","drawable", getPackageName())));
        friends.add(new Friend("Sam", "Stiekem ben ik veel ondeugender dan ik lijk",
                getResources().getIdentifier("sam","drawable", getPackageName())));
        friends.add(new Friend("Rebecca", "Ohhhh dat vind ik echt heeeul LEUK",
                getResources().getIdentifier("rebecca","drawable", getPackageName())));
        friends.add(new Friend("Mendel", "Ho, dat gaan we niet doen he",
                getResources().getIdentifier("mendel","drawable", getPackageName())));
        friends.add(new Friend("Renske", "Ik ga nog wel mee uit hoor maar doe toch alvast mijn lenzen uit",
                getResources().getIdentifier("renske","drawable", getPackageName())));
        friends.add(new Friend("Tess", "Sanne je heb echt slechte muziek smaak",
                getResources().getIdentifier("tess","drawable", getPackageName())));

        // instantiate the adapter and attach the adapter to the gridview
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gv = findViewById(R.id.GridView);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new GridItemClickListener());

    }

    // get the position and information of the item that is clicked
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }


}
