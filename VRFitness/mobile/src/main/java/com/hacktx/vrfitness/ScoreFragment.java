package com.hacktx.vrfitness;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ScoreFragment extends Fragment {

    ListView scoreList;
    static ArrayList<Score> stringScores;
    boolean done;

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_score, container, false);


        scoreList = (ListView) v.findViewById(R.id.scoreList);
        stringScores = new ArrayList<Score>();
        ParseUser user = ParseUser.getCurrentUser();
        Log.d("parseUSER", user.getUsername());
        Log.d("parseUSER id", user.getObjectId());

        done = false;

        ParseQuery<ParseUser> userQuery = ParseUser.getQuery();
        List<ParseUser> parseUsers = null;
        try {
            parseUsers = userQuery.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }

                Log.d("parseUsers", parseUsers.size() + "");
                for(int j =0; j < parseUsers.size(); j++)
                {
                    List list = parseUsers.get(j).getList("scores");
                    //Collections.sort(list);

                    for(int i = 0; i < list.size(); i++)
                    {
                        stringScores.add(new Score(list.get(i).toString(), parseUsers.get(j).getUsername()));
                        Log.d("TAG1", list.get(i).toString());
                        Log.d("score", "Retrieved " + list.size() + " scores");
                    }
                    Log.d("SIZE", stringScores.size() + "");
                    //stringScores.add(new Score("1231231", "hellooooooo"));
                }


                        Log.d("scoressss", "" + stringScores.size() );

                        Collections.sort(stringScores);
                    StatsArrayAdapter scoreAdapter = new StatsArrayAdapter(getActivity(), stringScores);

                    scoreList.setAdapter(scoreAdapter);
                    // Hooray! The user is logged in.


        return v;
    }




}
