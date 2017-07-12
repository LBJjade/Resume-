package com.manu.bianmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.manu.bianmin.R;
import com.manu.bianmin.bean.MenuBean;

import java.util.ArrayList;

/**
 * Created by min on 2017/7/12.
 */

public class MenuGridViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MenuBean> menus;
    public MenuGridViewAdapter(Context context, ArrayList<MenuBean> menus){
        this.context = context;
        this.menus = menus;
    }

    @Override
    public int getCount() {
        return menus==null?0:menus.size();
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
        MenuItem item = null;
        if(view==null || view.getTag()==null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_index_menu,null);
            item = new MenuItem();
            item.resIv=(ImageView) view.findViewById(R.id.iv_menu_res);
            item.titleTv=(TextView) view.findViewById(R.id.tv_menu_title);
            item.descTv=(TextView) view.findViewById(R.id.tv_menu_desc);
            item.unreadTv=(TextView)view.findViewById(R.id.tv_menu_unread_msg);
            view.setTag(item);
        }else{
            item=(MenuItem)view.getTag();
        }
        item.resIv.setImageResource(menus.get(i).getRes());
        item.titleTv.setText(menus.get(i).title);
        item.descTv.setText(menus.get(i).content);
        if (menus.get(i).unread<=0) {
            item.unreadTv.setVisibility(View.GONE);
        }else{
            item.unreadTv.setVisibility(View.VISIBLE);
            if (menus.get(i).unread>99){
                item.unreadTv.setText("99+");
            }else {
                item.unreadTv.setText(String.valueOf(menus.get(i).unread));
            }
        }
        return view;
    }
}

class MenuItem{
    public ImageView resIv;
    public TextView titleTv;
    public TextView descTv;
    public TextView unreadTv;
}
