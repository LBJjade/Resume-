package manu.mymessagedemo.message;

/**
 * Created by weedys on 16/7/26.
 */
public class AccountEvent {
    public final static int TYPE_EXIT_ACCOUNT=0X12;//退出应用
    public final static int TYPE_EXTRUSION_RELOGIN=0X14;//被挤出，重新登录
    public final static int TYPE_LOGIN_MULT_ACCOUNT=0X33;//账号被挤出
    public final static int TYPE_USER_EXIT_APP=0X22;// 退出app
//    public final static int TYPE_SEND_JP=0X30;// 极光推送

    public int eventId = 0;
    public String value ="";
    public AccountEvent(int eId, String val){
        this.eventId = eId;
        this.value = val;
    }
    public AccountEvent(int eId){
        this.eventId = eId;
        this.value = "1";
    }
}
