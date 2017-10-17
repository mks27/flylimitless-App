package com.flylimitless.flylimitless;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonlogin;
    private EditText textemail;
    private EditText textpassword;
    private TextView textsignup;
    private ProgressDialog progressdialog;
    private FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mauth= FirebaseAuth.getInstance();

        if(mauth.getCurrentUser()!=null){
            //start search activity
            finish();
            startActivity(new Intent(getApplicationContext(), SearchActivity.class));
        }

        progressdialog= new ProgressDialog(this);

        buttonlogin= (Button)findViewById(R.id.loginbtn);
        textemail= (EditText)findViewById(R.id.textemail);
        textpassword=(EditText)findViewById(R.id.textpass);
        textsignup=(TextView)findViewById(R.id.textalready1);

         buttonlogin.setOnClickListener(this);
         textsignup.setOnClickListener(this);


    }

   private void userlogin()
   {
       final String email = textemail.getText().toString().trim();
       String password= textpassword.getText().toString().trim();

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

       progressdialog.setMessage("logging you in...");
       progressdialog.show();

       mauth.signInWithEmailAndPassword(email,password)
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       progressdialog.dismiss();

                       if(task.isSuccessful())
                       {
                           //start search activity
                           if(email.equalsIgnoreCase("admin@gmail.com"))
                           {
                               finish();
                               startActivity(new Intent(getApplicationContext(), UploadData.class));
                           }
                           else {
                               finish();
                               startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                           }
                       }
                       else{
                           Toast.makeText(LoginActivity.this, "Login Failed,Try Again", Toast.LENGTH_SHORT).show();
                       }
                   }
               });


   }


    @Override
    public void onClick(View view) {
        if(view==buttonlogin){
            userlogin();
        }

        if(view==textsignup){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

    }
}
