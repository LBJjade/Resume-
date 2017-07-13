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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ContactItem item = null;
        if(view==null || view.getTag()==null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list,null);
            item = new ContactItem();
            item.resIv=(ImageView) view.findViewById(R.id.iv_contact_res);
            item.titleTv=(TextView) view.findViewById(R.id.tv_title);
            item.descTv=(TextView) view.findViewById(R.id.tv_phone);
            item.callBt=(TextView) view.findViewById(R.id.call);
            view.setTag(item);
        }else{
            item=(ContactItem)view.getTag();
        }

        if("Clean".equals(contacts.get(i).getClassName())){
            item.resIv.setImageResource(R.mipmap.baojie_list);
        }else if("Dredge".equals(contacts.get(i).getClassName())){
            item.resIv.setImageResource(R.mipmap.shutong_list);
        }else if("Express".equals(contacts.get(i).getClassName())){
            item.resIv.setImageResource(R.mipmap.kuaidi_);
        }else if("Lock".equals(contacts.get(i).getClassName())){
            item.resIv.setImageResource(R.mipmap.kaisuo_dingdang);
        }else if("Plumber".equals(contacts.get(i).getClassName())){
            item.resIv.setImageResource(R.mipmap.jiaju);
        }else if("Property".equals(contacts.get(i).getClassName())){
            item.resIv.setImageResource(R.mipmap.wuye);
        }else if("Complaint".equals(contacts.get(i).getClassName())){
            item.resIv.setImageResource(R.mipmap.tousu);
        }else {
            item.resIv.setImageResource(R.mipmap.tousu);
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
    public TextView callBt;
}

