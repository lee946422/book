package cn.lei.book.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * zj_users
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户IP
     */
    private String userIp;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户头像
     */
    private String userProfilePhoto;

    /**
     * 注册时间
     */
    private Date userRegistrationTime;

    /**
     * 用户生日
     */
    private Date userBirthday;

    /**
     * 用户年龄
     */
    private Byte userAge;

    /**
     * 用户手机号
     */
    private String userTelephoneNumber;

    /**
     * 用户昵称
     */
    private String userNickname;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}