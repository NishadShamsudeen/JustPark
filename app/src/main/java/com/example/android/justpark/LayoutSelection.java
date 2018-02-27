package com.example.android.justpark;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LayoutSelection extends AppCompatActivity {
    FragmentManager fragmentManager;
    Fragment fragment;
    String mallname,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_selection);
        Bundle bundle = getIntent().getExtras();
        mallname = bundle.getString("mallkey");
        location = bundle.getString("locationkey");
        //Toast.makeText(getApplicationContext(),location,Toast.LENGTH_SHORT).show();
        Bundle bundle1 = new Bundle();
        bundle1.putString("mallnamekey",mallname);
        bundle1.putString("locationnamekey",location);
        Baement1 baement1 = new Baement1();
        baement1.setArguments(bundle1);
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_switch,baement1,baement1.getTag()).commit();
    }

    public void ChangeFragment(View view){
        switch (view.getId()){
            case R.id.b1:
                Baement1 baement1 = new Baement1();
                Bundle bundle1 = new Bundle();
                bundle1.putString("mallnamekey",mallname);
                bundle1.putString("locationnamekey",location);
                baement1.setArguments(bundle1);
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_switch,baement1,baement1.getTag()).commit();

                break;


            case R.id.b2:
                Basement2 basement2 = new Basement2();
                Bundle bundle2 = new Bundle();
                bundle2.putString("mallnamekey",mallname);
                basement2.setArguments(bundle2);
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_switch,basement2,basement2.getTag()).commit();

                break;


            case R.id.b3:
                GroundFloor groundFloor = new GroundFloor();
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_switch,groundFloor,groundFloor.getTag()).commit();
                break;
        }



    }
}
