package com.flylimitless.flylimitless;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class searchcancelledfActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView date;
    static final int DATE_DIALOG_ID = 999;
    int count=0;
    private int year;
    private int month;
    private int day;
    private Button searchbtn,home;
    private Spinner spinner_from;
    private Spinner spinner_to;
    private Spinner spinner_adult,spinner_child,spinner_infant;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchcancelledf);

        spinner_from= (Spinner)findViewById(R.id.sp_from3);
        ArrayAdapter<String> adapter3_1= new ArrayAdapter<String>(searchcancelledfActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.fromlist));

        adapter3_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(adapter3_1);


        spinner_to= (Spinner)findViewById(R.id.sp_to3);
        ArrayAdapter<String>adapter3_2= new ArrayAdapter<String>(searchcancelledfActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.tolist));

        adapter3_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_to.setAdapter(adapter3_2);



        spinner_adult= (Spinner)findViewById(R.id.sp_adult3);
        ArrayAdapter<String> adapter3_3= new ArrayAdapter<String>(searchcancelledfActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.adultlist));

        adapter3_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_adult.setAdapter(adapter3_3);


        spinner_child= (Spinner)findViewById(R.id.sp_child3);
        ArrayAdapter<String> adapter3_4= new ArrayAdapter<String>(searchcancelledfActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.childlist));

        adapter3_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_child.setAdapter(adapter3_4);


        spinner_infant= (Spinner)findViewById(R.id.sp_infant3);
        ArrayAdapter<String> adapter3_5= new ArrayAdapter<String>(searchcancelledfActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.infantlist));

        adapter3_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_infant.setAdapter(adapter3_5);




        date=(TextView)findViewById(R.id.textdate3);
        date.setOnClickListener(this);


        searchbtn=(Button)findViewById(R.id.search_btn3);
        searchbtn.setOnClickListener(this);

        home=(Button)findViewById(R.id.btHome3);
        home.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==date)
        {
            showDialog(DATE_DIALOG_ID);
        }

        if(view==home)
        {
            startActivity(new Intent(this,SearchActivity.class));
        }

        if(view==searchbtn)
        {
            Intent i= new Intent(this, showcancelledfActivity.class);
            final String source= spinner_from.getSelectedItem().toString();
            final  String destination= spinner_to.getSelectedItem().toString();
            final String adult= spinner_adult.getSelectedItem().toString();
            final String child= spinner_child.getSelectedItem().toString();
            final String infant= spinner_infant.getSelectedItem().toString();
            final String dd= String.valueOf(day);
            final String dm= String.valueOf(month);
            final String dy= String.valueOf(year);

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
                i.putExtra("nadult",adult);
                i.putExtra("nchild",child);
                i.putExtra("ninfant",infant);
                i.putExtra("departday",dd);
                i.putExtra("departmonth",dm);
                i.putExtra("departyear",dy);


                startActivity(i);
            }
        }
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview


                date.setText(new StringBuilder().append(day)
                        .append("-").append(month+1).append("-").append(year)
                        .append(" "));

        }
    };
}
