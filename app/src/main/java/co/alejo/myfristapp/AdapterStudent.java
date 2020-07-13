package co.alejo.myfristapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AdapterStudent extends ArrayAdapter {
    private Activity context;
    ArrayList<Student> students;
    private int resource;
    public AdapterStudent(@NonNull Activity context, int resource, ArrayList<Student> students) {
        super(context, resource, students);
        this.context = context;
        this.resource= resource;
        this.students=students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=new ViewHolder();;
        if(view==null){
            if(context!=null){
                view=context.getLayoutInflater().inflate(resource,null);

                holder.txtItem= (TextView) view.findViewById(R.id.txtItem);
                view.setTag(holder);

            }else{
                holder=(ViewHolder) view.getTag();
            }
            Student student = students.get(i);
            holder.txtItem.setText(student.getName());
            if(!student.isPass()){
                holder.txtItem.setBackgroundColor(Color.RED);
            }

        }
        return view;
    }

    static class ViewHolder{
        private TextView txtItem;

    }
}
