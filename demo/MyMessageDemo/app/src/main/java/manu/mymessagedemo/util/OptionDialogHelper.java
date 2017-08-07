package manu.mymessagedemo.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import org.greenrobot.eventbus.EventBus;

import manu.mymessagedemo.R;
import manu.mymessagedemo.views.CustomDialog;


/**
 * Created by weedys on 16/7/26.
 */
public class OptionDialogHelper {
//    /**
//     * 这是兼容的 AlertDialog
//     */
//    public static void showDialog(Context c, String title, String msg, String okStr, String cancelStr, DialogInterface.OnClickListener okl, DialogInterface.OnClickListener cancell) {
//  /*
//  这里使用了 android.support.v7.app.AlertDialog.Builder
//  可以直接在头部写 import android.support.v7.app.AlertDialog
//  那么下面就可以写成 AlertDialog.Builder
//  */
//        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
//        builder.setTitle(title);
//        builder.setMessage(msg);
//        builder.setNegativeButton(cancelStr, cancell);
//        builder.setPositiveButton(okStr, okl);
//        builder.show();
//    }

//    public static void showDialog2(Context c, String title, String msg, String okStr, String cancelStr, DialogInterface.OnClickListener okl, DialogInterface.OnClickListener cancell) {
//  /*
//  这里使用了 android.support.v7.app.AlertDialog.Builder
//  可以直接在头部写 import android.support.v7.app.AlertDialog
//  那么下面就可以写成 AlertDialog.Builder
//  */
//        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
////        AlertDialog.Builder builder = new AlertDialog.Builder(c);
//        builder.setTitle(title);
//        builder.setMessage(msg);
//        builder.setNegativeButton(cancelStr, cancell);
//        builder.setPositiveButton(okStr, okl);
//        builder.setCancelable(false);
//        builder.show();
//    }

//    public static void showDialog(Context c, String msg, String okStr, String cancelStr, DialogInterface.OnClickListener okl, DialogInterface.OnClickListener cancell) {
//  /*
//  这里使用了 android.support.v7.app.AlertDialog.Builder
//  可以直接在头部写 import android.support.v7.app.AlertDialog
//  那么下面就可以写成 AlertDialog.Builder
//  */
//        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
////        AlertDialog.Builder builder = new AlertDialog.Builder(c);
//        builder.setTitle(c.getResources().getString(R.string.warm_prompt));
//        builder.setMessage(msg);
//        builder.setNegativeButton(cancelStr, cancell);
//        builder.setPositiveButton(okStr, okl);
//        builder.setCancelable(false);
//        builder.show();
//    }

//    public static void showDialogNoCancel(Context c, String msg, String okStr, DialogInterface.OnClickListener okl) {
//  /*
//  这里使用了 android.support.v7.app.AlertDialog.Builder
//  可以直接在头部写 import android.support.v7.app.AlertDialog
//  那么下面就可以写成 AlertDialog.Builder
//  */
//        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
////        AlertDialog.Builder builder = new AlertDialog.Builder(c);
//        builder.setTitle(c.getResources().getString(R.string.warm_prompt));
//        builder.setMessage(msg);
//        builder.setPositiveButton(okStr, okl);
//        builder.setCancelable(false);
//        builder.show();
//    }

    //    public static void showOption(Context c){
//        showDialog(c);
//
//    }
//    public static Dialog showBottonDialog(Context c, String[] menus, final BottomMenuItemListener l) {
//        if (menus == null || menus.length == 0) {
//            return null;
//        }
//        int width = GlobalApp.screenWidth;
//        final BottomDialog dialog = new BottomDialog(c);
//        LinearLayout root = new LinearLayout(c);
//        root.setLayoutParams(new LinearLayout.LayoutParams(width * 5 / 8, ViewGroup.LayoutParams.WRAP_CONTENT));
//        root.setBackgroundColor(c.getResources().getColor(R.color.color_white));
//        root.setOrientation(LinearLayout.VERTICAL);
//
//        for (int i = 0; i < menus.length; i++) {
//            TextView vs = (TextView) LayoutInflater.from(c).inflate(R.layout.view_menu_textview, null);
//            vs.setText(menus[i]);
//            final int pos = i;
//            root.addView(vs);
////            if(i<menus.length-1){
//            View line = new View(c);
//            line.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1));
//            line.setBackgroundColor(c.getResources().getColor(R.color.color_d2ccc5));
//            root.addView(line);
////            }
//            vs.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (l != null) {
//                        l.onItemClicked(view, pos);
//                    }
//                }
//            });
//        }
//
//        View line = new View(c);
//        line.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px(c, 5)));
//        line.setBackgroundColor(c.getResources().getColor(R.color.colorPrimary));
//        root.addView(line);
//
//        TextView cancelbt = (TextView) LayoutInflater.from(c).inflate(R.layout.view_menu_textview, null);
//        cancelbt.setText("取消");
//        cancelbt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//        root.addView(cancelbt);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.setContentView(root);
//        return dialog;
//    }

//    public static Dialog showBottomDialog(Context c, String[] menus, String title, final BottomMenuItemListener l) {
//        final BottomDialog dialog = new BottomDialog(c);
//        int width = GlobalApp.screenWidth;
//        View vs = LayoutInflater.from(c).inflate(R.layout.view_bottom_dialog, null);
//        vs.setLayoutParams(new LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT));
//        TextView textView = (TextView) vs.findViewById(R.id.title_tv);
//        View view = vs.findViewById(R.id.view);
//        if (TextUtils.isEmpty(title)) {
//            textView.setVisibility(View.GONE);
//            view.setVisibility(View.GONE);
//        } else {
//            textView.setText(title);
//            view.setVisibility(View.VISIBLE);
//        }
//        ListView listView = (ListView) vs.findViewById(R.id.list_view);
//        ArrayAdapter<String> menuAdapter = new ArrayAdapter<>(c, R.layout.view_menu_textview, R.id.menu_name, menus);
//        listView.setAdapter(menuAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (l != null) {
//                    l.onItemClicked(view, position);
//                }
//            }
//        });
//
//        TextView cancel = (TextView) vs.findViewById(R.id.cancel_tv);
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setContentView(vs);
//        return dialog;
//    }


//    /**
//     * 通用评论框
//     *
//     * @param hint     输入框提示语
//     * @param content  输入框缓存内容
//     * @param num      输入框限制字数
//     * @param contentL 对话框空白处监听
//     * @param l        对话框发送监听
//     */
//    public static Dialog showBottomEditDialog(final Context c, String hint, String content, final int num, final DismissListener contentL, final BottomSendListener l) {
//        final Dialog dialog = new Dialog(c, R.style.customDialog);
//        View vs = LayoutInflater.from(c).inflate(R.layout.layout_my_edit_bottom_dialog, null);
//        //获得dialog的window窗口
//        Window window = dialog.getWindow();
//        //设置dialog在屏幕底部
//        window.setGravity(Gravity.BOTTOM);
//        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
//        window.setWindowAnimations(R.style.MyDialogAnimation);
//        window.getDecorView().setPadding(0, 0, 0, 0);
//        //获得window窗口的属性
//        android.view.WindowManager.LayoutParams lp = window.getAttributes();
//        //设置窗口宽度为充满全屏
//        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//        //设置窗口高度为包裹内容
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        //将设置好的属性set回去
//        window.setAttributes(lp);
//        //将自定义布局加载到dialog上
//        dialog.setContentView(vs);
//        final TextView contentNumTv = (TextView) vs.findViewById(R.id.edit_tv_num);
//        contentNumTv.setText("0/" + num);
//        final EditText contentEt = (EditText) vs.findViewById(R.id.write_et);
//        final TextView sendTv = (TextView) vs.findViewById(R.id.send_tv);
//        //发送按钮监听
//        sendTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (l != null) {
//                    String str = "";
//                    if (null != contentEt && null != contentEt.getText()) {
//                        str = contentEt.getText().toString();
//                        l.onClick(v, str);
//                    } else {
//                        l.onClick(v, "");
//                    }
//                }
//            }
//        });
////        sendTv.setClickable(false);
//        contentEt.setHint(hint);
//        //自动弹出软键盘
//        contentEt.setFocusable(true);
//        contentEt.setFocusableInTouchMode(true);
//        contentEt.requestFocus();
//        //适当的延迟弹出软键盘如300毫秒（保证界面的数据加载完成）
//        final Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            public void run() {
//                InputMethodManager inputManager =
//                        (InputMethodManager) contentEt.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                inputManager.showSoftInput(contentEt, 0);
//            }
//        }, 300);
//
//
//        if (!TextUtils.isEmpty(content)) {
//            contentEt.setText(content);
//            contentEt.setSelection(content.length());//将光标移至文字末尾
//            //解决用户取消发送，重新进入评论框后，数字栏显示0的问题
//            contentNumTv.setText(content.length() + "/" + num);
//        }
////        else {
////            sendTv.setBackgroundResource(R.drawable.shape_btn_gray);
////            sendTv.setClickable(false);
////        }
//
//        String str = CommonsUtils.filterString(content);
//        if (!TextUtils.isEmpty(str)) {
//            sendTv.setBackgroundResource(R.drawable.shape_btn_primary);
//            sendTv.setClickable(true);
//        } else {
//            sendTv.setBackgroundResource(R.drawable.shape_btn_gray);
//            sendTv.setClickable(false);
//        }
//
//
//        contentEt.addTextChangedListener(new TextWatcher() {
//            private CharSequence temp;
//            private int editStart;
//            private int editEnd;
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
//                temp = s;
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                String msg = contentEt.getText().toString();
//
//                if (!TextUtils.isEmpty(msg)) {
//                    if (msg.equals("")) {
//                        return;
//                    }
//                    if (msg.length() <= num) {
//                        int count = 0 + msg.length();
//                        contentNumTv.setText(count + "/" + num);
//                    } else {
//                        contentNumTv.setText(num + "/" + num);
//                        return;
//                    }
//                } else {
//                    contentNumTv.setText(0 + "/" + num);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                editStart = contentEt.getSelectionStart();
//                editEnd = contentEt.getSelectionEnd();
//                if (null != temp && (temp.length()) > num) {
//                    ToastUtil.show("最多只能输入" + num + "个字喔~");
//                    s.delete(editStart - 1, editEnd);
//                    int tempSelection = editEnd;
//                    contentEt.setText(s);
//                    contentEt.setSelection(tempSelection);
//                }
//
////                String tmpStr = s.toString().replace(" ", "");
//                String tmpStr = CommonsUtils.filterString(s.toString());
//
//                if (TextUtils.isEmpty(s) || TextUtils.isEmpty(tmpStr)) {
//                    sendTv.setBackgroundResource(R.drawable.shape_btn_gray);
//                    sendTv.setClickable(false);
//                } else {
//                    sendTv.setBackgroundResource(R.drawable.shape_btn_primary);
//                    sendTv.setClickable(true);
//                }
//            }
//        });
//
//
//        //对话框点击空白处监听
//        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialog) {
//                if (contentL != null) {
//                    contentL.onClick(contentEt.getText().toString());
//                }
//                closeKeyboard((Activity) c);
//            }
//        });
////        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
////
////            @Override
////            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
////                if(keyCode== KeyEvent.KEYCODE_BACK){
////                    if(null != dialog){
////                        dialog.dismiss();
////                    }
////                }
////                return false;
////            }
////        });
//        dialog.show();
//        return dialog;
//    }

//    public static void closeKeyboard(Activity activity) {
//        View view = activity.getWindow().peekDecorView();
//        if (view != null) {
//            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
//        }
//    }

//    /**
//     * 通用评论框
//     *
//     * @param content  输入框缓存内容
//     * @param num      输入框限制字数
//     * @param contentL 对话框空白处监听
//     * @param l        对话框发送监听
//     */
//    public static Dialog showBottomEditDialog(Context c, String content, final int num, final DismissListener contentL, final BottomSendListener l) {
//        final Dialog dialog = new Dialog(c, R.style.customDialog);
//        View vs = LayoutInflater.from(c).inflate(R.layout.layout_my_edit_bottom_dialog, null);
//        //获得dialog的window窗口
//        Window window = dialog.getWindow();
//        //设置dialog在屏幕底部
//        window.setGravity(Gravity.BOTTOM);
//        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
//        window.setWindowAnimations(R.style.MyDialogAnimation);
//        window.getDecorView().setPadding(0, 0, 0, 0);
//        //获得window窗口的属性
//        android.view.WindowManager.LayoutParams lp = window.getAttributes();
//        //设置窗口宽度为充满全屏
//        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//        //设置窗口高度为包裹内容
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        //将设置好的属性set回去
//        window.setAttributes(lp);
//        //将自定义布局加载到dialog上
//        dialog.setContentView(vs);
//        final TextView contentNumTv = (TextView) vs.findViewById(R.id.edit_tv_num);
//        contentNumTv.setText("0/" + num);
//        final EditText contentEt = (EditText) vs.findViewById(R.id.write_et);
//        final TextView sendTv = (TextView) vs.findViewById(R.id.send_tv);
//        //发送按钮监听
//        sendTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (l != null) {
//                    l.onClick(v, contentEt.getText().toString());
//                }
//            }
//        });
////        sendTv.setClickable(false);
//        //自动弹出软键盘
//        contentEt.setFocusable(true);
//        contentEt.setFocusableInTouchMode(true);
//        contentEt.requestFocus();
//        //适当的延迟弹出软键盘如300毫秒（保证界面的数据加载完成）
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            public void run() {
//                InputMethodManager inputManager =
//                        (InputMethodManager) contentEt.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                inputManager.showSoftInput(contentEt, 0);
//            }
//        }, 300);
//
//        if (!TextUtils.isEmpty(content)) {
//            contentEt.setText(content);
//            contentEt.setSelection(content.length());//将光标移至文字末尾
//            //解决用户取消发送，重新进入评论框后，数字栏显示0的问题
//            contentNumTv.setText(content.length() + "/" + num);
//        }
////        else {
////            sendTv.setBackgroundResource(R.drawable.shape_btn_gray);
////            sendTv.setClickable(false);
////        }
//
//        String str = CommonsUtils.filterString(content);
//        if (!TextUtils.isEmpty(str)) {
//            sendTv.setBackgroundResource(R.drawable.shape_btn_primary);
//            sendTv.setClickable(true);
//        } else {
//            sendTv.setBackgroundResource(R.drawable.shape_btn_gray);
//            sendTv.setClickable(false);
//        }
//
//        contentEt.addTextChangedListener(new TextWatcher() {
//            private CharSequence temp;
//            private int editStart;
//            private int editEnd;
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
//                temp = s;
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                String msg = contentEt.getText().toString();
//
//                if (!TextUtils.isEmpty(msg)) {
//                    if (msg.equals("")) {
//                        return;
//                    }
//                    if (msg.length() <= num) {
//                        int count = 0 + msg.length();
//                        contentNumTv.setText(count + "/" + num);
//                    } else {
//                        contentNumTv.setText(num + "/" + num);
//                        return;
//                    }
//                } else {
//                    contentNumTv.setText(0 + "/" + num);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                editStart = contentEt.getSelectionStart();
//                editEnd = contentEt.getSelectionEnd();
//                if ((temp.length()) > num) {
//                    ToastUtil.show("最多只能输入" + num + "个字喔~");
//                    s.delete(editStart - 1, editEnd);
//                    int tempSelection = editEnd;
//                    contentEt.setText(s);
//                    contentEt.setSelection(tempSelection);
//                }
//
//                String tmpStr = CommonsUtils.filterString(s.toString());
//                if (TextUtils.isEmpty(s) || TextUtils.isEmpty(tmpStr)) {
//                    sendTv.setBackgroundResource(R.drawable.shape_btn_gray);
//                    sendTv.setClickable(false);
//                } else {
//                    sendTv.setBackgroundResource(R.drawable.shape_btn_primary);
//                    sendTv.setClickable(true);
//                }
//            }
//        });
//
//
//        //对话框点击空白处监听
//        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialog) {
//                if (contentL != null) {
//                    contentL.onClick(contentEt.getText().toString());
//                }
//            }
//        });
//        dialog.show();
//        return dialog;
//
//    }

//    public static Dialog showCustomDialog(Context c, View vs) {
//        Dialog d = showCustomDialog(c, vs, true);
//        return d;
//    }

//    public static Dialog showCustomDialog(Context c, View vs, boolean cancel) {
//        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
//        builder.setView(vs);
//        builder.setCancelable(cancel);
//        Dialog d = builder.create();
//        d.show();
//        return d;
//    }

//    public static Dialog showCustomDialog(Context c, View vs, String positive, String negative, DialogInterface.OnClickListener okL, DialogInterface.OnClickListener cancelL) {
//        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
//        builder.setView(vs);
//        builder.setNegativeButton(negative, cancelL);
//        builder.setPositiveButton(positive, okL);
//        Dialog d = builder.create();
////        Field field = null;
////        try {
////            field = d.getClass().getSuperclass().getDeclaredField("mShowing");
////            field.setAccessible(false);
////            field.set(d, false);//设定为true,则可以关闭对话框
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        d.show();
//        return d;
//    }

//    public static Dialog showCustomDialog(Context c, View vs, String positive, String negative, DialogInterface.OnClickListener okL, DialogInterface.OnClickListener cancelL, boolean cancelable) {
//        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
//        builder.setView(vs);
//        builder.setNegativeButton(negative, cancelL);
//        builder.setPositiveButton(positive, okL);
//        builder.setCancelable(cancelable);
//        Dialog d = builder.create();
//        d.show();
//        return d;
//    }

//    public static Dialog showMenuDialog(Context c, String[] content, DialogInterface.OnClickListener okL) {
//        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
//        builder.setItems(content, okL);
////        builder.setSingleChoiceItems(content, 0, okL);
//        Dialog d = builder.create();
////        Field field = null;
////        try {
////            field = d.getClass().getSuperclass().getDeclaredField("mShowing");
////            field.setAccessible(false);
////            field.set(d, false);//设定为true,则可以关闭对话框
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        d.show();
//        return d;
//    }

//    public static Dialog showSimpleDialg(Context c, View content, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener) {
//        CustomDialog.Builder builder = new CustomDialog.Builder(c);
//        builder.setNegativeButton("取消", cancelListener);
//        builder.setPositiveButton("确定", okListener);
//        builder.setTitle("安全验证");
//        builder.setContentView(content);
//        Dialog dialog = builder.create();
//        dialog.show();
//        return dialog;
//    }

    public static Dialog showSimpleDialg(Context c, View content, String title, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener) {
        CustomDialog.Builder builder = new CustomDialog.Builder(c);
        builder.setNegativeButton("取消", cancelListener);
        builder.setPositiveButton("确定", okListener);
        builder.setTitle(title);
        builder.setContentView(content);
        Dialog dialog = builder.create();
        dialog.show();
        return dialog;
    }

    public static Dialog showSimpleDialg(Context c, String title, View content, String okStr, String cancelStr, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener) {
        return showSimpleDialg(c, title, content, okStr, cancelStr, okListener, cancelListener, true);
    }

    public static Dialog showSimpleDialg(Context c, String title, View content, String okStr, String cancelStr, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener, boolean cancel) {
        CustomDialog.Builder builder = new CustomDialog.Builder(c);
        builder.setNegativeButton(cancelStr, cancelListener);
        builder.setPositiveButton(okStr, okListener);
        builder.setTitle(title);
        builder.setCancelable(cancel);
        builder.setContentView(content);
        Dialog dialog = builder.create();
        dialog.show();
        return dialog;
    }

//    public static Dialog showRightDialg(Context c, View content) {
//        RightDialog dialog = new RightDialog(c);
//        dialog.addContentView(content);
//        dialog.show();
//        return dialog;
//    }

    public static Dialog showSimpleDialg(Context c, String title, String content, String okStr, String cancelStr, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener, boolean cancel) {
        View vs = LayoutInflater.from(c).inflate(R.layout.tea_view_text, null);
        TextView contentTv = (TextView) vs.findViewById(R.id.tv_title);
        contentTv.setText(content);
        CustomDialog.Builder builder = new CustomDialog.Builder(c);
        builder.setNegativeButton(cancelStr, cancelListener);
        builder.setPositiveButton(okStr, okListener);
        builder.setTitle(title);
        builder.setCancelable(cancel);
        builder.setContentView(vs);
        Dialog dialog = builder.create();
        dialog.show();
        return dialog;
    }

//    public static Dialog showSimpleDialg(Context c, String content, String okStr, String cancelStr, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener, boolean cancel) {
//        View vs = LayoutInflater.from(c).inflate(R.layout.tea_view_text, null);
//        TextView contentTv = (TextView) vs.findViewById(R.id.tv_title);
//        contentTv.setText(content);
//        CustomDialog.Builder builder = new CustomDialog.Builder(c);
//        builder.setNegativeButton(cancelStr, cancelListener);
//        builder.setPositiveButton(okStr, okListener);
//        builder.setTitle(c.getResources().getString(R.string.warm_prompt));
//        builder.setCancelable(cancel);
//        builder.setContentView(vs);
//        Dialog dialog = builder.create();
//        dialog.show();
//        return dialog;
//    }

//    /**
//     * 强制对话框,不让用户进入界面
//     *
//     * @param c
//     * @param msg
//     * @param okStr
//     * @param cancelStr
//     * @param okl
//     * @param cancell
//     */
//    public static void showConstraintDialog(Context c, String msg, String okStr, String cancelStr, DialogInterface.OnClickListener okl, DialogInterface.OnClickListener cancell) {
//  /*
//  这里使用了 android.support.v7.app.AlertDialog.Builder
//  可以直接在头部写 import android.support.v7.app.AlertDialog
//  那么下面就可以写成 AlertDialog.Builder
//  */
//        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
////        AlertDialog.Builder builder = new AlertDialog.Builder(c);
//        builder.setTitle(c.getResources().getString(R.string.warm_prompt));
//        builder.setMessage(msg);
//        builder.setNegativeButton(cancelStr, null);
//        builder.setPositiveButton(okStr, null);
//        builder.setCancelable(false);
//        builder.show();
//        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
//            @Override
//            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_SEARCH) {
//                    return true;
//                } else {
//                    return false; //默认返回 false
//                }
//            }
//        });
//        builder.show();
//    }

//    /**
//     * flag==2是强制升级
//     *
//     * @param c
//     * @param flag
//     */
//    public static void showUpdateDialog(final Context c, int flag) {
//        MobclickAgent.onEvent(c, "m_home_update");
//        View vs = LayoutInflater.from(c).inflate(R.layout.view_update, null);
//        TextView titleTv = (TextView) vs.findViewById(R.id.tv_update_title);
//        String newVer = PrefManager.getPrefString(GlobalApp.PRE_UPDATE_VERSION_NEW, "");
//        titleTv.setText("发现新版本" + newVer);
//        TextView msgTv = (TextView) vs.findViewById(R.id.tv_update_msg);
//        String msg = PrefManager.getPrefString(GlobalApp.PRE_UPDATE_VERSION_NEW_MSG, "");
//        msgTv.setText(msg);
//        if (flag == 2) {
//            OptionDialogHelper.showSimpleDialg(c, null, vs, "立即升级", null, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    String apk = PrefManager.getPrefString(GlobalApp.PRE_UPDATE_VERSION_NEW_APK, "");
//                    if (!TextUtils.isEmpty(apk)) {
//                        AppUtils.download(c, apk);
//                    }
//                    MobclickAgent.onEvent(c, "m_update_yes");
//                }
//            }, null, false);
//        } else {
//            OptionDialogHelper.showSimpleDialg(c, null, vs, "立即升级", "稍候再说", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    String apk = PrefManager.getPrefString(GlobalApp.PRE_UPDATE_VERSION_NEW_APK, "");
//                    if (!TextUtils.isEmpty(apk)) {
//                        AppUtils.download(c, apk);
//                    }
//                    MobclickAgent.onEvent(c, "m_update_yes");
//                    dialogInterface.dismiss();
//                }
//            }, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    dialogInterface.dismiss();
//                    MobclickAgent.onEvent(c, "m_update_no");
//                }
//            });
//        }
//    }

    /**
     * 账号被挤出
     *
     * @param c
     */
//    public static void showExtrusionDialog(final Context c) {
////        OptionDialogHelper.showDialog2(c, "账户提示", "您的账户在其他设备上登录。", "退出应用", "重新登录", new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialogInterface, int i) {
////                EventBus.getDefault().post(new AccountEvent(AccountEvent.TYPE_EXIT_ACCOUNT, "11"));
//////                            SwitchCenterActivity.closeSwitchCenterActivity(MainActivity.this);
////                ((Activity)c).finish();
////            }
////        }, new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialogInterface, int i) {
////                EventBus.getDefault().post(new AccountEvent(AccountEvent.TYPE_EXTRUSION_RELOGIN));
////                LoginActivity.startLoginActivity(c);
////                ((Activity)c).finish();
////            }
////        });
//
//        showSimpleDialg(c, c.getResources().getString(R.string.warm_prompt), c.getResources().getString(R.string.extrusion_warm), c.getResources().getString(R.string.exit_app), c.getResources().getString(R.string.reload_app), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                EventBus.getDefault().post(new AccountEvent(AccountEvent.TYPE_EXIT_ACCOUNT, "11"));
//                ((Activity)c).finish();
//            }
//        }, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                EventBus.getDefault().post(new AccountEvent(AccountEvent.TYPE_EXTRUSION_RELOGIN));
//                LoginActivity.startLoginActivity(c);
//                ((Activity)c).finish();
//            }
//        },false);
//    }
    /**
     * 账号被挤出
     *
     * @param c
//     */
    public static void showExitDialog(final Context c) {
//        String title = c.getResources().getString(R.string.exit_warm);
//        OptionDialogHelper.showDialog(c, title, "退出", "取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                EventBus.getDefault().post(new AccountEvent(AccountEvent.TYPE_USER_EXIT_APP));
//                ((Activity)c).finish();
//            }
//        }, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });

        showSimpleDialg(c, c.getResources().getString(R.string.warm_prompt), c.getResources().getString(R.string.exit_warm), c.getResources().getString(R.string.exit_app), c.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
//                EventBus.getDefault().post(new AccountEvent(AccountEvent.TYPE_USER_EXIT_APP));
                ((Activity)c).finish();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        },false);
    }

//    /**
//     * 带输入框对话框
//     *
//     * @param context
//     * @param title      对话框标题
//     * @param hint       输入框提示语
//     * @param contentStr 输入框内容
//     * @param l          输入框内容回调
//     */
//    public static void showEditDialog(Context context, String title, String hint, String contentStr, final EditContentListener l) {
//        View content = LayoutInflater.from(context).inflate(R.layout.tea_view_checkpwd_dialog, null);
//        final EditText unameEt = (EditText) content.findViewById(R.id.edit_text);
//        unameEt.setHint(hint);
//        if (!TextUtils.isEmpty(contentStr)) {
//            unameEt.setText(contentStr);
//        }
//        unameEt.setSelection(TextUtils.isEmpty(contentStr) == true ? 0 : contentStr.length());
//        OptionDialogHelper.showSimpleDialg(context, content, title, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                if (l != null) {
//                    l.onClick(dialogInterface, unameEt.getText().toString());
//                }
//            }
//        }, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });
//    }


//    public static void showLoginDialog(final Context c, String operation) {
//        OptionDialogHelper.showSimpleDialg(c, "登录后才能" + operation + "喔，是否登录呢？", "登录", "取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
////                LoginActivity.startLoginActivity(c);
//            }
//        }, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        }, true);
//    }

    public static Dialog showProgressDialog(Context c, String msg) {
        ProgressDialog dialog = new ProgressDialog(c);
        dialog.setMessage(msg);
        dialog.show();
        return dialog;
    }


//    public interface BottomMenuItemListener {
//        public void onItemClicked(View v, int pos);
//    }


//    public interface BottomSendListener {
//        public void onClick(View v, String content);
//    }

//    public interface TaskBottomSendListener {
//        public void onClick(View v, String content, Boolean flag);
//    }

//    public interface DismissListener {
//        public void onClick(String content);
//    }

//    public interface LeftBottomSendListener {
//        public void onClick(View v, String content);
//    }
//
//    public interface EditContentListener {
//        public void onClick(DialogInterface dialogInterface, String content);
//    }

    public static void showDialog(Context c, String msg, String okStr, String cancelStr, DialogInterface.OnClickListener okl, DialogInterface.OnClickListener cancell) {
  /*
  这里使用了 android.support.v7.app.AlertDialog.Builder
  可以直接在头部写 import android.support.v7.app.AlertDialog
  那么下面就可以写成 AlertDialog.Builder
  */
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
//        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle(c.getResources().getString(R.string.warm_prompt));
        builder.setMessage(msg);
        builder.setNegativeButton(cancelStr, cancell);
        builder.setPositiveButton(okStr, okl);
        builder.setCancelable(false);
        builder.show();
    }
}
