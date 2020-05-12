package com.example.RockPaperScissor;


import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class PopUp extends AppCompatActivity {
TextView textView;

Button button,button1;
//String playername,player1name,playervalue,player1value;
MediaPlayer mediaPlayer,mediaPlayer1;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pop_up);
        super.onCreate(savedInstanceState);

        final Intent intent=getIntent();
        final String playername=intent.getStringExtra("playername");
       final String player1name=intent.getStringExtra("player1name");
        final String playervalue=intent.getStringExtra("playervalue");
       final  String player1value=intent.getStringExtra("player1value");
        textView= findViewById(R.id.playerWon);
        Animation shake= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.text1shake);
        textView.setAnimation(shake);

        button=findViewById(R.id.buttonnext);
        final MediaPlayer mediaPlayer= MediaPlayer.create(PopUp.this,R.raw.crackers);
        mediaPlayer.start();
        final MediaPlayer mediaPlayer1= MediaPlayer.create(PopUp.this,R.raw.pungi);
        mediaPlayer1.start();
        /*
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.start();
            }
        });

        mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer1.start();
            }
        });*/



        assert playervalue != null;
        assert player1value != null;

        switch (player1value) {
            case "Rock✊":
                if (player1value.equals(playervalue))
                {
                    textView.setText("Draw");
                    break;
                }
                       else if (playervalue.equals("Paper✋")) {
                             assert playername != null;
                              textView.setText(playername.concat(" Won"));
                              break;
                }
                            else if (playervalue.equals("Scissor✌️")) ;
                                 {
                                    assert player1name != null;
                                   textView.setText(player1name.concat(" Won"));
                                   break;
                                           }

            case "Paper✋":
                if (player1value.equals(playervalue))
                {
                    textView.setText("Draw");
                    break;
                }
                           else  if (playervalue.equals("Rock✊")) {
                                    assert player1name != null;
                                 textView.setText(player1name.concat(" Won"));
                                 break;
                             } else if (playervalue.equals("Scissor✌️")) {
                                        assert playername != null;
                                textView.setText(playername.concat(" Won"));
                                 break;
                                 }

            case "Scissor✌️":
                if (player1value.equals(playervalue))
                {
                    textView.setText("Draw");
                    break;
                }
                else if (playervalue.equals("Rock✊")) {
                    assert playername != null;
                    textView.setText(playername.concat(" Won"));
                    break;
                } else if (playervalue.equals("Paper✋")) {
                    assert player1name != null;
                    textView.setText(player1name.concat(" Won"));
                    break;
                }


        }





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(PopUp.this,Next.class);
                intent1.putExtra("playername",playername);
                intent1.putExtra("player1name",player1name);
                startActivity(intent1);

            }
        });



        button1=findViewById(R.id.exit);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });


    }
    @Override
    public void onBackPressed() {

    }

}

