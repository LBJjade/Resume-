package com.manu.bianmin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.manu.bianmin.adapter.ContactGridViewAdapter;
import com.manu.bianmin.bean.Contact;
import com.manu.bianmin.bean.MenuBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by min on 2017/7/12.
 */

public class AboutActivity extends AppCompatActivity {
    private GridView contactGv;
    private ContactGridViewAdapter adapter = null;
    ArrayList<Contact> contacts = new ArrayList<Contact>();
    private MenuBean myMenu;
    public static String MENUBEAN="menubean";
    public static void startAboutActivity(Context context){
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(1 == msg.what){
                adapter.notifyDataSetChanged();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        initData();
        initView();

    }

    private void initView() {
        contactGv=(GridView)findViewById(R.id.gv_index_fun);
        adapter = new ContactGridViewAdapter(AboutActivity.this,contacts);
        contactGv.setAdapter(adapter);
        contactGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                ListActivity.startListActivity(MainActivity.this,menus.get(i));
            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        myMenu = (MenuBean)intent.getSerializableExtra(MENUBEAN);
        if(null != myMenu){
            getTableData();
        }
    }

    private void getTableData() {
        AVQuery<AVObject> query = new AVQuery<>(myMenu.getClassName());
        query.orderByDescending("SID");
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if(null != list && list.size() > 0){
                    Collections.reverse(list); // 倒序排列
                    for (int i = 0; i < list.size(); i++) {
                        AVObject object = list.get(i);
                        try {
                            JSONObject obj = new JSONObject(object.toString());
                            Contact contact = new Contact();
                            JSONObject serverData  = obj.optJSONObject("serverData");
                            if(null != serverData){
                                contact.setName(serverData.optString("Name"));
                                contact.setPhone(serverData.optString("Phone"));
                                contact.setIsShow(serverData.optInt("IsShow"));
                                contact.setsID(serverData.optInt("SID"));
                                contact.setThumbs(serverData.optInt("Thumbs"));
                            }
                            contacts.add(contact);
                            if(null != handler){
                                Message msg = new Message();
                                msg.what = 1;
                                handler.sendMessage(msg);
                            }
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
