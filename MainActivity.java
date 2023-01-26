package com.example.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showpopup(View v) {
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();

    }
    public void showpopup2(View view) {
        PopupMenu popup2 = new PopupMenu(this,view);
        popup2.setOnMenuItemClickListener(this);
        popup2.inflate(R.menu.popup2_menu);
        popup2.show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText (this, "All clicked", Toast.LENGTH_SHORT).show();
                Intent itemm1 = new Intent(MainActivity.this,All1.class);
                startActivity(itemm1);
                return true;

            case R.id.item2:
                Toast.makeText (this, "Salary clicked", Toast.LENGTH_SHORT).show();
                Intent itemm2 = new Intent(MainActivity.this,Salary.class);
                startActivity(itemm2);
                return true;

            case R.id.item3:
                Toast.makeText (this, "transfer clicked", Toast.LENGTH_SHORT).show();
                Intent itemm3 = new Intent(MainActivity.this,transfer.class);
                startActivity(itemm3);
                return true;

            case R.id.item4:
                Toast.makeText (this, "All clicked", Toast.LENGTH_SHORT).show();
                Intent itemm4 = new Intent(MainActivity.this,All2.class);
                startActivity(itemm4);
                return true;

            case R.id.item5:
                Toast.makeText (this, "Purchases clicked", Toast.LENGTH_SHORT).show();
                Intent itemm5 = new Intent(MainActivity.this,Purchases.class);
                startActivity(itemm5);
                return true;

            case R.id.item6:
                Toast.makeText (this, "transfers clicked", Toast.LENGTH_SHORT).show();
                Intent itemm6 = new Intent(MainActivity.this,transfers2.class);
                startActivity(itemm6);
                return true;

            case R.id.item7:
                Toast.makeText (this, "investment clicked", Toast.LENGTH_SHORT).show();
                Intent itemm7 = new Intent(MainActivity.this,transfers2.class);
                startActivity(itemm7);
                return true;

            case R.id.item8:
                Toast.makeText (this, "monthly redemption payments clicked", Toast.LENGTH_SHORT).show();
                Intent itemm8 = new Intent(MainActivity.this,monthly_r_p.class);
                startActivity(itemm8);
                return true;

            case R.id.item9:
                Toast.makeText (this, "insurance and taxes clicked", Toast.LENGTH_SHORT).show();
                Intent itemm9 = new Intent(MainActivity.this,insurance.class);
                startActivity(itemm9);
                return true;

            case R.id.item10:
                Toast.makeText (this, "entertainment clicked", Toast.LENGTH_SHORT).show();
                Intent itemm10 = new Intent(MainActivity.this,entertainment.class);
                startActivity(itemm10);
                return true;

            default: return false;
        }
    }


    public void Report1(View view2) {
        Intent report = new Intent(MainActivity.this,report.class);
        startActivity(report);
    }
}