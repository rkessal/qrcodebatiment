package com.example.qrcodebatiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qrcodebatiment.models.MXAsset;
import com.example.qrcodebatiment.models.PieceJointe;
import com.example.qrcodebatiment.network.GetDataService;
import com.example.qrcodebatiment.network.RetrofitClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    String str = "";
    ArrayList<PieceJointe> pieceJointes = new ArrayList<>();
    public static TextView text;
    Button btn;
    Button btnIdBatiment;
    EditText etIdBatiment;
    final String TAG = "MainAcivity";
    public static String batiment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btnIdBatiment = findViewById(R.id.btnIdBatiment);
        etIdBatiment = findViewById(R.id.etIdBatiment);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + batiment);
                finish();
                startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
            }
        });

        btnIdBatiment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etIdBatiment != null) {
                    PieceJointeActivity.idBatiment = etIdBatiment.getText().toString().trim().toUpperCase();
                    startActivity(new Intent(getApplicationContext(), PieceJointeActivity.class));
                }
            }
        });





        Log.d(TAG, "onCreate: " + str);

    }






}
