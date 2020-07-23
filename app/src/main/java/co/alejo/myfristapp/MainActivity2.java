package co.alejo.myfristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String welcome=bundle.getString("welcome","");
            int age=bundle.getInt("age",0);
            boolean relaxed=bundle.getBoolean("relaxed",false);
            Toast.makeText(getApplicationContext(),"Welcome "+welcome+" age "+age+" Relaxed "+relaxed,Toast.LENGTH_LONG).show();
        }
    }
}