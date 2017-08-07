package manu.mymessagedemo.bean;

/**
 * Created by min on 2017/8/7.
 *
 * 联系人实体
 */

public class ContactEntity {
    private int contactId;
    private String telNumber;
    private String  contactName;

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "contactId=" + contactId +
                ", telNumber='" + telNumber + '\'' +
                ", contactName='" + contactName + '\'' +
                '}';
    }
}
