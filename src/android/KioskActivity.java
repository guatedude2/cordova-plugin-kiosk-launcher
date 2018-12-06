package org.cordova.plugin.labs.kiosk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import org.apache.cordova.*;
import android.widget.*;

import java.lang.Integer;
import java.util.Collections;
import java.util.Set;

public class KioskActivity extends CordovaActivity {

    public static volatile boolean running = false;
    public static volatile boolean kioskModeEnabled = false;

    public static volatile Set<Integer> runningKeys = Collections.EMPTY_SET;

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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("onKeyDown event: keyCode = " + event.getKeyCode());
        return !runningKeys.contains(event.getKeyCode()); // event not being propagated if not allowed
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