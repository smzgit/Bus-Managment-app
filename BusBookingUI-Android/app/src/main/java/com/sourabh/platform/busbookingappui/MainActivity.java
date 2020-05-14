package com.sourabh.platform.busbookingappui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity  {

    Button search_buses;
    AutoCompleteTextView dest,sorc;
    EditText dt ;
    String[] cities ={"Sangli","Washi","Marathwada","Belgaum","Miraj",
            "Pune ", "Mumbai ", "Nasik ", "Solapur"  , "Satara", "Latur" ,
            "Kolhapur" ,"Amravati " , "Dhule", "Jalna", "Panvel ", "Udgir"};

    boolean testInput(String a,String b){

        if(a.isEmpty() || b.isEmpty()){
            Toast.makeText(getApplicationContext(),
                    "Destination or Source not entered !!",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if(a.equals(b)){
            Toast.makeText(getApplicationContext(),
                    "Destination and Source must not be same.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        return true ;
    }

    boolean checkDate(Date date,Date r){
        if (r==null){
            Toast.makeText(getApplicationContext(),
                    "Date not entered !.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (date.compareTo(r)>0) {
            Toast.makeText(getApplicationContext(),
                    "Date Invalid !!",
                    Toast.LENGTH_SHORT).show();
           return false ;
        }

        return true ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,cities);

        search_buses = findViewById(R.id.search_buses);
        dest =  (AutoCompleteTextView)findViewById(R.id.destination);
        sorc =  (AutoCompleteTextView)findViewById(R.id.src);
        dt = (EditText)findViewById(R.id.inp_date) ;
        dest.setThreshold(1);
        sorc.setThreshold(1);
        dest.setAdapter(adapter);
        sorc.setAdapter(adapter);

        final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = new Date();



        search_buses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date r =null;
                String d = dest.getText().toString();
                String s = sorc.getText().toString();
                try {
                    r = formatter.parse(dt.getText().toString()) ;
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                if(testInput(d,s) && checkDate(date, r)){
                    Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent); }
            }
        } );
    }
}
