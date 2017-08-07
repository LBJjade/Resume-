package manu.mymessagedemo.bean;

/**
 * Created by min on 2017/8/7.
 * 通讯录的分组
 */

public class GroupEntity {

    private int groupId;
    private String groupName;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "GroupEntity{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
