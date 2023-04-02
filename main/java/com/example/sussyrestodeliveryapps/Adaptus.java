package com.example.sussyrestodeliveryapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adaptus extends ArrayAdapter<String>{
    String[] names, prices;
    int[] menus;
    Context c;

    public Adaptus(Context c, String[] names, int[] menus, String prices[]){
        super(c, R.layout.listview_item);
        this.names = names;
        this.menus = menus;
        this.prices = prices;
        this.c = c;
    }

    @Override
    public int getCount(){
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder vh = new ViewHolder();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);

            vh.mMenu = (ImageView) convertView.findViewById(R.id.imeeji);
            vh.mName = (TextView) convertView.findViewById(R.id.tekusu);
            vh.mPrice = (TextView) convertView.findViewById(R.id.puraisu);
            convertView.setTag(vh);
        }

        else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.mMenu.setImageResource(menus[position]);
        vh.mName.setText(names[position]);
        vh.mPrice.setText(prices[position]);

        return convertView;
    }

    static class ViewHolder{
        ImageView mMenu;
        TextView mName, mPrice;
    }
}
