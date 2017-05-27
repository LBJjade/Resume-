## 主要是针对环信：长按录音按钮，进行录音，并弹出dialog显示录音动画，松开按钮结束录音。手机会有各种的权限提示dialog。录音按钮是响应的onTouch事件，所以就造成我的按钮在onkeydown时去初始化录音并显示dialog动画时，弹出，我的界面控件失去焦点，当我去选择权限时，控件无法捕获onkeyup或者onkeymove事件，不能及时消除dialog动画效果。

解决方式：

         1、对录音控件进行设置监听 View.OnTouchListener

         2、如果没有权限的Dialog弹窗，当我们点击录音他会执行 MotionEvent.ACTION_DOWN，这时候就弹出了“权限管理”的系统弹窗/第三方的权限管理弹窗

         3、当你点击 权限管理 弹窗的“允许”按钮之后，手指就会抬起，离开录音控件，然后Debug调试它并没有执行 MotionEvent.ACTION_UP，而是执行  了 MotionEvent.ACTION_MOVE、MotionEvent.ACTION_CANCEL 两个事件。

         4、所以最终我之前在 MotionEvent.ACTION_CANCEL 事件中 关闭录音、取消动画，由此解决该问题！

         注：具体还的视情况而定：在 onTouch 事件中的 defalut 注释一个属性也可！



##  http://m.blog.csdn.net/article/details?id=50460758