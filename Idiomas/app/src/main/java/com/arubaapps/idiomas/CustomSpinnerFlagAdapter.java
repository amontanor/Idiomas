package com.arubaapps.idiomas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Antonio_2 on 20/05/2016.
 */
public class CustomSpinnerFlagAdapter extends ArrayAdapter {

    Context context;

    public CustomSpinnerFlagAdapter(Context context, int resourceId, List items) {
        super(context, resourceId, items);
        this.context = context;
    }
    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
    }

    @Override
    public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
        return getCustomView(position, cnvtView, prnt);
    }

    @Override
    public View getView(int pos, View cnvtView, ViewGroup prnt) {
        return getCustomView(pos, cnvtView, prnt);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        SpinnerRowFlags rowItem = (SpinnerRowFlags) getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.spinner_item_row, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iconFlag);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }

}
