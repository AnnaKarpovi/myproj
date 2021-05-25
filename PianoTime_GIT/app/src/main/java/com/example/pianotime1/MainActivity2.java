package com.example.pianotime1;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    MusicBarView musBarView;
    NoteData.NoteDuration duration;
    Button buttonCC2, buttonA, buttonC, buttonE, buttonF, buttonG, buttonD, buttonB,bb1,bb2,bb3,bb4,bb5,buttonClear,buttonSave,buttonLoad;

    private SoundPool soundPool;
    private int soundCC2, soundC, soundD, soundE, soundF, soundG, soundA, soundB, sound1sh, sound2sh, sound3sh, sound4sh, sound5sh;

    private final String filename = "pianotimeSavedData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        duration = NoteData.NoteDuration.WHOLE;

        buttonA = (Button) (findViewById(R.id.buttonA));
        buttonC = (Button) (findViewById(R.id.buttonC));
        buttonE = (Button) (findViewById(R.id.buttonE));
        buttonF = (Button) (findViewById(R.id.buttonF));
        buttonG = (Button) (findViewById(R.id.buttonG));
        buttonD = (Button) (findViewById(R.id.buttonD));
        buttonB = (Button) (findViewById(R.id.buttonB));
        buttonCC2 = (Button) (findViewById(R.id.buttonCC2));
        bb1 = (Button) (findViewById(R.id.bb1));
        bb2 = (Button) (findViewById(R.id.bb2));
        bb3 = (Button) (findViewById(R.id.bb3));
        bb4 = (Button) (findViewById(R.id.bb4));
        bb5 = (Button) (findViewById(R.id.bb5));
        buttonClear = (Button) (findViewById(R.id.buttonClear));
        buttonSave = (Button) (findViewById(R.id.buttonSave));
        buttonLoad = (Button) (findViewById(R.id.buttonLoad));

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

        musBarView = (MusicBarView) (findViewById(R.id.musBarView));
        View.OnClickListener bth = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonC:
                        soundPool.play(soundC, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.LOWER_C, duration));
                        break;
                    case R.id.buttonD:
                        soundPool.play(soundD, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.LOWER_D, duration));
                        break;
                    case R.id.buttonE:
                        soundPool.play(soundE, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.LOWER_E, duration));
                        break;
                    case R.id.buttonF:
                        soundPool.play(soundF, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.LOWER_F, duration));
                        break;
                    case R.id.buttonG:
                        soundPool.play(soundG, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.LOWER_G, duration));
                        break;
                    case R.id.buttonA:
                        soundPool.play(soundA, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.HIGHER_A, duration));
                        break;
                    case R.id.buttonB:
                        soundPool.play(soundB, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.HIGHER_B, duration));
                        break;
                    case R.id.bb1:
                        soundPool.play(sound1sh, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.LOWER_C, duration,true));
                        break;
                    case R.id.bb2:
                        soundPool.play(sound2sh, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.LOWER_D, duration,true));
                        break;
                    case R.id.bb3:
                        soundPool.play(sound3sh, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.LOWER_F, duration,true));
                        break;
                    case R.id.bb4:
                        soundPool.play(sound4sh, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.LOWER_G, duration,true));
                        break;
                    case R.id.bb5:
                        soundPool.play(sound5sh, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.HIGHER_A, duration,true));
                        break;
                    case R.id.buttonCC2:
                        soundPool.play(soundCC2, 1, 1, 0, 0, 1);
                        musBarView.addNote(new NoteData(NoteData.NoteValue.HIGHER_C, duration));
                        break;
                }
            }
        };

        buttonC.setOnClickListener(bth);
        buttonD.setOnClickListener(bth);
        buttonF.setOnClickListener(bth);
        buttonG.setOnClickListener(bth);
        buttonB.setOnClickListener(bth);
        buttonE.setOnClickListener(bth);
        buttonA.setOnClickListener(bth);
        bb1.setOnClickListener(bth);
        bb2.setOnClickListener(bth);
        bb3.setOnClickListener(bth);
        bb4.setOnClickListener(bth);
        bb5.setOnClickListener(bth);
        buttonCC2.setOnClickListener(bth);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musBarView.clearNotes();
            }
        });


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //все NoteData записываются в файл

                ArrayList<NoteData> noteDataArrayList = new ArrayList<>();
                for (int i=0,n=musBarView.getChildCount(); i < n; i++) {
                    noteDataArrayList.add(((NoteView)musBarView.getChildAt(i)).noteData);
                }

                // Записывается в файл полученный список

                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput(filename, MODE_PRIVATE));
                    objectOutputStream.writeObject(noteDataArrayList);

                    objectOutputStream.close();

                }
                catch (IOException e) {
                    Log.e("Exception", "File write failed: " + e.toString());
                }

            }
        });
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Загружаются данные из файла
                try {
                    InputStream inputStream = openFileInput(filename);

                    if ( inputStream != null ) {
                        // Очищается текущий нотный стан
                        musBarView.clearNotes();

                        ObjectInputStream oi = new ObjectInputStream(inputStream);
                        ArrayList<NoteData> noteDataArrayList = (ArrayList<NoteData>)oi.readObject();

                        for (int i=0,n=noteDataArrayList.size(); i < n; i++) {
                            musBarView.addNote(noteDataArrayList.get(i));
                        }

                        inputStream.close();
                        oi.close();
                    }
                }
                catch (ClassNotFoundException e) {
                    //Log.e("login activity", "File not found: " + e.toString());
                } catch (IOException e) {
                    //Log.e("login activity", "Can not read file: " + e.toString());
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.eighth:
                item.setChecked(!item.isChecked());
                duration = NoteData.NoteDuration.EIGHTH;
                return true;
            case R.id.fourth:
                item.setChecked(!item.isChecked());
                duration = NoteData.NoteDuration.FOURTH;
                return true;
            case R.id.half:
                item.setChecked(!item.isChecked());
                duration = NoteData.NoteDuration.HALF;
                return true;
            case R.id.whole:
                item.setChecked(!item.isChecked());
                duration = NoteData.NoteDuration.WHOLE;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}