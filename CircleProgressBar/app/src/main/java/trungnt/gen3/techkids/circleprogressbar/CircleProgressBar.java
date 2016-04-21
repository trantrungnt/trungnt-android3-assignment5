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
    public CircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

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

        Paint pCircleBorder = new Paint();
        pCircleBorder.setColor(Color.parseColor("#1A237E"));
        pCircleBorder.setStyle(Paint.Style.STROKE);
        pCircleBorder.setStrokeWidth(20.0f);;
        RectF rectFCircleBorder = new RectF(100, 80, 500, 480);
        canvas.drawArc(rectFCircleBorder, 0, 360, false, pCircleBorder);

        Paint pCricleBlue = new Paint();
        pCricleBlue.setAntiAlias(true);
        pCricleBlue.setColor(Color.BLUE);
        pCricleBlue.setStyle(Paint.Style.FILL);
        pCricleBlue.setStrokeWidth(2.5f);
        canvas.drawCircle(300, 280, 180, pCricleBlue);

        Paint pText = new Paint();
        pText.setColor(Color.parseColor("#FFEBEE"));
        pText.setStyle(Paint.Style.FILL);
        pText.setTextSize(100);
        pText.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("25:00", 300, 300, pText);
    }
}
