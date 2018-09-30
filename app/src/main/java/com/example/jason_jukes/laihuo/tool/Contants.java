package com.example.jason_jukes.laihuo.tool;

/**
 * 作者：Jason_Jukes on 2018/9/26 0026 16:50
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class Contants {

    public static String HTTP_OK = "0000";
    public static String HTTP_ERROR = "0004";


    public static String USER_ID = "user_id";


    /*基地址*/
    public static String URL_BASE = "http://47.105.90.56:8080/lh/";
    public static String URL_IMG_BASE = "https://image.lhservice.hrbyuantu.com/";

    /*首頁*/
    public static String HOME_TOP_PIC = "https://image.liwei1.irebane.cn/index_bingd_banner1.png";
    public static String HOME_MIDDLE_PIC = "https://image.liwei1.irebane.cn/jianguanBanner1.png";


    //信息市场
    public static String MESSAGE_MARKET = URL_BASE + "getBbsTopics";
    //信息市场详情
    public static String MESSAGE_MARKET_DETAIL = URL_BASE + "getBbsTopicById";
    //添加评论
    public static String ADD_COMMENT = URL_BASE + "addBbsSreply";
    //我的发帖列表
    public static String MINE_POST_MESSAGE = URL_BASE + "getBbsTopicsByUserId";
    //我的回帖列表
    public static String MINE_PARTAKE_MESSAGE = URL_BASE + "getBbsSreplysbyUserId";


    /*我的*/
    //我的地址
    public static String MY_ADDRESS = URL_BASE + "getUserAddress";
    //添加地址
    public static String ADD_ADDRESS = URL_BASE + "addUserAddress";
    //修改地址
    public static String CHANGE_ADDRESS = URL_BASE + "updateUserAddress";


}
