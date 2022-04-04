package com.example.demo_b9_lt_xacdinhdonghieng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Display display;
    TextView txtHuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtDoNghieng = findViewById(R.id.txtDoNghieng);
        txtHuong = findViewById(R.id.txtHuong);

        InfoScreen();

        OrientationEventListener orientationEventListener = new OrientationEventListener(MainActivity.this, SensorManager.SENSOR_DELAY_NORMAL) {
            @Override
            public void onOrientationChanged(int i) {
                txtDoNghieng.setText(""+i);
                InfoScreen();
            }
        };
        orientationEventListener.enable();

    }
    /**
     * Xác định màn hình PORTRAIT, LANDSCAPE
     */
    void InfoScreen() {

        display =
                ((WindowManager)getSystemService(Context.WINDOW_SERVICE))
                        .getDefaultDisplay();

        switch (display.getRotation()) {
            case Surface.ROTATION_0:
                txtHuong.setText("Màn hình LAYOUT đứng: 0°");
                break;

            case Surface.ROTATION_90:
                txtHuong.setText("Màn hình LAYOUT ngang: 90°");
                break;

            case Surface.ROTATION_180:
                txtHuong.setText("Màn hình LAYOUT ngang: 180°");
                break;

            case Surface.ROTATION_270:
                txtHuong.setText("Màn hình LAYOUT đứng: 270°");
                break;
        }
    }
}