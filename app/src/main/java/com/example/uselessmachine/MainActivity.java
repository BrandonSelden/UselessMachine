package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.uselessmachine.R;

public class MainActivity extends AppCompatActivity {
    private Switch use;
    private Button button;
    private ConstraintLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
    }

    private void wireWidgets() {
        use = findViewById(R.id.switch_main_useless);
        button = findViewById(R.id.button_main_selfdestruct);
    }

    private void setListeners(){
        use.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, final boolean isChecked) {
                new CountDownTimer(2000, 1000) {
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

//                if(isChecked){
//                    Toast.makeText(MainActivity.this, "Switch is on!", Toast.LENGTH_SHORT);
//                }
//                else{
//                    Toast.makeText(MainActivity.this, "Switch is off!", Toast.LENGTH_SHORT);
//                }
            }
        });
    }
}
