package kakin.demo.mybatis.dto;

import java.util.Objects;

public class User {

    /** 用户ID */
    private Long userId;

    /** 用户姓名 */
    private String userName;

    /** 用户地址 */
    private String userAddress;

    /** 用户性别 */
    private String userSex;

    /** 用户爱好编号 */
    private String userHobbyId;

    public User() {
    }

    public User(Long userId, String userName, String userAddress, String userSex, String userHobbyId) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userSex = userSex;
        this.userHobbyId = userHobbyId;
    }

    /** 得到用户ID */
    public Long getUserId() {
        return userId;
    }

    /** 设置用户ID */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 得到用户姓名 */
    public String getUserName() {
        return userName;
    }

    /** 设置用户姓名 */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 得到用户地址 */
    public String getUserAddress() {
        return userAddress;
    }

    /** 设置用户地址 */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /** 得到用户性别 */
    public String getUserSex() {
        return userSex;
    }

    /** 设置用户性别 */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /** 得到用户爱好编号 */
    public String getUserHobbyId() {
        return userHobbyId;
    }

    /** 设置用户爱好编号 */
    public void setUserHobbyId(String userHobbyId) {
        this.userHobbyId = userHobbyId;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + ", userSex="
                + userSex + ", userHobbyId=" + userHobbyId + "]";
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(userAddress, userHobbyId, userId, userName, userSex);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(userAddress, other.userAddress) && Objects.equals(userHobbyId, other.userHobbyId)
                && Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName)
                && Objects.equals(userSex, other.userSex);
    }

}
