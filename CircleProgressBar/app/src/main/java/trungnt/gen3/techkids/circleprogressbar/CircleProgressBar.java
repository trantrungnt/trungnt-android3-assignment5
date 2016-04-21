package trungnt.gen3.techkids.circleprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
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
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        //ve o vi tri nao
        RectF rectF = new RectF(0, 0, 10, 10); //don vi ve trong java la pizel, con don vi tren xml la dp
        canvas.drawRect(rectF, paint);
    }
}
