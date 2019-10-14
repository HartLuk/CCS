package com.web.common.utils.jwt;
public class JwtConstants {
 
    public final static String CONTEXT_AUTHENTICATION = "authentication";
    public final static String CONTEXT_USERNAME = "contextUsername";
    public final static String CONTEXT_USER_ID = "contextUserId";
    public final static String JWT_PRIVATE_KEY = "0123456789";
    public final static String RENEWAL_TIME = "renewalTime";
    public final static String REDIS_USER_INFO_PREFIX = "userInfo_";
    public final static String TOKEN = "token";
    public final static String NO_LOGIN = "您目前还没有登陆";
    public final static String TOKEN_CHECK_ERROR = "token校验出错";
    public final static String TOKEN_EXPIRED = "登陆token已经失效";
    public final static String USER_LOGIN_AGAIN = "用户已经重新登陆";
}
