package co.alejo.myfristapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;

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
    }

    public void test(){
        Log.e("test", "Error");
        Log.w("test", "advertencia");
        Log.i("test", "Informar");
        Log.d("test", "Depuracion");
        Log.v("test", "Detalle");
    }
}