package org.cordova.plugin.labs.kiosk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import org.apache.cordova.*;
import android.widget.*;

public class KioskActivity extends CordovaActivity {

    public static volatile boolean running = false;
    public static volatile boolean kioskModeEnabled = false;

    protected void onStart() {
        super.onStart();
        System.out.println("KioskActivity started");
        running = true;
    }

    protected void onStop() {
        super.onStop();
        System.out.println("KioskActivity stopped");
        running = false;
    }

    public void onCreate(Bundle savedInstanceState) {
        System.out.println("KioskActivity paused");
        super.onCreate(savedInstanceState);
        super.init();

        if (running) {
            finish(); // prevent more instances of kiosk activity
        }

        loadUrl(launchUrl);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (kioskModeEnabled) {
            ActivityManager activityManager = (ActivityManager) getApplicationContext()
                    .getSystemService(Context.ACTIVITY_SERVICE);

            activityManager.moveTaskToFront(getTaskId(), 0);
        }

    }
}