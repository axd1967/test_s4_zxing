package com.augnition.scan_for_glass.test_int_s4.app;

import android.IntentIntegrator;
import android.IntentResult;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;


public class ScanActivity extends Activity {

    private static final String TAG = ScanActivity.class.getSimpleName();

    ////////////////////////////////////////
    // ScanActivity
    ////////////////////////////////////////

    private void startScan() {
        IntentIntegrator ii = new IntentIntegrator(this);

        ii.initiateScan(IntentIntegrator.ONE_D_CODE_TYPES);
        //ii.initiateScan();
    }

    ////////////////////////////////////////
    // Activity
    ////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        startScan();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.scan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (scanResult != null) {
        // handle scan result

            String str = scanResult.toString();
            Log.d(TAG, str);

        }
        else {
            // else continue with any other code you need in the method
            Log.d(TAG, "oops");

    }
}
}
