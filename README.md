﻿# trungnt-android3-assignment5
##Yêu cầu
![BTVN Assignment 5](http://i477.photobucket.com/albums/rr132/trungepu/26270076970_881327d18a_o_zpsctj0isq2.jpg)

##Chú ý khi code
+ AttributeSet chứa các thuộc tính ta định nghĩa cho CircleProgressBar
+ Context quản lý tài nguyên Res
+ Đơn vị vẽ trong Java là đơn vị pixel, còn đơn vị vẽ trên giao diện xml là đơn vị dp ...
```
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

        //ve o vi tri nao: x, y, width, height cua rectF => left, top, right, bottom
        RectF rectF = new RectF(0, 0, 200, 200); //don vi ve trong java la pizel, con don vi tren xml la dp
        //rectF la vung Cha bao quanh hinh tron, goc quay tu 0 den 45 do la goc quay, ve o giua tam cua hinh chu nhat, paint  la but ve
        canvas.drawArc(rectF, 0, 45, true, paint);
    }
}

```

+ Vẽ đường tròn và viền hình tròn kết hợp có Text bên trong hình tròn
```
  Paint pCircleBorder = new Paint();
        pCircleBorder.setColor(Color.parseColor("#1A237E"));
        pCircleBorder.setStyle(Paint.Style.STROKE);
        pCircleBorder.setStrokeWidth(20.0f);;
        RectF rectFCircleBorder = new RectF(100, 80, 500, 480);
        canvas.drawArc(rectFCircleBorder, -90, 20, false, pCircleBorder);

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
```


##Môi trường phát triển
+ Bộ công cụ Android Studio version 2.0
+ Máy ảo Genymotion với hệ điều hành Android version 4.3
+ Máy thật Samsung Galazy S3 với hệ điều hành Android version 4.3


##Nguồn tham khảo
+ [Material Design Icons của Google](https://google.github.io/material-design-icons/)
+ [Draw Circle Android basic example](http://android.okhelp.cz/draw-circle-android-basic-example/)
