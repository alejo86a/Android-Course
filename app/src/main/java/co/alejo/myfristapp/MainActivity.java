package co.alejo.myfristapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private Button btnShow;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(),"Permiso Aceptado", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Permiso Denegado", Toast.LENGTH_LONG).show();
                }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout= new LinearLayout(getApplicationContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //setContentView(linearLayout);
        setContentView(R.layout.activity_main);
        linearLayout.setBackgroundColor(Color.BLUE);
        getResources().getColor(R.color.orange);
        ContextCompat.getColor(getApplicationContext(), R.color.orange);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin=30;
        TextView textView = new TextView(getApplicationContext());
        textView.setText("Hola");
        //textView.setLayoutParams(layoutParams);
        textView.setBackgroundColor(Color.RED);
        linearLayout.addView(textView, layoutParams);

        //btnSave=(Button) findViewById(R.id.btnSave);
        //btnSave.setBackgroundColor(Color.GREEN);
        //btnSave.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
        test();

        //clase de adaptadores
        //ArrayAdapter<Student> arrayAdapter = new ArrayAdapter<Student>(this, R.layout.itm_adapter, R.id.txtItem, Student.getStudents());
        AdapterStudent adapterStudent = new AdapterStudent(this, R.layout.itm_adapter, Student.getStudents());
        ListView listView= (ListView) findViewById(R.id.listView);
        //listView.setAdapter(arrayAdapter);
        listView.setAdapter(adapterStudent);

        btnShow = (Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent= new Intent(MainActivity.this, MainActivity2.class);
                //intent.putExtra("age", 23);
                //intent.putExtra("welcome","Hola");
                //intent.putExtra("relaxed", true);
                //startActivity(intent);
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Mi primer mensaje");
                intent.setType("text/plane"); //image/jpeg
                startActivity(Intent.createChooser(intent,"Envia el texto a"));
            }
        });

        //verificar si se tienen los permisos
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(),"Permiso Aceptado", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},1);
            Toast.makeText(getApplicationContext(),"Permiso Denegado", Toast.LENGTH_LONG).show();
        }

    }

    public void test(){
        Log.e("test", "Error");
        Log.w("test", "advertencia");
        Log.i("test", "Informar");
        Log.d("test", "Depuracion");
        Log.v("test", "Detalle");
    }
}