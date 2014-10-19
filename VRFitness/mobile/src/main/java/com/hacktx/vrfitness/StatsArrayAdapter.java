package com.hacktx.vrfitness;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;



/**
 * Created by franklong on 10/18/14.
 */
public class StatsArrayAdapter extends ArrayAdapter<Score> {
    private final Context context;
    private ArrayList<Score> scoreArray;
    public StatsArrayAdapter(Context context, ArrayList<Score> scoreArray) {
        super(context, R.layout.score_item, scoreArray);
        this.context = context;
        // this.values = values;
        // this.scores = scores;
        this.scoreArray = scoreArray;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.score_item, parent, false);
        rowView.setId(position);
        TextView username = (TextView) rowView.findViewById(R.id.username);
        TextView scoreText = (TextView) rowView.findViewById(R.id.number);


        //get the name and score
        username.setText(scoreArray.get(position).username);
        scoreText.setText(scoreArray.get(position).score);

        return rowView;
    }
}
