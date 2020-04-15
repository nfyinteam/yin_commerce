package edu.nf.shopping.user.entity;


import lombok.Data;

/**
 * @author re
 * @date 2020/3/22
 */
@Data
public class UserInfo {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户手机号
     */
    private String tel;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 用户真实姓名
     */
    private String realName;
    /**
     * 用户身份证号码
     */
    private String carNumber;
    /**
     * 用户头像编号
     */
    private String faceId;

    /**
     * 是否需要客服
     */
    private String necessaryCustomerService;

    private String customerServiceId;

    private String orderId;

    private String lastContent;
}
