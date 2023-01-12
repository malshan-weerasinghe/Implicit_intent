package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText email,subject,message;

    @SuppressLint("IntentReset")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //xml references(Linking widets to java)
        button=findViewById(R.id.btn1);
        email=findViewById(R.id.txtEmail);
        subject=findViewById(R.id.txtSubject);
        message=findViewById(R.id.txtMessege);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = email.getText().toString();
                String Sub = subject.getText().toString();
                String Msg = message.getText().toString();

                Intent intent=new Intent(Intent.ACTION_SEND);//creating a intent and set a action
                Intent chooser;

                intent.setData(Uri.parse("mailto:"));//setting the data
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{mail});//Extra Details
                intent.putExtra(Intent.EXTRA_SUBJECT,Sub);
                intent.putExtra(Intent.EXTRA_TEXT,Msg);

                intent.setType("message/rfc822");//
                chooser = Intent.createChooser(intent,"Choose your email APP");//to create  choosing list

                startActivity(chooser);

            }
        });


    }
}