package com.example.android.justpark;


import android.app.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    LinearLayout linearLayout;
    FragmentManager fragmentManager;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.book);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MallListFragment listMalls = new MallListFragment();
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contentLayout,listMalls,listMalls.getTag()).commit();
            }
        });


        return view;
    }

}
