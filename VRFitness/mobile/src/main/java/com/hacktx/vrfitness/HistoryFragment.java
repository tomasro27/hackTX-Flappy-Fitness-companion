package com.hacktx.vrfitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR on 10/19/2014.
 */
public class HistoryFragment extends Fragment {

    ListView historyView;
    ArrayList<Score> stringHistory;

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle SavedInstanceState)
    {
        View v =  inflater.inflate(R.layout.history_fragment, container, false);

        historyView = (ListView) v.findViewById(R.id.historyList);
        stringHistory = new ArrayList<Score>();
        ParseUser user = ParseUser.getCurrentUser();
        Log.d("parseUSER", user.getUsername());
        Log.d("parseUSER id", user.getObjectId());
        List list = user.getList("scores");

        for(int i = 0; i < list.size(); i++)
        {
            stringHistory.add(new Score(list.get(i).toString(),"" + Integer.parseInt(list.get(i).toString())*1.07));
            Log.d("TAG1", list.get(i).toString());
            Log.d("score", "Retrieved " + list.size() + " scores");
        }
        Log.d("SIZE", stringHistory.size() + "");


        StatsArrayAdapter scoreAdapter = new StatsArrayAdapter(getActivity(), stringHistory);

        historyView.setAdapter(scoreAdapter);



        return v;
    }
}
