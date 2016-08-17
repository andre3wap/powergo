package com.andre3.playground2;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity{
Button btn, btn2;
Switch sw1, sw2;
    Boolean pwd_modeV, tap_modeV;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences.Editor editor = getSharedPreferences("user_pref", MODE_PRIVATE).edit();

        SharedPreferences prefs = getSharedPreferences("user_pref", MODE_PRIVATE);

        Boolean pwd_modeTemp = prefs.getBoolean("pwd_mode", false);
        Boolean tap_modeTemp = prefs.getBoolean("tap_mode", true);


        ///toggleService();
       /// finish();

        btn = (Button)findViewById(R.id.button);

        // Enable password screen for user
        sw1 = (Switch)findViewById(R.id.switch1);
        sw1.setChecked(pwd_modeTemp);

        // Enable tap screen for user
        sw2 = (Switch)findViewById(R.id.switch2);
        sw2.setChecked(tap_modeTemp);


        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    openDialog();
                    pwd_modeV = true;
                    tap_modeV = false;
                }else
                {
                    pwd_modeV = false;
                    tap_modeV = true;
                }

                editor.putBoolean("pwd_mode", pwd_modeV);
                editor.putBoolean("tap_mode", tap_modeV);
                editor.commit();
                System.out.println("pwdMopde " + pwd_modeV);
            }
        });
        sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    tap_modeV = true;
                    pwd_modeV = false;

                }else
                {
                    tap_modeV = false;
                    pwd_modeV = true;

                    // Check if password is empty, if so; fire openDialog();
                }

                editor.putBoolean("tap_mode", tap_modeV);
                editor.putBoolean("pwd_mode", pwd_modeV);
                editor.commit();

                System.out.println("tapMopde " + tap_modeV);
            }
        });



    }

    private void toggleService(){
        Intent intent=new Intent(this, OService.class);
        // Try to stop the service if it is already running
        // Otherwise start the service
        if(!stopService(intent)){
            startService(intent);
        }
    }

    public void openDialog() {
        final Dialog dialog = new Dialog(this); // Context, this, etc.
        dialog.setContentView(R.layout.dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setTitle("My Dialog");
        dialog.show();
    }

}
