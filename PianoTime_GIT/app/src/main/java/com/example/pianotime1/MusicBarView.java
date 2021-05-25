package com.example.pianotime1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class MusicBarView extends ViewGroup
{
    private final int NUM_HORIZONTAL_LINES = 5;
    private final float STROKE_WIDTH = 4f; // Ширина чёрных полос
    private final float DRAW_AREA_MULTIPLIER = 0.82f;

    private Paint musicBarBlack;
    private Context mContext;

    public MusicBarView(Context context)
    {
        super(context);
        initialize(context);
    }

    public MusicBarView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context)
    {
        mContext = context;

        musicBarBlack = new Paint();
        musicBarBlack.setColor(Color.BLACK);
        musicBarBlack.setStyle(Paint.Style.FILL);
        musicBarBlack.setStrokeWidth(STROKE_WIDTH);

        setWillNotDraw(false);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        final float yTop = 0,
                    yLeft = 0,
                    yBottom = getLinePosition(NUM_HORIZONTAL_LINES - 1),
                    xTopRight = getMeasuredWidth();

        // Отрисовка горизонтальных чёрных линий
        for (int i = 0; i < NUM_HORIZONTAL_LINES; ++i)
        {
            final float yLineCenter = getLinePosition(i) + STROKE_WIDTH * 0.5f;
            canvas.drawLine(yLeft, yLineCenter, xTopRight, yLineCenter, musicBarBlack);
        }

        // Вертикальные линии слева и справа
        canvas.drawLine(yLeft, yTop, yLeft, yBottom, musicBarBlack);
        canvas.drawLine(xTopRight, yTop, xTopRight, yBottom,  musicBarBlack);

        // Горизонтальные линии для До
        for(int i = getChildCount()-1; i>=0; --i)
        {
            NoteView view = (NoteView) getChildAt(i);
            if(view.noteData.noteValue == NoteData.NoteValue.LOWER_C)
            {

                final float lineY = getLinePosition(NUM_HORIZONTAL_LINES);

                int leftHeadBoundary=view.getLeft(),
                    rightHeadBoundary=view.getRight();

                if(view.noteData.noteSharp){
                    leftHeadBoundary+=(headW_sharp-40)*h1/headH;
                }else{
                    leftHeadBoundary-=100*h1/headH;
                }
                if(view.noteData.noteDuration== NoteData.NoteDuration.EIGHTH && view.noteData.facingUp){
                    rightHeadBoundary-=headW_eighth_up*h1/headH;
                }

                rightHeadBoundary+=100*h1/headH;

                canvas.drawLine(leftHeadBoundary, lineY, rightHeadBoundary, lineY, musicBarBlack);
            }
        }
    }

    // Отступ от левого края нотного стана до первой ноты
    private final int leftCleffMargin=180;

    // размеры ноты (головы). Важно соотношение
    private final int headH=320;// высота головы ноты в пикселях
    private final int headW=400; // ширина головы ноты в пикселях
    private final int headW_eighth_up=208; // хвостик справа от основной головы
    private final int headW_sharp=340+20; // ширина диеза с отступом (добавка к основной части)
    private int h1=0;


    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        if(getChildCount() == 0)
            return;

        int neededWidth = leftCleffMargin; // 20 пикселей для первого До, чтобы влезла чёрточка

        // сколько в ширину требуется для текущих нот
        for(int i = 0,n=getChildCount(); i <n; i++){
            neededWidth+=((NoteView)getChildAt(i)).getMeasuredWidth()+50;
        }

        // Избыток, который вылазит за правый край нотного стана
        neededWidth-=getMeasuredWidth();

        int positionLeft = leftCleffMargin; // 20 пикселей для первого До, чтобы влезла чёрточка

        // Размеры
        for(int i = 0; i < getChildCount(); i++)
        {
            NoteView view = (NoteView)getChildAt(i);

            // Удаление избыточных нот слева
            if(neededWidth>0){
                neededWidth-=((NoteView)getChildAt(0)).getMeasuredWidth()+50;
                removeViewAt(0);
                i--;
                continue;
            }

            if(view.noteData.noteDuration == NoteData.NoteDuration.WHOLE || view.noteData.facingUp)
            {
                final int positionBottom = (int) (getLinePosition(NUM_HORIZONTAL_LINES+1-view.noteData.line));
                view.layout(positionLeft, positionBottom-view.getMeasuredHeight(), positionLeft + view.getMeasuredWidth(), positionBottom);
            }
            else{
                final int positionTop = (int) (getLinePosition(NUM_HORIZONTAL_LINES-view.noteData.line)+STROKE_WIDTH*0.5f);
                view.layout(positionLeft, positionTop, positionLeft + view.getMeasuredWidth(), positionTop+view.getMeasuredHeight());
            }

            positionLeft+=view.getMeasuredWidth()+50;


        }
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        // Расстояние в пикселях между линиями
        h1 = (int) (getLinePosition(1)-getLinePosition(0));

        if(h1==0) return;

        // Высота и ширина каждого символа
        for (int i = getChildCount()-1; i >=0; i--)
        {
            NoteView view = (NoteView) getChildAt(i);

            // Старт с базовой ширины головы ноты
            int proportionalWidth=headW;

            if(view.noteData.noteSharp){
                proportionalWidth+=headW_sharp;
            }
            if(view.noteData.noteDuration== NoteData.NoteDuration.EIGHTH && view.noteData.facingUp){
                proportionalWidth+=headW_eighth_up;
            }

            final int   childWidth = proportionalWidth*h1/headH,
                        childHeight = childWidth*view.getImageHeight()/view.getImageWidth(),
                        wSpec = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
                        hSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY);

            getChildAt(i).measure(wSpec, hSpec);
        }

    }



    public void addNote(NoteData note)
    {
        addView(new NoteView(mContext, note));

        // Если добавлена До, то нужно перерисовать с чёрточкой
        if(note.noteValue == NoteData.NoteValue.LOWER_C) {
            invalidate();
        }
    }

    public void clearNotes(){
        removeAllViews();
    }

    private float getLinePosition(float i){
        return i*getMeasuredHeight() / NUM_HORIZONTAL_LINES * DRAW_AREA_MULTIPLIER;
    }
}