package com.flylimitless.flylimitless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class fstatusActivity extends AppCompatActivity implements View.OnClickListener {

    Button bthome1;
    Button check;
    private Spinner spinner_from1;
    private Spinner spinner_to1;
    EditText flightno;
    private FirebaseAuth mauth;
    private DatabaseReference datareference;
    String source, destination,arritime,departtime,fno;
    String source1, destination1,arritime1,departtime1,fno1;
    String source2, destination2,arritime2,departtime2,fno2;
    private bookedticket book;
    String userId,userEmail,ref;
    private TextView display;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fstatus);

        mauth=  FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mauth.getCurrentUser();
        if (firebaseUser != null) {
            userId = firebaseUser.getUid();
            userEmail = firebaseUser.getEmail();
        }

        int l=userEmail.length();
        ref= userEmail.substring(0,l-10);



        bthome1= (Button)findViewById(R.id.btHome1);
        bthome1.setOnClickListener(this);

        check= (Button)findViewById(R.id.checkbtn);
        check.setOnClickListener(this);

        spinner_from1= (Spinner)findViewById(R.id.sp_from1);
        ArrayAdapter<String> adapter_1= new ArrayAdapter<String>(fstatusActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.fromlist));

        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from1.setAdapter(adapter_1);


        spinner_to1= (Spinner)findViewById(R.id.sp_to1);
        ArrayAdapter<String> adapter_2= new ArrayAdapter<String>(fstatusActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.tolist));

        adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_to1.setAdapter(adapter_2);

        flightno= (EditText)findViewById(R.id.editfno);

        display=(TextView)findViewById(R.id.print);



        datareference= FirebaseDatabase.getInstance().getReference("booked ticket").child(ref).child("1");

        datareference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue(bookedticket.class)!=null) {
                    book = dataSnapshot.getValue(bookedticket.class);
                    //Log.i("Hello"+note.getSource(),note.getDestination());
                    source=book.getSource();
                    destination=book.getDestination();
                    arritime=book.getArrivalTime();
                    departtime=book.getDepartureTime();
                    fno=book.getFlightNo();
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
                    book = dataSnapshot.getValue(bookedticket.class);
                    //Log.i("Hello"+note.getSource(),note.getDestination());
                    source1=book.getSource();
                    destination1=book.getDestination();
                    arritime1=book.getArrivalTime();
                    departtime1=book.getDepartureTime();
                    fno1=book.getFlightNo();
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
                    book = dataSnapshot.getValue(bookedticket.class);
                    //Log.i("Hello"+note.getSource(),note.getDestination());
                    source2=book.getSource();
                    destination2=book.getDestination();
                    arritime2=book.getArrivalTime();
                    departtime2=book.getDepartureTime();
                    fno2=book.getFlightNo();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






    }



    @Override
    public void onClick(View view) {
        if(view == bthome1)
        {
            finish();
            startActivity(new Intent(this, SearchActivity.class));
        }

        if(view==check)
        {
            String flightnum= flightno.getText().toString().trim();
            String s=spinner_from1.getSelectedItem().toString();
            String de=spinner_to1.getSelectedItem().toString();

            if(s.equals("From") || de.equals("To"))
            {
                Toast.makeText(fstatusActivity.this, "please select source and destination", Toast.LENGTH_SHORT).show();
            }

            if(s.equals(de))
            {
                Toast.makeText(fstatusActivity.this, "source and destination must not be same", Toast.LENGTH_SHORT).show();
            }

            if(flightnum.equals(fno))
            {
                display.setText("On Time,"+ " arrival:"+arritime+" departure:"+departtime);
            }

           else if(flightnum.equals(fno1))
            {
                display.setText("On Time,"+ " arrival:"+arritime1+" departure:"+departtime1);
            }

         else   if(flightnum.equals(fno2))
            {
                display.setText("On Time,"+ " arrival:"+arritime2+" departure:"+departtime2);
            }

            else
            {
                Toast.makeText(fstatusActivity.this, "please enter correct flight number", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
