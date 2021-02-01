package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 30000;
    private TextView countDown;
    private Button buttonStartPause;
    private Button buttonReset;
    private Button buttonDown;
    private Button buttonUP;
    private CountDownTimer countDownTimerM;
    private boolean timerON;
    private long currentTimeinMilli = START_TIME_IN_MILLIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countDown = findViewById(R.id.text_view_countdown);
        buttonStartPause = findViewById(R.id.button_start_pause);
        buttonReset = findViewById(R.id.button_reset);
        buttonDown = findViewById(R.id.button_down);
        buttonUP = findViewById(R.id.button_up);
        buttonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerON) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();

        buttonUP.setOnClickListener(e->{
            if(currentTimeinMilli < 99000){
                currentTimeinMilli+=1000; updateCountDownText();
            }
        });
        buttonDown.setOnClickListener(e->{
            if(currentTimeinMilli > 5000){
                currentTimeinMilli-=1000; updateCountDownText();
            }

        });
    }
    private void startTimer() {
        countDownTimerM = new CountDownTimer(currentTimeinMilli, 1000) {
            @Override
            public void onTick(long timeTillFinished) {
                currentTimeinMilli = timeTillFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                timerON = false;
                buttonStartPause.setText("Start");
                buttonStartPause.setVisibility(View.INVISIBLE);
                buttonReset.setVisibility(View.VISIBLE);
            }
        }.start();
        timerON = true;
        buttonStartPause.setText("Pause");
        buttonReset.setVisibility(View.INVISIBLE);
        buttonDown.setVisibility(View.INVISIBLE);
        buttonUP.setVisibility(View.INVISIBLE);

    }
    private void pauseTimer() {
        countDownTimerM.cancel();
        timerON = false;
        buttonStartPause.setText("Start");
        buttonReset.setVisibility(View.VISIBLE);
        buttonDown.setVisibility(View.VISIBLE);
        buttonUP.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        currentTimeinMilli = START_TIME_IN_MILLIS;
        updateCountDownText();
        buttonReset.setVisibility(View.INVISIBLE);
        buttonStartPause.setVisibility(View.VISIBLE);
        buttonDown.setVisibility(View.VISIBLE);
        buttonUP.setVisibility(View.VISIBLE);
    }
    private void updateCountDownText() {
        int minutes = (int) (currentTimeinMilli / 1000) / 60;
        int seconds = (int) (currentTimeinMilli / 1000) % 60;
        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        countDown.setText(timeLeft);
    }
}