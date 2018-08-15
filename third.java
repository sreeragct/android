package com.example.sree.mydetailspro;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.sree.mydetailspro.SessionManager.KEY_BATCH;
import static com.example.sree.mydetailspro.SessionManager.KEY_BRANCH;
import static com.example.sree.mydetailspro.SessionManager.KEY_BUTTON;
import static com.example.sree.mydetailspro.SessionManager.KEY_EMAIL;
import static com.example.sree.mydetailspro.SessionManager.KEY_MOBILE;
import static com.example.sree.mydetailspro.SessionManager.KEY_NAME;
import static com.example.sree.mydetailspro.SessionManager.KEY_PLACE;

public class third_ extends AppCompatActivity {
    TextView name,mobile,email,place,branch,batch;
    String nme,mob,eml,plc,brn,bat,btn;
    LinearLayout lbr,leml,lbat,lplc;
    SharedPreferences sharedPreferences;
    private static final int PRIVATE_MODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_);

        Bundle bundle = getIntent().getExtras();
        btn = bundle.getString("btn");

        name = (TextView)findViewById(R.id.name);
        mobile = (TextView)findViewById(R.id.mobile);
        email = (TextView)findViewById(R.id.email);
        place = (TextView)findViewById(R.id.place);
        branch = (TextView)findViewById(R.id.branch);
        batch = (TextView)findViewById(R.id.batch);

        lbr = (LinearLayout)findViewById(R.id.lbr);
        lplc = (LinearLayout)findViewById(R.id.lplc);
        leml = (LinearLayout)findViewById(R.id.leml);
        lbat = (LinearLayout)findViewById(R.id.lbat);

        sharedPreferences = getSharedPreferences("shared",PRIVATE_MODE);
        nme = sharedPreferences.getString(KEY_NAME,"");
        mob = sharedPreferences.getString(KEY_MOBILE,"");
        eml = sharedPreferences.getString(KEY_EMAIL,"");
        plc = sharedPreferences.getString(KEY_PLACE,"");
        brn = sharedPreferences.getString(KEY_BRANCH,"");
        bat = sharedPreferences.getString(KEY_BATCH,"");

        name.setText(nme);
        mobile.setText(mob);
        email.setText(eml);
        place.setText(plc);
        branch.setText(brn);
        batch.setText(bat);

        if(btn.equals("b1")){
            setTitle("Profile");
            lbr.setVisibility(View.GONE);
            lbat.setVisibility(View.GONE);
        }else{
            setTitle("Details");
            leml.setVisibility(View.GONE);
            lplc.setVisibility(View.GONE);
        }
    }
}
