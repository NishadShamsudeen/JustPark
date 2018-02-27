package com.example.android.justpark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.Console;

public class SelectionSpecific extends AppCompatActivity {


    WebView webView;

    FetchDetails fetchDetails = new FetchDetails();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_specific);
        webView = (WebView)findViewById(R.id.MyWebView2);
        webView.loadUrl("file:///android_asset/www/index.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.addJavascriptInterface(fetchDetails,"ob");
        webView.setWebChromeClient(new WebChromeClient());


    }



    public class FetchDetails{
        @android.webkit.JavascriptInterface
        public void fetchString(String name,String counter){

            String name1 = name;
            String count = counter;
            if (name1.isEmpty()){
                Toast.makeText(SelectionSpecific.this,"Select atleast 1 slot",Toast.LENGTH_LONG).show();

            }else {

                Intent intent = new Intent(SelectionSpecific.this,SummeryPage.class);
                startActivity(intent);
                //Toast.makeText(SelectionSpecific.this,count,Toast.LENGTH_LONG).show();
                //int result = Integer.parseInt(count);
                //Toast.makeText(SelectionSpecific.this,String.valueOf(result),Toast.LENGTH_LONG).show();
                //Log.v("message",name1);

            }

            //Toast.makeText(SelectionSpecific.this,name1,Toast.LENGTH_LONG).show();
        }

        }
    }




