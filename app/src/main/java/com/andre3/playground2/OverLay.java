package com.andre3.playground2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;


/**
 * Created by ODBBROW on 8/15/2016.
 */
public class OverLay extends AppCompatActivity {
    Context mcontext;


    public OverLay(Context mcontext) {
        this.mcontext = mcontext;

    }

    public void LaunchOverlay() {
        System.out.println("Executed..");

        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view, null);
        final WindowManager manager = (WindowManager) mcontext.getSystemService(Context.WINDOW_SERVICE);


        ////view = new LinearLayout(mcontext);
       ///// view.setBackgroundColor(Color.parseColor("#000000")); // The translucent red color

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_TOAST,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.CENTER;

        manager.addView(view, params);
        final Intent intent=new Intent(mcontext, OService.class);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Clicked");

                mcontext.stopService(intent);
                manager.removeView(v);
            }
        });
    }



}
