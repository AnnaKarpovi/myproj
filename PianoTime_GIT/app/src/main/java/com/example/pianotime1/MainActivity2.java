package com.example.pianotime1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    
    public int var=0;
    TextView C,D,E,F,G,A,B; boolean yon = false;
    Button buttonCC2, buttonA, buttonC, buttonE, buttonF, buttonG, buttonD, buttonB,button1sh,button2sh,button3sh,button4sh,button5sh;

    private SoundPool soundPool;
    private int soundCC2,soundC,soundD,soundE,soundF,soundG,soundA,soundB,sound1sh,sound2sh,sound3sh,sound4sh,sound5sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonA = (Button) (findViewById(R.id.buttonA));
        buttonC = (Button) (findViewById(R.id.buttonC));
        buttonE = (Button) (findViewById(R.id.buttonE));
        buttonF = (Button) (findViewById(R.id.buttonF));
        buttonG = (Button) (findViewById(R.id.buttonG));
        buttonD = (Button) (findViewById(R.id.buttonD));
        buttonB = (Button) (findViewById(R.id.buttonB));
        buttonCC2 = (Button) (findViewById(R.id.buttonCC2));

        button1sh = (Button)(findViewById(R.id.bb1));
        button2sh = (Button)(findViewById(R.id.bb2));
        button3sh = (Button)(findViewById(R.id.bb3));
        button4sh = (Button)(findViewById(R.id.bb4));
        button5sh = (Button)(findViewById(R.id.bb5));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().setMaxStreams(3).build();
        } else {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        soundC = soundPool.load(this, R.raw.c, 0);
        soundD = soundPool.load(this, R.raw.d, 0);
        soundE = soundPool.load(this, R.raw.e, 0);
        soundF = soundPool.load(this, R.raw.f, 0);
        soundG = soundPool.load(this, R.raw.g, 0);
        soundA = soundPool.load(this, R.raw.a, 0);
        soundB = soundPool.load(this, R.raw.b, 0);
        soundCC2 =  soundPool.load(this, R.raw.c2, 0);
        sound1sh=soundPool.load(this,R.raw.shp1,0);
        sound2sh=soundPool.load(this,R.raw.shp2,0);
        sound3sh=soundPool.load(this,R.raw.shp3,0);
        sound4sh=soundPool.load(this,R.raw.shp4,0);
        sound5sh=soundPool.load(this,R.raw.shp5,0);

        //View.OnClickListener bth = new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {
        //switch (v.getId()){
        //  case R.id.buttonC:
        //    soundPool.play(soundC,1,1,0,0,1);

        //  break;
        //case R.id.buttonD:
        //  soundPool.play(soundD,1,1,0,0,1);
        //break;
        //case R.id.buttonE:
        // soundPool.play(soundE,1,1,0,0,1);
        //break;
        //case R.id.buttonF:
        // soundPool.play(soundF,1,1,0,0,1);
        //break;
        //case R.id.buttonG:
        //soundPool.play(soundG,1,1,0,0,1);
        // break;
        //case R.id.buttonA:
        //soundPool.play(soundA,1,1,0,0,1);
        //row.add.text = variable = "text";break;
        // case R.id.buttonB:
        //  soundPool.play(soundB,1,1,0,0,1);break; } }};
        //buttonA.setOnClickListener(bth);
        //buttonC.setOnClickListener(bth);
//buttonD.setOnClickListener(bth);
        //buttonF.setOnClickListener(bth);

        //buttonG.setOnClickListener(bth);
        //buttonB.setOnClickListener(bth);
        //buttonE.setOnClickListener(bth);







        for (int i = 1; i <= 3; i++) {

            switch (i) {
                case (1):
                    C = (TextView) (findViewById(R.id.C1));
                    D = (TextView) (findViewById(R.id.D1));
                    E = (TextView) (findViewById(R.id.E1));
                    F = (TextView) (findViewById(R.id.F1));
                    G = (TextView) (findViewById(R.id.G1));
                    A = (TextView) (findViewById(R.id.A1));
                    B = (TextView) (findViewById(R.id.B1));
                    break;
                case (2):
                    C = (TextView) (findViewById(R.id.C2));
                    D = (TextView) (findViewById(R.id.D2));
                    E = (TextView) (findViewById(R.id.E2));
                    F = (TextView) (findViewById(R.id.F2));
                    G = (TextView) (findViewById(R.id.G2));
                    A = (TextView) (findViewById(R.id.A2));
                    B = (TextView) (findViewById(R.id.B2));
                    break;
                case (3):
                    C = (TextView) (findViewById(R.id.C3));
                    D = (TextView) (findViewById(R.id.D3));
                    E = (TextView) (findViewById(R.id.E3));
                    F = (TextView) (findViewById(R.id.F3));
                    G = (TextView) (findViewById(R.id.G3));
                    A = (TextView) (findViewById(R.id.A3));
                    B = (TextView) (findViewById(R.id.B3));
                    break;
            }
            button1sh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(sound1sh, 1, 1, 0, 0, 1);
                    C.setText("La");

                }
            });
            button2sh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(sound2sh, 1, 1, 0, 0, 1);
                    C.setText("La");

                }
            });
            button3sh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(sound3sh, 1, 1, 0, 0, 1);
                    C.setText("La");

                }
            });
            button4sh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(sound4sh, 1, 1, 0, 0, 1);
                    C.setText("La");

                }
            });
            button5sh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(sound5sh, 1, 1, 0, 0, 1);
                    C.setText("La");

                }
            });
            buttonCC2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(soundCC2, 1, 1, 0, 0, 1);
                    C.setText("La");

                }
            });



            buttonC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(soundC, 1, 1, 0, 0, 1);
                    C.setText("La");
                    var++;
                    yon = true;

                }
            });
            buttonD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(soundD, 1, 1, 0, 0, 1);
                    D.setText("La");
                    var++;
                    yon = true;

                }
            });
            buttonE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(soundE, 1, 1, 0, 0, 1);
                    E.setText("La");
                    yon = true;

                }
            });

            buttonF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(soundF, 1, 1, 0, 0, 1);
                    F.setText("La");
                    yon = true;

                }
            });
            buttonG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(soundG, 1, 1, 0, 0, 1);
                    G.setText("La");
                    yon = true;

                }
            });
            buttonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(soundA, 1, 1, 0, 0, 1);
                    A.setText("La");
                    yon = true;

                }
            });
            buttonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool.play(soundB, 1, 1, 0, 0, 1);
                    B.setText("La");
                    yon = true;

                }
            });

        }}}
