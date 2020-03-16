package com.example.qrcodebatiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qrcodebatiment.models.PieceJointe;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    
    String str = "";
    ArrayList<PieceJointe> pieceJointes = new ArrayList<>();
    public static TextView text;
    Button btn;
    Button btnIdBatiment;
    TextInputLayout etIdBatiment;

    TextView tvScanner;
    TextView tvSaisir;
    ImageView ivSaisir;

    final String TAG = "MainAcivity";
    public static String batiment;
    View btnNavSaisie;
    View btnNavScan;
    View navbar;

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIdBatiment = findViewById(R.id.btnIdBatiment);
        etIdBatiment = findViewById(R.id.etIdBatiment);
        navbar = findViewById(R.id.navbar);
        btnNavSaisie = navbar.findViewById(R.id.saisie);
        btnNavScan = navbar.findViewById(R.id.scan);

        ivSaisir = navbar.findViewById(R.id.ivSaisir);
        ivSaisir.setImageResource(R.drawable.ic_search_selected_24px);
        tvSaisir = navbar.findViewById(R.id.tvSaisir);
        tvSaisir.setTextColor(getResources().getColor(R.color.colorPrimary));

        btnIdBatiment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etIdBatiment != null) {
                    PieceJointeActivity.idBatiment = etIdBatiment.getEditText().getText().toString().trim().toUpperCase();
                    startActivity(new Intent(getApplicationContext(), PieceJointeActivity.class));
                }
            }
        });

        btnNavScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });



        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);









        Log.d(TAG, "onCreate: " + str);

    }






}
