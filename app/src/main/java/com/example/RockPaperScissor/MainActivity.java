package com.example.RockPaperScissor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Animation Shake;
    ImageView imageView1,imageView2,imageView3;
    Button b1;
    MediaPlayer mysong;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Rock_Paper_Scissor");
        setContentView(R.layout.activity_main);
        imageView1=(ImageView)findViewById(R.id.buttonimage1);
        imageView2=(ImageView)findViewById(R.id.buttonimage2);
        imageView3=(ImageView)findViewById(R.id.buttonimage3);
        imageView1.setImageResource(R.drawable.scissor01);
        imageView2.setImageResource(R.drawable.rock01);
        imageView3.setImageResource(R.drawable.paper02);
        b1=findViewById(R.id.button1);


      Animation shake= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake);
      imageView1.setAnimation(shake);
      imageView2.setAnimation(shake);
        imageView3.setAnimation(shake);
        b1.setAnimation(shake);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,welcome.class);
                startActivity(intent);

            }
        });


        mysong=MediaPlayer.create(MainActivity.this,R.raw.rock);

        mysong.setOnCompletionListener(new MediaPlayer.OnCompletionListener()// to play mp3 continously
        {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mysong.start();
            }
        });
        mysong.start();

            }



    @Override
    protected void onPause() {
        super.onPause();
        mysong.release();
    }

}
