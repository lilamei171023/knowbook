package com.excellent.knowbookcommon.model.vo;

/**
 * @author User wxxu
 * @description: 地址总列表包装类
 * @create 2018/8/8 10:19
 */
public class AddressTotal {

    private String userId;

    private String addressId;

    /**
     * 收件人地址
     */
    private String addresseeInfo;

    private String addresseePhone;

    private String addresseeName;

    private String userDefaultAddressId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddresseeInfo() {
        return addresseeInfo;
    }

    public void setAddresseeInfo(String addresseeInfo) {
        this.addresseeInfo = addresseeInfo;
    }

    public String getAddresseePhone() {
        return addresseePhone;
    }

    public void setAddresseePhone(String addresseePhone) {
        this.addresseePhone = addresseePhone;
    }

    public String getAddresseeName() {
        return addresseeName;
    }

    public void setAddresseeName(String addresseeName) {
        this.addresseeName = addresseeName;
    }

    public String getUserDefaultAddressId() {
        return userDefaultAddressId;
    }

    public void setUserDefaultAddressId(String userDefaultAddressId) {
        this.userDefaultAddressId = userDefaultAddressId;
    }

    @Override
    public String toString() {
        return "AddressTotal{" +
                "userId='" + userId + '\'' +
                ", addressId='" + addressId + '\'' +
                ", addresseeInfo='" + addresseeInfo + '\'' +
                ", addresseePhone='" + addresseePhone + '\'' +
                ", addresseeName='" + addresseeName + '\'' +
                ", userDefaultAddressId='" + userDefaultAddressId + '\'' +
                '}';
    }
}
