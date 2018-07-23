package com.example.hermes.profilescreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by Hermes on 08/06/2017.
 *
 * Populating the lsit view by implementing the ViewHolder pattern
 */

public class CustomAdapter extends BaseAdapter{

    private ArrayList<DataObject> mDataObjectArray;
    private Context mContext;

    public CustomAdapter(ArrayList<DataObject> mDataObjectArray, Context mContext) {
        this.mDataObjectArray = mDataObjectArray;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mDataObjectArray.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataObjectArray.indexOf(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(mContext).inflate(R.layout.items_for_list,parent,false);
            viewHolder.webpage_text = (TextView)convertView.findViewById(R.id.webpage_text);
            viewHolder.email_text = (TextView)convertView.findViewById(R.id.email_text);
            viewHolder.birthday_text = (TextView)convertView.findViewById(R.id.birthday_text);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder = (ViewHolder)convertView.getTag();

        DataObject dataObject = mDataObjectArray.get(position);
        viewHolder.webpage_text.setText(dataObject.getmWebpage());
        viewHolder.email_text.setText(dataObject.getmEmail());
        viewHolder.birthday_text.setText(dataObject.getmBirthday());

        return convertView;
    }
}
