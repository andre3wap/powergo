package com.andre3.playground2;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by ODBBROW on 8/12/2016.
 */
public class OService extends Service {
    LinearLayout oView;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getBaseContext(),"onCreate", Toast.LENGTH_LONG).show();

        OverLay ovl = new OverLay(this);
        ovl.LaunchOverlay();
    }

    @Override
    public void onDestroy() {

        Toast.makeText(getBaseContext(),"Stopped", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}