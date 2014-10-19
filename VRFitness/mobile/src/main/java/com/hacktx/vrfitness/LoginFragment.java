package com.hacktx.vrfitness;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.ParseException;

import java.util.ArrayList;

/**
 * Created by TR on 10/18/2014.
 */
public class LoginFragment extends Fragment {

    EditText username;
    EditText password;
    Button login;
    Button signUp;

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle SavedInstanceState) {

        View v = inflater.inflate(R.layout.login_fragment, parent, false);

        username = (EditText) v.findViewById(R.id.username);
        password = (EditText) v.findViewById(R.id.password);
        login = (Button) v.findViewById(R.id.login);
        signUp = (Button) v.findViewById(R.id.signUp);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(username.getText().toString().length() < 6)
                {
                    Toast.makeText(getActivity(), "Username must be at least 6 characters.", Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().length() < 6)
                {
                    Toast.makeText(getActivity(), "Password must be at least 6 characters.", Toast.LENGTH_LONG).show();

                }
                else {
                    ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                        public void done(ParseUser user, ParseException e) {
                            if (user != null) {

                                MainActivity.username = username.getText().toString();
                                Log.d("username", "Login: username: " + MainActivity.username);
                                MainActivity.password = password.getText().toString();
                                Log.d("password", "Login: password: " + MainActivity.password);

                                Fragment tabbedMenuFragment = new TabbedMenu();

                                Bundle bundle = new Bundle();

                                ArrayList<String> pair = new ArrayList<String>();
                                pair.add(username.getText().toString());
                                pair.add(password.getText().toString());
                                bundle.putStringArrayList("pair", pair);

                                tabbedMenuFragment.setArguments(bundle);
                                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                                        .beginTransaction();
                                transaction.replace(R.id.container, tabbedMenuFragment);
                                transaction.addToBackStack("LoginFragment");
                                transaction.commit();
                                // Hooray! The user is logged in.
                            } else {
                                Toast.makeText(getActivity(), "Invalid username/password.", Toast.LENGTH_LONG).show();
                                // Signup failed. Look at the ParseException to see what happened.
                            }
                        }
                    });
                }
            }

        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.user = new ParseUser();
                if(username.getText().toString().length() < 6)
                {
                    Toast.makeText(getActivity(), "Username must be at least 6 characters.", Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().length() < 6)
                {
                    Toast.makeText(getActivity(), "Password must be at least 6 characters.", Toast.LENGTH_LONG).show();

                }
                else
                {
                    MainActivity.user.setUsername(username.getText().toString());
                    MainActivity.user.setPassword(password.getText().toString());


                    MainActivity.user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                ArrayList<Integer> scores = new ArrayList<Integer>();
                                MainActivity.user.put("scores", scores);
                                MainActivity.user.saveInBackground();

                                Fragment tabbedMenuFragment = new TabbedMenu();
                                FragmentTransaction transaction = getActivity().getSupportFragmentManager()
                                        .beginTransaction();
                                transaction.replace(R.id.container, tabbedMenuFragment);
                                transaction.addToBackStack("LoginFragment");
                                transaction.commit();
                            } else {
                                Toast.makeText(getActivity(), "User Already Exists.", Toast.LENGTH_LONG).show();
                                // Sign up didn't succeed. Look at the ParseException
                                // to figure out what went wrong
                            }
                        }
                    });
                }

            }

        });


        





        return v;
    }

}
