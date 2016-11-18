package com.example.nirbhay.blipper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nirbhay Pherwani on 16/11/2016
 */

public class LoginActivity extends AppCompatActivity {

    static String userid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_form);

        TextView myTextView2=(TextView)findViewById(R.id.label_points);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf");
        myTextView2.setTypeface(typeFace);





    }
    @Override
    public void onBackPressed() {

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
    public void signupPost(View view){
        Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(i);

    }
    public void loginPost(View view){
        EditText username = (EditText) findViewById(R.id.tusername);
        EditText password = (EditText) findViewById(R.id.tpassword);
        String uname = username.getText().toString();
        String pass = password.getText().toString();
        if(!uname.equals("") && !pass.equals("")){

            new ValidateUserLogin(this).execute(uname,pass);


        }
        else{
            Toast toast= Toast.makeText(this, "Please Fill all entries!", Toast.LENGTH_SHORT);
            toast.setMargin(150,150);
            toast.show();
        }




    }
}