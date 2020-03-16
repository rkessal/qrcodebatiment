package com.example.qrcodebatiment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    String TAG = "ScanCodeActivity";
    private String NUMBATIMENT = "";
    private ZXingScannerView mScannerView;
    View btnNavSaisie;
    View navbar;
    TextView tvScanner;
    ImageView ivScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 123);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 123);
        }
        navbar = findViewById(R.id.navbar);
        mScannerView = findViewById(R.id.zxscanner);


        btnNavSaisie = navbar.findViewById(R.id.saisie);

        ivScanner = navbar.findViewById(R.id.ivScanner);
        ivScanner.setImageResource(R.drawable.ic_photo_camera_selected_24px);
        tvScanner = navbar.findViewById(R.id.tvScanner);
        tvScanner.setTextColor(getResources().getColor(R.color.colorPrimary));

        btnNavSaisie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });

    }

    @Override
    public void handleResult(Result result) {
        String[] DATA = result.getText().split("/");
        String GET[] = DATA[DATA.length - 1].split("=");
        NUMBATIMENT = GET[GET.length - 1];
        PieceJointeActivity.idBatiment = NUMBATIMENT;
        Log.d(TAG, "handleResult: " + NUMBATIMENT);
        mScannerView.resumeCameraPreview(this);
        startActivity(new Intent(getApplicationContext(), PieceJointeActivity.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }
}
