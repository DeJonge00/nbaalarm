package com.smartsports.nbaalarm.Data;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.smartsports.nbaalarm.R;

import java.util.ArrayList;

/**
 * Created by pieter on 23-9-17.
 */

public class GameAdapter extends ArrayAdapter {
    public GameAdapter(Context context, ArrayList<Game> games) {
        super(context, 0, games);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Game game = (Game) getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.game_view, parent, false);
        }
        // Lookup view for data population
        TextView tvTeam_1 = (TextView) convertView.findViewById(R.id.tvTeam_1);
        TextView tvTeam_2 = (TextView) convertView.findViewById(R.id.tvTeam_2);
        TextView tvTime = (TextView) convertView.findViewById(R.id.tvTime);
        // Populate the data into the template view using the data object
        tvTeam_1.setText(game != null ? game.getTeam_1() : "Null");
        tvTeam_2.setText(game != null ? game.getTeam_2() : "Null");
        tvTime.setText(  game != null ? game.getStart().toString() : "Null");
        // Return the completed view to render on screen
        return convertView;
    }

}
