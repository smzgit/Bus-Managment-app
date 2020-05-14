package com.sourabh.platform.busbookingappui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class first extends AppCompatActivity {

    Button btn_login, btn_sign_up;
    EditText username;
    EditText pass ;

    String uname = "smz007";
    String pwd = "12345" ;

    boolean testInput(String a,String b){

        if(a.isEmpty() || b.isEmpty()){
            Toast.makeText(getApplicationContext(),
                    "Username or password not entered !!",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if(a.equals(uname) && b.equals(pwd)){
            Toast.makeText(getApplicationContext(),
                    "Login Successful",
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(getApplicationContext(),
                "Wrong Username or password !!",
                Toast.LENGTH_SHORT).show();
        return false ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first2);

        btn_login = (Button) findViewById(R.id.button_login);
        btn_sign_up = (Button) findViewById(R.id.button4);
        username = (EditText) findViewById(R.id.uname);
        pass = (EditText) findViewById(R.id.pass);

        //username.setText("smz007");
        //pass.setText("12345");
        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String unamee  = username.getText().toString() ;
                String paswrd = pass.getText().toString() ;

               if(testInput(unamee,paswrd)){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);}

            }
        });

        btn_sign_up.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(getApplicationContext(),Sign_up.class);
                    startActivity(intent);

            }
        });
    }
}
