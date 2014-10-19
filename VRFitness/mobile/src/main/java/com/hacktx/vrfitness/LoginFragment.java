package com.hacktx.vrfitness;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by TR on 10/18/2014.
 */
public class LoginFragment extends Fragment {

    EditText username;
    EditText password;
    Button login;
    Button register;

    @Override
    public void onCreate(Bundle ksavedInstanceState) { super.onCreate(ksavedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle SavedInstanceState)
    {
        View v = inflater.inflate(R.layout.login_fragment, parent, false);

        username = (EditText) v.findViewById(R.id.username);
        password = (EditText) v.findViewById(R.id.password);
        login = (Button) v.findViewById(R.id.login);
        register = (Button) v.findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {

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
