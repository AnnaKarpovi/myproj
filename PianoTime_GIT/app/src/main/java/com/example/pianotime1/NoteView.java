package com.example.pianotime1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class NoteView extends View
{
    public final NoteData noteData;

    private int imageWidth, imageHeight;

    public NoteView(Context context, AttributeSet attributes)
    {
        super(context, attributes);
        TypedArray attrs = context.getTheme().obtainStyledAttributes(attributes, R.styleable.NoteView, 0 ,0);

        try
        {
            NoteData.NoteValue[] noteValues = NoteData.NoteValue.values();
            NoteData.NoteDuration[] noteDurations = NoteData.NoteDuration.values();

            int noteValueIndex = attrs.getInteger(R.styleable.NoteView_noteValue, -1);
            if((noteValueIndex < 0) || (noteValueIndex >= noteValues.length))
                throw new IllegalArgumentException("Invalid attribute for noteValue");

            int noteDurationIndex = attrs.getInteger(R.styleable.NoteView_noteDuration, -1);
            if((noteDurationIndex < 0) || (noteDurationIndex >= noteDurations.length))
                throw new IllegalArgumentException("Invalid attribute for noteDuration");

            this.noteData = new NoteData(noteValues[noteValueIndex], noteDurations[noteDurationIndex]);
        }
        finally
        {
            attrs.recycle();
        }
        initialize();
    }

    public NoteView(Context context, NoteData noteData)
    {
        super(context);
        this.noteData = noteData;
        initialize();
    }

    private void initialize()
    {
        int backgroundImageId=-1;
        if(noteData.noteSharp){
            switch (noteData.noteDuration) {
                case EIGHTH:
                    backgroundImageId = noteData.facingUp ? R.drawable.sharp_eighth_up :
                            R.drawable.sharp_eighth_down;
                    break;
                case FOURTH:
                    backgroundImageId = noteData.facingUp ? R.drawable.sharp_quarter_up :
                            R.drawable.sharp_quarter_down;
                    break;
                case HALF:
                    backgroundImageId = noteData.facingUp ? R.drawable.sharp_half_up :
                            R.drawable.sharp_half_down;
                    break;
                case WHOLE:
                    backgroundImageId = R.drawable.sharp_whole;
                    break;
                default:
                    break;
            }
        }else {
            switch (noteData.noteDuration) {
                case EIGHTH:
                    backgroundImageId = noteData.facingUp ? R.drawable.eighth_up :
                            R.drawable.eighth_down;
                    break;
                case FOURTH:
                    backgroundImageId = noteData.facingUp ? R.drawable.quarter_up :
                            R.drawable.quarter_down;
                    break;
                case HALF:
                    backgroundImageId = noteData.facingUp ? R.drawable.half_up :
                            R.drawable.half_down;
                    break;
                case WHOLE:
                    backgroundImageId = R.drawable.whole;
                    break;
                default:
                    break;
            }
        }

        // Устанавливается нужная картинка в качестве фона
        setBackgroundResource(backgroundImageId);

        // Размеры картинки для корректного отображения на нотном стане
        final BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), backgroundImageId, opt);

        imageHeight=opt.outHeight; // height of resource
        imageWidth=opt.outWidth; // width of resource

        // Расположить изображение по центру View
        WindowManager.LayoutParams l = new WindowManager.LayoutParams();
        l.gravity = Gravity.CENTER;
        setLayoutParams(l);
    }

    public int getImageWidth(){
        return imageWidth;
    }
    public int getImageHeight(){
        return imageHeight;
    }

}