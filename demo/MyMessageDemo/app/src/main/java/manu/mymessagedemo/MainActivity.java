package manu.mymessagedemo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.bugly.crashreport.CrashReport;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import manu.mymessagedemo.message.AccountEvent;
import manu.mymessagedemo.util.LogUtil;
import manu.mymessagedemo.util.OptionDialogHelper;
import manu.mymessagedemo.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        initView();
        CrashReport.initCrashReport(getApplicationContext(), "0b589ea511", false);
    }

    private TextView homeTv;
    private TextView setTv;
    private TextView recordTv;
    String currentTag = TAG_HOME;
    private static String TAB_INTENT = "tab";
    View currentView = null;
    private void initView() {

        homeTv = (TextView) findViewById(R.id.tv_send);
        setTv = (TextView) findViewById(R.id.tv_setting);
        recordTv = (TextView) findViewById(R.id.tv_record);

        homeTv.setOnClickListener(this);
        setTv.setOnClickListener(this);
        recordTv.setOnClickListener(this);
        initFragment();
        if (getIntent() != null) {
            currentTag = getIntent().getStringExtra(TAB_INTENT);
        }
        showFragmentBy(currentTag);
    }

    public void showFragmentBy(String tag) {
        if(TextUtils.isEmpty(tag)){
            tag = TAG_HOME;
        }
        if (currentView != null) {
            currentView.setSelected(false);
        }
        if (tag.equals(TAG_HOME)) {//首页
            homeTv.setSelected(true);
            showFragment(TAG_HOME);
            currentView = homeTv;
        }else if (tag.equals(TAG_SET)) {//设置
            setTv.setSelected(true);
            showFragment(TAG_SET);
            currentView = setTv;
        }else if (tag.equals(TAG_RECORD)) {//记录
            recordTv.setSelected(true);
            showFragment(TAG_RECORD);
            currentView = recordTv;
        }
    }

    public void showFragment(String tag) {
        showFragment(tag, null, R.id.index_content, true);
    }
    private String TAG = "fragment";
    private Fragment fragment;
    private FragmentTransaction fragmentTransaction;
    private void showFragment(String tag, Bundle data, int viewContainer,
                              boolean hideBehind) {
        final FragmentManager mFragmentManager = getSupportFragmentManager();
        fragment = mFragmentManager.findFragmentByTag(tag);
        fragmentTransaction = mFragmentManager.beginTransaction();
        if (hideBehind) {
            for (String t : tags) {
                if (!t.equals(tag)) {
                    Fragment oldfragment = mFragmentManager
                            .findFragmentByTag(t);
                    if (oldfragment != null) {
                        fragmentTransaction.hide(oldfragment);
                        LogUtil.show(t + " = hide");
                    }
                }
            }
            // mCurrTag = tag;
        }
        if (fragment == null) {
            LogUtil.show(TAG, "fragment=null");
            Class<? extends Fragment> cl = fragments.get(tag);
            try {
                fragment = cl.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fragment != null) {
                LogUtil.show(TAG, "new fragment !=null");
                fragment.setArguments(data);
                //
                fragmentTransaction.add(viewContainer, fragment, tag);
            } else {
                LogUtil.show(TAG, "new fragment null");
            }
        } else {
            fragmentTransaction.show(fragment);
            LogUtil.show(TAG,
                    "fragment show isAdd=" + fragment.isAdded() + ",hidden="
                            + fragment.isHidden() + ",tag=" + fragment.getTag());
        }
        if (fragment != null) {
            fragment.setUserVisibleHint(true);
        }
        currentTag = tag;
        fragmentTransaction.commitAllowingStateLoss();
    }


    private HashMap<String, Class<? extends BaseFragment>> fragments = new HashMap<>();
    public final static String TAG_HOME = "home";//就是send 主功能
    public final static String TAG_SET = "set";
    public final static String TAG_RECORD = "record";

    private final static String[] tags = {TAG_HOME, TAG_SET,TAG_RECORD};
    private void initFragment() {

        fragments.put(TAG_HOME, HomeFragment.class);
        fragments.put(TAG_SET, SetFragment.class);
        fragments.put(TAG_RECORD, RecordFragment.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tv_send:
                showFragment(TAG_HOME);
                if (currentView != null && currentView != view) {
                    currentView.setSelected(false);
                }
                currentView = view;
                currentView.setSelected(true);
                ToastUtil.show(MainActivity.this,"打开了send");
                break;
            case R.id.tv_setting:
                showFragment(TAG_SET);
                if (currentView != null && currentView != view) {
                    currentView.setSelected(false);
                }
                currentView = view;
                currentView.setSelected(true);
                ToastUtil.show(MainActivity.this,"打开了set");
                break;
            case R.id.tv_record:
                showFragment(TAG_RECORD);
                if (currentView != null && currentView != view) {
                    currentView.setSelected(false);
                }
                currentView = view;
                currentView.setSelected(true);
                ToastUtil.show(MainActivity.this,"打开了record");
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void AccountEventBus(AccountEvent message) {
        if (message != null) {
            switch (message.eventId) {
                case AccountEvent.TYPE_EXIT_ACCOUNT:
//                    EMClient.getInstance().logout(true);
                    break;
                case AccountEvent.TYPE_LOGIN_MULT_ACCOUNT:
//                    EMClient.getInstance().logout(true);
                    break;
                case AccountEvent.TYPE_USER_EXIT_APP:
                    finish();
                    break;
            }
        }
    }
    @Override
    public void onBackPressed() {
        OptionDialogHelper.showExitDialog(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            currentTag = intent.getStringExtra(TAB_INTENT);
        }
        showFragmentBy(currentTag);
    }

}
