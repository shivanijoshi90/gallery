package com.shivani.cameragallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    Button btngallery;

    ImageView imgImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngallery = findViewById(R.id.btngallery);

        imgImage = findViewById(R.id.imgImage);

        btngallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

                intent.setType("image/*");

                startActivityForResult(intent,12);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 12){
            if(requestCode == 12){
                Uri uri = data.getData();
                imgImage.setImageURI(uri);
            }
        }
    }
}