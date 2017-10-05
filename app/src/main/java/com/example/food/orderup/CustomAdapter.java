package com.example.food.orderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MAYANK on 02-10-2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    MenuActivity menuActivity1;
    String name1[];
    String items1[];
    int[] price1;
    String qty1[];
    int images1[];
    LayoutInflater layoutInflater; //DEALS WITH ADAPTER CLASS OR FRAGMENTS
    CustomAdapter customAdapter;
    CustomAdapter(){


    }
    CustomAdapter(MenuActivity menuActivity,String name1[], int images1[], int price1[]){

        menuActivity1=menuActivity;
        this.name1=name1; //we use this here because name and name are same in both the constructor
        this.images1=images1;
        this.price1=price1;
        layoutInflater=(LayoutInflater)menuActivity1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//IF WE DO NOT INITALISE IT , NULL POINTER ERROR OCCURS
    }
    @Override
    public int getCount()  {//DATA INCOMING TO BE SHOWN TO USER
        return images1.length;
    }

    @Override
    public Object getItem(int i) {// FETCH ITEM TILL ARRAY LENGTH
        return images1;
    }

    @Override
    public long getItemId(int i) {//DATA POSITION
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent)
    {
        convertView = layoutInflater.inflate(R.layout.activity_appetizer, parent,false);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.img);
        TextView tone=(TextView)convertView.findViewById(R.id.tone);
        TextView tthree=(TextView)convertView.findViewById(R.id.tthree);
        TextView ttwo=(TextView)convertView.findViewById(R.id.ttwo);
        Button plus=(Button)convertView.findViewById(R.id.plus);
        Button minus=(Button)convertView.findViewById(R.id.minus);
        EditText editText=(EditText)convertView.findViewById(R.id.edittext);
        imageView.setImageResource(images1[i]);
        tone.setText(name1[i]);
       /* tthree.setText(price1[i]);*/
        return convertView;




    }
}

