package com.flylimitless.flylimitless;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class showflightActivity extends AppCompatActivity implements View.OnClickListener {

    private Button book_btn1;
    private Button book_btn2;
    private Button book_btn3;
    private Button book_btn4;
    private Button book_btn5;
    private TextView fromto,arritime1,depttime1,price1,fno1;
    private TextView arritime2,depttime2,price2,fno2;
    private TextView arritime3,depttime3,price3,fno3;
    private TextView arritime4,depttime4,price4,fno4;
    private TextView arritime5,depttime5,price5,fno5;
   private FirebaseAuth mauth;
    private DatabaseReference reference1;
    private DatabaseReference reference2;
    private DatabaseReference reference3;
    private DatabaseReference reference4;
    private DatabaseReference reference5;
    FlightDetails note;
    LinearLayout layout1,layout2,layout3,layout4,layout5;
    private ProgressDialog progressdialog;
    String source, destination, nadult,nchild,ninfant,departday,departmonth,departyear,returnday,returnmonth,returnyear;
    String where;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showflight);


        mauth = FirebaseAuth.getInstance();

        book_btn1= (Button)findViewById(R.id.bookbtn1);
        book_btn1.setOnClickListener(this);

        book_btn2= (Button)findViewById(R.id.bookbtn2);
        book_btn2.setOnClickListener(this);

        book_btn3= (Button)findViewById(R.id.bookbtn3);
        book_btn3.setOnClickListener(this);

        book_btn4= (Button)findViewById(R.id.bookbtn4);
        book_btn4.setOnClickListener(this);

        book_btn5= (Button)findViewById(R.id.bookbtn5);
        book_btn5.setOnClickListener(this);

        fromto= (TextView)findViewById(R.id.viewfromto);

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
        where= firstdata.getString("where");



        if(where==null)
        {

        }
        else
        {
            book_btn1.setVisibility(Button.GONE);
            book_btn2.setVisibility(Button.GONE);
            book_btn3.setVisibility(Button.GONE);
            book_btn4.setVisibility(Button.GONE);
            book_btn5.setVisibility(Button.GONE);
        }


        fromto.setText(""+ source + " to "+destination);

        progressdialog=new ProgressDialog(this);
        progressdialog.setMessage("Fetching Flights...");
        progressdialog.show();



        //pune to delhi

        if(source.equalsIgnoreCase("pune") && destination.equalsIgnoreCase("delhi"))
        {
           reference1= FirebaseDatabase.getInstance().getReference().child("1");
            reference2=FirebaseDatabase.getInstance().getReference().child("2");
            reference3=FirebaseDatabase.getInstance().getReference().child("3");
            reference4=FirebaseDatabase.getInstance().getReference().child("4");
            reference5=FirebaseDatabase.getInstance().getReference().child("5");


            arritime1= (TextView)findViewById(R.id.viewarri1);
            depttime1=(TextView)findViewById(R.id.viewdept1);
            price1=(TextView)findViewById(R.id.viewprice1);
            fno1= (TextView)findViewById(R.id.viewfno1);


                reference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                            layout1.setVisibility(LinearLayout.VISIBLE);
                            note = dataSnapshot.getValue(FlightDetails.class);
                            //Log.i("Hello"+note.getSource(),note.getDestination());
                            arritime1.setText(note.getArrivalTime());
                            depttime1.setText(note.getDepartureTime());
                            price1.setText(note.getPrice());
                            fno1.setText(note.getFlightNo());
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });





            arritime2= (TextView)findViewById(R.id.viewarri2);
            depttime2=(TextView)findViewById(R.id.viewdept2);
            price2=(TextView)findViewById(R.id.viewprice2);
            fno2= (TextView)findViewById(R.id.viewfno2);

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout2.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime2.setText(note.getArrivalTime());
                        depttime2.setText(note.getDepartureTime());
                        price2.setText(note.getPrice());
                        fno2.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime3= (TextView)findViewById(R.id.viewarri3);
            depttime3=(TextView)findViewById(R.id.viewdept3);
            price3=(TextView)findViewById(R.id.viewprice3);
            fno3= (TextView)findViewById(R.id.viewfno3);

            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout3.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime3.setText(note.getArrivalTime());
                        depttime3.setText(note.getDepartureTime());
                        price3.setText(note.getPrice());
                        fno3.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



            arritime4= (TextView)findViewById(R.id.viewarri4);
            depttime4=(TextView)findViewById(R.id.viewdept4);
            price4=(TextView)findViewById(R.id.viewprice4);
            fno4= (TextView)findViewById(R.id.viewfno4);

            reference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout4.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime4.setText(note.getArrivalTime());
                        depttime4.setText(note.getDepartureTime());
                        price4.setText(note.getPrice());
                        fno4.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime5= (TextView)findViewById(R.id.viewarri5);
            depttime5=(TextView)findViewById(R.id.viewdept5);
            price5=(TextView)findViewById(R.id.viewprice5);
            fno5= (TextView)findViewById(R.id.viewfno5);

            reference5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout5.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime5.setText(note.getArrivalTime());
                        depttime5.setText(note.getDepartureTime());
                        price5.setText(note.getPrice());
                        fno5.setText(note.getFlightNo());
                    }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });


        }//if



        //mumbai to delhi

       if(source.equalsIgnoreCase("mumbai") && destination.equalsIgnoreCase("delhi"))
        {
            reference1= FirebaseDatabase.getInstance().getReference().child("6");
            reference2=FirebaseDatabase.getInstance().getReference().child("7");
            reference3=FirebaseDatabase.getInstance().getReference().child("8");
            reference4=FirebaseDatabase.getInstance().getReference().child("9");
            reference5=FirebaseDatabase.getInstance().getReference().child("10");


            arritime1= (TextView)findViewById(R.id.viewarri1);
            depttime1=(TextView)findViewById(R.id.viewdept1);
            price1=(TextView)findViewById(R.id.viewprice1);
            fno1= (TextView)findViewById(R.id.viewfno1);


            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout1.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime1.setText(note.getArrivalTime());
                        depttime1.setText(note.getDepartureTime());
                        price1.setText(note.getPrice());
                        fno1.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });






            arritime2= (TextView)findViewById(R.id.viewarri2);
            depttime2=(TextView)findViewById(R.id.viewdept2);
            price2=(TextView)findViewById(R.id.viewprice2);
            fno2= (TextView)findViewById(R.id.viewfno2);

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout2.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime2.setText(note.getArrivalTime());
                        depttime2.setText(note.getDepartureTime());
                        price2.setText(note.getPrice());
                        fno2.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime3= (TextView)findViewById(R.id.viewarri3);
            depttime3=(TextView)findViewById(R.id.viewdept3);
            price3=(TextView)findViewById(R.id.viewprice3);
            fno3= (TextView)findViewById(R.id.viewfno3);

            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout3.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime3.setText(note.getArrivalTime());
                        depttime3.setText(note.getDepartureTime());
                        price3.setText(note.getPrice());
                        fno3.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



            arritime4= (TextView)findViewById(R.id.viewarri4);
            depttime4=(TextView)findViewById(R.id.viewdept4);
            price4=(TextView)findViewById(R.id.viewprice4);
            fno4= (TextView)findViewById(R.id.viewfno4);

            reference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout4.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime4.setText(note.getArrivalTime());
                        depttime4.setText(note.getDepartureTime());
                        price4.setText(note.getPrice());
                        fno4.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime5= (TextView)findViewById(R.id.viewarri5);
            depttime5=(TextView)findViewById(R.id.viewdept5);
            price5=(TextView)findViewById(R.id.viewprice5);
            fno5= (TextView)findViewById(R.id.viewfno5);

            reference5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout5.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime5.setText(note.getArrivalTime());
                        depttime5.setText(note.getDepartureTime());
                        price5.setText(note.getPrice());
                        fno5.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });




        }//if


        //pune to jaipur(11-15)

        if((source.equalsIgnoreCase("pune") && destination.equalsIgnoreCase("jaipur")))
        {
            reference1= FirebaseDatabase.getInstance().getReference().child("11");
            reference2=FirebaseDatabase.getInstance().getReference().child("12");
            reference3=FirebaseDatabase.getInstance().getReference().child("13");
            reference4=FirebaseDatabase.getInstance().getReference().child("14");
            reference5=FirebaseDatabase.getInstance().getReference().child("15");


            arritime1= (TextView)findViewById(R.id.viewarri1);
            depttime1=(TextView)findViewById(R.id.viewdept1);
            price1=(TextView)findViewById(R.id.viewprice1);
            fno1= (TextView)findViewById(R.id.viewfno1);


            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout1.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime1.setText(note.getArrivalTime());
                        depttime1.setText(note.getDepartureTime());
                        price1.setText(note.getPrice());
                        fno1.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });






            arritime2= (TextView)findViewById(R.id.viewarri2);
            depttime2=(TextView)findViewById(R.id.viewdept2);
            price2=(TextView)findViewById(R.id.viewprice2);
            fno2= (TextView)findViewById(R.id.viewfno2);

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout2.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime2.setText(note.getArrivalTime());
                        depttime2.setText(note.getDepartureTime());
                        price2.setText(note.getPrice());
                        fno2.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime3= (TextView)findViewById(R.id.viewarri3);
            depttime3=(TextView)findViewById(R.id.viewdept3);
            price3=(TextView)findViewById(R.id.viewprice3);
            fno3= (TextView)findViewById(R.id.viewfno3);

            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout3.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime3.setText(note.getArrivalTime());
                        depttime3.setText(note.getDepartureTime());
                        price3.setText(note.getPrice());
                        fno3.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



            arritime4= (TextView)findViewById(R.id.viewarri4);
            depttime4=(TextView)findViewById(R.id.viewdept4);
            price4=(TextView)findViewById(R.id.viewprice4);
            fno4= (TextView)findViewById(R.id.viewfno4);

            reference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout4.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime4.setText(note.getArrivalTime());
                        depttime4.setText(note.getDepartureTime());
                        price4.setText(note.getPrice());
                        fno4.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime5= (TextView)findViewById(R.id.viewarri5);
            depttime5=(TextView)findViewById(R.id.viewdept5);
            price5=(TextView)findViewById(R.id.viewprice5);
            fno5= (TextView)findViewById(R.id.viewfno5);

            reference5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout5.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime5.setText(note.getArrivalTime());
                        depttime5.setText(note.getDepartureTime());
                        price5.setText(note.getPrice());
                        fno5.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }//if

        //mumbai to jaipur(16-20)

        if((source.equalsIgnoreCase("mumbai") && destination.equalsIgnoreCase("jaipur")))
        {
            reference1= FirebaseDatabase.getInstance().getReference().child("16");
            reference2=FirebaseDatabase.getInstance().getReference().child("17");
            reference3=FirebaseDatabase.getInstance().getReference().child("18");
            reference4=FirebaseDatabase.getInstance().getReference().child("19");
            reference5=FirebaseDatabase.getInstance().getReference().child("20");


            arritime1= (TextView)findViewById(R.id.viewarri1);
            depttime1=(TextView)findViewById(R.id.viewdept1);
            price1=(TextView)findViewById(R.id.viewprice1);
            fno1= (TextView)findViewById(R.id.viewfno1);


            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout1.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime1.setText(note.getArrivalTime());
                        depttime1.setText(note.getDepartureTime());
                        price1.setText(note.getPrice());
                        fno1.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });






            arritime2= (TextView)findViewById(R.id.viewarri2);
            depttime2=(TextView)findViewById(R.id.viewdept2);
            price2=(TextView)findViewById(R.id.viewprice2);
            fno2= (TextView)findViewById(R.id.viewfno2);

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout2.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime2.setText(note.getArrivalTime());
                        depttime2.setText(note.getDepartureTime());
                        price2.setText(note.getPrice());
                        fno2.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime3= (TextView)findViewById(R.id.viewarri3);
            depttime3=(TextView)findViewById(R.id.viewdept3);
            price3=(TextView)findViewById(R.id.viewprice3);
            fno3= (TextView)findViewById(R.id.viewfno3);

            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout3.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime3.setText(note.getArrivalTime());
                        depttime3.setText(note.getDepartureTime());
                        price3.setText(note.getPrice());
                        fno3.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



            arritime4= (TextView)findViewById(R.id.viewarri4);
            depttime4=(TextView)findViewById(R.id.viewdept4);
            price4=(TextView)findViewById(R.id.viewprice4);
            fno4= (TextView)findViewById(R.id.viewfno4);

            reference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout4.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime4.setText(note.getArrivalTime());
                        depttime4.setText(note.getDepartureTime());
                        price4.setText(note.getPrice());
                        fno4.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime5= (TextView)findViewById(R.id.viewarri5);
            depttime5=(TextView)findViewById(R.id.viewdept5);
            price5=(TextView)findViewById(R.id.viewprice5);
            fno5= (TextView)findViewById(R.id.viewfno5);

            reference5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout5.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime5.setText(note.getArrivalTime());
                        depttime5.setText(note.getDepartureTime());
                        price5.setText(note.getPrice());
                        fno5.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }//if

   //delhi to jaipur(21-25)

        if(source.equalsIgnoreCase("delhi") && destination.equalsIgnoreCase("jaipur"))
        {
            reference1= FirebaseDatabase.getInstance().getReference().child("21");
            reference2=FirebaseDatabase.getInstance().getReference().child("22");
            reference3=FirebaseDatabase.getInstance().getReference().child("23");
            reference4=FirebaseDatabase.getInstance().getReference().child("24");
            reference5=FirebaseDatabase.getInstance().getReference().child("25");


            arritime1= (TextView)findViewById(R.id.viewarri1);
            depttime1=(TextView)findViewById(R.id.viewdept1);
            price1=(TextView)findViewById(R.id.viewprice1);
            fno1= (TextView)findViewById(R.id.viewfno1);


            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout1.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime1.setText(note.getArrivalTime());
                        depttime1.setText(note.getDepartureTime());
                        price1.setText(note.getPrice());
                        fno1.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });






            arritime2= (TextView)findViewById(R.id.viewarri2);
            depttime2=(TextView)findViewById(R.id.viewdept2);
            price2=(TextView)findViewById(R.id.viewprice2);
            fno2= (TextView)findViewById(R.id.viewfno2);

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout2.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime2.setText(note.getArrivalTime());
                        depttime2.setText(note.getDepartureTime());
                        price2.setText(note.getPrice());
                        fno2.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime3= (TextView)findViewById(R.id.viewarri3);
            depttime3=(TextView)findViewById(R.id.viewdept3);
            price3=(TextView)findViewById(R.id.viewprice3);
            fno3= (TextView)findViewById(R.id.viewfno3);

            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout3.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime3.setText(note.getArrivalTime());
                        depttime3.setText(note.getDepartureTime());
                        price3.setText(note.getPrice());
                        fno3.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



            arritime4= (TextView)findViewById(R.id.viewarri4);
            depttime4=(TextView)findViewById(R.id.viewdept4);
            price4=(TextView)findViewById(R.id.viewprice4);
            fno4= (TextView)findViewById(R.id.viewfno4);

            reference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout4.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime4.setText(note.getArrivalTime());
                        depttime4.setText(note.getDepartureTime());
                        price4.setText(note.getPrice());
                        fno4.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime5= (TextView)findViewById(R.id.viewarri5);
            depttime5=(TextView)findViewById(R.id.viewdept5);
            price5=(TextView)findViewById(R.id.viewprice5);
            fno5= (TextView)findViewById(R.id.viewfno5);

            reference5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout5.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime5.setText(note.getArrivalTime());
                        depttime5.setText(note.getDepartureTime());
                        price5.setText(note.getPrice());
                        fno5.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });




        }//if

        //DELHI to PUNE (26-30)

        if(source.equalsIgnoreCase("delhi") && destination.equalsIgnoreCase("pune"))
        {
            reference1= FirebaseDatabase.getInstance().getReference().child("26");
            reference2=FirebaseDatabase.getInstance().getReference().child("27");
            reference3=FirebaseDatabase.getInstance().getReference().child("28");
            reference4=FirebaseDatabase.getInstance().getReference().child("29");
            reference5=FirebaseDatabase.getInstance().getReference().child("30");


            arritime1= (TextView)findViewById(R.id.viewarri1);
            depttime1=(TextView)findViewById(R.id.viewdept1);
            price1=(TextView)findViewById(R.id.viewprice1);
            fno1= (TextView)findViewById(R.id.viewfno1);


            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout1.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime1.setText(note.getArrivalTime());
                        depttime1.setText(note.getDepartureTime());
                        price1.setText(note.getPrice());
                        fno1.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });






            arritime2= (TextView)findViewById(R.id.viewarri2);
            depttime2=(TextView)findViewById(R.id.viewdept2);
            price2=(TextView)findViewById(R.id.viewprice2);
            fno2= (TextView)findViewById(R.id.viewfno2);

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout2.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime2.setText(note.getArrivalTime());
                        depttime2.setText(note.getDepartureTime());
                        price2.setText(note.getPrice());
                        fno2.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime3= (TextView)findViewById(R.id.viewarri3);
            depttime3=(TextView)findViewById(R.id.viewdept3);
            price3=(TextView)findViewById(R.id.viewprice3);
            fno3= (TextView)findViewById(R.id.viewfno3);

            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout3.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime3.setText(note.getArrivalTime());
                        depttime3.setText(note.getDepartureTime());
                        price3.setText(note.getPrice());
                        fno3.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



            arritime4= (TextView)findViewById(R.id.viewarri4);
            depttime4=(TextView)findViewById(R.id.viewdept4);
            price4=(TextView)findViewById(R.id.viewprice4);
            fno4= (TextView)findViewById(R.id.viewfno4);

            reference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout4.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime4.setText(note.getArrivalTime());
                        depttime4.setText(note.getDepartureTime());
                        price4.setText(note.getPrice());
                        fno4.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime5= (TextView)findViewById(R.id.viewarri5);
            depttime5=(TextView)findViewById(R.id.viewdept5);
            price5=(TextView)findViewById(R.id.viewprice5);
            fno5= (TextView)findViewById(R.id.viewfno5);

            reference5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout5.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime5.setText(note.getArrivalTime());
                        depttime5.setText(note.getDepartureTime());
                        price5.setText(note.getPrice());
                        fno5.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }//if


        //DELHI TO MUMBAI(31-35)
        if(source.equalsIgnoreCase("delhi") && destination.equalsIgnoreCase("mumbai"))
        {
            reference1= FirebaseDatabase.getInstance().getReference().child("31");
            reference2=FirebaseDatabase.getInstance().getReference().child("32");
            reference3=FirebaseDatabase.getInstance().getReference().child("33");
            reference4=FirebaseDatabase.getInstance().getReference().child("34");
            reference5=FirebaseDatabase.getInstance().getReference().child("35");


            arritime1= (TextView)findViewById(R.id.viewarri1);
            depttime1=(TextView)findViewById(R.id.viewdept1);
            price1=(TextView)findViewById(R.id.viewprice1);
            fno1= (TextView)findViewById(R.id.viewfno1);


            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout1.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime1.setText(note.getArrivalTime());
                        depttime1.setText(note.getDepartureTime());
                        price1.setText(note.getPrice());
                        fno1.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });






            arritime2= (TextView)findViewById(R.id.viewarri2);
            depttime2=(TextView)findViewById(R.id.viewdept2);
            price2=(TextView)findViewById(R.id.viewprice2);
            fno2= (TextView)findViewById(R.id.viewfno2);

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout2.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime2.setText(note.getArrivalTime());
                        depttime2.setText(note.getDepartureTime());
                        price2.setText(note.getPrice());
                        fno2.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime3= (TextView)findViewById(R.id.viewarri3);
            depttime3=(TextView)findViewById(R.id.viewdept3);
            price3=(TextView)findViewById(R.id.viewprice3);
            fno3= (TextView)findViewById(R.id.viewfno3);

            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout3.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime3.setText(note.getArrivalTime());
                        depttime3.setText(note.getDepartureTime());
                        price3.setText(note.getPrice());
                        fno3.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



            arritime4= (TextView)findViewById(R.id.viewarri4);
            depttime4=(TextView)findViewById(R.id.viewdept4);
            price4=(TextView)findViewById(R.id.viewprice4);
            fno4= (TextView)findViewById(R.id.viewfno4);

            reference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout4.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime4.setText(note.getArrivalTime());
                        depttime4.setText(note.getDepartureTime());
                        price4.setText(note.getPrice());
                        fno4.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime5= (TextView)findViewById(R.id.viewarri5);
            depttime5=(TextView)findViewById(R.id.viewdept5);
            price5=(TextView)findViewById(R.id.viewprice5);
            fno5= (TextView)findViewById(R.id.viewfno5);

            reference5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout5.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime5.setText(note.getArrivalTime());
                        depttime5.setText(note.getDepartureTime());
                        price5.setText(note.getPrice());
                        fno5.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }//if

        //jaipur to pune(36-40)

        if(source.equalsIgnoreCase("jaipur") && destination.equalsIgnoreCase("pune"))
        {
            reference1= FirebaseDatabase.getInstance().getReference().child("36");
            reference2=FirebaseDatabase.getInstance().getReference().child("37");
            reference3=FirebaseDatabase.getInstance().getReference().child("38");
            reference4=FirebaseDatabase.getInstance().getReference().child("39");
            reference5=FirebaseDatabase.getInstance().getReference().child("40");


            arritime1= (TextView)findViewById(R.id.viewarri1);
            depttime1=(TextView)findViewById(R.id.viewdept1);
            price1=(TextView)findViewById(R.id.viewprice1);
            fno1= (TextView)findViewById(R.id.viewfno1);


            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout1.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime1.setText(note.getArrivalTime());
                        depttime1.setText(note.getDepartureTime());
                        price1.setText(note.getPrice());
                        fno1.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });






            arritime2= (TextView)findViewById(R.id.viewarri2);
            depttime2=(TextView)findViewById(R.id.viewdept2);
            price2=(TextView)findViewById(R.id.viewprice2);
            fno2= (TextView)findViewById(R.id.viewfno2);

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout2.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime2.setText(note.getArrivalTime());
                        depttime2.setText(note.getDepartureTime());
                        price2.setText(note.getPrice());
                        fno2.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime3= (TextView)findViewById(R.id.viewarri3);
            depttime3=(TextView)findViewById(R.id.viewdept3);
            price3=(TextView)findViewById(R.id.viewprice3);
            fno3= (TextView)findViewById(R.id.viewfno3);

            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout3.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime3.setText(note.getArrivalTime());
                        depttime3.setText(note.getDepartureTime());
                        price3.setText( note.getPrice());
                        fno3.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



            arritime4= (TextView)findViewById(R.id.viewarri4);
            depttime4=(TextView)findViewById(R.id.viewdept4);
            price4=(TextView)findViewById(R.id.viewprice4);
            fno4= (TextView)findViewById(R.id.viewfno4);

            reference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout4.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime4.setText(note.getArrivalTime());
                        depttime4.setText(note.getDepartureTime());
                        price4.setText(note.getPrice());
                        fno4.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime5= (TextView)findViewById(R.id.viewarri5);
            depttime5=(TextView)findViewById(R.id.viewdept5);
            price5=(TextView)findViewById(R.id.viewprice5);
            fno5= (TextView)findViewById(R.id.viewfno5);

            reference5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout5.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime5.setText(note.getArrivalTime());
                        depttime5.setText(note.getDepartureTime());
                        price5.setText(note.getPrice());
                        fno5.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }//if

        //jaipur to mumbai(41-45)

        if(source.equalsIgnoreCase("jaipur") && destination.equalsIgnoreCase("mumbai"))
        {
            reference1= FirebaseDatabase.getInstance().getReference().child("41");
            reference2=FirebaseDatabase.getInstance().getReference().child("42");
            reference3=FirebaseDatabase.getInstance().getReference().child("43");
            reference4=FirebaseDatabase.getInstance().getReference().child("44");
            reference5=FirebaseDatabase.getInstance().getReference().child("45");


            arritime1= (TextView)findViewById(R.id.viewarri1);
            depttime1=(TextView)findViewById(R.id.viewdept1);
            price1=(TextView)findViewById(R.id.viewprice1);
            fno1= (TextView)findViewById(R.id.viewfno1);


            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout1.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime1.setText(note.getArrivalTime());
                        depttime1.setText(note.getDepartureTime());
                        price1.setText(note.getPrice());
                        fno1.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });






            arritime2= (TextView)findViewById(R.id.viewarri2);
            depttime2=(TextView)findViewById(R.id.viewdept2);
            price2=(TextView)findViewById(R.id.viewprice2);
            fno2= (TextView)findViewById(R.id.viewfno2);

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout2.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime2.setText(note.getArrivalTime());
                        depttime2.setText(note.getDepartureTime());
                        price2.setText(note.getPrice());
                        fno2.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime3= (TextView)findViewById(R.id.viewarri3);
            depttime3=(TextView)findViewById(R.id.viewdept3);
            price3=(TextView)findViewById(R.id.viewprice3);
            fno3= (TextView)findViewById(R.id.viewfno3);

            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout3.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime3.setText(note.getArrivalTime());
                        depttime3.setText(note.getDepartureTime());
                        price3.setText(note.getPrice());
                        fno3.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



            arritime4= (TextView)findViewById(R.id.viewarri4);
            depttime4=(TextView)findViewById(R.id.viewdept4);
            price4=(TextView)findViewById(R.id.viewprice4);
            fno4= (TextView)findViewById(R.id.viewfno4);

            reference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout4.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime4.setText(note.getArrivalTime());
                        depttime4.setText(note.getDepartureTime());
                        price4.setText( note.getPrice());
                        fno4.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime5= (TextView)findViewById(R.id.viewarri5);
            depttime5=(TextView)findViewById(R.id.viewdept5);
            price5=(TextView)findViewById(R.id.viewprice5);
            fno5= (TextView)findViewById(R.id.viewfno5);

            reference5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout5.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime5.setText(note.getArrivalTime());
                        depttime5.setText(note.getDepartureTime());
                        price5.setText(note.getPrice());
                        fno5.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });




        }//if

        //jaipur to delhi(46-50)

        if(source.equalsIgnoreCase("jaipur") && destination.equalsIgnoreCase("delhi"))
        {
            reference1= FirebaseDatabase.getInstance().getReference().child("46");
            reference2=FirebaseDatabase.getInstance().getReference().child("47");
            reference3=FirebaseDatabase.getInstance().getReference().child("48");
            reference4=FirebaseDatabase.getInstance().getReference().child("49");
            reference5=FirebaseDatabase.getInstance().getReference().child("50");


            arritime1= (TextView)findViewById(R.id.viewarri1);
            depttime1=(TextView)findViewById(R.id.viewdept1);
            price1=(TextView)findViewById(R.id.viewprice1);
            fno1= (TextView)findViewById(R.id.viewfno1);


            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout1.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime1.setText(note.getArrivalTime());
                        depttime1.setText(note.getDepartureTime());
                        price1.setText( note.getPrice());
                        fno1.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });






            arritime2= (TextView)findViewById(R.id.viewarri2);
            depttime2=(TextView)findViewById(R.id.viewdept2);
            price2=(TextView)findViewById(R.id.viewprice2);
            fno2= (TextView)findViewById(R.id.viewfno2);

            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout2.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime2.setText(note.getArrivalTime());
                        depttime2.setText(note.getDepartureTime());
                        price2.setText(note.getPrice());
                        fno2.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime3= (TextView)findViewById(R.id.viewarri3);
            depttime3=(TextView)findViewById(R.id.viewdept3);
            price3=(TextView)findViewById(R.id.viewprice3);
            fno3= (TextView)findViewById(R.id.viewfno3);

            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout3.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime3.setText(note.getArrivalTime());
                        depttime3.setText(note.getDepartureTime());
                        price3.setText( note.getPrice());
                        fno3.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



            arritime4= (TextView)findViewById(R.id.viewarri4);
            depttime4=(TextView)findViewById(R.id.viewdept4);
            price4=(TextView)findViewById(R.id.viewprice4);
            fno4= (TextView)findViewById(R.id.viewfno4);

            reference4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout4.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime4.setText(note.getArrivalTime());
                        depttime4.setText(note.getDepartureTime());
                        price4.setText( note.getPrice());
                        fno4.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            arritime5= (TextView)findViewById(R.id.viewarri5);
            depttime5=(TextView)findViewById(R.id.viewdept5);
            price5=(TextView)findViewById(R.id.viewprice5);
            fno5= (TextView)findViewById(R.id.viewfno5);

            reference5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if(dataSnapshot.getValue(FlightDetails.class)!=null) {
                        layout5.setVisibility(LinearLayout.VISIBLE);
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        arritime5.setText(note.getArrivalTime());
                        depttime5.setText(note.getDepartureTime());
                        price5.setText(note.getPrice());
                        fno5.setText(note.getFlightNo());
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }//if

        if ((source.equalsIgnoreCase("pune") && destination.equalsIgnoreCase("mumbai"))|| (source.equalsIgnoreCase("mumbai") && destination.equalsIgnoreCase("pune")))
        {
            Toast.makeText(this, "No flights available", Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onClick(View view) {
        if(view==book_btn1)
        {
            Intent i= new Intent(this, afterbooknowActivity.class);
            final String arritime= arritime1.getText().toString().trim();
            final String departtime= depttime1.getText().toString().trim();
            final String fno= fno1.getText().toString().trim();
            final String price=price1.getText().toString().trim();
            final String sour=source;
            final String dest=destination;
            final String adult=nadult;
            final String child=nchild;
            final String infant=ninfant;
            final String dd=departday;
            final String dm=departmonth;
            final String dy=departyear;
            final String rd=returnday;
            final String rm=returnmonth;
            final String ry=returnyear;



            i.putExtra("from",sour);
            i.putExtra("to",dest);
            i.putExtra("nadult",adult);
            i.putExtra("nchild",child);
            i.putExtra("ninfant",infant);
            i.putExtra("departday",dd);
            i.putExtra("departmonth",dm);
            i.putExtra("departyear",dy);
            i.putExtra("returnday",rd);
            i.putExtra("returnmonth",rm);
            i.putExtra("returnyear",ry);
            i.putExtra("arritime",arritime);
            i.putExtra("departtime",departtime);
            i.putExtra("fno",fno);
            i.putExtra("price",price);

            startActivity(i);

        }

        if(view==book_btn2)
        {
            Intent i= new Intent(this, afterbooknowActivity.class);
            final String arritime= arritime2.getText().toString().trim();
            final String departtime= depttime2.getText().toString().trim();
            final String fno= fno2.getText().toString().trim();
            final String price=price2.getText().toString().trim();
            final String sour=source;
            final String dest=destination;
            final String adult=nadult;
            final String child=nchild;
            final String infant=ninfant;
            final String dd=departday;
            final String dm=departmonth;
            final String dy=departyear;
            final String rd=returnday;
            final String rm=returnmonth;
            final String ry=returnyear;



            i.putExtra("from",sour);
            i.putExtra("to",dest);
            i.putExtra("nadult",adult);
            i.putExtra("nchild",child);
            i.putExtra("ninfant",infant);
            i.putExtra("departday",dd);
            i.putExtra("departmonth",dm);
            i.putExtra("departyear",dy);
            i.putExtra("returnday",rd);
            i.putExtra("returnmonth",rm);
            i.putExtra("returnyear",ry);
            i.putExtra("arritime",arritime);
            i.putExtra("departtime",departtime);
            i.putExtra("fno",fno);
            i.putExtra("price",price);

            startActivity(i);

        }

        if(view==book_btn3)
        {
            Intent i= new Intent(this, afterbooknowActivity.class);
            final String arritime= arritime3.getText().toString().trim();
            final String departtime= depttime3.getText().toString().trim();
            final String fno= fno3.getText().toString().trim();
            final String price=price3.getText().toString().trim();
            final String sour=source;
            final String dest=destination;
            final String adult=nadult;
            final String child=nchild;
            final String infant=ninfant;
            final String dd=departday;
            final String dm=departmonth;
            final String dy=departyear;
            final String rd=returnday;
            final String rm=returnmonth;
            final String ry=returnyear;



            i.putExtra("from",sour);
            i.putExtra("to",dest);
            i.putExtra("nadult",adult);
            i.putExtra("nchild",child);
            i.putExtra("ninfant",infant);
            i.putExtra("departday",dd);
            i.putExtra("departmonth",dm);
            i.putExtra("departyear",dy);
            i.putExtra("returnday",rd);
            i.putExtra("returnmonth",rm);
            i.putExtra("returnyear",ry);
            i.putExtra("arritime",arritime);
            i.putExtra("departtime",departtime);
            i.putExtra("fno",fno);
            i.putExtra("price",price);

            startActivity(i);

        }

        if(view==book_btn4)
        {
            Intent i= new Intent(this, afterbooknowActivity.class);
            final String arritime= arritime4.getText().toString().trim();
            final String departtime= depttime4.getText().toString().trim();
            final String fno= fno4.getText().toString().trim();
            final String price=price4.getText().toString().trim();
            final String sour=source;
            final String dest=destination;
            final String adult=nadult;
            final String child=nchild;
            final String infant=ninfant;
            final String dd=departday;
            final String dm=departmonth;
            final String dy=departyear;
            final String rd=returnday;
            final String rm=returnmonth;
            final String ry=returnyear;



            i.putExtra("from",sour);
            i.putExtra("to",dest);
            i.putExtra("nadult",adult);
            i.putExtra("nchild",child);
            i.putExtra("ninfant",infant);
            i.putExtra("departday",dd);
            i.putExtra("departmonth",dm);
            i.putExtra("departyear",dy);
            i.putExtra("returnday",rd);
            i.putExtra("returnmonth",rm);
            i.putExtra("returnyear",ry);
            i.putExtra("arritime",arritime);
            i.putExtra("departtime",departtime);
            i.putExtra("fno",fno);
            i.putExtra("price",price);

            startActivity(i);

        }

        if(view==book_btn5)
        {
            Intent i= new Intent(this, afterbooknowActivity.class);
            final String arritime= arritime5.getText().toString().trim();
            final String departtime= depttime5.getText().toString().trim();
            final String fno= fno5.getText().toString().trim();
            final String price=price5.getText().toString().trim();
            final String sour=source;
            final String dest=destination;
            final String adult=nadult;
            final String child=nchild;
            final String infant=ninfant;
            final String dd=departday;
            final String dm=departmonth;
            final String dy=departyear;
            final String rd=returnday;
            final String rm=returnmonth;
            final String ry=returnyear;



            i.putExtra("from",sour);
            i.putExtra("to",dest);
            i.putExtra("nadult",adult);
            i.putExtra("nchild",child);
            i.putExtra("ninfant",infant);
            i.putExtra("departday",dd);
            i.putExtra("departmonth",dm);
            i.putExtra("departyear",dy);
            i.putExtra("returnday",rd);
            i.putExtra("returnmonth",rm);
            i.putExtra("returnyear",ry);
            i.putExtra("arritime",arritime);
            i.putExtra("departtime",departtime);
            i.putExtra("fno",fno);
            i.putExtra("price",price);

            startActivity(i);

        }



    }
}
