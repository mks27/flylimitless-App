package com.flylimitless.flylimitless;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class afterbooknowActivity extends AppCompatActivity implements View.OnClickListener {

    Button confirm;
    String source, destination, nadult,nchild,ninfant,departday,departmonth,departyear,returnday,returnmonth,returnyear;
    String arritime,departtime,fno,price,total;
    TextView textno,textfrom,textto,textarri,textdept,textdate,textprice,textadult,textchild,textinfant,texttotal;
    int n1,n2,n3;
    double t,n;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterbooknow);

        confirm= (Button)findViewById(R.id.confirmbtn);
        confirm.setOnClickListener(this);

        textno= (TextView)findViewById(R.id.viewno);
        textfrom=(TextView)findViewById(R.id.viewsource);
        textto=(TextView)findViewById(R.id.viewdest);
        textarri=(TextView)findViewById(R.id.viewarri);
        textdept=(TextView)findViewById(R.id.viewdept);
        textdate=(TextView)findViewById(R.id.viewdate);
        textprice=(TextView)findViewById(R.id.viewprice);
        textadult=(TextView)findViewById(R.id.viewadult);
        textchild=(TextView)findViewById(R.id.viewchild);
        textinfant=(TextView)findViewById(R.id.viewinfant);
        texttotal=(TextView)findViewById(R.id.viewtotal);
        cb=(CheckBox)findViewById(R.id.checkbox);

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


        textno.setText(fno);
        textfrom.setText(source);
        textto.setText(destination);
        textarri.setText(arritime);
        textdept.setText(departtime);
        textdate.setText(departday + "/"+departmonth+"/"+departyear);
        textprice.setText(price);
        textadult.setText(nadult);
        textchild.setText(nchild);
        textinfant.setText(ninfant);


       n1=Integer.valueOf(nadult);
        n2=Integer.valueOf(nchild);
        n3=Integer.valueOf(ninfant);
        n=Double.valueOf(price);
        t= (n1*n) + (n2*n*0.75)+(n3*1000);

        total= String.valueOf(t);
        texttotal.setText(total);





    }




    @Override
    public void onClick(View view) {
        if(view==confirm)
        {
            if(cb.isChecked())
            {
                Intent i= new Intent(this,enterdetailsActivity.class);
                i.putExtra("from",source);
                i.putExtra("to",destination);
                i.putExtra("adult",nadult);
                i.putExtra("child",nchild);
                i.putExtra("infant",ninfant);
                i.putExtra("dd",departday);
                i.putExtra("dm",departmonth);
                i.putExtra("dy",departyear);
                i.putExtra("rd",returnday);
                i.putExtra("rm",returnmonth);
                i.putExtra("ry",returnyear);
                i.putExtra("arri",arritime);
                i.putExtra("dt",departtime);
                i.putExtra("fn",fno);
                i.putExtra("pric",price);
                i.putExtra("total1",total);

                startActivity(i);
            }

            else
            {
                Toast.makeText(this, "please tick the checkbox", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
