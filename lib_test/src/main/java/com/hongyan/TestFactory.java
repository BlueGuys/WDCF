package com.hongyan;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class TestFactory {

    private static volatile TestFactory instance;

    private TestFactory() {
    }

    public static TestFactory getInstance() {
        if (instance == null) {
            synchronized (TestFactory.class) {
                if (instance == null) {
                    instance = new TestFactory();
                }
            }
        }
        return instance;
    }

    public void init(final Context context) {
        SensorManager manager = (SensorManager) context.getSystemService(Service.SENSOR_SERVICE);
        if (manager != null) {
            manager.registerListener(new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {
                    //获取传感器类型
                    int sensorType = sensorEvent.sensor.getType();
                    //values[0]:X轴，values[1]：Y轴，values[2]：Z轴
                    float[] values = sensorEvent.values;
                    //如果传感器类型为加速度传感器，则判断是否为摇一摇
                    if (sensorType == Sensor.TYPE_ACCELEROMETER) {
                        if ((Math.abs(values[0]) > 17 || Math.abs(values[1]) > 17 || Math
                                .abs(values[2]) > 17)) {
                            context.startActivity(new Intent(context, TestActivity.class));
                        }
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            }, manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

}
