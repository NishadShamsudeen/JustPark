package com.example.android.justpark;

import android.app.*;
import android.app.ListFragment;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.MapFragment;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    LinearLayout linearLayout;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = new HomeFragment();
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.contentLayout,homeFragment,homeFragment.getTag()).commit();
                    return true;

                case R.id.navigation_profile:
                    Profile profile = new Profile();
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.contentLayout,profile,profile.getTag()).commit();
                    return true;
                case R.id.navigation_setting:
                    Setting setting = new Setting();
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.contentLayout,setting,setting.getTag()).commit();
                    return true;




            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeFragment homeFragment = new HomeFragment();
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contentLayout,homeFragment,homeFragment.getTag()).commit();
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
