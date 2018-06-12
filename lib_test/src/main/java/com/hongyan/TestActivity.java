package com.hongyan;

import android.app.Activity;
import android.app.Service;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.hongyan.lib_test.R;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        SensorManager manager = (SensorManager) this.getSystemService(Service.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
