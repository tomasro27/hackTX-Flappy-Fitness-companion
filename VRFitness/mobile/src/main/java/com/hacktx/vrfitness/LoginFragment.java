package com.hacktx.vrfitness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by TR on 10/18/2014.
 */
public class LoginFragment extends Fragment {

    EditText username;
    EditText password;
    Button login;
    Button register;

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle SavedInstanceState) {

        View v = inflater.inflate(R.layout.login_fragment, parent, false);

        username = (EditText) v.findViewById(R.id.username);
        password = (EditText) v.findViewById(R.id.password);
        login = (Button) v.findViewById(R.id.login);
        register = (Button) v.findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
//                ParseUser user = new ParseUser();
//                user.setUsername("");
//                user.setPassword("my pass");
//
//// other fields can be set just like with ParseObject
//                user.put("phone", "650-555-0000");
//
//                user.signUpInBackground(new SignUpCallback() {
//                    public void done(ParseException e) {
//                        if (e == null) {
//                            // Hooray! Let them use the app now.
//                        } else {
//                            // Sign up didn't succeed. Look at the ParseException
//                            // to figure out what went wrong
//                        }
//                    }
//                });
            }

        });

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {

            }

        });


        





        return v;
    }

}
