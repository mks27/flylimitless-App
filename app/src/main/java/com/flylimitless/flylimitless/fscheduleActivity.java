package com.flylimitless.flylimitless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class fscheduleActivity extends AppCompatActivity implements View.OnClickListener {

    Button bthome2;
    Button schedule;
    private String source,destination,where;
    private Spinner spinner_from2,spinner_to2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fschedule);

        bthome2= (Button)findViewById(R.id.btHome2);
        bthome2.setOnClickListener(this);

        schedule=(Button)findViewById(R.id.schedulebtn);
        schedule.setOnClickListener(this);



        spinner_from2= (Spinner)findViewById(R.id.sp_from2);
        ArrayAdapter<String> adapter_11= new ArrayAdapter<String>(fscheduleActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.fromlist));

        adapter_11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from2.setAdapter(adapter_11);


        spinner_to2= (Spinner)findViewById(R.id.sp_to2);
        ArrayAdapter<String> adapter_12= new ArrayAdapter<String>(fscheduleActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.tolist));

        adapter_12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_to2.setAdapter(adapter_12);


    }



    @Override
    public void onClick(View view) {
        if(view==bthome2)
        {
            finish();
            startActivity(new Intent(this, SearchActivity.class));
        }

        if(view==schedule)
        {
            Intent i= new Intent(this, showflightActivity.class);
            source= spinner_from2.getSelectedItem().toString();
            destination= spinner_to2.getSelectedItem().toString();
            where="schedule";

            if(source.equals("From") || destination.equals("To"))
            {
                Toast.makeText(this, "please select source and destination correctly", Toast.LENGTH_SHORT).show();
            }

            else if(source.equals(destination))
            {
                Toast.makeText(this, "source and destination can't be same", Toast.LENGTH_SHORT).show();
            }

            else{
                i.putExtra("from",source);
                i.putExtra("to",destination);
                i.putExtra("where",where);

                startActivity(i);
            }

        }
    }
}
