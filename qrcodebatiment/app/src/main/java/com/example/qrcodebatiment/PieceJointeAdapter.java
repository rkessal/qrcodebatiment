package com.example.qrcodebatiment;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.app.DownloadManager;
import android.content.Context;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.qrcodebatiment.models.MXAsset;
import com.example.qrcodebatiment.models.PieceJointe;

import java.io.File;
import java.util.ArrayList;

import retrofit2.Callback;

public class PieceJointeAdapter extends ArrayAdapter<PieceJointe> {

    public PieceJointeAdapter(Context context, ArrayList<PieceJointe> piecejointes) {
        super(context, 0, piecejointes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PieceJointe pj = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_piece_jointe, parent, false);
        }
        TextView tvDesc = convertView.findViewById(R.id.description);
        TextView tvType = convertView.findViewById(R.id.type);
        TextView tvPieceJointe = convertView.findViewById(R.id.pieceJointe);

        tvDesc.setText(pj.getDESCRIPTION());
        tvType.setText(pj.getDOCTYPE());
        tvPieceJointe.setText(pj.getNameUrl());
        tvPieceJointe.setTag(position);


        tvPieceJointe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = (Integer) v.getTag();
                PieceJointe pj = getItem(position);
                Uri uri = Uri.parse(pj.getWEBURL());
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setTitle(pj.getNameUrl());
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);


                String nameOfFile = pj.getNameUrl();
                String appFolder = "QRCodeBatiment";

                File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + appFolder);
                if (!f.exists()) {
                    f.mkdirs();
                }
                request.setDestinationInExternalPublicDir(appFolder, nameOfFile);
                DownloadManager downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);

            }
        });

        return convertView;
    }
}
