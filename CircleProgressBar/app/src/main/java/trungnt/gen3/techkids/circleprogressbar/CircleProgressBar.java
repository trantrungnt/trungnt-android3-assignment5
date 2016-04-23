package trungnt.gen3.techkids.circleprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by TrungNT on 4/21/2016.
 */
public class CircleProgressBar extends View {
    private Paint pCircleBorder, pCricle, pText, pCircleSmall;
    private String minute;

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    private String second;

    public CircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private float delta;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
        delta = 1.0f * 360 / max;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    private int max;
    private int progress;


    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
//        Paint paint = new Paint();
//        paint.setColor(Color.GREEN);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(10);
//
//        //ve o vi tri nao: x, y, width, height cua rectF => left, top, right, bottom
//        RectF rectF = new RectF(100, 100, 500, 500); //don vi ve trong java la pizel, con don vi tren xml la dp
//        //rectF la vung Cha bao quanh hinh tron, goc quay tu 0 den 45 do la goc quay, ve o giua tam cua hinh chu nhat, paint  la but ve
//        canvas.drawArc(rectF, 0, 45, false, paint);

//        Paint pCircleRed = new Paint();
//        // smooths
//        pCircleRed.setAntiAlias(true);
//        pCircleRed.setColor(Color.parseColor("#1A237E"));
//        pCircleRed.setStyle(Paint.Style.STROKE);
//        pCircleRed.setStrokeWidth(20.0f);
//        //canvas.drawCircle(300, 280, 200, pCircleRed);
//        canvas.drawCircle(300, 280, 200, pCircleRed);

        pCircleBorder = new Paint();
        //pCircleBorder.setColor(Color.parseColor("#1A237E"));
        pCircleBorder.setColor(Color.WHITE);
        //pCircleBorder.setColor(Color.GREEN);
        pCircleBorder.setStyle(Paint.Style.STROKE);
        pCircleBorder.setStrokeWidth(8.0f);;
        RectF rectFCircleBorder = new RectF(100, 80, 500, 480);
        //canvas.drawArc(rectFCircleBorder, -90, 45, false, pCircleBorder);
        canvas.drawArc(rectFCircleBorder, -90, delta*progress, false, pCircleBorder);

        pCricle = new Paint();
        pCricle.setAntiAlias(true);
        pCricle.setColor(Color.BLUE);
        pCricle.setStyle(Paint.Style.FILL);
        pCricle.setStrokeWidth(2.0f);
        canvas.drawCircle(300, 280, 200, pCricle);

        pText = new Paint();
        pText.setColor(Color.parseColor("#FFEBEE"));
        pText.setStyle(Paint.Style.FILL);
        pText.setTextSize(50);
        pText.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(minute + ":" + second, 300, 300, pText);

        pCircleSmall = new Paint();
        pCircleSmall.setColor(Color.WHITE);
        pCircleSmall.setStyle(Paint.Style.FILL);
        canvas.drawCircle(50, 50, 10, pCircleSmall);
    }
}
