package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uselessmachine.R;

public class MainActivity extends AppCompatActivity {
    private Switch use;
    private Button button;
    private ConstraintLayout background;
    private int colorr;
    private int colorc;
    private ProgressBar bar;
    private TextView busy;
    private Button busyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        colorr = Color.rgb(203, 34, 40);
        colorc = Color.rgb(255, 255, 255);
    }

    private void wireWidgets() {
        use = findViewById(R.id.switch_main_useless);
        button = findViewById(R.id.button_main_selfdestruct);
        background = findViewById(R.id.background_main_stuff);
        bar = findViewById(R.id.progressBar_main_busy);
        busy = findViewById(R.id.textView_main_busy);
        busyButton = findViewById(R.id.button2_main_busy);
    }

    private void setListeners(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(10000, 1000){
                    int x = 11;
                    public void onTick(long l){
                        x--;
                        if(x % 2 == 0)
                        {
                            button.setBackgroundColor(colorr);
                            background.setBackgroundColor(colorc);
                        }
                        else{
                            button.setBackgroundColor(colorc);
                            background.setBackgroundColor(colorr);
                        }
                        button.setText(x + "");
                    }
                    @Override
                    public void onFinish() {
                        int i = 0/0;
                    }
                }.start();
            }
        });
        use.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, final boolean isChecked) {
                new CountDownTimer(500000, 1000) {
                    @Override
                    public void onTick(long l) {
                        if(!use.isChecked())
                        {
                            cancel();
                        }
                    }

                    @Override
                    public void onFinish() {
                        use.setChecked(false);
                    }
                }.start();
            }
        });
        busyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                new CountDownTimer(10000, 100){
                    int yay = 0;
                    public void onTick(long l){
                        busy.setVisibility(View.VISIBLE);
                        busy.setText("Loading Important Stuff...");
                        busyButton.setVisibility(View.INVISIBLE);
                        use.setVisibility(View.INVISIBLE);
                        bar.setVisibility(View.VISIBLE);
                        button.setVisibility(View.INVISIBLE);
                        bar.setProgress(yay);
                        yay++;
                    }
                    public void onFinish(){
                        busy.setVisibility(View.INVISIBLE);
                        busyButton.setVisibility(View.VISIBLE);
                        use.setVisibility(View.VISIBLE);
                        bar.setVisibility(View.INVISIBLE);
                        button.setVisibility(View.VISIBLE);
                        yay = 0;
                        bar.setProgress(yay);
                    }
                }.start();
            }
        });

    }
}
