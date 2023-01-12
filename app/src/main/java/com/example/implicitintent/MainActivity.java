package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;


    @SuppressLint("IntentReset")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn1);

        Intent intent=new Intent(Intent.ACTION_SEND);
        final Intent chooser;

        intent.setData(Uri.parse("mailto:"));
        // intent.setData(Uri.parse("tel:(+94)77123456"));//to open sms
        //intent.setData(Uri.parse("geo:50.123,7.1434?z=19"));//to open map
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"Example@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,"This is subject");
        intent.putExtra(Intent.EXTRA_TEXT,"This is message");
        intent.setType("text/plain");
        chooser = Intent.createChooser(intent,"Choose your email APP");

        // intent.setData(Uri.parse("tel:(+94)77123456"));//to open sms
        //intent.setData(Uri.parse("geo:50.123,7.1434?z=19"));//to open map

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(chooser);

            }
        });
    }
}