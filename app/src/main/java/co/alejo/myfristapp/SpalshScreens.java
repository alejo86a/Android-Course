package co.alejo.myfristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SpalshScreens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent= new Intent(SpalshScreens.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}