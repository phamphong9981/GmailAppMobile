package com.example.gmail;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MailAdapter extends BaseAdapter {
    ArrayList<Mail> arrayList;
    Context context;
    boolean isChecked;
    ViewHolder viewHolder;

    public MailAdapter(ArrayList<Mail> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.mail,parent,false);
            viewHolder.icon=convertView.findViewById(R.id.icon);
            viewHolder.subject=convertView.findViewById(R.id.subject);
            viewHolder.content1=convertView.findViewById(R.id.content1);
            viewHolder.content2=convertView.findViewById(R.id.content2);
            viewHolder.time=convertView.findViewById(R.id.time);
            viewHolder.checkbox=convertView.findViewById(R.id.checkbox);
            convertView.setTag(viewHolder);
        }else
            viewHolder=(ViewHolder) convertView.getTag();
        Drawable background=viewHolder.icon.getBackground();
        ((GradientDrawable)background).setColor(Color.parseColor(arrayList.get(position).getColor()));
        viewHolder.subject.setText(arrayList.get(position).getSubject());
        viewHolder.content1.setText(arrayList.get(position).getContent1());
        viewHolder.content2.setText(arrayList.get(position).getContent2());
        viewHolder.time.setText(arrayList.get(position).getTime());
        viewHolder.icon.setText(arrayList.get(position).getIcon());

        isChecked=arrayList.get(position).isCheckbox();
        if(isChecked==true){
            viewHolder.checkbox.setImageResource(R.drawable.ic_star_black_24dp);
        }else
            viewHolder.checkbox.setImageResource(R.drawable.ic_star_border_black_24dp);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isChecked=arrayList.get(position).isCheckbox();
                isChecked=!isChecked;
                arrayList.get(position).setCheckbox(isChecked);
                if(isChecked==true){
                    ((ImageView) v.findViewById(R.id.checkbox)).setImageResource(R.drawable.ic_star_black_24dp);
                }else
                    ((ImageView) v.findViewById(R.id.checkbox)).setImageResource(R.drawable.ic_star_border_black_24dp);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class ViewHolder{
        TextView icon;
        TextView subject;
        TextView content1;
        TextView content2;
        TextView time;
        ImageView checkbox;

    }
}
