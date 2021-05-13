package com.example.pianotime1;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.nitishp.sheetmusic.MusicBarView;
import com.nitishp.sheetmusic.NoteData;
import com.nitishp.sheetmusic.NoteView;

//import org.jfugue.Player;
//import jp.kshoji.javax.sound.midi.UsbMidiSystem;


public class MainActivity2 extends AppCompatActivity {


    public int var=0;

    MusicBarView musBarView;
    Button button123,buttonCC2, buttonA, buttonC, buttonE, buttonF, buttonG, buttonD, buttonB,button1sh,button2sh,button3sh,button4sh,button5sh;

    private SoundPool soundPool;
    private int soundCC2;
    private int soundC;
    private int soundD;
    private int soundE;
    private int soundF;
    private int soundG;
    private int soundA;
    private int soundB;
    private int sound1sh;
    private int sound2sh;
    private int sound3sh;
    private int sound4sh;
    private int sound5sh;
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
        button1sh = (Button) (findViewById(R.id.bb1));
        button2sh = (Button) (findViewById(R.id.bb2));
        button3sh = (Button) (findViewById(R.id.bb3));
        button4sh = (Button) (findViewById(R.id.bb4));
        button5sh = (Button) (findViewById(R.id.bb5));

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
        soundCC2 = soundPool.load(this, R.raw.c2, 0);
        sound1sh = soundPool.load(this, R.raw.shp1, 0);
        sound2sh = soundPool.load(this, R.raw.shp2, 0);
        sound3sh = soundPool.load(this, R.raw.shp3, 0);
        sound4sh = soundPool.load(this, R.raw.shp4, 0);
        sound5sh = soundPool.load(this, R.raw.shp5, 0);



        musBarView = (MusicBarView)(findViewById(R.id.musBarView));
        View.OnClickListener bth = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            NoteData note = new NoteData(NoteData.NoteValue.valueOf("LOWER_C"),NoteData.NoteDuration.valueOf("HALF"));
            switch (v.getId()){
                case R.id.buttonC:
                    soundPool.play(soundC,1,1,0,0,1);
                    note.setNoteValue(NoteData.NoteValue.valueOf("LOWER_C"));
                    note.setNoteDuration(NoteData.NoteDuration.valueOf("HALF"));
                    musBarView.addNote(note);
                    break;

                case R.id.buttonD:
                    soundPool.play(soundD,1,1,0,0,1);
                    note.setNoteValue(NoteData.NoteValue.valueOf("LOWER_D"));
                    note.setNoteDuration(NoteData.NoteDuration.valueOf("HALF"));
                    musBarView.addNote(note);
                    break;
            case R.id.buttonE:
                soundPool.play(soundE,1,1,0,0,1);
                note.setNoteValue(NoteData.NoteValue.valueOf("LOWER_E"));
                note.setNoteDuration(NoteData.NoteDuration.valueOf("HALF"));
                musBarView.addNote(note);
                break;
            case R.id.buttonF:
                soundPool.play(soundF,1,1,0,0,1);
                note.setNoteValue(NoteData.NoteValue.valueOf("LOWER_F"));
                note.setNoteDuration(NoteData.NoteDuration.valueOf("HALF"));
                musBarView.addNote(note);
                break;
            case R.id.buttonG:
                soundPool.play(soundG,1,1,0,0,1);
                note.setNoteValue(NoteData.NoteValue.valueOf("LOWER_G"));
                note.setNoteDuration(NoteData.NoteDuration.valueOf("HALF"));
                musBarView.addNote(note);
                break;
            case R.id.buttonA:
                soundPool.play(soundA,1,1,0,0,1);
                note.setNoteValue(NoteData.NoteValue.valueOf("HIGHER_A"));
                note.setNoteDuration(NoteData.NoteDuration.valueOf("HALF"));
                musBarView.addNote(note);
                break;
            case R.id.buttonB:
                soundPool.play(soundB,1,1,0,0,1);
                note.setNoteValue(NoteData.NoteValue.valueOf("HIGHER_B"));
                note.setNoteDuration(NoteData.NoteDuration.valueOf("HALF"));
                musBarView.addNote(note);
                break;} }};

        buttonC.setOnClickListener(bth);
        buttonD.setOnClickListener(bth);
        buttonF.setOnClickListener(bth);
        buttonG.setOnClickListener(bth);
        buttonB.setOnClickListener(bth);
        buttonE.setOnClickListener(bth);
        buttonA.setOnClickListener(bth);
        //buttonC.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {

               // NoteData note = new NoteData(NoteData.NoteValue.valueOf("LOWER_C"),NoteData.NoteDuration.valueOf("HALF"));
               // musBarView.addNote(note);
                //soundPool.play(soundC,1,1,0,0,1);
            //}});
        //buttonD.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {

                //NoteData note = new NoteData(NoteData.NoteValue.valueOf("LOWER_D"),NoteData.NoteDuration.valueOf("HALF"));
               // musBarView.addNote(note);
            //}});

    }}