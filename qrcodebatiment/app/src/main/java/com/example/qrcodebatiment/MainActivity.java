package com.example.qrcodebatiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.qrcodebatiment.models.Batiment;
import com.example.qrcodebatiment.models.Breakfast;
import com.example.qrcodebatiment.network.GetDataService;
import com.example.qrcodebatiment.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String str = "";
    public static TextView text;
    Button btn;
    final String TAG = "MainAcivity";
    public static String batiment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.test);
        btn = findViewById(R.id.btn);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);


        if (batiment == null) {
            batiment  = "";
        }
        Call<Breakfast> call = service.getInfoBatiment(batiment);
        Log.d(TAG, "onCreate: " + batiment);


        call.enqueue(new Callback<Breakfast>() {
            @Override
            public void onResponse(Call<Breakfast> call, Response<Breakfast> response) {
                str += response;
                Log.d(TAG, "onResponse: " + str);
                text.setText(str +"   " + batiment);
            }

            @Override
            public void onFailure(Call<Breakfast> call, Throwable t) {
                Log.d(TAG, "Erreur : " + t.getMessage());
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + batiment);
                finish();
                startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));


            }
        });



        Log.d(TAG, "onCreate: " + str);

    }






}
