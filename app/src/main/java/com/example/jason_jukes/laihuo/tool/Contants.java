package com.example.jason_jukes.laihuo.tool;

/**
 * 作者：Jason_Jukes on 2018/9/26 0026 16:50
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class Contants {

    public static String HTTP_OK = "0000";
    public static String HTTP_NO_LOGIN = "0004";


    public static String USER_ID = "user_id";
    public static String CLASSIFY_ID = "classify_id";
    public static String SHANGBAN = "work_status";
    public static String PHONE_STATUS = "phone_status";
    public static String CARD_STATUS = "card_status";
    public static String ID_STATUS = "id_status";


    /*基地址*/
    public static String URL_BASE = "http://47.105.90.56:8080/lh/";
    public static String URL_IMG_BASE = "https://image.lhservice.hrbyuantu.com/";

    /*首頁*/
    public static String HOME_TOP_PIC = "https://image.liwei1.irebane.cn/index_bingd_banner1.png";
    public static String HOME_MIDDLE_PIC = "https://image.liwei1.irebane.cn/jianguanBanner1.png";
    //首页
    public static String HOME = URL_BASE + "xcxIndex";

    //信息市场
    public static String MESSAGE_MARKET = URL_BASE + "getBbsTopics";
    //信息市场详情
    public static String MESSAGE_MARKET_DETAIL = URL_BASE + "getBbsTopicById";
    //信息市场：发帖
    public static String SEND_MESSAGE = URL_BASE + "addBbsTopic";
    //添加评论
    public static String ADD_COMMENT = URL_BASE + "addBbsSreply";
    //我的发帖列表
    public static String MINE_POST_MESSAGE = URL_BASE + "getBbsTopicsByUserId";
    //我的回帖列表
    public static String MINE_PARTAKE_MESSAGE = URL_BASE + "getBbsSreplysbyUserId";
    //服务项目
    public static String GET_CLASSIFY = URL_BASE + "getUserCertificationClassify";
    //附近的能人
    public static String NEARBY_WORKER = URL_BASE + "getWorkerListByClassifyId";
    //首页-找活干
    public static String FIND_WORK = URL_BASE + "getOrderListForWaitBidAll";
    //议价发布（可还价）
    public static String POST_HUANJIA = URL_BASE + "orderCreate";
    //一口价发布
    public static String POST_YIKOU = URL_BASE + "orderCreateFixed";
    //订单详情
    public static String ORDER_DETAIL = URL_BASE + "getOrderDetail";
    //询价关闭订单
    public static String ORDER_CANCEL_XUNJIA = URL_BASE + "cancelWorkOrder";
    //一口价关闭订单
    public static String ORDER_CANCEL_YIKOUJIA = URL_BASE + "cancelWorkOrderForFixed";
    //白5订单确认完成
    public static String ORDER_SURE_FINISH = URL_BASE + "agreeOrder";
    //网页薪资标准
    public static String XINZI_BIAOZHUN = URL_IMG_BASE + "web/gongzibiaozhun2.html";
    //申请报价
    public static String APPLY_PRICE = URL_BASE + "addBid";
    //确认接单价格
    public static String SURE_ORDER_PRICE = URL_BASE + "agreeBid";
    //确认到达
    public static String SURE_ARRIVE = URL_BASE + "workerArrived";
    //提交工作
    public static String FINISH_WORK = URL_BASE + "commitWork";
    //选择TA
    public static String CHOOSE_IT = URL_BASE + "selectedWorker";
    //请他输入最终价格
    public static String PLEASE_INPUT_PRICE = URL_BASE + "canBidAgree";
    //一口价接单
    public static String FIXED_PRICE_GET_ORDER = URL_BASE + "fixedOrder";
    //评价
    public static String SEND_RANKING = URL_BASE + "addRanking";
    //邀请他完成我的活
    public static String INVIST_WORKER = URL_BASE + "inviteWorker";




    /*我的*/

    //登陆
    public static String LOGIN = URL_BASE + "appLogin";
    //注册
    public static String REGISTER = URL_BASE + "appReg";
    //修改昵称
    public static String CHANGE_NAME = URL_BASE + "updateUserName";
    //获取短信验证码
    public static String APP_CODE = URL_BASE + "sendAppSmsCode";
    //获取图形验证码
    public static String GET_IMG_CODE = URL_BASE + "imageCode";
    //我的地址
    public static String MY_ADDRESS = URL_BASE + "getUserAddress";
    //添加地址
    public static String ADD_ADDRESS = URL_BASE + "addUserAddress";
    //地址列表
    public static String AREA_LIST = URL_BASE + "getAreaList";
    //修改地址
    public static String CHANGE_ADDRESS = URL_BASE + "updateUserAddress";
    //删除地址
    public static String DEL_ADDRESS = URL_BASE + "delUserAddress";
    //手机验证码
    public static String GET_CODE = URL_BASE + "sendSmsCode";
    //认证手机
    public static String PHONE_CER = URL_BASE + "bindingTel";
    //绑卡
    public static String BIND_CARD = URL_BASE + "bindingIdcardToWorker";
    //用户信息
    public static String USER_INFO = URL_BASE + "getUserByTokenNow";
    //获取个人评价
    public static String GET_USER_PINGJIA = URL_BASE + "getRankingListForUser";
    //切换至上下班状态
    public static String SHANGBAN_STATUS = URL_BASE + "setWorkerStatus";
    //金额变动
    public static String MONEY_CHANGE = URL_BASE + "getUserMoneyLog";
    //提现记录
    public static String WITHDRAW_RECORD = URL_BASE + "getWithdrawCashList";
    //提现申请
    public static String WITHDRAW = URL_BASE + "userWithdrawCash";
    //我的资质列表
    public static String MINE_QUALIFICATION = URL_BASE + "getUserCustomCert";
    //删除资质
    public static String DEL_QUALIFICATION = URL_BASE + "delUserCustomCert";
    //添加资质
    public static String ADD_QUALIFICATION = URL_BASE + "addUserCustomCert";
    //我的关注列表
    public static String MINE_FOCUS = URL_BASE + "subscribeList";
    //我的粉丝列表
    public static String MINE_FANS = URL_BASE + "funsList";
    //关注
    public static String FOCUS = URL_BASE + "subscribeUser";
    //取消关注
    public static String CANCEL_FOCUS = URL_BASE + "cancelSubscribeUser";
    //查询TA的信息
    public static String SEE_OTHER_HOME = URL_BASE + "getUserDetailForWork";
    //我发布的活
    public static String MINE_POST_WORK = URL_BASE + "getOrderListByCreator";
    //我参与的活-已申请的活
    public static String MINE_PART_WORK_SHENQING = URL_BASE + "getOrderListByJoinedBid";
    //我参与的活-进行中的活
    public static String MINE_PART_WORKING = URL_BASE + "getOrderListForWorkingByMyBid";
    //我参与的活-已完成的活
    public static String MINE_PART_WORKED = URL_BASE + "getOrderListByMyBid";
    //邀请我的活
    public static String MINE_INVIST_WORK = URL_BASE + "getMyInvite";
    //获取投诉原因列表
    public static String TOUSU_CAUSE_LIST = URL_BASE + "getBaseDictByType";
    //提交投诉
    public static String SEND_TOUSU = URL_BASE + "addTipoff";


}
