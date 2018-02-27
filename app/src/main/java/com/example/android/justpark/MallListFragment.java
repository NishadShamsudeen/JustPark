package com.example.android.justpark;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LENOVO on 23-08-2017.
 */

public class MallListFragment extends ListFragment {

    int[] IMAGES = {R.drawable.lulumall,R.drawable.centre,R.drawable.oberonmall,R.drawable.nucleusmall1};
    String[] NAMES = {"Lulu Mall","Central Mall","Oberon Mall","Nucleus Mall"};
    String[] DESCRIPTION = {"This is sample","This is sample","This is sample","This is sample"};
    String[] LOCATION = {"Edapalli,Kochi","Kaloor,Kochi","Edapalli,Kochi","Marine drive"};
    String[] TYPE = {"Type: Mall","Type: Mall","Type: Mall","Type: Mall"};

    ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
    SimpleAdapter simpleAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HashMap<String,String> map = new HashMap<String, String>();
        for (int i=0;i<NAMES.length;i++)
        {
            map = new HashMap<String, String>();
            map.put("Name",NAMES[i]);
            map.put("Image",Integer.toString(IMAGES[i]));
            map.put("Description",DESCRIPTION[i]);
            map.put("Location",LOCATION[i]);
            map.put("Type",TYPE[i]);
            data.add(map);
        }

        String[] from = {"Name","Image","Description","Location","Type"};
        int[] to = {R.id.mall_name,R.id.lulu_image,R.id.mall_description,R.id.mall_location,R.id.mall_type};

        simpleAdapter =new SimpleAdapter(getActivity(),data,R.layout.custom_layout,from,to);
        setListAdapter(simpleAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getActivity(),data.get(i).get("Name"),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),LayoutSelection.class);
                intent.putExtra("mallkey",NAMES[i]);
                intent.putExtra("locationkey",LOCATION[i]);
                startActivity(intent);


            }
        });
    }
}
