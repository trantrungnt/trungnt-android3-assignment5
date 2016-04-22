package trungnt.gen3.techkids.circleprogressbar;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int countTime;
    private CircleProgressBar circleProgressBar;
    private ImageButton imgBtnProcess;
    private int minute, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        countTime = 1500;
    }

    private void initView()
    {
        circleProgressBar = (CircleProgressBar) this.findViewById(R.id.circleProgressBar);
        circleProgressBar.setMax(1500);
        circleProgressBar.setProgress(0);
        imgBtnProcess = (ImageButton) this.findViewById(R.id.imgBtnProcess);
        imgBtnProcess.setOnClickListener(this);
        imgBtnProcess.setImageResource(R.drawable.play);

        //khoi tao thoi gian
        circleProgressBar.setMinute("25");
        circleProgressBar.setSecond("00");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.imgBtnProcess) {
            //doi anh cua nut imgBtnProcess
            imgBtnProcess.setImageResource(R.drawable.stop);
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    countTime--;
                    minute = countTime / 60;
                    second = countTime % 60;

                    if (countTime>=0) {
                        MainActivity.this.circleProgressBar.setProgress(countTime);
                        MainActivity.this.circleProgressBar.postInvalidate(); //giong repaint
                        MainActivity.this.circleProgressBar.setMinute(String.valueOf(minute));
                        MainActivity.this.circleProgressBar.setSecond(String.valueOf(second));
                    }

                    if (countTime == 0)
                    {
                        notificationAlert();
                        MainActivity.this.circleProgressBar.setMinute(String.valueOf(0));
                        MainActivity.this.circleProgressBar.setSecond(String.valueOf(0));

                    }
                }
            }, 1000, 1000);
        }
    }


    private void notificationAlert()
    {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.phone)
                        .setContentTitle("WARNING ...")
                        .setContentText("You need to relax !!!!! ");

        Intent resultIntent = new Intent(this, ResultActivity.class);


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        stackBuilder.addParentStack(ResultActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(99, mBuilder.build());
    }
}
