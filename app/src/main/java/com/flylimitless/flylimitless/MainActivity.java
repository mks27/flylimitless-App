package com.flylimitless.flylimitless;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import static com.flylimitless.flylimitless.R.id.message;

public class MainActivity extends AppCompatActivity
        implements  View.OnClickListener {

    private Button buttonreg;
    private EditText editemail;
    private EditText editpassword;
    private TextView textlogin;
    private ProgressDialog progressdialog;
    //private FirebaseAuth firebaseauth;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "SignUp_Debug";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebaseauth=FirebaseAuth.getInstance();
        //initialise firebaseauth object
        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null){
            //start search activity
            finish();
            startActivity(new Intent(getApplicationContext(), SearchActivity.class));
        }

        progressdialog= new ProgressDialog(this);
        buttonreg= (Button)findViewById(R.id.registerbtn);
        editemail= (EditText)findViewById(R.id.edittextemail);
        editpassword=(EditText)findViewById(R.id.edittextpass);
        textlogin=(TextView)findViewById(R.id.textalready);

        buttonreg.setOnClickListener(this);
        textlogin.setOnClickListener(this);


    }

    private void registerUser()
    {
        String email = editemail.getText().toString().trim();
        String password= editpassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)) {
           //email is empty
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }

        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        //if validations are ok then first show progress bar
          progressdialog.setMessage("Registering User...");
          progressdialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            progressdialog.dismiss();
                            finish();
                            startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        }


                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Registrationv failed,Try Again",
                                    Toast.LENGTH_SHORT).show();
                            progressdialog.dismiss();
                        }


                    }
                });

    }

    @Override
    public void onClick(View view) {
        if(view== buttonreg)
            registerUser();

        if(view==textlogin){
            //will make a login activity
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

    }

}
