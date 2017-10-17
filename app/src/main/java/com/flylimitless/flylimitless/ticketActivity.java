package com.flylimitless.flylimitless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ticketActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textfno,from,to,dept,arri,date,tprice,ttotal,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
    Button conf;
    String source, destination, nadult,nchild,ninfant,departday,departmonth,departyear,returnday,returnmonth,returnyear;
    String arritime,departtime,fno,price,total,date1;
    String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;
    private FirebaseAuth mauth;
    private DatabaseReference reference,reference1,reference2;
    private bookedticket book1;
    String userId,userEmail,ref,num;
    String action,ticket;
    private cancelledflights note;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);


        mauth=  FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mauth.getCurrentUser();
        if (firebaseUser != null) {
            userId = firebaseUser.getUid();
            userEmail = firebaseUser.getEmail();
        }

        int l=userEmail.length();
        ref= userEmail.substring(0,l-10);

        reference = FirebaseDatabase.getInstance().getReference("booked ticket");



        textfno=(TextView)findViewById(R.id.vno);
        from=(TextView)findViewById(R.id.vsource);
        to=(TextView)findViewById(R.id.vdest);
        dept=(TextView)findViewById(R.id.vdept);
        arri=(TextView)findViewById(R.id.varri);
        date=(TextView)findViewById(R.id.vdate);
        tprice=(TextView)findViewById(R.id.vprice);
        ttotal=(TextView)findViewById(R.id.vtotal);
        p1=(TextView)findViewById(R.id.p1);
        p2=(TextView)findViewById(R.id.p2);
        p3=(TextView)findViewById(R.id.p3);
        p4=(TextView)findViewById(R.id.p4);
        p5=(TextView)findViewById(R.id.p5);
        p6=(TextView)findViewById(R.id.p6);
        p7=(TextView)findViewById(R.id.p7);
        p8=(TextView)findViewById(R.id.p8);
        p9=(TextView)findViewById(R.id.p9);
        p10=(TextView)findViewById(R.id.p10);
        p11=(TextView)findViewById(R.id.p11);
        p12=(TextView)findViewById(R.id.p12);

        conf=(Button)findViewById(R.id.bookanotherbtn);
        conf.setOnClickListener(this);


        p1.setVisibility(TextView.GONE);
        p2.setVisibility(TextView.GONE);
        p3.setVisibility(TextView.GONE);
        p4.setVisibility(TextView.GONE);
        p5.setVisibility(TextView.GONE);
        p6.setVisibility(TextView.GONE);
        p7.setVisibility(TextView.GONE);
        p8.setVisibility(TextView.GONE);
        p9.setVisibility(TextView.GONE);
        p10.setVisibility(TextView.GONE);
        p11.setVisibility(TextView.GONE);
        p12.setVisibility(TextView.GONE);



        Bundle firstdata= getIntent().getExtras();

        if(firstdata==null)
            return;

        source= firstdata.getString("from");
        destination= firstdata.getString("to");
        nadult= firstdata.getString("nadult");
        nchild= firstdata.getString("nchild");
        ninfant= firstdata.getString("ninfant");
        departday= firstdata.getString("departday");
        departmonth= firstdata.getString("departmonth");
        departyear= firstdata.getString("departyear");
        returnday= firstdata.getString("returnday");
        returnmonth= firstdata.getString("returnmonth");
        returnyear= firstdata.getString("returnyear");
        arritime=firstdata.getString("arritime");
        departtime=firstdata.getString("departtime");
        fno=firstdata.getString("fno");
        price=firstdata.getString("price");
        total=firstdata.getString("total");
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
        action=firstdata.getString("booked");
        ticket=firstdata.getString("ticketno");

       // Log.i("hellohellohellohello",returnday);

        if(action.equals("frombookedticket"))
        conf.setText("Cancel the ticket");


        textfno.setText(fno);
        from.setText(source);
        to.setText(destination);
        dept.setText(departtime);
        arri.setText(arritime);
        date.setText(departday+"/"+departmonth+"/"+departyear);
        tprice.setText(price);
        ttotal.setText(total);
        int n1,n2,n3,n;
        n1=Integer.valueOf(nadult);
        n2=Integer.valueOf(nchild);
        n3=Integer.valueOf(ninfant);
        n=n1+n2+n3;

        if(n1==1)
        {
           p1.setVisibility(TextView.VISIBLE);
            if(a1!=null)
            p1.setText(a1);
        }
        else if(n1==2)
        {
            p1.setVisibility(TextView.VISIBLE);
            p2.setVisibility(TextView.VISIBLE);
            if(a1!=null)
                p1.setText(a1);
            p2.setText(a2);

        }
        else if(n1==3){
            p1.setVisibility(TextView.VISIBLE);
            p2.setVisibility(TextView.VISIBLE);
            p3.setVisibility(TextView.VISIBLE);
            p1.setText(a1);
            p2.setText(a2);
            p3.setText(a3);

        }
        else if(n1==4)
        {
            p1.setVisibility(TextView.VISIBLE);
            p2.setVisibility(TextView.VISIBLE);
            p3.setVisibility(TextView.VISIBLE);
            p4.setVisibility(TextView.VISIBLE);
            p1.setText(a1);
            p2.setText(a2);
            p3.setText(a3);
            p4.setText(a4);
        }


        if(n2==1)
        {
            p5.setVisibility(TextView.VISIBLE);
            if(a5!=null)
                p5.setText(a5);
        }
        else if(n2==2)
        {
            p5.setVisibility(TextView.VISIBLE);
            p6.setVisibility(TextView.VISIBLE);
            if(a5!=null)
                p5.setText(a5);
            p6.setText(a6);

        }
        else if(n2==3){
            p5.setVisibility(TextView.VISIBLE);
            p6.setVisibility(TextView.VISIBLE);
            p7.setVisibility(TextView.VISIBLE);
            p5.setText(a5);
            p6.setText(a6);
            p7.setText(a7);

        }
        else if(n2==4)
        {
            p5.setVisibility(TextView.VISIBLE);
            p6.setVisibility(TextView.VISIBLE);
            p7.setVisibility(TextView.VISIBLE);
            p8.setVisibility(TextView.VISIBLE);
            p5.setText(a5);
            p6.setText(a6);
            p7.setText(a7);
            p8.setText(a8);
        }

        //infant

        if(n3==1)
        {
            p9.setVisibility(TextView.VISIBLE);
            if(a9!=null)
                p9.setText(a9);
        }
        else if(n3==2)
        {
            p9.setVisibility(TextView.VISIBLE);
            p10.setVisibility(TextView.VISIBLE);
            if(a9!=null)
                p9.setText(a9);
            p10.setText(a10);

        }
        else if(n3==3){
            p9.setVisibility(TextView.VISIBLE);
            p10.setVisibility(TextView.VISIBLE);
            p11.setVisibility(TextView.VISIBLE);
            p9.setText(a9);
            p10.setText(a10);
            p11.setText(a11);

        }
        else if(n3==4)
        {
            p9.setVisibility(TextView.VISIBLE);
            p10.setVisibility(TextView.VISIBLE);
            p11.setVisibility(TextView.VISIBLE);
            p12.setVisibility(TextView.VISIBLE);
            p9.setText(a9);
            p10.setText(a10);
            p11.setText(a11);
            p12.setText(a12);
        }


      if(action.equals("payment"))
      {
           if(returnday.equals("40"))
              num="2";

           else  if(returnday.equals("0"))
               num="1";
          else
              num="3";
      }




    }


    public void onBackPressed()
    {
        //do whatever you want the 'Back' button to do
            this.startActivity(new Intent(ticketActivity.this,SearchActivity.class));
            return;
    }


    @Override
    public void onClick(View view) {
        if(view==conf)
        {

            if(action.equals("payment"))
            {
                if(!returnday.equals("0") && !returnday.equals("40"))
                {

                    book1= new bookedticket(source,destination, departtime, arritime, price,fno ,total,departday,departmonth, departyear,nadult,nchild,ninfant, a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12);
                    reference.child(ref).child("3").setValue(book1);

                    Intent i= new Intent(this, showflightActivity.class);
                    String s=destination;
                    String de=source;
                    departday=returnday;
                    departmonth=returnmonth;
                    departyear=returnyear;
                    returnday="0";
                    i.putExtra("from",s);
                    i.putExtra("to",de);
                    i.putExtra("nadult",nadult);
                    i.putExtra("nchild",nchild);
                    i.putExtra("ninfant",ninfant);
                    i.putExtra("departday",departday);
                    i.putExtra("departmonth",departmonth);
                    i.putExtra("departyear",departyear);
                    i.putExtra("returnday",returnday);
                    i.putExtra("returnmonth",returnmonth);
                    i.putExtra("returnyear",returnyear);

                    startActivity(i);

                }
                else{
                    book1= new bookedticket(source,destination, departtime, arritime, price,fno ,total,departday,departmonth, departyear,nadult,nchild,ninfant, a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12);
                    reference.child(ref).child(num).setValue(book1);
                    finish();
                    startActivity(new Intent(this,SearchActivity.class));
                }

            }

            else
            {
                reference1 = FirebaseDatabase.getInstance().getReference("cancelledflights");

                //pune to delhi
                if (source.equalsIgnoreCase("pune") && destination.equalsIgnoreCase("delhi"))
                {
                    note = new cancelledflights(source,destination,departtime,arritime,price,fno,date1);
                    reference1.child("1").setValue(note);
                }

                //mumbai to delhi
                if (source.equalsIgnoreCase("mumbai") && destination.equalsIgnoreCase("delhi"))
                {
                    note = new cancelledflights(source,destination,departtime,arritime,price,fno,date1);
                    reference1.child("6").setValue(note);
                }

                //pune to jaipur

                if (source.equalsIgnoreCase("pune") && destination.equalsIgnoreCase("jaipur"))
                {
                    note = new cancelledflights(source,destination,departtime,arritime,price,fno,date1);
                    reference1.child("11").setValue(note);
                }

                //mumbai to jaipur

                if (source.equalsIgnoreCase("mumbai") && destination.equalsIgnoreCase("jaipur"))
                {
                    note = new cancelledflights(source,destination,departtime,arritime,price,fno,date1);
                    reference1.child("16").setValue(note);
                }

                //delhi to jaipur

                if (source.equalsIgnoreCase("delhi") && destination.equalsIgnoreCase("jaipur"))
                {
                    note = new cancelledflights(source,destination,departtime,arritime,price,fno,date1);
                    reference1.child("21").setValue(note);
                }

                //delhi to pune

                if (source.equalsIgnoreCase("delhi") && destination.equalsIgnoreCase("pune"))
                {
                    note = new cancelledflights(source,destination,departtime,arritime,price,fno,date1);
                    reference1.child("26").setValue(note);
                }

                //delhi to mumbai

                if (source.equalsIgnoreCase("delhi") && destination.equalsIgnoreCase("mumbai"))
                {
                    note = new cancelledflights(source,destination,departtime,arritime,price,fno,date1);
                    reference1.child("31").setValue(note);
                }

                //jaipur to pune

                if (source.equalsIgnoreCase("jaipur") && destination.equalsIgnoreCase("pune"))
                {
                    note = new cancelledflights(source,destination,departtime,arritime,price,fno,date1);
                    reference1.child("36").setValue(note);
                }

                //jaipur to mumbai

                if (source.equalsIgnoreCase("jaipur") && destination.equalsIgnoreCase("mumbai"))
                {
                    note = new cancelledflights(source,destination,departtime,arritime,price,fno,date1);
                    reference1.child("41").setValue(note);
                }

                //jaipur to delhi

                if (source.equalsIgnoreCase("jaipur") && destination.equalsIgnoreCase("delhi"))
                {
                    note = new cancelledflights(source,destination,departtime,arritime,price,fno,date1);
                    reference1.child("46").setValue(note);
                }

                reference2 = FirebaseDatabase.getInstance().getReference("booked ticket").child(ref);

                reference2.child(ticket).removeValue();

                finish();
                startActivity(new Intent(this, SearchActivity.class));





            }

        }
    }
}
