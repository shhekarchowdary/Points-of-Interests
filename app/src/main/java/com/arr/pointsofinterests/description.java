package com.arr.pointsofinterests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class description extends AppCompatActivity {

    ImageView mImageView1,mImageView2;
    TextView mTextViewDescription;
    Button mButton;
    public String imgSelected,imgUnSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        mImageView1 = findViewById(R.id.imageView1);
        mImageView2 = findViewById(R.id.imageView2);
        mTextViewDescription = findViewById((R.id.txtDescription));
        mButton = findViewById(R.id.btnBack);

        imgSelected = MainActivity.imgSelected;
        imgUnSelected = MainActivity.imgUnSelected;

        setTitle(MainActivity.poiSelected.getName());

        int res1 = getResources().getIdentifier(imgSelected,"drawable",getPackageName());
        mImageView1.setTag(imgSelected);
        mImageView1.setImageResource(res1);

        int res2 = getResources().getIdentifier(imgUnSelected,"drawable",getPackageName());
        mImageView2.setTag(imgUnSelected);
        mImageView2.setImageResource(res2);

        mTextViewDescription.setText(MainActivity.poiSelected.getDescription());

        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strSmall = (String) mImageView2.getTag();
                String strBig = (String) mImageView1.getTag();
                int res1 = getResources().getIdentifier(strSmall,"drawable",getPackageName());
                int res2 = getResources().getIdentifier(strBig,"drawable",getPackageName());
                mImageView1.setTag(strSmall);
                mImageView2.setTag(strBig);
                mImageView1.setImageResource(res1);
                mImageView2.setImageResource(res2);
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });



    }
}