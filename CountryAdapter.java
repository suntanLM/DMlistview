package com.itplus.demolistview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 24/04/2017.
 */

public class CountryAdapter extends BaseAdapter {

    private Activity mActivity;
    private List<CountryInfo> listName = new ArrayList<CountryInfo>();


    public CountryAdapter(Activity activity, List<CountryInfo> listCountry){
        mActivity = activity;
        listName.addAll(listCountry);
    }

    public void clearAll(){
        if(listName!=null && listName.size()>0){
            listName.clear();
        }
    }
    public void addObject(List<CountryInfo> lst){
        if(listName!=null){
            listName.addAll(lst);
        }
    }

    @Override
    public int getCount() {
        return listName.size();
    }

    @Override
    public Object getItem(int position) {
        return listName.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(mActivity).inflate(R.layout.item_listview_layout, null);

        TextView tvCountryName = (TextView) convertView.findViewById(R.id.tvCountryName);

        tvCountryName.setText(listName.get(position).getCountryName());

        return convertView;
    }
}
