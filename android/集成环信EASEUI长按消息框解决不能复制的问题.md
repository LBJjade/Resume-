 @Override
    public void onMessageBubbleLongClick(EMMessage message) {
//        ToastUtil.shortShow("消息长按");//去掉这个没意义的弹框
//        ClipboardManager cm =(ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE);
//        cm.setText(message.getBody().toString());
////        cm.setTextIsSelectable(true);
//        ToastUtil.shortShow("已复制到剪切板，快去粘贴吧~");
//        return false;
        if(message.getType() == EMMessage.Type.TXT){
            ClipboardManager cm =(ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            String messageStr = message.getBody().toString();
            cm.setText(messageStr.substring(5,messageStr.length()-1));
            ToastUtil.shortShow("文字已复制到剪切板，快去粘贴吧~");
        }

    }