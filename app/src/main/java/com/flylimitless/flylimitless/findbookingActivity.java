package com.flylimitless.flylimitless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class findbookingActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonhome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findbooking);

        buttonhome= (Button)findViewById(R.id.btHome);
        buttonhome.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view==buttonhome)
        {
            finish();
            startActivity(new Intent(this,SearchActivity.class));
        }
    }
}
