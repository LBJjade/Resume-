package manu.mymessagedemo;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import manu.mymessagedemo.adapter.ContactsSortAdapter;
import manu.mymessagedemo.bean.ContactEntity;
import manu.mymessagedemo.bean.GroupEntity;
import manu.mymessagedemo.bean.SortModel;
import manu.mymessagedemo.bean.SortToken;
import manu.mymessagedemo.message.DataEvent;
import manu.mymessagedemo.util.CharacterParser;
import manu.mymessagedemo.util.ContactUtil;
import manu.mymessagedemo.util.LogUtil;
import manu.mymessagedemo.util.PinyinComparator;
import manu.mymessagedemo.util.ToastUtil;
import manu.mymessagedemo.views.SideBar;


/**
 * Created by weedys on 17/7/13.
 * 主界面,发送消息
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    private String num;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vs = inflater.inflate(R.layout.fragment_home, container, false);
        initView(vs);
        initListener();
        initData();
        return vs;
    }

    @Override
    public void onStart() {
        super.onStart();
//        initData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void DataEventBus(DataEvent message) {
        if (message != null) {
            switch (message.eventId) {
                case DataEvent.TYPE_NUMTV:
                    numTv.setText(num);
                    break;
            }
        }
    }

    private void initData() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.READ_CONTACTS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                ToastUtil.show(getActivity(),"请开启权限吧");
            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_CONTACTS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
           // 执行获取权限后的操作
//            getContacts();
            loadContacts();
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
//                    getContacts();
                    loadContacts();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    ToastUtil.show(getActivity(),"请开启权限");
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void getContacts() {
        ContactUtil util = new ContactUtil(getActivity());

        String str = null;
        try {
            str = util.getContactInfo();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getAllContacts();
        LogUtil.show("联系人"+str);
        getAllGroup();

        contactEntitys = getGroupById(getActivity(),groups.get(0).getGroupId());
        for (int i = 0; i < contactEntitys.size(); i++) {
            LogUtil.show(contactEntitys.get(i).toString());

        }
    }

    /**
     * 获取所有人的联系信息
     */
    private List<ContactEntity> allContacts = new ArrayList<>();
    private void getAllContacts() {
        allContacts = getAllContacts(getActivity());
        for (int i = 0; i < allContacts.size(); i++) {
            LogUtil.show("allContacts:  "+allContacts.get(i).toString());
        }
    }

    /**
     * 获取手机所有联系人信息
     *
     * @return
     */
    public List<ContactEntity> getAllContacts(Context context) {

        // 1.查询raw_contacts表 获取所有联系人的id
        Uri rawUri = Uri.parse("content://com.android.contacts/raw_contacts");
        Uri dataUri = Uri.parse("content://com.android.contacts/data");

        List<ContactEntity> contaList = new ArrayList<ContactEntity>();

        Cursor idCursor = context.getContentResolver().query(rawUri,
                new String[] { "contact_id" }, null, null, null);

        while (idCursor.moveToNext()) {

            int id = idCursor.getInt(0); // 得到联系人的id

            ContactEntity ce = new ContactEntity();
            ce.setContactId(id);

            Cursor dataCursor = context.getContentResolver().query(dataUri,
                    null, "raw_contact_id=?", new String[] { id+"" }, null);

            while (dataCursor.moveToNext()) {
                String data1 = dataCursor.getString(dataCursor
                        .getColumnIndex("data1"));

                String mime = dataCursor.getString(dataCursor
                        .getColumnIndex("mimetype"));
                if ("vnd.android.cursor.item/phone_v2".equals(mime)) {
                    ce.setTelNumber(data1);
                } else if ("vnd.android.cursor.item/name".equals(mime)) {
                    ce.setContactName(data1);
                }

            }
            dataCursor.close();
            contaList.add(ce);
            ce = null;
        }

        idCursor.close();

        return contaList;
    }

    /**
     * 获取某个通讯录分组里面的联系人信息
     */
    private List<ContactEntity> contactEntitys = new ArrayList<>();
    private List<ContactEntity> getGroupById(Context context,int groupId) {
        String[] RAW_PROJECTION = new String[] { ContactsContract.Data.RAW_CONTACT_ID, };

        String RAW_CONTACTS_WHERE = ContactsContract.CommonDataKinds.GroupMembership.GROUP_ROW_ID
                + "=?"
                + " and "
                + ContactsContract.Data.MIMETYPE
                + "="
                + "'"
                + ContactsContract.CommonDataKinds.GroupMembership.CONTENT_ITEM_TYPE
                + "'";

        // 通过分组的id 查询得到RAW_CONTACT_ID
        Cursor cursor = context.getContentResolver().query(
                ContactsContract.Data.CONTENT_URI, RAW_PROJECTION,
                RAW_CONTACTS_WHERE, new String[] { groupId + "" }, "data1 asc");

        List<ContactEntity> contactList = new ArrayList<ContactEntity>();

        while (cursor.moveToNext()) {
            // RAW_CONTACT_ID
            int col = cursor.getColumnIndex("raw_contact_id");
            int raw_contact_id = cursor.getInt(col);

            // Log.i("getAllContactsByGroupId", "raw_contact_id:" +
            // raw_contact_id);

            ContactEntity ce = new ContactEntity();

            ce.setContactId(raw_contact_id);

            Uri dataUri = Uri.parse("content://com.android.contacts/data");
            Cursor dataCursor = context.getContentResolver().query(dataUri,
                    null, "raw_contact_id=?",
                    new String[] { raw_contact_id + "" }, null);

            while (dataCursor.moveToNext()) {
                String data1 = dataCursor.getString(dataCursor
                        .getColumnIndex("data1"));
                String mime = dataCursor.getString(dataCursor
                        .getColumnIndex("mimetype"));

                if ("vnd.android.cursor.item/phone_v2".equals(mime)) {
                    ce.setTelNumber(data1);
                } else if ("vnd.android.cursor.item/name".equals(mime)) {
                    ce.setContactName(data1);
                }
            }

            dataCursor.close();
            contactList.add(ce);
            ce = null;
        }

        cursor.close();

        return contactList;
    }

    /**
     * 获取所有通讯录里面的分组
     *
     */
    List<GroupEntity> groups = new ArrayList<>();

    private void getAllGroup() {
        groups = getAllGroupInfo(getActivity());
        for (int i = 0; i < groups.size(); i++) {
            LogUtil.show(groups.get(i).toString());

        }
    }

    /**
     * 获取所有的 联系人分组信息
     *
     * @return
     */
    public List<GroupEntity> getAllGroupInfo(Context context) {

        List<GroupEntity> groupList = new ArrayList<GroupEntity>();

        Cursor cursor = null;

        try {
            cursor = context.getContentResolver().query(ContactsContract.Groups.CONTENT_URI,
                    null, null, null, null);

            while (cursor.moveToNext()) {

                GroupEntity ge = new GroupEntity();

                int groupId = cursor.getInt(cursor.getColumnIndex(ContactsContract.Groups._ID)); // 组id
                String groupName = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.Groups.TITLE)); // 组名

                ge.setGroupId(groupId);
                ge.setGroupName(groupName);

                Log.i("MainActivity", "group id:" + groupId + ">>groupName:"
                        + groupName);

                groupList.add(ge);
                ge = null;
            }

            return groupList;

        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }


    private Spinner spinner;
    ListView mListView;
    EditText etSearch;
    ImageView ivClearText;

    private SideBar sideBar;
    private TextView dialog;
    private TextView numTv;

    private List<SortModel> mAllContactsList = new ArrayList<>();
    private ContactsSortAdapter adapter;
    /** 汉字转换成拼音的类 */
    private CharacterParser characterParser;

    /** 根据拼音来排列ListView里面的数据类 */
    private PinyinComparator pinyinComparator;
    private void initView(View v) {
        ivClearText = (ImageView) v.findViewById(R.id.ivClearText);
        etSearch = (EditText) v.findViewById(R.id.et_search);
        sideBar = (SideBar)  v.findViewById(R.id.sidrbar);
        dialog = (TextView)  v.findViewById(R.id.dialog);
        numTv = (TextView)  v.findViewById(R.id.content_tv);
        spinner = (Spinner) v.findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] languages = getResources().getStringArray(R.array.sreach_type);
                Toast.makeText(getActivity(), "你点击的是:"+languages[pos], Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });


        mListView = (ListView) v.findViewById(R.id.lv_contacts);

        /** 给ListView设置adapter **/
        characterParser = CharacterParser.getInstance();
        mAllContactsList = new ArrayList<SortModel>();
        pinyinComparator = new PinyinComparator();
        Collections.sort(mAllContactsList, pinyinComparator);// 根据a-z进行排序源数据
        adapter = new ContactsSortAdapter(getActivity(), mAllContactsList);
        mListView.setAdapter(adapter);
    }

    private void initListener() {

        /**清除输入字符**/
        ivClearText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                etSearch.setText("");
            }
        });
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable e) {

                String content = etSearch.getText().toString();
                if ("".equals(content)) {
                    ivClearText.setVisibility(View.INVISIBLE);
                } else {
                    ivClearText.setVisibility(View.VISIBLE);
                }

                if (content.length() > 0) {
                    num = content.length()+"字";
                    ArrayList<SortModel> fileterList = (ArrayList<SortModel>) search(content);
                    adapter.updateListView(fileterList);
                    //mAdapter.updateData(mContacts);
                } else {
                    num = "0字";
                    adapter.updateListView(mAllContactsList);
                }
                mListView.setSelection(0);
//                EventBus.getDefault().post(new DataEvent(DataEvent.TYPE_NUMTV));
            }

        });

        //设置右侧[A-Z]快速导航栏触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    mListView.setSelection(position);
                }
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
                ContactsSortAdapter.ViewHolder viewHolder = (ContactsSortAdapter.ViewHolder) view.getTag();
                viewHolder.cbChecked.performClick();
                adapter.toggleChecked(position);
            }
        });

    }


    private void loadContacts() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ContentResolver resolver = getActivity().getApplicationContext().getContentResolver();
                    Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, "sort_key" }, null, null, "sort_key COLLATE LOCALIZED ASC");
                    if (phoneCursor == null || phoneCursor.getCount() == 0) {
                        Toast.makeText( getActivity().getApplicationContext(), "未获得读取联系人权限 或 未获得联系人数据", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    int PHONES_NUMBER_INDEX = phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    int PHONES_DISPLAY_NAME_INDEX = phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                    int SORT_KEY_INDEX = phoneCursor.getColumnIndex("sort_key");
                    if (phoneCursor.getCount() > 0) {
                        mAllContactsList = new ArrayList<SortModel>();
                        while (phoneCursor.moveToNext()) {
                            String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
                            if (TextUtils.isEmpty(phoneNumber))
                                continue;
                            String contactName = phoneCursor.getString(PHONES_DISPLAY_NAME_INDEX);
                            String sortKey = phoneCursor.getString(SORT_KEY_INDEX);
                            //System.out.println(sortKey);
                            SortModel sortModel = new SortModel(contactName, phoneNumber, sortKey);
                            //优先使用系统sortkey取,取不到再使用工具取
                            String sortLetters = getSortLetterBySortKey(sortKey);
                            if (sortLetters == null) {
                                sortLetters = getSortLetter(contactName);
                            }

                            sortModel.sortLetters = sortLetters;

                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
                                sortModel.sortToken = parseSortKey(sortKey);
                            else
                                sortModel.sortToken = parseSortKeyLollipop(sortKey);

                            mAllContactsList.add(sortModel);
                        }
                    }
                    phoneCursor.close();
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            Collections.sort(mAllContactsList, pinyinComparator);
                            adapter.updateListView(mAllContactsList);
                        }
                    });
                } catch (Exception e) {
                    Log.e("xbc", e.getLocalizedMessage());
                }
            }
        }).start();
    }



    /**
     * 模糊查询
     * @param str
     * @return
     */
    private List<SortModel> search(String str) {
        List<SortModel> filterList = new ArrayList<SortModel>();// 过滤后的list
        //if (str.matches("^([0-9]|[/+])*$")) {// 正则表达式 匹配号码
        if (str.matches("^([0-9]|[/+]).*")) {// 正则表达式 匹配以数字或者加号开头的字符串(包括了带空格及-分割的号码)
            String simpleStr = str.replaceAll("\\-|\\s", "");
            for (SortModel contact : mAllContactsList) {
                if (contact.number != null && contact.name != null) {
                    if (contact.simpleNumber.contains(simpleStr) || contact.name.contains(str)) {
                        if (!filterList.contains(contact)) {
                            filterList.add(contact);
                        }
                    }
                }
            }
        }else {
            for (SortModel contact : mAllContactsList) {
                if (contact.number != null && contact.name != null) {
                    //姓名全匹配,姓名首字母简拼匹配,姓名全字母匹配
                    boolean isNameContains = contact.name.toLowerCase(Locale.CHINESE)
                            .contains(str.toLowerCase(Locale.CHINESE));

                    boolean isSortKeyContains = contact.sortKey.toLowerCase(Locale.CHINESE).replace(" ", "")
                            .contains(str.toLowerCase(Locale.CHINESE));

                    boolean isSimpleSpellContains = contact.sortToken.simpleSpell.toLowerCase(Locale.CHINESE)
                            .contains(str.toLowerCase(Locale.CHINESE));

                    boolean isWholeSpellContains = contact.sortToken.wholeSpell.toLowerCase(Locale.CHINESE)
                            .contains(str.toLowerCase(Locale.CHINESE));

                    if (isNameContains || isSortKeyContains || isSimpleSpellContains || isWholeSpellContains) {
                        if (!filterList.contains(contact)) {
                            filterList.add(contact);
                        }
                    }
                }
            }
        }
        return filterList;
    }

    /**
     * 取sort_key的首字母
     * @param sortKey
     * @return
     */
    private String getSortLetterBySortKey(String sortKey) {
        if (sortKey == null || "".equals(sortKey.trim())) {
            return null;
        }
        String letter = "#";
        //汉字转换成拼音
        String sortString = sortKey.trim().substring(0, 1).toUpperCase(Locale.CHINESE);
        // 正则表达式，判断首字母是否是英文字母
        if (sortString.matches("[A-Z]")) {
            letter = sortString.toUpperCase(Locale.CHINESE);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// 5.0以上需要判断汉字
            if (sortString.matches("^[\u4E00-\u9FFF]+$"))// 正则表达式，判断是否为汉字
                letter = getSortLetter(sortString.toUpperCase(Locale.CHINESE));
        }
        return letter;
    }
    /**
     * 名字转拼音,取首字母
     * @param name
     * @return
     */
    private String getSortLetter(String name) {
        String letter = "#";
        if (name == null) {
            return letter;
        }
        //汉字转换成拼音
        String pinyin = characterParser.getSelling(name);
        String sortString = pinyin.substring(0, 1).toUpperCase(Locale.CHINESE);

        // 正则表达式，判断首字母是否是英文字母
        if (sortString.matches("[A-Z]")) {
            letter = sortString.toUpperCase(Locale.CHINESE);
        }
        return letter;
    }

    //String chReg="[^\\u4E00-\\u9FA5]";//除中文外的字符匹配
    /**
     * 解析sort_key,封装简拼,全拼
     * @param sortKey
     * @return
     */
    public SortToken parseSortKey(String sortKey) {
        SortToken token = new SortToken();
        if (sortKey != null && sortKey.length() > 0) {
            //其中包含的中文字符
            String[] enStrs = sortKey.replace(" ", "").split(chReg);
            for (int i = 0, length = enStrs.length; i < length; i++) {
                if (enStrs[i].length() > 0) {
                    //拼接简拼
                    token.simpleSpell += enStrs[i].charAt(0);
                    token.wholeSpell += enStrs[i];
                }
            }
        }
        return token;
    }
    /** 中文字符串匹配 */
    String chReg = "[\\u4E00-\\u9FA5]+";
    /**
     * 解析sort_key,封装简拼,全拼。
     * Android 5.0 以上使用
     * @param sortKey
     * @return
     */
    public SortToken parseSortKeyLollipop(String sortKey) {
        SortToken token = new SortToken();
        if (sortKey != null && sortKey.length() > 0) {
            boolean isChinese = sortKey.matches(chReg);
            // 分割条件：中文不分割，英文以大写和空格分割
            String regularExpression = isChinese ? "" : "(?=[A-Z])|\\s";

            String[] enStrs = sortKey.split(regularExpression);

            for (int i = 0, length = enStrs.length; i < length; i++)
                if (enStrs[i].length() > 0) {
                    //拼接简拼
                    token.simpleSpell += getSortLetter(String.valueOf(enStrs[i].charAt(0)));
                    token.wholeSpell += characterParser.getSelling(enStrs[i]);
                }
        }
        return token;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(getActivity());
    }
}
