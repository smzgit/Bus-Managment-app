package com.sourabh.platform.busbookingappui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    EditText name,num,expdte;
    Button cnfm ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        name = (EditText) findViewById(R.id.cname) ;
        num = (EditText) findViewById(R.id.cno) ;
        expdte = (EditText) findViewById(R.id.exp_date) ;
        cnfm = (Button) findViewById(R.id.go) ;

        cnfm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nam  = name.getText().toString() ;
                String no = num.getText().toString() ;
                String dt = expdte.getText().toString() ;

                if(!nam.isEmpty() || !no.isEmpty() || !dt.isEmpty()){

                    final ProgressDialog progress = new ProgressDialog(Payment.this);
                    progress.setTitle("Connecting ..");
                    progress.setMessage("Please wait while we connect to Bank Server...");
                    progress.show();

                    Runnable progressRunnable = new Runnable() {

                        @Override
                        public void run() {
                            progress.cancel();
                            Toast.makeText(getApplicationContext(),
                                    "Payment Successful !!",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),first.class);
                            startActivity(intent);
                        }
                    };

                    Handler pdCanceller = new Handler();
                    pdCanceller.postDelayed(progressRunnable, 6000);


                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Name,Number or Expiry date not entered !!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
