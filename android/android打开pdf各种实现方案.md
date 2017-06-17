## 实现方案参考
http://www.jianshu.com/p/1bf49af6584d
http://www.pffair.com/blog/2016/03/12/android-pdf/

## 调用第三方库打开
http://blog.csdn.net/u010046908/article/details/53008310

## 用okhttp下载并打开
* http://www.ctolib.com/AndroidPdfViewDowload.html
* 上面的链接对应的源码
https://github.com/qiushi123/AndroidPdfViewDowload

将pdf的Intent抛出
优势：也很简单，目前大部分Android设备貌似都有pdf阅读器

File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/"+ filename);
Intent target = new Intent(Intent.ACTION_VIEW);
target.setDataAndType(Uri.fromFile(file),"application/pdf");
target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

Intent intent = Intent.createChooser(target, "Open File");
try {
    startActivity(intent);
} catch (ActivityNotFoundException e) {
    // Instruct the user to install a PDF reader here, or something
}


## 使用谷歌,微软
两个在线预览office文档的地址：(浏览器都需要chrome的内核)
1 google：https://docs.google.com/viewer?url=（输入你的文档在服务器中的地址）；
2 微软：https://view.officeapps.live.com/op/view.aspx?src=(输入你的文档在服务器中的地址)；//已经不可用了

我试了一下都可以显示，但是谷歌的在国内需要翻墙，还有就是本地的和局域网的都不行，第三方打开的话可以用WPS，有暴露出来activity，但是项目要求不能用第三方，内置方式打开本地和局域网的不知道大家有没有什么思路，打开前先上传到服务器？

