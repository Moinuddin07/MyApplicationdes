package com.example.RockPaperScissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class welcome extends AppCompatActivity {
Button button1, button2;
MediaPlayer mysong;
EditText editText,editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        button1=findViewById(R.id.button3);

        editText=(EditText)findViewById(R.id.editText) ;

        editText1=(EditText)findViewById(R.id.editText1);
        final MediaPlayer mediaPlayer= MediaPlayer.create(welcome.this,R.raw.welcome);
        mediaPlayer.start();

       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (editText.equals("")|| editText.length()==0|| editText==null||editText1.equals("")|| editText1.length()==0|| editText1==null)
               {
                   Toast toast=Toast.makeText(welcome.this,"Enter Player Name",Toast.LENGTH_LONG);
                   toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
                   toast.show();
               }
               else
                   {

                           Intent intent = new Intent(welcome.this, Next.class);
                           final String string1 = editText1.getText().toString();
                           final String string2 = editText.getText().toString();
                           intent.putExtra("playername", string1);
                           intent.putExtra("player1name", string2);
                           startActivity(intent);

               }

           }
       });

}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
