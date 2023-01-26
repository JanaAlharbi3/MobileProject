package com.example.test;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final  int MY_PERMSSIONS_RROUEST_RECRIVE_SMS = 0;
    private static final String SMS ="android.permission.RECEIVE_SMS";
    private static final String SMS_RECEIVED ="android.provider.Telephony.SMS_RECEIVED";
    TextView Message;
    model mmodel;


     String all,Type,Category,Amount,Date;
    int t1,t2,c1,c2,a1,a2,d1,d2;

    final SMSbroadcast receiver = new SMSbroadcast() {
        @Override
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
            try{
            t1 = msg.indexOf("Type") + 5;
            if (t1>0){}
            else{
                Toast.makeText(MainActivity.this,"Wrong message", LENGTH_SHORT).show();}
            t2 = msg.indexOf("Category");
            if (t2>0){}
            else{

                Toast.makeText(MainActivity.this,"Wrong message", LENGTH_SHORT).show();}
            c1 = msg.indexOf("Category") + 9;
            if (c1>0){}
            else{

                Toast.makeText(MainActivity.this,"Wrong message", LENGTH_SHORT).show();}
            c2 = msg.indexOf("The");
            if (c2>0){}
            else{

                Toast.makeText(MainActivity.this,"Wrong message", LENGTH_SHORT).show();}
            a1 = msg.indexOf("of") + 2;
            if (a1>0){}
            else{

                Toast.makeText(MainActivity.this,"Wrong message", LENGTH_SHORT).show();}
            a2 = msg.indexOf("Store");
            if (a2>0){}
            else{

                Toast.makeText(MainActivity.this,"Wrong message", LENGTH_SHORT).show();}
            d1 = msg.indexOf("On") + 2;
            if (d1>0){}
            else{

                Toast.makeText(MainActivity.this,"Wrong message", LENGTH_SHORT).show();}
            d2 = msg.indexOf("At");
            if (d2>0){}
            else{

                Toast.makeText(MainActivity.this,"Wrong message", LENGTH_SHORT).show();}


            Type = msg.substring(t1, t2);
            Category = msg.substring(c1, c2);
            Amount = msg.substring(a1, a2);

            Date = msg.substring(d1, d2);
            all = "" + Type + Category + Amount + Date;
             mmodel = new model(-1, Type, Amount, Category, Date);
            Message.setText(mmodel.toString());
            DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
            boolean b = dataBaseHelper.insertData(mmodel);
            Toast.makeText(MainActivity.this,"Message has been received"+b, LENGTH_SHORT).show();} catch (Exception e) {
                e.printStackTrace();
            }

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver,new IntentFilter(SMS_RECEIVED));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Message = findViewById(R.id.message);



       if(ContextCompat.checkSelfPermission(this, SMS)!=PackageManager.PERMISSION_GRANTED)
       {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,SMS)){


        }

        else {
          ActivityCompat.requestPermissions(this,new String[]{SMS},MY_PERMSSIONS_RROUEST_RECRIVE_SMS);
        }
       }


    }

    public void onRequestPermissionsResult (int requestCode, String permissions[], int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case MY_PERMSSIONS_RROUEST_RECRIVE_SMS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this, "Thank you for permitting!", LENGTH_SHORT).show();
                } else {

                    Toast.makeText(this, "Can't Access Messages", LENGTH_SHORT).show();
                }

        }



    }
}