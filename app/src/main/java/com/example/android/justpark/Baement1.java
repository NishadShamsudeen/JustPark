package com.example.android.justpark;


import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Baement1 extends Fragment {
    WebView webView;
    TextView t1,t2,mallnametv,locationtv;
    LinearLayout l1,l2;
    int day,month,year,hour,minute;
    int counter;
    int dayFinal,monthFinal,yearFinal,hourFinal,minuteFinal;
    String mallname,location,date;
    long mMinReturnDate,mTime=0;


    public Baement1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view =  inflater.inflate(R.layout.fragment_baement1, container, false);
        CalculateObject calculateObject = new CalculateObject();


        webView = (WebView)view.findViewById(R.id.MyWebView);
        mallnametv = (TextView)view.findViewById(R.id.mallname);
        locationtv = (TextView)view.findViewById(R.id.malllocation);
        t1 = (TextView)view.findViewById(R.id.crnt_time);
        t2 = (TextView)view.findViewById(R.id.crnttimeplus1);
        l1 = (LinearLayout)view.findViewById(R.id.time1);
        l2 = (LinearLayout)view.findViewById(R.id.time2);
        Calendar calendar =Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM,HH:mm");
        t1.setText(simpleDateFormat.format(calendar.getTime()));
        calendar.add(Calendar.HOUR,1);
        t2.setText(simpleDateFormat.format(calendar.getTime()));
        //l1.setOnClickListener(showDataPicker);
        //l2.setOnClickListener(showDataPicker);

        mallname = getArguments().getString("mallnamekey");
        location = getArguments().getString("locationnamekey");
        mallnametv.setText(mallname);
        locationtv.setText("Location: "+location);

        webView.loadUrl("file:///android_asset/www/demoajax.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.addJavascriptInterface(calculateObject,"ob");
        webView.setWebChromeClient(new WebChromeClient());





        return view;
    }









    private static String formatDate(int year,int month,int day,int hour,int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(year,month,day,hour,minute);
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM,HH:mm");
        return simpleDateFormat.format(date);


    }

    public class CalculateObject{
        @android.webkit.JavascriptInterface
        public void calculateSum(String name){

            String name1 = name;
            //Toast.makeText(getActivity(),name,Toast.LENGTH_SHORT).show();
            switch (name) {
                case "div1":
                    Intent intent = new Intent(getActivity(),SelectionSpecific.class);
                    startActivity(intent);
                    break;
                case "div2":
                    Toast.makeText(getActivity(),"div2",Toast.LENGTH_SHORT).show();
                    break;
                    //Intent intent2 = new Intent(getActivity(),SelectionSpecific.class);
                    //startActivity(intent2);
                case "div3":
                    Intent intent3 = new Intent(getActivity(),SelectionSpecific.class);
                    startActivity(intent3);
                    break;
                case "div4":
                    Intent intent4 = new Intent(getActivity(),SelectionSpecific.class);
                    startActivity(intent4);
                    break;
                case "div5":
                    Intent intent5 = new Intent(getActivity(),SelectionSpecific.class);
                    startActivity(intent5);
                    break;
            }



            //Log.d("MYINT", "value: " + num);

        }
    }

}
