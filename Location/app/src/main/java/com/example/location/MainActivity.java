package com.example.location;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 101;
    // private final Context CONTEXT = this;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            // performAction(...);
         // } else if (shouldShowRequestPermissionRationale()) {
            // In an educational UI, explain to the user why your app requires this
            // permission for a specific feature to behave as expected. In this UI,
            // include a "cancel" or "no thanks" button that allows the user to
            // continue using your app without granting the permission.
            // showInContextUI(...);
         } else {
            // Ask for both the ACCESS_FINE_LOCATION and ACCESS_COARSE_LOCATION permissions.
            ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION },
                    REQUEST_CODE);
        }

//        // Register the permissions callback, which handles the user's response to the
//        // system permissions dialog. Save the return value, an instance of
//        // ActivityResultLauncher, as an instance variable.
//        ActivityResultLauncher<String> requestPermissionLauncher =
//                registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
//                    if (isGranted) {
//                        // Permission is granted. Continue the action or workflow in your
//                        // app.
//                    } else {
//                        // Explain to the user that the feature is unavailable because the
//                        // features requires a permission that the user has denied. At the
//                        // same time, respect the user's decision. Don't link to system
//                        // settings in an effort to convince the user to change their
//                        // decision.
//                    }
//                });
//
//        if (ContextCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_FINE_LOCATION) ==
//                PackageManager.PERMISSION_GRANTED) {
//            // You can use the API that requires the permission.
////            performAction(...);
////        } else if (shouldShowRequestPermissionRationale(...)) {
////            // In an educational UI, explain to the user why your app requires this
////            // permission for a specific feature to behave as expected. In this UI,
////            // include a "cancel" or "no thanks" button that allows the user to
////            // continue using your app without granting the permission.
////            showInContextUI(...);
////        } else {
//            // You can directly ask for the permission.
//            // The registered ActivityResultCallback gets the result of this request.
//            requestPermissionLauncher.launch(
//                    new String[] {
//                            Manifest.permission.ACCESS_FINE_LOCATION,
//                            Manifest.permission.ACCESS_COARSE_LOCATION});
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE:
                // If the request is cancelled, the result arrays are empty.
                if (grantResults.length > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        // ACCESS_FINE_LOCATION is granted
                    } else if (grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED) {
                        // ACCESS_COARSE_LOCATION is granted
                    }
                } else {
                    // Explain to the user that the feature is unavailable because
                    // the feature requires a permission that the user has denied.
                    // At the same time, respect the user's decision. Don't link to
                    // system settings in an effort to convince the user to change
                    // their decision.
                    Toast.makeText(MainActivity.this,
                            "permission denied",
                            Toast.LENGTH_LONG).show();
                }
                return;
            // default: super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        // Other 'case' lines to check for other
        // permissions this app might request.
    }
}
