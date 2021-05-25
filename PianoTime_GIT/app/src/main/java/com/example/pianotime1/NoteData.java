package com.example.pianotime1;

import java.io.Serializable;

public class NoteData implements Serializable
{
    public enum NoteValue {
        LOWER_C,
        LOWER_D,
        LOWER_E,
        LOWER_F,
        LOWER_G,
        HIGHER_A,
        HIGHER_B,
        HIGHER_C;
    }

    public enum NoteDuration
    {
        EIGHTH,
        FOURTH,
        HALF,
        WHOLE
    }

    public final Boolean noteSharp;
    public final NoteValue noteValue;
    public final NoteDuration noteDuration;
    public final float line;
    public final Boolean facingUp;

    public NoteData(NoteValue noteValue, NoteDuration noteDuration)
    {
        this(noteValue,noteDuration,false);
    }

    public NoteData(NoteValue noteValue, NoteDuration noteDuration, Boolean noteSharp)
    {
        this.noteValue = noteValue;
        this.noteDuration = noteDuration;
        this.noteSharp = noteSharp;
        // Если символ идёт вниз от строки как у верхних Си и До, то facingUp==false
        this.facingUp = noteValue!=NoteValue.HIGHER_B&&noteValue!=NoteValue.HIGHER_C;

        // Сдвиг вниз на пол линии если диез (все диезы только вверх)
        if(noteSharp) {
            if(noteDuration==NoteDuration.WHOLE)
                this.line = setLineByValue() - 0.5f;
            else
                this.line = setLineByValue() - 0.6f;
        }
        else
            this.line = setLineByValue();
    }

    private float setLineByValue(){
        switch (noteValue) {
            case LOWER_C:
                return 0.5f;
            case LOWER_D:
                return 1f;
            case LOWER_E:
                return 1.5f;
            case LOWER_F:
                return 2f;
            case LOWER_G:
                return 2.5f;
            case HIGHER_A:
                return 3f;
            case HIGHER_B:
                return 3.5f;
            case HIGHER_C:
                return 4f;
        }

        return 0.5f;
    }
}