package com.example.qrcodebatiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class PieceJointeActivity extends AppCompatActivity {


    final String TAG = "PieceJointeActivity";
    public static String idBatiment;
    ArrayList<PieceJointe> pieceJointes = new ArrayList<>();

    public TextView descBatiment;
    public TextView numBatiment;
    public Button btnRetour;
    public ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piece_jointe);



        descBatiment = findViewById(R.id.tvDescBatiment);
        numBatiment = findViewById(R.id.tvNumBatiment);

        ivBack = findViewById(R.id.ivBack);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        if (idBatiment == null) {
            idBatiment  = "";
        }else {
            Call<MXAsset> call = service.getInfoBatiment(idBatiment);
            Log.d(TAG, "onCreate: " + idBatiment);


            call.enqueue(new Callback<MXAsset>() {
                @Override
                public void onResponse(Call<MXAsset> call, Response<MXAsset> response) {
                    if (response.body().getMXASSETSet().getBatiment() != null) {
                        numBatiment.setText(response.body().getMXASSETSet().getBatiment().getASSETNUM());
                        descBatiment.setText(response.body().getMXASSETSet().getBatiment().getDESCRIPTION());
                        Log.d(TAG, "onResponse: " + response);

                        if (response.body().getMXASSETSet().getBatiment().getDOCLINKS() != null) {
                            pieceJointes.addAll(response.body().getMXASSETSet().getBatiment().getDOCLINKS());
                            ArrayList<PieceJointe> arrayOfPieceJointes = new ArrayList<>();
                            PieceJointeAdapter adapter = new PieceJointeAdapter(getApplicationContext(), arrayOfPieceJointes);
                            ListView listView = findViewById(R.id.lvItems);
                            listView.setAdapter(adapter);
                            adapter.addAll(pieceJointes);
                        }
                    }
                }

                @Override
                public void onFailure(Call<MXAsset> call, Throwable t) {
                    Log.d(TAG, "Erreur : " + t.getMessage());
                }
            });
        }

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




    }



}
