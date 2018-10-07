package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/6 0006.
 */

public class WorkDetailBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"orderType":"talk_price","orderAddress":{"con_tel":"18724613676","con_username":"李伟","con_address":"和兴路180号"},"orderRecordList":[{"create_time_text":"2018-10-05 14:36:27","record_content":"创建了服务工单"},{"create_time_text":"2018-10-05 14:36:36","record_content":"支付了押金0.01 元"}],"bidDetail":{"bid_price_max":2587,"bid_price_last":null,"work_order_id":645,"bid_price_min":2587,"bid_status":0,"id":347,"bid_user_id":1},"rankingDetail":{"ranking_attitude":"4","ranking_quality":"4","ranking_last":"4","ranking_quick":"4","ranking_text":"Ojbk"},"rankingInfo":{"ranking_attitude":"4","ranking_quality":"4","ranking_last":"4","ranking_quick":"4","ranking_text":"Ojbk"},"showType":"creator.waitSelectUser","orderDetail":{"create_time_second":"14:36:27","order_title":"道里区-招钟点工","order_status_text":"议价进行中","must_arrive_date":"","must_arrive_time":"","order_desc_pics":"","order_desc_sounds":"","order_can_breach":"0","create_time_day":"2018/10/05","order_desc":"②可还价，token=gggg》创建者，待选择工人","order_desc_videos":""},"getWorkerBidList":[{"bid_price_max":12,"bid_price_last":null,"sex":null,"num_funs":0,"phoneno":"15313960257","head_url":"https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132","work_order_id":634,"bid_price_min":12,"bid_status":0,"ranking_last":"3.0","id":341,"bid_user_id":100018,"username":"葛国龙"},{"bid_price_max":10,"bid_price_last":null,"sex":null,"num_funs":0,"phoneno":"18545523468","head_url":"https://image.lhservice.hrbyuantu.com/userXcxHead/0000.png","work_order_id":634,"bid_price_min":10,"bid_status":2,"ranking_last":"4.0","id":342,"bid_user_id":100015,"username":"未设置"},{"bid_price_max":100,"bid_price_last":100,"sex":null,"num_funs":0,"phoneno":"18604515178","head_url":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKUBaslg40a0ykFG7LJJrdf52NdWqlEafYGaMzXgUL3TDfia2ZeEpqqILtszNBc3ZUJobJ6GpQicSgQ/132","work_order_id":634,"bid_price_min":100,"bid_status":1,"ranking_last":"4.0","id":343,"bid_user_id":100012,"username":"诩翃"},{"bid_price_max":1,"bid_price_last":null,"sex":null,"num_funs":0,"phoneno":null,"head_url":"https://wx.qlogo.cn/mmopen/vi_32/zo9QSE4Hgv08UGac35u4VF0Dus9FwXAbQ27gtAqdiaibGicqXZgGesfNKVu1d0zxmjIl08ULnuv5IFLlMhiaR827Tw/132","work_order_id":634,"bid_price_min":1,"bid_status":0,"ranking_last":"0.0","id":352,"bid_user_id":100020,"username":"多动症晚期"}],"workUserDetail":{"birthday":"","city_value":"haerbin","num_funs":0,"zuobiao_x":126.669442,"zuobiao_y":45.77336,"score":15,"head_url":"https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132","merid":"CM2000666998","ranking_last":"3.0","id":100018,"referee_code":null,"head_url_png":"userXcxHead/100018.png","num_subscribe":0,"token_str":null,"token_time":null,"pay_pass":"323EE81C6B807724147ACEA9C159A148","create_time":{"date":6,"day":6,"hours":19,"minutes":38,"month":9,"nanos":0,"seconds":54,"time":1538825934000,"timezoneOffset":-480,"year":118},"openid":"oM7Rr5axGZmXf5kYdNtx6lu4Rinc","sex":null,"money_yue":0.01,"order_price":"0.01","referee_user_id":"0","phoneno":"15313960257","area_names":null,"work_names":null,"acctno":"00110000000010308969","def_classify_id":null,"def_area_id":null,"is_worker":"1","bind_idcard":"1","username":"葛国龙","is_logout":"0","ranking_text":"3.0000,3.0000,3.0000,3.0000"},"payDetail":{"price":"0.01"},"codeMap":{"doorCode":"7053"},"userRole":"creator","orderBase":{"base_user_certification_classify_name":"钟点工","order_price_range":"","order_price":"","base_area_name":"道里区"}}
     */

    private String errorCode;
    private String errorMsg;
    private DataObjBean dataObj;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DataObjBean getDataObj() {
        return dataObj;
    }

    public void setDataObj(DataObjBean dataObj) {
        this.dataObj = dataObj;
    }

    public static class DataObjBean {
        /**
         * orderType : talk_price
         * orderAddress : {"con_tel":"18724613676","con_username":"李伟","con_address":"和兴路180号"}
         * orderRecordList : [{"create_time_text":"2018-10-05 14:36:27","record_content":"创建了服务工单"},{"create_time_text":"2018-10-05 14:36:36","record_content":"支付了押金0.01 元"}]
         * bidDetail : {"bid_price_max":2587,"bid_price_last":null,"work_order_id":645,"bid_price_min":2587,"bid_status":0,"id":347,"bid_user_id":1}
         * rankingDetail : {"ranking_attitude":"4","ranking_quality":"4","ranking_last":"4","ranking_quick":"4","ranking_text":"Ojbk"}
         * rankingInfo : {"ranking_attitude":"4","ranking_quality":"4","ranking_last":"4","ranking_quick":"4","ranking_text":"Ojbk"}
         * showType : creator.waitSelectUser
         * orderDetail : {"create_time_second":"14:36:27","order_title":"道里区-招钟点工","order_status_text":"议价进行中","must_arrive_date":"","must_arrive_time":"","order_desc_pics":"","order_desc_sounds":"","order_can_breach":"0","create_time_day":"2018/10/05","order_desc":"②可还价，token=gggg》创建者，待选择工人","order_desc_videos":""}
         * getWorkerBidList : [{"bid_price_max":12,"bid_price_last":null,"sex":null,"num_funs":0,"phoneno":"15313960257","head_url":"https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132","work_order_id":634,"bid_price_min":12,"bid_status":0,"ranking_last":"3.0","id":341,"bid_user_id":100018,"username":"葛国龙"},{"bid_price_max":10,"bid_price_last":null,"sex":null,"num_funs":0,"phoneno":"18545523468","head_url":"https://image.lhservice.hrbyuantu.com/userXcxHead/0000.png","work_order_id":634,"bid_price_min":10,"bid_status":2,"ranking_last":"4.0","id":342,"bid_user_id":100015,"username":"未设置"},{"bid_price_max":100,"bid_price_last":100,"sex":null,"num_funs":0,"phoneno":"18604515178","head_url":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKUBaslg40a0ykFG7LJJrdf52NdWqlEafYGaMzXgUL3TDfia2ZeEpqqILtszNBc3ZUJobJ6GpQicSgQ/132","work_order_id":634,"bid_price_min":100,"bid_status":1,"ranking_last":"4.0","id":343,"bid_user_id":100012,"username":"诩翃"},{"bid_price_max":1,"bid_price_last":null,"sex":null,"num_funs":0,"phoneno":null,"head_url":"https://wx.qlogo.cn/mmopen/vi_32/zo9QSE4Hgv08UGac35u4VF0Dus9FwXAbQ27gtAqdiaibGicqXZgGesfNKVu1d0zxmjIl08ULnuv5IFLlMhiaR827Tw/132","work_order_id":634,"bid_price_min":1,"bid_status":0,"ranking_last":"0.0","id":352,"bid_user_id":100020,"username":"多动症晚期"}]
         * workUserDetail : {"birthday":"","city_value":"haerbin","num_funs":0,"zuobiao_x":126.669442,"zuobiao_y":45.77336,"score":15,"head_url":"https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132","merid":"CM2000666998","ranking_last":"3.0","id":100018,"referee_code":null,"head_url_png":"userXcxHead/100018.png","num_subscribe":0,"token_str":null,"token_time":null,"pay_pass":"323EE81C6B807724147ACEA9C159A148","create_time":{"date":6,"day":6,"hours":19,"minutes":38,"month":9,"nanos":0,"seconds":54,"time":1538825934000,"timezoneOffset":-480,"year":118},"openid":"oM7Rr5axGZmXf5kYdNtx6lu4Rinc","sex":null,"money_yue":0.01,"order_price":"0.01","referee_user_id":"0","phoneno":"15313960257","area_names":null,"work_names":null,"acctno":"00110000000010308969","def_classify_id":null,"def_area_id":null,"is_worker":"1","bind_idcard":"1","username":"葛国龙","is_logout":"0","ranking_text":"3.0000,3.0000,3.0000,3.0000"}
         * payDetail : {"price":"0.01"}
         * codeMap : {"doorCode":"7053"}
         * userRole : creator
         * orderBase : {"base_user_certification_classify_name":"钟点工","order_price_range":"","order_price":"","base_area_name":"道里区"}
         */

        private String orderType;
        private OrderAddressBean orderAddress;
        private BidDetailBean bidDetail;
        private RankingDetailBean rankingDetail;
        private RankingInfoBean rankingInfo;
        private String showType;
        private OrderDetailBean orderDetail;
        private WorkUserDetailBean workUserDetail;
        private PayDetailBean payDetail;
        private CodeMapBean codeMap;
        private String userRole;
        private OrderBaseBean orderBase;
        private List<OrderRecordListBean> orderRecordList;
        private List<GetWorkerBidListBean> getWorkerBidList;

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public OrderAddressBean getOrderAddress() {
            return orderAddress;
        }

        public void setOrderAddress(OrderAddressBean orderAddress) {
            this.orderAddress = orderAddress;
        }

        public BidDetailBean getBidDetail() {
            return bidDetail;
        }

        public void setBidDetail(BidDetailBean bidDetail) {
            this.bidDetail = bidDetail;
        }

        public RankingDetailBean getRankingDetail() {
            return rankingDetail;
        }

        public void setRankingDetail(RankingDetailBean rankingDetail) {
            this.rankingDetail = rankingDetail;
        }

        public RankingInfoBean getRankingInfo() {
            return rankingInfo;
        }

        public void setRankingInfo(RankingInfoBean rankingInfo) {
            this.rankingInfo = rankingInfo;
        }

        public String getShowType() {
            return showType;
        }

        public void setShowType(String showType) {
            this.showType = showType;
        }

        public OrderDetailBean getOrderDetail() {
            return orderDetail;
        }

        public void setOrderDetail(OrderDetailBean orderDetail) {
            this.orderDetail = orderDetail;
        }

        public WorkUserDetailBean getWorkUserDetail() {
            return workUserDetail;
        }

        public void setWorkUserDetail(WorkUserDetailBean workUserDetail) {
            this.workUserDetail = workUserDetail;
        }

        public PayDetailBean getPayDetail() {
            return payDetail;
        }

        public void setPayDetail(PayDetailBean payDetail) {
            this.payDetail = payDetail;
        }

        public CodeMapBean getCodeMap() {
            return codeMap;
        }

        public void setCodeMap(CodeMapBean codeMap) {
            this.codeMap = codeMap;
        }

        public String getUserRole() {
            return userRole;
        }

        public void setUserRole(String userRole) {
            this.userRole = userRole;
        }

        public OrderBaseBean getOrderBase() {
            return orderBase;
        }

        public void setOrderBase(OrderBaseBean orderBase) {
            this.orderBase = orderBase;
        }

        public List<OrderRecordListBean> getOrderRecordList() {
            return orderRecordList;
        }

        public void setOrderRecordList(List<OrderRecordListBean> orderRecordList) {
            this.orderRecordList = orderRecordList;
        }

        public List<GetWorkerBidListBean> getGetWorkerBidList() {
            return getWorkerBidList;
        }

        public void setGetWorkerBidList(List<GetWorkerBidListBean> getWorkerBidList) {
            this.getWorkerBidList = getWorkerBidList;
        }

        public static class OrderAddressBean {
            /**
             * con_tel : 18724613676
             * con_username : 李伟
             * con_address : 和兴路180号
             */

            private String con_tel;
            private String con_username;
            private String con_address;

            public String getCon_tel() {
                return con_tel;
            }

            public void setCon_tel(String con_tel) {
                this.con_tel = con_tel;
            }

            public String getCon_username() {
                return con_username;
            }

            public void setCon_username(String con_username) {
                this.con_username = con_username;
            }

            public String getCon_address() {
                return con_address;
            }

            public void setCon_address(String con_address) {
                this.con_address = con_address;
            }
        }

        public static class BidDetailBean {
            /**
             * bid_price_max : 2587
             * bid_price_last : null
             * work_order_id : 645
             * bid_price_min : 2587
             * bid_status : 0
             * id : 347
             * bid_user_id : 1
             */

            private int bid_price_max;
            private int bid_price_last;
            private int work_order_id;
            private int bid_price_min;
            private int bid_status;
            private int id;
            private int bid_user_id;

            public int getBid_price_max() {
                return bid_price_max;
            }

            public void setBid_price_max(int bid_price_max) {
                this.bid_price_max = bid_price_max;
            }

            public int getBid_price_last() {
                return bid_price_last;
            }

            public void setBid_price_last(int bid_price_last) {
                this.bid_price_last = bid_price_last;
            }

            public int getWork_order_id() {
                return work_order_id;
            }

            public void setWork_order_id(int work_order_id) {
                this.work_order_id = work_order_id;
            }

            public int getBid_price_min() {
                return bid_price_min;
            }

            public void setBid_price_min(int bid_price_min) {
                this.bid_price_min = bid_price_min;
            }

            public int getBid_status() {
                return bid_status;
            }

            public void setBid_status(int bid_status) {
                this.bid_status = bid_status;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getBid_user_id() {
                return bid_user_id;
            }

            public void setBid_user_id(int bid_user_id) {
                this.bid_user_id = bid_user_id;
            }
        }

        public static class RankingDetailBean {
            /**
             * ranking_attitude : 4
             * ranking_quality : 4
             * ranking_last : 4
             * ranking_quick : 4
             * ranking_text : Ojbk
             */

            private String ranking_attitude;
            private String ranking_quality;
            private String ranking_last;
            private String ranking_quick;
            private String ranking_text;

            public String getRanking_attitude() {
                return ranking_attitude;
            }

            public void setRanking_attitude(String ranking_attitude) {
                this.ranking_attitude = ranking_attitude;
            }

            public String getRanking_quality() {
                return ranking_quality;
            }

            public void setRanking_quality(String ranking_quality) {
                this.ranking_quality = ranking_quality;
            }

            public String getRanking_last() {
                return ranking_last;
            }

            public void setRanking_last(String ranking_last) {
                this.ranking_last = ranking_last;
            }

            public String getRanking_quick() {
                return ranking_quick;
            }

            public void setRanking_quick(String ranking_quick) {
                this.ranking_quick = ranking_quick;
            }

            public String getRanking_text() {
                return ranking_text;
            }

            public void setRanking_text(String ranking_text) {
                this.ranking_text = ranking_text;
            }
        }

        public static class RankingInfoBean {
            /**
             * ranking_attitude : 4
             * ranking_quality : 4
             * ranking_last : 4
             * ranking_quick : 4
             * ranking_text : Ojbk
             */

            private String ranking_attitude;
            private String ranking_quality;
            private String ranking_last;
            private String ranking_quick;
            private String ranking_text;

            public String getRanking_attitude() {
                return ranking_attitude;
            }

            public void setRanking_attitude(String ranking_attitude) {
                this.ranking_attitude = ranking_attitude;
            }

            public String getRanking_quality() {
                return ranking_quality;
            }

            public void setRanking_quality(String ranking_quality) {
                this.ranking_quality = ranking_quality;
            }

            public String getRanking_last() {
                return ranking_last;
            }

            public void setRanking_last(String ranking_last) {
                this.ranking_last = ranking_last;
            }

            public String getRanking_quick() {
                return ranking_quick;
            }

            public void setRanking_quick(String ranking_quick) {
                this.ranking_quick = ranking_quick;
            }

            public String getRanking_text() {
                return ranking_text;
            }

            public void setRanking_text(String ranking_text) {
                this.ranking_text = ranking_text;
            }
        }

        public static class OrderDetailBean {
            /**
             * create_time_second : 14:36:27
             * order_title : 道里区-招钟点工
             * order_status_text : 议价进行中
             * must_arrive_date :
             * must_arrive_time :
             * order_desc_pics :
             * order_desc_sounds :
             * order_can_breach : 0
             * create_time_day : 2018/10/05
             * order_desc : ②可还价，token=gggg》创建者，待选择工人
             * order_desc_videos :
             */

            private String create_time_second;
            private String order_title;
            private String order_status_text;
            private String must_arrive_date;
            private String must_arrive_time;
            private String order_desc_pics;
            private String order_desc_sounds;
            private String order_can_breach;
            private String create_time_day;
            private String order_desc;
            private String order_desc_videos;

            public String getCreate_time_second() {
                return create_time_second;
            }

            public void setCreate_time_second(String create_time_second) {
                this.create_time_second = create_time_second;
            }

            public String getOrder_title() {
                return order_title;
            }

            public void setOrder_title(String order_title) {
                this.order_title = order_title;
            }

            public String getOrder_status_text() {
                return order_status_text;
            }

            public void setOrder_status_text(String order_status_text) {
                this.order_status_text = order_status_text;
            }

            public String getMust_arrive_date() {
                return must_arrive_date;
            }

            public void setMust_arrive_date(String must_arrive_date) {
                this.must_arrive_date = must_arrive_date;
            }

            public String getMust_arrive_time() {
                return must_arrive_time;
            }

            public void setMust_arrive_time(String must_arrive_time) {
                this.must_arrive_time = must_arrive_time;
            }

            public String getOrder_desc_pics() {
                return order_desc_pics;
            }

            public void setOrder_desc_pics(String order_desc_pics) {
                this.order_desc_pics = order_desc_pics;
            }

            public String getOrder_desc_sounds() {
                return order_desc_sounds;
            }

            public void setOrder_desc_sounds(String order_desc_sounds) {
                this.order_desc_sounds = order_desc_sounds;
            }

            public String getOrder_can_breach() {
                return order_can_breach;
            }

            public void setOrder_can_breach(String order_can_breach) {
                this.order_can_breach = order_can_breach;
            }

            public String getCreate_time_day() {
                return create_time_day;
            }

            public void setCreate_time_day(String create_time_day) {
                this.create_time_day = create_time_day;
            }

            public String getOrder_desc() {
                return order_desc;
            }

            public void setOrder_desc(String order_desc) {
                this.order_desc = order_desc;
            }

            public String getOrder_desc_videos() {
                return order_desc_videos;
            }

            public void setOrder_desc_videos(String order_desc_videos) {
                this.order_desc_videos = order_desc_videos;
            }
        }

        public static class WorkUserDetailBean {
            /**
             * birthday :
             * city_value : haerbin
             * num_funs : 0
             * zuobiao_x : 126.669442
             * zuobiao_y : 45.77336
             * score : 15
             * head_url : https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132
             * merid : CM2000666998
             * ranking_last : 3.0
             * id : 100018
             * referee_code : null
             * head_url_png : userXcxHead/100018.png
             * num_subscribe : 0
             * token_str : null
             * token_time : null
             * pay_pass : 323EE81C6B807724147ACEA9C159A148
             * create_time : {"date":6,"day":6,"hours":19,"minutes":38,"month":9,"nanos":0,"seconds":54,"time":1538825934000,"timezoneOffset":-480,"year":118}
             * openid : oM7Rr5axGZmXf5kYdNtx6lu4Rinc
             * sex : null
             * money_yue : 0.01
             * order_price : 0.01
             * referee_user_id : 0
             * phoneno : 15313960257
             * area_names : null
             * work_names : null
             * acctno : 00110000000010308969
             * def_classify_id : null
             * def_area_id : null
             * is_worker : 1
             * bind_idcard : 1
             * username : 葛国龙
             * is_logout : 0
             * ranking_text : 3.0000,3.0000,3.0000,3.0000
             */

            private String birthday;
            private String city_value;
            private int num_funs;
            private double zuobiao_x;
            private double zuobiao_y;
            private int score;
            private String head_url;
            private String merid;
            private String ranking_last;
            private int id;
            private Object referee_code;
            private String head_url_png;
            private int num_subscribe;
            private Object token_str;
            private Object token_time;
            private String pay_pass;
            private CreateTimeBean create_time;
            private String openid;
            private Object sex;
            private double money_yue;
            private String order_price;
            private String referee_user_id;
            private String phoneno;
            private Object area_names;
            private Object work_names;
            private String acctno;
            private Object def_classify_id;
            private Object def_area_id;
            private String is_worker;
            private String bind_idcard;
            private String username;
            private String is_logout;
            private String ranking_text;

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getCity_value() {
                return city_value;
            }

            public void setCity_value(String city_value) {
                this.city_value = city_value;
            }

            public int getNum_funs() {
                return num_funs;
            }

            public void setNum_funs(int num_funs) {
                this.num_funs = num_funs;
            }

            public double getZuobiao_x() {
                return zuobiao_x;
            }

            public void setZuobiao_x(double zuobiao_x) {
                this.zuobiao_x = zuobiao_x;
            }

            public double getZuobiao_y() {
                return zuobiao_y;
            }

            public void setZuobiao_y(double zuobiao_y) {
                this.zuobiao_y = zuobiao_y;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public String getHead_url() {
                return head_url;
            }

            public void setHead_url(String head_url) {
                this.head_url = head_url;
            }

            public String getMerid() {
                return merid;
            }

            public void setMerid(String merid) {
                this.merid = merid;
            }

            public String getRanking_last() {
                return ranking_last;
            }

            public void setRanking_last(String ranking_last) {
                this.ranking_last = ranking_last;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getReferee_code() {
                return referee_code;
            }

            public void setReferee_code(Object referee_code) {
                this.referee_code = referee_code;
            }

            public String getHead_url_png() {
                return head_url_png;
            }

            public void setHead_url_png(String head_url_png) {
                this.head_url_png = head_url_png;
            }

            public int getNum_subscribe() {
                return num_subscribe;
            }

            public void setNum_subscribe(int num_subscribe) {
                this.num_subscribe = num_subscribe;
            }

            public Object getToken_str() {
                return token_str;
            }

            public void setToken_str(Object token_str) {
                this.token_str = token_str;
            }

            public Object getToken_time() {
                return token_time;
            }

            public void setToken_time(Object token_time) {
                this.token_time = token_time;
            }

            public String getPay_pass() {
                return pay_pass;
            }

            public void setPay_pass(String pay_pass) {
                this.pay_pass = pay_pass;
            }

            public CreateTimeBean getCreate_time() {
                return create_time;
            }

            public void setCreate_time(CreateTimeBean create_time) {
                this.create_time = create_time;
            }

            public String getOpenid() {
                return openid;
            }

            public void setOpenid(String openid) {
                this.openid = openid;
            }

            public Object getSex() {
                return sex;
            }

            public void setSex(Object sex) {
                this.sex = sex;
            }

            public double getMoney_yue() {
                return money_yue;
            }

            public void setMoney_yue(double money_yue) {
                this.money_yue = money_yue;
            }

            public String getOrder_price() {
                return order_price;
            }

            public void setOrder_price(String order_price) {
                this.order_price = order_price;
            }

            public String getReferee_user_id() {
                return referee_user_id;
            }

            public void setReferee_user_id(String referee_user_id) {
                this.referee_user_id = referee_user_id;
            }

            public String getPhoneno() {
                return phoneno;
            }

            public void setPhoneno(String phoneno) {
                this.phoneno = phoneno;
            }

            public Object getArea_names() {
                return area_names;
            }

            public void setArea_names(Object area_names) {
                this.area_names = area_names;
            }

            public Object getWork_names() {
                return work_names;
            }

            public void setWork_names(Object work_names) {
                this.work_names = work_names;
            }

            public String getAcctno() {
                return acctno;
            }

            public void setAcctno(String acctno) {
                this.acctno = acctno;
            }

            public Object getDef_classify_id() {
                return def_classify_id;
            }

            public void setDef_classify_id(Object def_classify_id) {
                this.def_classify_id = def_classify_id;
            }

            public Object getDef_area_id() {
                return def_area_id;
            }

            public void setDef_area_id(Object def_area_id) {
                this.def_area_id = def_area_id;
            }

            public String getIs_worker() {
                return is_worker;
            }

            public void setIs_worker(String is_worker) {
                this.is_worker = is_worker;
            }

            public String getBind_idcard() {
                return bind_idcard;
            }

            public void setBind_idcard(String bind_idcard) {
                this.bind_idcard = bind_idcard;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getIs_logout() {
                return is_logout;
            }

            public void setIs_logout(String is_logout) {
                this.is_logout = is_logout;
            }

            public String getRanking_text() {
                return ranking_text;
            }

            public void setRanking_text(String ranking_text) {
                this.ranking_text = ranking_text;
            }

            public static class CreateTimeBean {
                /**
                 * date : 6
                 * day : 6
                 * hours : 19
                 * minutes : 38
                 * month : 9
                 * nanos : 0
                 * seconds : 54
                 * time : 1538825934000
                 * timezoneOffset : -480
                 * year : 118
                 */

                private int date;
                private int day;
                private int hours;
                private int minutes;
                private int month;
                private int nanos;
                private int seconds;
                private long time;
                private int timezoneOffset;
                private int year;

                public int getDate() {
                    return date;
                }

                public void setDate(int date) {
                    this.date = date;
                }

                public int getDay() {
                    return day;
                }

                public void setDay(int day) {
                    this.day = day;
                }

                public int getHours() {
                    return hours;
                }

                public void setHours(int hours) {
                    this.hours = hours;
                }

                public int getMinutes() {
                    return minutes;
                }

                public void setMinutes(int minutes) {
                    this.minutes = minutes;
                }

                public int getMonth() {
                    return month;
                }

                public void setMonth(int month) {
                    this.month = month;
                }

                public int getNanos() {
                    return nanos;
                }

                public void setNanos(int nanos) {
                    this.nanos = nanos;
                }

                public int getSeconds() {
                    return seconds;
                }

                public void setSeconds(int seconds) {
                    this.seconds = seconds;
                }

                public long getTime() {
                    return time;
                }

                public void setTime(long time) {
                    this.time = time;
                }

                public int getTimezoneOffset() {
                    return timezoneOffset;
                }

                public void setTimezoneOffset(int timezoneOffset) {
                    this.timezoneOffset = timezoneOffset;
                }

                public int getYear() {
                    return year;
                }

                public void setYear(int year) {
                    this.year = year;
                }
            }
        }

        public static class PayDetailBean {
            /**
             * price : 0.01
             */

            private String price;

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }

        public static class CodeMapBean {
            /**
             * doorCode : 7053
             */

            private String doorCode;

            public String getDoorCode() {
                return doorCode;
            }

            public void setDoorCode(String doorCode) {
                this.doorCode = doorCode;
            }
        }

        public static class OrderBaseBean {
            /**
             * base_user_certification_classify_name : 钟点工
             * order_price_range :
             * order_price :
             * base_area_name : 道里区
             */

            private String base_user_certification_classify_name;
            private String order_price_range;
            private String order_price;
            private String base_area_name;

            public String getBase_user_certification_classify_name() {
                return base_user_certification_classify_name;
            }

            public void setBase_user_certification_classify_name(String base_user_certification_classify_name) {
                this.base_user_certification_classify_name = base_user_certification_classify_name;
            }

            public String getOrder_price_range() {
                return order_price_range;
            }

            public void setOrder_price_range(String order_price_range) {
                this.order_price_range = order_price_range;
            }

            public String getOrder_price() {
                return order_price;
            }

            public void setOrder_price(String order_price) {
                this.order_price = order_price;
            }

            public String getBase_area_name() {
                return base_area_name;
            }

            public void setBase_area_name(String base_area_name) {
                this.base_area_name = base_area_name;
            }
        }

        public static class OrderRecordListBean {
            /**
             * create_time_text : 2018-10-05 14:36:27
             * record_content : 创建了服务工单
             */

            private String create_time_text;
            private String record_content;

            public String getCreate_time_text() {
                return create_time_text;
            }

            public void setCreate_time_text(String create_time_text) {
                this.create_time_text = create_time_text;
            }

            public String getRecord_content() {
                return record_content;
            }

            public void setRecord_content(String record_content) {
                this.record_content = record_content;
            }
        }

        public static class GetWorkerBidListBean {
            /**
             * bid_price_max : 12
             * bid_price_last : null
             * sex : null
             * num_funs : 0
             * phoneno : 15313960257
             * head_url : https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132
             * work_order_id : 634
             * bid_price_min : 12
             * bid_status : 0
             * ranking_last : 3.0
             * id : 341
             * bid_user_id : 100018
             * username : 葛国龙
             */

            private int bid_price_max;
            private Object bid_price_last;
            private Object sex;
            private int num_funs;
            private String phoneno;
            private String head_url;
            private int work_order_id;
            private int bid_price_min;
            private int bid_status;
            private String ranking_last;
            private int id;
            private int bid_user_id;
            private String username;

            public int getBid_price_max() {
                return bid_price_max;
            }

            public void setBid_price_max(int bid_price_max) {
                this.bid_price_max = bid_price_max;
            }

            public Object getBid_price_last() {
                return bid_price_last;
            }

            public void setBid_price_last(Object bid_price_last) {
                this.bid_price_last = bid_price_last;
            }

            public Object getSex() {
                return sex;
            }

            public void setSex(Object sex) {
                this.sex = sex;
            }

            public int getNum_funs() {
                return num_funs;
            }

            public void setNum_funs(int num_funs) {
                this.num_funs = num_funs;
            }

            public String getPhoneno() {
                return phoneno;
            }

            public void setPhoneno(String phoneno) {
                this.phoneno = phoneno;
            }

            public String getHead_url() {
                return head_url;
            }

            public void setHead_url(String head_url) {
                this.head_url = head_url;
            }

            public int getWork_order_id() {
                return work_order_id;
            }

            public void setWork_order_id(int work_order_id) {
                this.work_order_id = work_order_id;
            }

            public int getBid_price_min() {
                return bid_price_min;
            }

            public void setBid_price_min(int bid_price_min) {
                this.bid_price_min = bid_price_min;
            }

            public int getBid_status() {
                return bid_status;
            }

            public void setBid_status(int bid_status) {
                this.bid_status = bid_status;
            }

            public String getRanking_last() {
                return ranking_last;
            }

            public void setRanking_last(String ranking_last) {
                this.ranking_last = ranking_last;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getBid_user_id() {
                return bid_user_id;
            }

            public void setBid_user_id(int bid_user_id) {
                this.bid_user_id = bid_user_id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
