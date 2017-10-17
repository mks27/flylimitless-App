package com.flylimitless.flylimitless;               //set your profile here

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class settingActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name, phone,aadhar,email;
    private Button save;
    private FirebaseAuth mauth;
    private DatabaseReference reference;
    private profiledata user,fetchuser;
    String userId,userEmail,ref;
    private DatabaseReference datareference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mauth=  FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mauth.getCurrentUser();
        if (firebaseUser != null) {
            userId = firebaseUser.getUid();
            userEmail = firebaseUser.getEmail();
        }

          int l=userEmail.length();
        ref= userEmail.substring(0,l-10);
       // Log.i("hello",ref);
        //this is done as path should not contain . which is present in email.



        reference = FirebaseDatabase.getInstance().getReference("profile");
        datareference=FirebaseDatabase.getInstance().getReference("profile").child(ref);


        name=(EditText)findViewById(R.id.textname);
        email=(EditText)findViewById(R.id.textemail);
        aadhar=(EditText)findViewById(R.id.textaadhar);
        phone=(EditText)findViewById(R.id.textmobile);

        save=(Button)findViewById(R.id.savebtn);
        save.setOnClickListener(this);


        datareference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue(profiledata.class)!=null)
                {
                    fetchuser = dataSnapshot.getValue(profiledata.class);
                    //Log.i("Hello"+note.getSource(),note.getDestination());
                    name.setText(fetchuser.getname());
                    email.setText(fetchuser.getemail());
                    aadhar.setText(fetchuser.getaadhar());
                    phone.setText(fetchuser.getphone());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }

    @Override
    public void onClick(View view) {
          if(view==save)
          {
              String Name= name.getText().toString().trim();
              String Email=email.getText().toString().trim();
              String mobile=phone.getText().toString().trim();
              String Aadhar=aadhar.getText().toString().trim();

              user= new profiledata(Name,Email,mobile,Aadhar);
              reference.child(""+ref).setValue(user);
          }
    }
}
