package com.flylimitless.flylimitless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class UploadData extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference reference;
    private Button upload, getdata;
    private EditText mSource,mDestination,mref,mdept,marri,mprice,mflightno;
    private FlightDetails flightDetails,note;
    private TextView getsource, getdest;
    private DatabaseReference datareference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_data);

        mref= (EditText)findViewById(R.id.textreference);

        firebaseAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        upload = (Button) findViewById(R.id.btn_upload);
        mSource = (EditText) findViewById(R.id.textsource);
        mDestination = (EditText) findViewById(R.id.textdestination);
        mdept= (EditText)findViewById(R.id.textdepttime);
        marri= (EditText)findViewById(R.id.textarrivaltime);
        mprice= (EditText)findViewById(R.id.textprice);
        mflightno= (EditText)findViewById(R.id.textflightno);


        datareference=FirebaseDatabase.getInstance().getReference().child("1");
         getsource= (TextView)findViewById(R.id.viewsource);
        getdest= (TextView)findViewById(R.id.viewdest);
         getdata= (Button)findViewById(R.id.btn_get);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String source = mSource.getText().toString().trim();
                String destination = mDestination.getText().toString().trim();
                String depttime = mdept.getText().toString().trim();
                String arritime = marri.getText().toString().trim();
                String price = mprice.getText().toString().trim();
                String flightno = mflightno.getText().toString().trim();
                final String ref= mref.getText().toString().trim();


                flightDetails = new FlightDetails(source,destination,depttime,arritime,price,flightno);
                reference.child(""+ref).setValue(flightDetails);
            }
        });


        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datareference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        note = dataSnapshot.getValue(FlightDetails.class);
                        //Log.i("Hello"+note.getSource(),note.getDestination());
                        getsource.setText(note.getSource());
                         getdest.setText(note.getDestination());

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });


    }
}
