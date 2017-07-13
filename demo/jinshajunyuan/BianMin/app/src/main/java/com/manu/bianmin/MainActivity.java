package com.manu.bianmin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.avos.avoscloud.feedback.FeedbackAgent;
import com.manu.bianmin.adapter.MenuGridViewAdapter;
import com.manu.bianmin.bean.MenuBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<MenuBean> menus = new ArrayList<>();
    private GridView menuGv;
    private MenuGridViewAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                FeedbackAgent agent = new FeedbackAgent(MainActivity.this);
                agent.startDefaultThreadActivity();
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
        b1.res = R.mipmap.shuidian;
        b1.className = "Plumber";//水电工
        menus.add(b1);
        MenuBean b2 = new MenuBean();
        b2.title = "疏通";
        b2.content = "疏通下水道";
        b2.res = R.mipmap.shutong;
        b2.className = "Dredge";
        menus.add(b2);
        MenuBean b3 = new MenuBean();
        b3.title = "保洁";
        b3.content = "家政保洁";
        b3.res = R.mipmap.baojie;
        b3.className = "Clean";
        menus.add(b3);
        MenuBean b4 = new MenuBean();
        b4.title = "开锁";
        b4.content = "开锁换锁";
        b4.res = R.mipmap.kaisuo;
        b4.className = "Lock";
        menus.add(b4);
        MenuBean b5 = new MenuBean();
        b5.title = "物业";
        b5.content = "物业电话";
        b5.res = R.mipmap.wuye;
        b5.className = "Property";
        menus.add(b5);
        MenuBean b6 = new MenuBean();
        b6.title = "快递";
        b6.content = "快递电话";
        b6.res = R.mipmap.kuaidi;
        b6.className = "Express";
        menus.add(b6);
        MenuBean b7 = new MenuBean();
        b7.title = "投诉";
        b7.content = "政府投诉热线";
        b7.res = R.mipmap.tousu;
        b7.className = "Complaint";
        menus.add(b7);
        //最后的
        MenuBean last = new MenuBean();
        last.title = "关于";
        last.content = "APP信息";
        last.res = R.mipmap.guanyu;
        last.className = "Express";
        menus.add(last);
    }
    private void initView() {

        menuGv=(GridView)findViewById(R.id.gv_index_fun);
        adapter = new MenuGridViewAdapter(MainActivity.this,menus);
        menuGv.setAdapter(adapter);
        menuGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i== menus.size()-1){
                    AboutActivity.startAboutActivity(MainActivity.this);
                }else{
                    ListActivity.startListActivity(MainActivity.this,menus.get(i));
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
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
//            Toast.makeText(MainActivity.this, "我要分享！", Toast.LENGTH_LONG).show();
            share();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void share() {
//        Uri imageUri = Uri.parse("android.resource://" + getPackageName()
//                + "/drawable/" + "ic_launcher");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_TEXT, "Hello");
//        intent.putExtra(Intent.EXTRA_STREAM, imageUri);
//        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_TEXT, "https://www.pgyer.com/2ACA");
        intent.setType("text/plain");
        startActivity(intent);
    }
}
