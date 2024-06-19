package com.example.login_page;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class tab_sign_up extends Fragment {

    EditText name,email,password,phone;
    Button signup;
    ProgressBar pBar;
    FirebaseAuth fAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup v =  (ViewGroup) inflater.inflate(R.layout.fragment_tab_sign_up, container,false);

        name = v.findViewById(R.id.name);
        email = v.findViewById(R.id.email);
        password = v.findViewById(R.id.password);
        phone = v.findViewById(R.id.phone);
        signup = v.findViewById(R.id.btn_signup);
        pBar = v.findViewById(R.id.pBar2);

        fAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eml = email.getText().toString().trim();
                String pas = password.getText().toString().trim();
                String name1 =  name.getText().toString();
                String phone1 = phone.getText().toString();

                if (TextUtils.isEmpty(eml)){
                    email.setError("Email is Required");
                }
                if (TextUtils.isEmpty(pas)){
                    password.setError("Password is required");
                }
                if (pas.length()<6){
                    password.setError("Password must be >= 6 character");
                }
                if (TextUtils.isEmpty(name1)){
                    name.setError("Please Enter Your Name");
                }
                if (TextUtils.isEmpty(phone1)){
                    phone.setError("Please Enter Your Phone Number");
                }
                pBar.setVisibility(View.VISIBLE);

            }
        });

        return v;
    }
}