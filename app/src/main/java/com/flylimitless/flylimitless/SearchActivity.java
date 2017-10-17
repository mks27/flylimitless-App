package com.flylimitless.flylimitless;     //java file for HOME PAGE

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.R.attr.fragment;

public class SearchActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private FirebaseAuth mauth;
    private TextView useremail;
    private Button bookflight;
    private TextView flightstatus;
    private TextView flightschedule;
    private TextView findbooking;
    private TextView findbooking2;
    private TextView mybooking;
    private TextView hi;
    String userId,userEmail,ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(FloatingActionButton.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //my code is from here ............................

        mauth=  FirebaseAuth.getInstance();

        if(mauth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }


      /*  FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth mauth) {
                FirebaseUser firebaseUser = mauth.getCurrentUser();
                if (firebaseUser != null) {
                     userId = firebaseUser.getUid();
                     userEmail = firebaseUser.getEmail();
                }
            }
        };  */

        FirebaseUser firebaseUser = mauth.getCurrentUser();
        if (firebaseUser != null) {
            userId = firebaseUser.getUid();
            userEmail = firebaseUser.getEmail();
        }

        //Log.i("Current User:",userEmail);


        /*useremail= (TextView)findViewById(R.id.viewemail);
        useremail.setText(userEmail);
        we cannot directly put userEmail in a textview of navigation header, do it by line of codes written below.
        */

        useremail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.viewemail);
        useremail.setText(userEmail);



        bookflight= (Button)findViewById(R.id.btBooknow);
        bookflight.setOnClickListener(this);

        flightstatus= (TextView)findViewById(R.id.etFlightstatus);
        flightstatus.setOnClickListener(this);

        flightschedule= (TextView)findViewById(R.id.etFlightschedule);
        flightschedule.setOnClickListener(this);

        findbooking= (TextView)findViewById(R.id.etFindbooking);
        findbooking.setOnClickListener(this);

        findbooking2= (TextView)findViewById(R.id.etFindbooking2);
        findbooking2.setOnClickListener(this);

        mybooking=(TextView)findViewById(R.id.etMybookings);
        mybooking.setOnClickListener(this);

        hi=(TextView)findViewById(R.id.viewhi);


        int l=userEmail.length();
        ref= userEmail.substring(0,l-10);
        hi.setText("hi,"+ref);
        //Log.i("hello",ref);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
              mauth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_search) {
            startActivity(new Intent(this, bookflightActivity.class));
        } else if (id == R.id.nav_booked) {
            startActivity(new Intent(this, bookedticketsActivity.class));
        } else if (id == R.id.nav_cancelled) {
            startActivity(new Intent(this, searchcancelledfActivity.class));
        } else if (id == R.id.nav_setting) {
            startActivity(new Intent(this, settingActivity.class));
        } else if (id == R.id.nav_aboutus) {

        } else if (id == R.id.nav_feedback) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view==bookflight)
        {
            startActivity(new Intent(this,bookflightActivity.class));
        }

        if(view==findbooking)
        {
            finish();
            startActivity(new Intent(this,bookflightActivity.class));
        }

        if(view==findbooking2)
        {
            finish();
            startActivity(new Intent(this,searchcancelledfActivity.class));
        }

        if(view==flightstatus)
        {
            finish();
            startActivity(new Intent(this,fstatusActivity.class));
        }

        if(view==flightschedule)
        {
            finish();
            startActivity(new Intent(this,fscheduleActivity.class));
        }

        if(view==mybooking)
        {
            startActivity(new Intent(this, bookedticketsActivity.class));
        }


    }



}
