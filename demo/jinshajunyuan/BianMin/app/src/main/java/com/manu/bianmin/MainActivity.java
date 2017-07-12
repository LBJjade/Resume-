package com.manu.bianmin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.SaveCallback;
import com.manu.bianmin.adapter.MenuGridViewAdapter;
import com.manu.bianmin.bean.Contact;
import com.manu.bianmin.bean.MenuBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ArrayList<MenuBean> menus = new ArrayList<>();
    private GridView menuGv;
    private MenuGridViewAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initMenu();
        initView();
        // 测试 SDK 是否正常工作的代码
//        AVObject testObject = new AVObject("TestObject");
//        testObject.put("words","Hello World!");
//        testObject.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(AVException e) {
//                if(e == null){
//                    Log.d("saved","success!");
//                }
//            }
//        });

//        AVQuery<AVObject> query = new AVQuery<>("Test");
//        query.whereEqualTo("IsShow", 1);
//        // 如果这样写，查询只会返回 IsShow = 1 的结果
//        query.findInBackground(new FindCallback<AVObject>() {
//            @Override
//            public void done(List<AVObject> list, AVException e) {
//                for (int i = 0; i < list.size(); i++) {
//                    AVObject object = list.get(i);
//                    Log.d("AAA",object.toString());
//                }
//            }
//        });
    }



    private void initMenu() {
        MenuBean b1 = new MenuBean();
        b1.title = "水电";
        b1.content = "水电维修";
        b1.res = R.mipmap.ic_launcher;
        b1.className = "Test";//水电工
        menus.add(b1);
    }
    private void initView() {

        menuGv=(GridView)findViewById(R.id.gv_index_fun);
        adapter = new MenuGridViewAdapter(MainActivity.this,menus);
        menuGv.setAdapter(adapter);
        menuGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListActivity.startListActivity(MainActivity.this,menus.get(i));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
//        AVQuery<AVObject> query = new AVQuery<>("Test");
//        query.whereEqualTo("IsShow", 1);
//        // 如果这样写，查询只会返回 IsShow = 1 的结果
//        query.findInBackground(new FindCallback<AVObject>() {
//            @Override
//            public void done(List<AVObject> list, AVException e) {
//                for (int i = 0; i < list.size(); i++) {
//                    AVObject object = list.get(i);
//                    Log.d("AAA",object.toString());
//                }
//            }
//        });
//        AVQuery<AVObject> query = new AVQuery<>("Test");
//        query.orderByDescending("SID");
//        query.findInBackground(new FindCallback<AVObject>() {
//            @Override
//            public void done(List<AVObject> list, AVException e) {
//                if(null != list && list.size() > 0){
//                    Collections.reverse(list); // 倒序排列
//                    List<Contact> contacts = new ArrayList<Contact>();
//                    for (int i = 0; i < list.size(); i++) {
//                        AVObject object = list.get(i);
//                        try {
//                            JSONObject obj = new JSONObject(object.toString());
//                            Contact contact = new Contact();
//                            JSONObject serverData  = obj.optJSONObject("serverData");
//                            if(null != serverData){
//                                contact.setName(serverData.optString("Name"));
//                                contact.setPhone(serverData.optString("Phone"));
//                                contact.setIsShow(serverData.optInt("IsShow"));
//                                contact.setsID(serverData.optInt("SID"));
//                                contact.setThumbs(serverData.optInt("Thumbs"));
//                            }
//                            contacts.add(contact);
//                        } catch (JSONException e1) {
//                            e1.printStackTrace();
//                        }
//                    }
//                }
//            }
//        });
        Log.d("AAA","onStart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
