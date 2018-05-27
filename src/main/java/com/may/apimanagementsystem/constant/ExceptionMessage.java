package com.may.apimanagementsystem.constant;

public class ExceptionMessage {
    public static final String SUCCESS = "操作成功";
    /*user*/
    public static final String USER_NAME_IS_TOO_LONG = "用户名不要超过二十个字符";
    public static final String DOUBLE_USER_NAME = "用户名已经被注册了";
    public static final String PASSWORD_IS_TOO_LONG = "密码不要超过二十个字符";
    public static final String EMAIL_FORMAT_WRONG = "邮箱格式有误";
    public static final String USERNAME_NOT_EXIST = "用户不存在";
    public static final String PASSWORD_WRONG = "密码错误";
    public static final String SEX_WRONG = "性别只能为男或者女";
    public static final String PHONENUMBER_WRONG = "电话号码格式有误";
    public static final String PARAMETER_CANNOT_NULL = "信息没有填写完整";

    /*team*/
    public static final String TEAM_NAME_IS_EMPTY = "团队名称不能为空";
    public static final String DOUBLE_TEAM_NAME = "团队名已经被注册过了";

    /*teamMember*/
    public static final String TEAM_NOT_EXIST="该团队不存在";


}
