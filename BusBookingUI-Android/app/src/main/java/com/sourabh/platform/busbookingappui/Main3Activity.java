package com.sourabh.platform.busbookingappui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    Button p2p ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);
        p2p = (Button) findViewById(R.id.pay) ;

        p2p.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(getApplicationContext(),Payment.class);
                    startActivity(intent);

            }
        });
    }
}
