package com.example.a2019hack.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a2019hack.R;
import com.example.a2019hack.data.ChildProtect;

import java.util.ArrayList;
import java.util.List;

public class ChildProtectListviewAdapter extends BaseAdapter {

    private Context context;
    private List<ChildProtect> childProtectList;

    public ChildProtectListviewAdapter(Context context, ArrayList<ChildProtect> childProtectList) {

        this.context = context;
        this.childProtectList = childProtectList;
    }

    @Override
    public int getCount() {

        return childProtectList.size();
    }

    @Override
    public Object getItem(int position) {

        return childProtectList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.child_protect_listview_item, parent, false);

        final ChildProtect childProtect = childProtectList.get(position);

        final ImageView childPhoto = convertView.findViewById(R.id.childPhoto);
        final TextView childName = convertView.findViewById(R.id.childName);
        final TextView childSex = convertView.findViewById(R.id.childSex);
        final TextView childAge = convertView.findViewById(R.id.childAge);
        final TextView childPlace = convertView.findViewById(R.id.childPlace);
        final TextView childHeight = convertView.findViewById(R.id.childHeight);
        final TextView childWeight = convertView.findViewById(R.id.childWeight);

        childPhoto.setImageResource(R.drawable.child_image);
        childName.setText(childProtect.getChildProtectName());
        childSex.setText(childProtect.getChildProtectSex());
        childAge.setText(childProtect.getChildProtectAge());
        childPlace.setText(childProtect.getChildProtectPlace());
        childHeight.setText(childProtect.getChildProtectHeight());
        childWeight.setText(childProtect.getChildProtectWeight());

        return convertView;
    }
}