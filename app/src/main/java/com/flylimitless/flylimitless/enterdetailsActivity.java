package com.flylimitless.flylimitless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class enterdetailsActivity extends AppCompatActivity implements View.OnClickListener {

    String source, destination, nadult,nchild,ninfant,departday,departmonth,departyear,returnday,returnmonth,returnyear;
    String arritime,departtime,fno,price,total;
    EditText adult1,adult2,adult3,adult4,adultaa1,adultaa2,adultaa3,adultaa4;
    EditText child1,child2,child3,child4,childaa1,childaa2,childaa3,childaa4;
    EditText infant1, infant2, infant3, infant4, infantaa1, infantaa2, infantaa3, infantaa4;
    Button save;
    String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterdetails);

        adult1=(EditText)findViewById(R.id.adultname1);
        adult2=(EditText)findViewById(R.id.adultname2);
        adult3=(EditText)findViewById(R.id.adultname3);
        adult4=(EditText)findViewById(R.id.adultname4);
        adultaa1=(EditText)findViewById(R.id.adultaa1);
        adultaa2=(EditText)findViewById(R.id.adultaa2);
        adultaa3=(EditText)findViewById(R.id.adultaa3);
        adultaa4=(EditText)findViewById(R.id.adultaa4);

        child1=(EditText)findViewById(R.id.childname1);
        child2=(EditText)findViewById(R.id.childname2);
        child3=(EditText)findViewById(R.id.childname3);
        child4=(EditText)findViewById(R.id.childname4);
        childaa1=(EditText)findViewById(R.id.childaa1);
        childaa2=(EditText)findViewById(R.id.childaa2);
        childaa3=(EditText)findViewById(R.id.childaa3);
        childaa4=(EditText)findViewById(R.id.childaa4);

        infant1=(EditText)findViewById(R.id.infantname1);
        infant2=(EditText)findViewById(R.id.infantname2);
        infant3=(EditText)findViewById(R.id.infantname3);
        infant4=(EditText)findViewById(R.id.infantname4);
        infantaa1=(EditText)findViewById(R.id.infantaa1);
        infantaa2=(EditText)findViewById(R.id.infantaa2);
        infantaa3=(EditText)findViewById(R.id.infantaa3);
        infantaa4=(EditText)findViewById(R.id.infantaa4);

        save=(Button)findViewById(R.id.save_btn);
        save.setOnClickListener(this);


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

        if(nadult.equals("1"))
        {
            adult4.setEnabled(false);
            adultaa4.setEnabled(false);
            adult3.setEnabled(false);
            adultaa3.setEnabled(false);
            adult2.setEnabled(false);
            adultaa2.setEnabled(false);

            //here a1 is null as when this page opens it directly reads adult1 when it is vacant and since it do not have any
            //listener so when user enters anything it did not get modified.
            //so provide a listener to adult1 or read it when users press ok button.
        }

        else if(nadult.equals("2"))
        {
            adult4.setEnabled(false);
            adultaa4.setEnabled(false);
            adult3.setEnabled(false);
            adultaa3.setEnabled(false);
        }

        else if(nadult.equals("3"))
        {
            adult4.setEnabled(false);
            adultaa4.setEnabled(false);
        }


         if(nchild.equals("1"))
        {
           child4.setEnabled(false);
            childaa4.setEnabled(false);
            child3.setEnabled(false);
            childaa3.setEnabled(false);
            child2.setEnabled(false);
            childaa2.setEnabled(false);
        }

       else if(nchild.equals("2"))
        {
            child4.setEnabled(false);
            childaa4.setEnabled(false);
            child3.setEnabled(false);
            childaa3.setEnabled(false);
        }

       else if(nchild.equals("3"))
        {
            child4.setEnabled(false);
            childaa4.setEnabled(false);
        }

        else if(nchild.equals("0"))
         {
             child4.setEnabled(false);
             childaa4.setEnabled(false);
             child3.setEnabled(false);
             childaa3.setEnabled(false);
             child2.setEnabled(false);
             childaa2.setEnabled(false);
             child1.setEnabled(false);
             childaa1.setEnabled(false);

         }

        if(ninfant.equals("1"))
        {
            infant4.setEnabled(false);
            infantaa4.setEnabled(false);
            infant3.setEnabled(false);
            infantaa3.setEnabled(false);
            infant2.setEnabled(false);
            infantaa2.setEnabled(false);
        }

        else if(ninfant.equals("2"))
        {
            infant4.setEnabled(false);
            infantaa4.setEnabled(false);
            infant3.setEnabled(false);
            infantaa3.setEnabled(false);
        }

        else if(ninfant.equals("3"))
        {
            infant4.setEnabled(false);
            infantaa4.setEnabled(false);
        }

        else if(ninfant.equals("0"))
        {
            infant4.setEnabled(false);
            infantaa4.setEnabled(false);
            infant3.setEnabled(false);
            infantaa3.setEnabled(false);
            infant2.setEnabled(false);
            infantaa2.setEnabled(false);
            infant1.setEnabled(false);
            infantaa1.setEnabled(false);
        }

    }

    @Override
    public void onClick(View view) {
        if(view==save)
        {

            if(nadult.equals("1"))
            {
                a1=adult1.getText().toString().trim();
                String aa1= adultaa1.getText().toString().trim();
                if(a1.equals(""))
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa1.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();

                //string str==null is not working
                //use str.equals("")

            }

            else if(nadult.equals("2"))
            {
                a1=adult1.getText().toString().trim();
                a2=adult2.getText().toString().trim();
                String aa1= adultaa1.getText().toString().trim();
                String aa2=adultaa2.getText().toString().trim();
                if(a1.equals("") || a2.equals(""))
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa1.equals("") || aa2.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();
            }

            else if(nadult.equals("3"))
            {
                a1=adult1.getText().toString().trim();
                a2=adult2.getText().toString().trim();
                a3=adult3.getText().toString().trim();
                String aa1= adultaa1.getText().toString().trim();
                String aa2=adultaa2.getText().toString().trim();
                String aa3=adultaa3.getText().toString().trim();

                if(a1.equals("") || a2.equals("") ||a3.equals(""))
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa1.equals("") || aa2.equals("")|| aa3.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();
            }

            else if(nadult.equals("4"))
            {
                a1=adult1.getText().toString().trim();
                a2=adult2.getText().toString().trim();
                a3=adult3.getText().toString().trim();
                a4=adult4.getText().toString().trim();
                String aa1= adultaa1.getText().toString().trim();
                String aa2=adultaa2.getText().toString().trim();
                String aa3=adultaa3.getText().toString().trim();
                String aa4=adultaa4.getText().toString().trim();

                if(a1.equals("") || a2.equals("") ||a3.equals("") ||a4.equals(""))
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa1.equals("") || aa2.equals("")|| aa3.equals("") ||aa4.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();
            }



            if(nchild.equals("1"))
            {
                a5=child1.getText().toString().trim();
                String aa5= childaa1.getText().toString().trim();
                if(a5.equals(""))
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa5.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();
            }

            else if(nchild.equals("2"))
            {
                a5=child1.getText().toString().trim();
                a6=child2.getText().toString().trim();
                String aa5= childaa1.getText().toString().trim();
                String aa6= childaa2.getText().toString().trim();
                if(a5.equals("") ||a6.equals(""))
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa5.equals("") ||aa6.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();
            }

            else if(nchild.equals("3"))
            {
                a5=child1.getText().toString().trim();
                a6=child2.getText().toString().trim();
                a7=child3.getText().toString().trim();
                String aa1= childaa1.getText().toString().trim();
                String aa2=childaa2.getText().toString().trim();
                String aa3=childaa3.getText().toString().trim();

                if(a5.equals("") || a6.equals("") ||a7.equals(""))
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa1.equals("") || aa2.equals("") || aa3.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();
            }

            else if(nchild.equals("4"))
            {
                a5=child1.getText().toString().trim();
                a6=child2.getText().toString().trim();
                a7=child3.getText().toString().trim();
                a8=child4.getText().toString().trim();
                String aa1= childaa1.getText().toString().trim();
                String aa2=childaa2.getText().toString().trim();
                String aa3=childaa3.getText().toString().trim();
                String aa4=childaa4.getText().toString().trim();

                if(a5.equals("") || a6.equals("") ||a7.equals("")  ||a8.equals(""))
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa1.equals("") || aa2.equals("") || aa3.equals("") ||aa4.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();

            }

            if(ninfant.equals("1"))
            {
                a9=infant1.getText().toString().trim();
                String aa1= infantaa1.getText().toString().trim();
                if(a9.equals("") )
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa1.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();
            }

            else if(ninfant.equals("2"))
            {
                a9=infant1.getText().toString().trim();
                a10=infant2.getText().toString().trim();
                String aa1= infantaa1.getText().toString().trim();
                String aa2=infantaa2.getText().toString().trim();

                if(a9.equals("") || a10.equals("") )
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa1.equals("") || aa2.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();
            }

            else if(ninfant.equals("3"))
            {
                a9=infant1.getText().toString().trim();
                a10=infant2.getText().toString().trim();
                a11=infant3.getText().toString().trim();
                String aa1= infantaa1.getText().toString().trim();
                String aa2=infantaa2.getText().toString().trim();
                String aa3=infantaa3.getText().toString().trim();

                if(a9.equals("") || a10.equals("") ||a11.equals(""))
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa1.equals("") || aa2.equals("") || aa3.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();

            }

            else if(ninfant.equals("4"))
            {
                a9=infant1.getText().toString().trim();
                a10=infant2.getText().toString().trim();
                a11=infant3.getText().toString().trim();
                a12=infant4.getText().toString().trim();
                String aa1= infantaa1.getText().toString().trim();
                String aa2=infantaa2.getText().toString().trim();
                String aa3=infantaa3.getText().toString().trim();
                String aa4=infantaa4.getText().toString().trim();

                if(a9.equals("") || a10.equals("") ||a11.equals("") ||a12.equals(""))
                {
                    Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
                }

                if(aa1.equals("") || aa2.equals("") || aa3.equals("") ||aa4.equals(""))
                    Toast.makeText(this, "please enter the aadhar no.", Toast.LENGTH_SHORT).show();
            }




            Intent i= new Intent(this,paymentActivity.class);
            i.putExtra("from",source);
            i.putExtra("to",destination);
            i.putExtra("adult",nadult);
            i.putExtra("child",nchild);
            i.putExtra("infant",ninfant);
            i.putExtra("dd",departday);
            i.putExtra("dm",departmonth);
            i.putExtra("dy",departyear);
            i.putExtra("rd",returnday);
            i.putExtra("rm",returnmonth);
            i.putExtra("ry",returnyear);
            i.putExtra("arri",arritime);
            i.putExtra("dt",departtime);
            i.putExtra("fn",fno);
            i.putExtra("pric",price);
            i.putExtra("total1",total);
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


            startActivity(i);
        }
    }
}
