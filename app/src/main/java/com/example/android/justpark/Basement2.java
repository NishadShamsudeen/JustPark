package com.example.android.justpark;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Basement2 extends Fragment {
    TextView twohours,twoplus,moreday;
    String mallname;


    public Basement2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_basement2, container, false);
        twohours = (TextView)view.findViewById(R.id.datefrom);
        twoplus = (TextView)view.findViewById(R.id.dateuntil);
        moreday = (TextView)view.findViewById(R.id.duration_hrs);
        mallname = getArguments().getString("mallnamekey");
        Toast.makeText(getActivity(),mallname,Toast.LENGTH_SHORT).show();

        //Toast.makeText(getActivity(),name,Toast.LENGTH_SHORT).show();




        return view;
    }

}
