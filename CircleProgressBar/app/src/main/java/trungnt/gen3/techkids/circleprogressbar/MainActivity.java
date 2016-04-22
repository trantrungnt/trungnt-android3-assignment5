package trungnt.gen3.techkids.circleprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int countTime;
    private CircleProgressBar circleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView()
    {
        circleProgressBar = (CircleProgressBar) this.findViewById(R.id.circleProgressBar);
        circleProgressBar.setMax(20);
        circleProgressBar.setProgress(0);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                countTime++;
                MainActivity.this.circleProgressBar.setProgress(countTime);
                MainActivity.this.circleProgressBar.postInvalidate(); //giong repaint
            }
        }, 1000, 1000);
    }
}
