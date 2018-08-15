package com.example.sree.custreg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    LinearLayout lay_customer;

    EditText edt_name, edt_last_name, edt_dob, edt_gender, edt_mobile, edt_email, edt_address, edt_city, edt_District, edt_State;
    String name, last_name, dob, gender, mobile, email, address, city, district, state;
    public static final String ADDCUSTOMER = "http://10.0.2.2:1234/android/addCustomer.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lay_customer = (LinearLayout) findViewById(R.id.lay_customer);

        edt_State = (EditText) findViewById(R.id.edt_State);
        edt_District = (EditText) findViewById(R.id.edt_District);
        edt_city = (EditText) findViewById(R.id.edt_city);
        edt_address = (EditText) findViewById(R.id.edt_address);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_mobile = (EditText) findViewById(R.id.edt_mobile);
        edt_gender = (EditText) findViewById(R.id.edt_gender);
        edt_dob = (EditText) findViewById(R.id.edt_dob);
        edt_last_name = (EditText) findViewById(R.id.edt_last_name);
        edt_name = (EditText) findViewById(R.id.edt_name);
    }

    public void addCustomer(View view) {

        name = edt_name.getText().toString();
        last_name = edt_last_name.getText().toString();
        dob = edt_dob.getText().toString();
        gender = edt_gender.getText().toString();
        mobile = edt_mobile.getText().toString();
        email = edt_email.getText().toString();
        address = edt_address.getText().toString();
        city = edt_city.getText().toString();
        district = edt_District.getText().toString();
        state = edt_State.getText().toString();


        String emailPattern =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (name.isEmpty()) {
            Snackbar snackbar = Snackbar.make(lay_customer, "Please Enter Name", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
        else if (last_name.isEmpty()) {
            Snackbar snackbar = Snackbar.make(lay_customer, "Please Enter Lastname", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
        else if (dob.isEmpty()) {
            Snackbar snackbar = Snackbar.make(lay_customer, "Please Enter Date of Birth", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
        else if (gender.isEmpty()) {
            Snackbar snackbar = Snackbar.make(lay_customer, "Please Select Gender", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
        else if (mobile.length()<10) {
            Snackbar snackbar = Snackbar.make(lay_customer, "Invalid Mobile Number", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
        else if (email.isEmpty()) {
            Snackbar snackbar = Snackbar.make(lay_customer, "Please Enter Email Id", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
        else if (address.isEmpty()) {
            Snackbar snackbar = Snackbar.make(lay_customer, "Please Enter Address", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
        else if (city.isEmpty()) {
            Snackbar snackbar = Snackbar.make(lay_customer, "Please Enter City", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
        else if (district.isEmpty()) {
            Snackbar snackbar = Snackbar.make(lay_customer, "Please Enter District", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
        else if (state.isEmpty()) {
            Snackbar snackbar = Snackbar.make(lay_customer, "Please Enter State", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
        else if (email.matches(emailPattern)){
            addCustomerdetails( name, last_name, dob, gender, mobile, email, address, city, district, state);
        }else{
            Snackbar snackbar = Snackbar.make(lay_customer, "Please Enter Valid Email Id", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.color.colorPrimary);
            snackbar.show();
        }
    }


    private void addCustomerdetails( final String name , final String last_name , final String dob ,final String gender,final String mobile,final String email,final String address,final String city,final String district,final String state) {
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Please Wait...","Adding Data.", true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (s.contains("Data Inserted")) {
                    Snackbar snackbar = Snackbar.make(lay_customer, "New Customer Added.", Snackbar.LENGTH_LONG);
                    View sbView = snackbar.getView();
                    sbView.setBackgroundResource(R.color.colorPrimary);
                    snackbar.show();
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(in);
                } else {
                    Snackbar snackbar = Snackbar.make(lay_customer, s, Snackbar.LENGTH_LONG);
                    View sbView = snackbar.getView();
                    sbView.setBackgroundResource(R.color.colorPrimary);
                    snackbar.show();
                }

            }
            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String, String>();

                data.put("name", name);
                data.put("last_name", last_name);
                data.put("dob", dob);
                data.put("gender", gender);
                data.put("mobile", mobile);
                data.put("email", email);
                data.put("address", address);
                data.put("city", city);
                data.put("district", district);
                data.put("state", state);

                String result = rh.sendPostRequest(ADDCUSTOMER, data);

                return result;
            }
        }
        RegisterUser ru = new RegisterUser();
        ru.execute( name, last_name, dob, gender, mobile, email, address, city, district, state);
    }

}


	
	
	
