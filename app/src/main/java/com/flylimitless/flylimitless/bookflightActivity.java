package com.flylimitless.flylimitless;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
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

public class bookflightActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView depart_date;
    private TextView return_date;
    static final int DATE_DIALOG_ID = 999;
    int count=0;
    private int year;
    private int month;
    private int day;
    private RadioButton oneway;
    private RadioButton roundway;
    private Button searchbtn;
   private Spinner spinner_from;
    private Spinner spinner_to;
    private Spinner spinner_adult, spinner_child, spinner_infant;
    int departday=0, departmonth=0, departyear=0,returnday=0,returnmonth=0,returnyear=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookflight);

         spinner_from= (Spinner)findViewById(R.id.sp_from);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(bookflightActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.fromlist));

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(adapter1);

         spinner_to= (Spinner)findViewById(R.id.sp_to);
        ArrayAdapter<String>adapter2= new ArrayAdapter<String>(bookflightActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.tolist));

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_to.setAdapter(adapter2);


         spinner_adult= (Spinner)findViewById(R.id.adult_sp);
        ArrayAdapter<String>adapter3= new ArrayAdapter<String>(bookflightActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.adultlist));

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_adult.setAdapter(adapter3);



        spinner_child= (Spinner)findViewById(R.id.child_sp);
        ArrayAdapter<String>adapter4= new ArrayAdapter<String>(bookflightActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.childlist));

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_child.setAdapter(adapter4);



        spinner_infant= (Spinner)findViewById(R.id.infant_sp);
        ArrayAdapter<String>adapter5= new ArrayAdapter<String>(bookflightActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.infantlist));

        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_infant.setAdapter(adapter5);


        //date picker...................
        depart_date= (TextView)findViewById(R.id.departdate);
        depart_date.setOnClickListener(this);
        return_date= (TextView)findViewById(R.id.returndate);
        return_date.setOnClickListener(this);

        oneway= (RadioButton)findViewById(R.id.rb_oneway);
        roundway=(RadioButton)findViewById(R.id.rb_round);

        searchbtn= (Button)findViewById(R.id.search_btn);
        searchbtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view==depart_date)
        {
            count=1;
            showDialog(DATE_DIALOG_ID);
        }

        if(view==return_date)
        {
            count=2;
            showDialog(DATE_DIALOG_ID);
        }

        if(view==searchbtn)
        {
            Intent i= new Intent(this, showflightActivity.class);
           final String source= spinner_from.getSelectedItem().toString();
          final  String destination= spinner_to.getSelectedItem().toString();
            final String adult= spinner_adult.getSelectedItem().toString();
            final String child= spinner_child.getSelectedItem().toString();
            final String infant= spinner_infant.getSelectedItem().toString();
            final String dd= String.valueOf(departday);
            final String dm= String.valueOf(departmonth);
            final String dy= String.valueOf(departyear);
            final String rd= String.valueOf(returnday);
            final String rm= String.valueOf(returnmonth);
            final String ry= String.valueOf(returnyear);


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
                i.putExtra("returnday",rd);
                i.putExtra("returnmonth",rm);
                i.putExtra("returnyear",ry);

                startActivity(i);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
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
            if(count==1)
            {
                depart_date.setText(new StringBuilder().append(day)
                        .append("-").append(month+1).append("-").append(year)
                        .append(" "));

                departday= day;
                departmonth=month+1;
                departyear=year;

            }

            if(count==2)
            {
                return_date.setText(new StringBuilder().append(day)
                        .append("-").append(month+1).append("-").append(year)
                        .append(" "));

                returnday= day;
                returnmonth=month+1;
                returnyear=year;
            }


        }
    };

    public void onclickradio(View view)
    {
        if(view==oneway)
        {
            oneway.setChecked(true);
            roundway.setChecked(false);
            return_date.setVisibility(View.GONE);
        }

        else if(view==roundway)
        {
            oneway.setChecked(false);
            roundway.setChecked(true);
            return_date.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
