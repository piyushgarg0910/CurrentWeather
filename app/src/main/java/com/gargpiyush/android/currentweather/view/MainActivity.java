package com.gargpiyush.android.currentweather.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gargpiyush.android.currentweather.R;
import com.gargpiyush.android.currentweather.util.AlertScreenDialog;

public class MainActivity extends AppCompatActivity {

    static boolean result = false;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = findViewById(android.R.id.content);
        setContentView(R.layout.activity_main);
        if(getResult())
            launchFragment();
    }

    @Override
    public void onBackPressed() {
        new AlertScreenDialog()
                .showAlert(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == 100){
            if ((grantResults.length > 0)
                    && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                launchFragment();
            } else {
                getResult();
            }
        }
    }

    void launchFragment(){
        Fragment fragment = new WeatherFragment();
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction
                .replace(R.id.MainActivityLayout,fragment,"WeatherFragment");
        transaction.commit();
    }

    Boolean getResult(){
        if ((checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)
                &&
                (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)){
            result = true;
        } else if ((shouldShowRequestPermissionRationale
                (Manifest.permission.ACCESS_FINE_LOCATION))
                && (shouldShowRequestPermissionRationale
                (Manifest.permission.ACCESS_COARSE_LOCATION))){
            Snackbar snackbar = Snackbar.make(view,
                    "Please enable location permission",
                    Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    requestPerm();
                }
            });
            snackbar.show();
        } else {
            requestPerm();
        }
        return result;
    }

    void requestPerm(){
        requestPermissions(new String[]{Manifest.permission
                .ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION},100);
    }
}
