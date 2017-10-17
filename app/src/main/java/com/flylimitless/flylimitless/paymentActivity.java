package com.flylimitless.flylimitless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class paymentActivity extends AppCompatActivity implements View.OnClickListener {

    Button pay;
    String source, destination, nadult,nchild,ninfant,departday,departmonth,departyear,returnday,returnmonth,returnyear;
    String arritime,departtime,fno,price,total;
    String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;
    String num="payment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Spinner spinner_month= (Spinner)findViewById(R.id.sp_month);
        ArrayAdapter<String> adapter_month= new ArrayAdapter<String>(paymentActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.monthlist));

        adapter_month.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_month.setAdapter(adapter_month);


        Spinner spinner_year= (Spinner)findViewById(R.id.sp_year);
        ArrayAdapter<String> adapter_year= new ArrayAdapter<String>(paymentActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.yearlist));

        adapter_year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_year.setAdapter(adapter_year);

        pay=(Button)findViewById(R.id.pay_btn);
        pay.setOnClickListener(this);


        Bundle firstdata= getIntent().getExtras();

        if(firstdata==null)
            return;

        source= firstdata.getString("from");
        destination= firstdata.getString("to");
        nadult= firstdata.getString("adult");
        nchild= firstdata.getString("child");
        ninfant= firstdata.getString("infant");
        departday= firstdata.getString("dd");
        departmonth= firstdata.getString("dm");
        departyear= firstdata.getString("dy");
        returnday= firstdata.getString("rd");
        returnmonth= firstdata.getString("rm");
        returnyear= firstdata.getString("ry");
        arritime=firstdata.getString("arri");
        departtime=firstdata.getString("dt");
        fno=firstdata.getString("fn");
        price=firstdata.getString("pric");
        total=firstdata.getString("total1");
        a1=firstdata.getString("per1");
        a2=firstdata.getString("per2");
        a3=firstdata.getString("per3");
        a4=firstdata.getString("per4");
        a5=firstdata.getString("per5");
        a6=firstdata.getString("per6");
        a7=firstdata.getString("per7");
        a8=firstdata.getString("per8");
        a9=firstdata.getString("per9");
        a10=firstdata.getString("per10");
        a11=firstdata.getString("per11");
        a12=firstdata.getString("per12");


    }

    @Override
    public void onClick(View view) {
        if(view==pay)
        {
            Intent i= new Intent(this,ticketActivity.class);
            i.putExtra("from",source);
            i.putExtra("to",destination);
            i.putExtra("nadult",nadult);
            i.putExtra("nchild",nchild);
            i.putExtra("ninfant",ninfant);
            i.putExtra("departday",departday);
            i.putExtra("departmonth",departmonth);
            i.putExtra("departyear",departyear);
            i.putExtra("returnday",returnday);
            i.putExtra("returnmonth",returnmonth);
            i.putExtra("returnyear",returnyear);
            i.putExtra("arritime",arritime);
            i.putExtra("departtime",departtime);
            i.putExtra("fno",fno);
            i.putExtra("price",price);
            i.putExtra("total",total);
            i.putExtra("per1",a1);
            i.putExtra("per2",a2);
            i.putExtra("per3",a3);
            i.putExtra("per4",a4);
            i.putExtra("per5",a5);
            i.putExtra("per6",a6);
            i.putExtra("per7",a7);
            i.putExtra("per8",a8);
            i.putExtra("per9",a9);
            i.putExtra("per10",a10);
            i.putExtra("per11",a11);
            i.putExtra("per12",a12);
            i.putExtra("booked",num);

            Toast.makeText(this, "Payment Successfull", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "don't press back button", Toast.LENGTH_SHORT).show();
             finish();
            startActivity(i);
        }
    }
}
