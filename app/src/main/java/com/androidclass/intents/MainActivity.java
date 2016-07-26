package com.androidclass.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity  implements View.OnClickListener{


    Button btn1, btn2, btn3, btn4, btn5, btn6,btn7;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button_1);
        btn2 = (Button) findViewById(R.id.button_2);
        btn3 = (Button) findViewById(R.id.button_3);
        btn4 = (Button) findViewById(R.id.button_4);
        btn5 = (Button) findViewById(R.id.button_5);
        btn6 = (Button) findViewById(R.id.button_6);
        btn7 = (Button) findViewById(R.id.button_7);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch(view.getId()) {

            case R.id.button_1:
                // view in a browser
                i = new Intent(android.content.Intent.ACTION_VIEW);
	            i.setData(Uri.parse("http://www.google.com"));
	            startActivity(i);

                break;
            case R.id.button_2:
                // send a message
                i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Subject...");
                i.putExtra(Intent.EXTRA_TEXT, "Text...");
                startActivity(Intent.createChooser(i, "Apps that can respond to this"));

                break;
            case R.id.button_3:
                // send an email
                i = new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("mailto:"));
                String[] to = { "someone1@example.com" , "someone2@example.com" };
                i.putExtra(Intent.EXTRA_EMAIL, to);
                i.putExtra(Intent.EXTRA_SUBJECT, "Subject here...");
                i.putExtra(Intent.EXTRA_TEXT, "Message here...");
                i.setType("message/rfc822");
                startActivity(Intent.createChooser(i, "Email"));
                break;
            case R.id.button_4:
                //show on a map
                double latitude = 40.714728;
                double longitude = -73.998672;
                String label = "Some Label";
                String uriBegin = "geo:" + latitude + "," + longitude;
                String query = latitude + "," + longitude + "(" + label + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                i = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(i);

                break;
            case R.id.button_5:
                // show an image file - a valid image needs to be present at the path

                i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setDataAndType(Uri.parse("file:///storage/sdcard0/MyPhoto.jpg"), "image/*");
                startActivity(i);

                break;
            case R.id.button_6:
                //implicit intent
                i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.google.com"));
                startActivity(i);
                break;

            case R.id.button_7:
                // explicit intent
                i = new Intent(this, MainActivity2.class);
                startActivity(i);
                break;
            default:
                break;


        }
    }
}