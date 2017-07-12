package com.manu.bianmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.manu.bianmin.R;
import com.manu.bianmin.bean.Contact;
import com.manu.bianmin.bean.MenuBean;

import java.util.ArrayList;

/**
 * Created by min on 2017/7/12.
 */

public class ContactGridViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Contact> contacts;
    public ContactGridViewAdapter(Context context, ArrayList<Contact> contacts){
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts==null?0:contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ContactItem item = null;
        if(view==null || view.getTag()==null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list,null);
            item = new ContactItem();
            item.resIv=(ImageView) view.findViewById(R.id.iv_contact_res);
            item.titleTv=(TextView) view.findViewById(R.id.tv_title);
            item.descTv=(TextView) view.findViewById(R.id.tv_phone);
            view.setTag(item);
        }else{
            item=(ContactItem)view.getTag();
        }

        if("".equals(contacts.get(i).getClassName())){
            item.resIv.setImageResource(R.mipmap.ic_launcher);
        }
        item.titleTv.setText(contacts.get(i).getName());
        item.descTv.setText(contacts.get(i).getPhone());
        return view;
    }
}

class ContactItem{
    public ImageView resIv;
    public TextView titleTv;
    public TextView descTv;
}

