package com.example.pianotime1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.jfugue.Player;

public class MainActivity extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Player player = new Player();
        player.play("C D E F G A B");

        b1 = (Button)(findViewById(R.id.button1));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });
    }

    public void openActivity2(){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);



        }

}
