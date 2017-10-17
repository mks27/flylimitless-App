package com.flylimitless.flylimitless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class bookedticketsActivity extends AppCompatActivity implements View.OnClickListener {


    String source, destination, nadult,nchild,ninfant,departday,departmonth,departyear,returnday,returnmonth,returnyear;
    String arritime,departtime,fno,price,total;
    String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;

    String source1, destination1, nadult1,nchild1,ninfant1,departday1,departmonth1,departyear1,returnday1,returnmonth1,returnyear1;
    String arritime1,departtime1,fno1,price1,total1;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    String num;

    String source2, destination2, nadult2,nchild2,ninfant2,departday2,departmonth2,departyear2,returnday2,returnmonth2,returnyear2;
    String arritime2,departtime2,fno2,price2,total2;
    String c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;

    private FirebaseAuth mauth;
    private DatabaseReference datareference;
    private bookedticket book,book1,book2;
    String userId,userEmail,ref,ticketno;
    private Button dbtn1;
    private Button dbtn2;
    private Button dbtn3;
    private Button dbtn4;
    private Button dbtn5;
    private TextView from1,to1,date1;
    private TextView from2,to2,date2;
    private TextView from3,to3,date3;
    private TextView from4,to4,date4;
    private TextView from5,to5,date5;
    LinearLayout layout1,layout2,layout3,layout4,layout5;
    int z=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookedtickets);

        mauth=  FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mauth.getCurrentUser();
        if (firebaseUser != null) {
            userId = firebaseUser.getUid();
            userEmail = firebaseUser.getEmail();
        }

        int l=userEmail.length();
        ref= userEmail.substring(0,l-10);


        layout1= (LinearLayout)findViewById(R.id.layout1);
        layout1.setVisibility(LinearLayout.INVISIBLE);

        layout2= (LinearLayout)findViewById(R.id.layout2);
        layout2.setVisibility(LinearLayout.INVISIBLE);

        layout3= (LinearLayout)findViewById(R.id.layout3);
        layout3.setVisibility(LinearLayout.INVISIBLE);

        layout4= (LinearLayout)findViewById(R.id.layout4);
        layout4.setVisibility(LinearLayout.INVISIBLE);

        layout5= (LinearLayout)findViewById(R.id.layout5);
        layout5.setVisibility(LinearLayout.INVISIBLE);

        dbtn1= (Button)findViewById(R.id.detailsbtn1);
        dbtn1.setOnClickListener(this);

        dbtn2= (Button)findViewById(R.id.detailsbtn2);
        dbtn2.setOnClickListener(this);

        dbtn3= (Button)findViewById(R.id.detailsbtn3);
        dbtn3.setOnClickListener(this);

        from1=(TextView)findViewById(R.id.viewsource1);
        to1=(TextView)findViewById(R.id.viewdest1);
        date1=(TextView)findViewById(R.id.viewdate1);

        from2=(TextView)findViewById(R.id.viewsource2);
        to2=(TextView)findViewById(R.id.viewdest2);
        date2=(TextView)findViewById(R.id.viewdate2);

        from3=(TextView)findViewById(R.id.viewsource3);
        to3=(TextView)findViewById(R.id.viewdest3);
        date3=(TextView)findViewById(R.id.viewdate3);


        datareference= FirebaseDatabase.getInstance().getReference("booked ticket").child(ref).child("1");

        datareference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue(bookedticket.class)!=null) {
                    layout1.setVisibility(LinearLayout.VISIBLE);
                    book = dataSnapshot.getValue(bookedticket.class);
                    //Log.i("Hello"+note.getSource(),note.getDestination());
                    source=book.getSource();
                    destination=book.getDestination();
                    nadult=book.getnadult();
                    nchild=book.getnchild();
                    ninfant=book.getninfant();
                    departday=book.getdd();
                    departmonth=book.getdm();
                    departyear=book.getdy();
                    arritime=book.getArrivalTime();
                    departtime=book.getDepartureTime();
                    fno=book.getFlightNo();
                    price=book.getPrice();
                    total=book.gettotal();
                    a1=book.getper1();
                    a2=book.getper2();
                    a3=book.getper3();
                    a4=book.getper4();
                    a5=book.getper5();
                    a6=book.getper6();
                    a7=book.getper7();
                    a8=book.getper8();
                    a9=book.getper9();
                    a10=book.getper10();
                    a11=book.getper11();
                    a12=book.getper12();
                    from1.setText(source);
                    to1.setText(destination);
                    date1.setText(departday+ "/"+departmonth+"/"+departyear);
                }
                else
                {
                    z++;
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        datareference= FirebaseDatabase.getInstance().getReference("booked ticket").child(ref).child("2");


        datareference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue(bookedticket.class)!=null) {
                    layout2.setVisibility(LinearLayout.VISIBLE);
                    book1 = dataSnapshot.getValue(bookedticket.class);
                    //Log.i("Hello"+note.getSource(),note.getDestination());
                    source1=book1.getSource();
                    destination1=book1.getDestination();
                    nadult1=book1.getnadult();
                    nchild1=book1.getnchild();
                    ninfant1=book1.getninfant();
                    departday1=book1.getdd();
                    departmonth1=book1.getdm();
                    departyear1=book1.getdy();
                    arritime1=book1.getArrivalTime();
                    departtime1=book1.getDepartureTime();
                    fno1=book1.getFlightNo();
                    price1=book1.getPrice();
                    total1=book1.gettotal();
                    b1=book1.getper1();
                    b2=book1.getper2();
                    b3=book1.getper3();
                    b4=book1.getper4();
                    b5=book1.getper5();
                    b6=book1.getper6();
                    b7=book1.getper7();
                    b8=book1.getper8();
                    b9=book1.getper9();
                    b10=book1.getper10();
                    b11=book1.getper11();
                    b12=book1.getper12();
                    from2.setText(source1);
                    to2.setText(destination1);
                    date2.setText(departday1+ "/"+departmonth1+"/"+departyear1);
                }
                else
                {
                    z++;
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        datareference= FirebaseDatabase.getInstance().getReference("booked ticket").child(ref).child("3");


        datareference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue(bookedticket.class)!=null) {
                    layout3.setVisibility(LinearLayout.VISIBLE);
                    book2 = dataSnapshot.getValue(bookedticket.class);
                    //Log.i("Hello"+note.getSource(),note.getDestination());
                    source2=book2.getSource();
                    destination2=book2.getDestination();
                    nadult2=book2.getnadult();
                    nchild2=book2.getnchild();
                    ninfant2=book2.getninfant();
                    departday2=book2.getdd();
                    departmonth2=book2.getdm();
                    departyear2=book2.getdy();
                    arritime2=book2.getArrivalTime();
                    departtime2=book2.getDepartureTime();
                    fno2=book2.getFlightNo();
                    price2=book2.getPrice();
                    total2=book2.gettotal();
                    c1=book2.getper1();
                    c2=book2.getper2();
                    c3=book2.getper3();
                    c4=book2.getper4();
                    c5=book2.getper5();
                    c6=book2.getper6();
                    c7=book2.getper7();
                    c8=book2.getper8();
                    c9=book2.getper9();
                    c10=book2.getper10();
                    c11=book2.getper11();
                    c12=book2.getper12();
                    from3.setText(source2);
                    to3.setText(destination2);
                    date3.setText(departday2+ "/"+departmonth2+"/"+departyear2);
                }
                else{
                    z++;
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        num="frombookedticket";

        if(z==3)
        {
            Toast.makeText(bookedticketsActivity.this, "no booked flights", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public void onClick(View view) {
        if(view==dbtn1)
        {
            ticketno= "1";
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
            i.putExtra("ticketno",ticketno);

            startActivity(i);

        }

        if(view==dbtn2)
        {
            ticketno="2";
            Intent i= new Intent(this,ticketActivity.class);
            i.putExtra("from",source1);
            i.putExtra("to",destination1);
            i.putExtra("nadult",nadult1);
            i.putExtra("nchild",nchild1);
            i.putExtra("ninfant",ninfant1);
            i.putExtra("departday",departday1);
            i.putExtra("departmonth",departmonth1);
            i.putExtra("departyear",departyear1);
            i.putExtra("returnday",returnday1);
            i.putExtra("returnmonth",returnmonth1);
            i.putExtra("returnyear",returnyear1);
            i.putExtra("arritime",arritime1);
            i.putExtra("departtime",departtime1);
            i.putExtra("fno",fno1);
            i.putExtra("price",price1);
            i.putExtra("total",total1);
            i.putExtra("per1",b1);
            i.putExtra("per2",b2);
            i.putExtra("per3",b3);
            i.putExtra("per4",b4);
            i.putExtra("per5",b5);
            i.putExtra("per6",b6);
            i.putExtra("per7",b7);
            i.putExtra("per8",b8);
            i.putExtra("per9",b9);
            i.putExtra("per10",b10);
            i.putExtra("per11",b11);
            i.putExtra("per12",b12);
            i.putExtra("booked",num);
            i.putExtra("ticketno",ticketno);

            startActivity(i);
        }

        if(view==dbtn3)
        {
            ticketno="3";
            Intent i= new Intent(this,ticketActivity.class);
            i.putExtra("from",source2);
            i.putExtra("to",destination2);
            i.putExtra("nadult",nadult2);
            i.putExtra("nchild",nchild2);
            i.putExtra("ninfant",ninfant2);
            i.putExtra("departday",departday2);
            i.putExtra("departmonth",departmonth2);
            i.putExtra("departyear",departyear2);
            i.putExtra("returnday",returnday2);
            i.putExtra("returnmonth",returnmonth2);
            i.putExtra("returnyear",returnyear2);
            i.putExtra("arritime",arritime2);
            i.putExtra("departtime",departtime2);
            i.putExtra("fno",fno2);
            i.putExtra("price",price2);
            i.putExtra("total",total2);
            i.putExtra("per1",c1);
            i.putExtra("per2",c2);
            i.putExtra("per3",c3);
            i.putExtra("per4",c4);
            i.putExtra("per5",c5);
            i.putExtra("per6",c6);
            i.putExtra("per7",c7);
            i.putExtra("per8",c8);
            i.putExtra("per9",c9);
            i.putExtra("per10",c10);
            i.putExtra("per11",c11);
            i.putExtra("per12",c12);
            i.putExtra("booked",num);
            i.putExtra("ticketno",ticketno);

            startActivity(i);
        }
    }
}
