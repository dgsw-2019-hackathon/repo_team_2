package com.example.a2019hack.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a2019hack.R;
import com.example.a2019hack.data.Child;

import java.util.List;

public class childListviewAdapter extends BaseAdapter {

    private Context context;
    private List<Child> childList;

    public childListviewAdapter(Context context, List<Child> childList) {

        this.context = context;
        this.childList = childList;
    }

    @Override
    public int getCount() {

        return childList.size();
    }

    @Override
    public Object getItem(int position) {

        return childList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.child_listview_item, parent, false);

        final Child child = childList.get(position);

        final TextView childName = convertView.findViewById(R.id.childName);
        final TextView childSex = convertView.findViewById(R.id.childSex);
        final TextView childAge = convertView.findViewById(R.id.childAge);
        final TextView childPlace = convertView.findViewById(R.id.childPlace);
        final TextView childHeight = convertView.findViewById(R.id.childHeight);
        final TextView childWeight = convertView.findViewById(R.id.childWeight);

        childName.setText(child.getChildName());
        childSex.setText(child.getChildSex());
        childAge.setText(child.getChildAge());
        childPlace.setText(child.getChildPlace());
        childHeight.setText(child.getChildHeight());
        childWeight.setText(child.getChildWeight());

        return convertView;
    }
}
