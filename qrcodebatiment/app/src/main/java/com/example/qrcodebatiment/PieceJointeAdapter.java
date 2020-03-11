package com.example.qrcodebatiment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.qrcodebatiment.models.MXAsset;
import com.example.qrcodebatiment.models.PieceJointe;

import java.util.ArrayList;

import retrofit2.Callback;

public class PieceJointeAdapter extends ArrayAdapter<PieceJointe> {

    public PieceJointeAdapter(Context context, ArrayList<PieceJointe> piecejointes) {
        super(context, 0, piecejointes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        PieceJointe pj = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_piece_jointe, parent, false);
        }
        // Lookup view for data population
        TextView tvDesc = (TextView) convertView.findViewById(R.id.description);
        TextView tvType = (TextView) convertView.findViewById(R.id.type);
        TextView tvPieceJointe = (TextView) convertView.findViewById(R.id.pieceJointe);
        // Populate the data into the template view using the data object
        tvDesc.setText(pj.getDESCRIPTION());
        tvType.setText(pj.getDOCTYPE());
        tvPieceJointe.setText(pj.getNameUrl());
        // Return the completed view to render on screen
        return convertView;
    }
}
