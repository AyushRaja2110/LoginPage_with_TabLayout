package com.example.login_page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class tab_log_in extends Fragment {


    EditText log_email,log_passsword;
    TextView forgetpassword;
    Button login;
    ProgressBar progressBar1;
    FirebaseAuth fAuth;
    FloatingActionButton fb,google,twitter;
   // Float x= Float.valueOf(0);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_tab_log_in, container, false);

        log_email = v.findViewById(R.id.log_email);
        log_passsword = v.findViewById(R.id.log_password);
        forgetpassword = v.findViewById(R.id.forpass);
        login = v.findViewById(R.id.btn_login);
        fb = v.findViewById(R.id.fb);
        google = v.findViewById(R.id.google);
        twitter = v.findViewById(R.id.twitter);

        fAuth = FirebaseAuth.getInstance();
        progressBar1 = v.findViewById(R.id.progressBar);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 =log_email.getText().toString().trim();
                String password1 =log_email.getText().toString().trim();

                if(TextUtils.isEmpty(email1)){
                    log_email.setError("Email id Required");
                }
                if (TextUtils.isEmpty(password1)){
                    log_passsword.setError("Password is Required");
                }
                if (password1.length() < 6){
                    log_passsword.setError("Password must be >= 6 character");
                }
                progressBar1.setVisibility(View.VISIBLE);

            }
        });
        return v;
    }
}