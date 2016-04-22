package trungnt.gen3.techkids.circleprogressbar;

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
        imgBtnProcess = (ImageButton) this.findViewById(R.id.imgBtnProcess);
        imgBtnProcess.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.imgBtnProcess) {
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
}
