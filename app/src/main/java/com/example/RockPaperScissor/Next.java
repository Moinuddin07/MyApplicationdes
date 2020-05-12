package com.example.RockPaperScissor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Next extends AppCompatActivity  {
Button button,button2;
 String selectedValue="";
TextView textView,textView1, textView3,textView4;
Intent intent,intent1;
Animation shake;
int rounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.nextlayout);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        final Animation shake= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.buttonshake);

        final Intent intent=getIntent();
        final String playername=intent.getStringExtra("playername");
        textView3=(TextView)findViewById(R.id.playertextView);
        textView3.setAnimation(shake);
        textView3.setText(playername);


        final String player1name=intent.getStringExtra("player1name");
        textView4=(TextView)findViewById(R.id.playertextView1);
        textView4.setAnimation(shake);
        textView4.setText(player1name);

        final Animation shake1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.textshake);
        final Animation shake2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.text2shake);
        button2.setAnimation(shake2);
        button.setAnimation(shake1);

        textView= findViewById(R.id.textView3);
        textView1= findViewById(R.id.textView4);

button2.setEnabled(false);
        final MediaPlayer mediaPlayer= MediaPlayer.create(Next.this,R.raw.buttonpush);
        final MediaPlayer mediaPlayer1=MediaPlayer.create(Next.this,R.raw.rockselected);
        final MediaPlayer mediaPlayer2=MediaPlayer.create(Next.this,R.raw.paperselected);
        final MediaPlayer mediaPlayer3=MediaPlayer.create(Next.this,R.raw.scissorselected);
        Random random= new Random();
       final String selectedValue=generator(random);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {

                textView.setText(selectedValue);

                mediaPlayer.start();

                if(selectedValue.equals("Rock✊"))
                {
                    mediaPlayer1.start();

                }
                else if(selectedValue.equals("Paper✋"))
                {
                    mediaPlayer2.start();

                }
                else if (selectedValue.equals("Scissor✌️"))
                {
                    mediaPlayer3.start();

                }
                button.setEnabled(false);

button2.setEnabled(true);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {

                Random random= new Random();
                final String selectedValue1=generator(random);
                textView1.setText(selectedValue1);

                mediaPlayer.start();


                if(selectedValue1.equals("Rock✊"))
                {
                    mediaPlayer1.start();

                }
                else if(selectedValue1.equals("Paper✋"))
                {
                    mediaPlayer2.start();

                }
                else if(selectedValue1.equals("Scissor✌️"))
                {
                    mediaPlayer3.start();

                }
                button2.setEnabled(false);

                Handler mHandler= new Handler();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent1=new Intent(Next.this,PopUp.class);

                        intent1.putExtra("playervalue",selectedValue);
                        intent1.putExtra("player1value",selectedValue1);
                        intent1.putExtra("player1name",player1name);
                        intent1.putExtra("playername",playername);
                        startActivity(intent1);}

                    },5000L);


             }
                 });


    }

    @Override
    public void onBackPressed() {

    }


    Random random= new Random();
    public static  String generator(Random random)
    {
        int wordrandom=  random.nextInt(3)+1;
        String playerselected=null;
        if(wordrandom==1)
        {
            playerselected="Rock✊";
        }
        else if (wordrandom==2)
        {
            playerselected="Paper✋";
        }
        else if(wordrandom==3)
        {
            playerselected="Scissor✌️";
        }
        return playerselected;
    }

}
