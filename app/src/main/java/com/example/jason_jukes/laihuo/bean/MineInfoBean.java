package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class MineInfoBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"birthday":"","ranking_attitude":"3.0000","city_value":"haerbin","num_funs":2,"zuobiao_x":126.5921173096,"bizInfo":[{"ico_py":"0","ico_px":"0","city_value":"haerbin","biz_type":"unlock_company","biz_name":"开锁公司","certification_classify_name":"开锁修锁","sort":100,"photo_path":"classifyIco/kaisuo.png","must_cert":"0","is_show":"1","parent_id":55,"must_cert_id":null,"id":65},{"ico_py":"0","ico_px":"0","city_value":"haerbin","biz_type":"","biz_name":null,"certification_classify_name":"推荐分类","sort":110,"photo_path":"classifyIco/kong.jpg","must_cert":"0","is_show":"1","parent_id":0,"must_cert_id":null,"id":55}],"zuobiao_y":45.7028007507,"score":5,"head_url":"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132","merid":"CM2000666988","ranking_last":"5.0000","id":1,"referee_code":"EGRIRY","head_url_png":"userXcxHead/100017.png","num_subscribe":9,"token_str":null,"token_time":null,"pay_pass":"323EE81C6B807724147ACEA9C159A148","create_time":{"date":3,"day":3,"hours":12,"minutes":58,"month":9,"nanos":0,"seconds":31,"time":1538542711000,"timezoneOffset":-480,"year":118},"openid":"oM7Rr5QIJklM0o00DBR-VZi-1WzU","ranking_quality":"2.0000","sex":null,"money_yue":0.91,"referee_user_id":"0","phoneno":"18346019592","area_names":null,"work_names":"开锁修锁,推荐分类","acctno":"00110000000010308968","def_classify_id":65,"def_area_id":null,"is_worker":"0","bind_idcard":"1","ranking_quick":"1.0000","username":"GGGG","is_logout":"0","ranking_text":"5.0000,1.0000,2.0000,3.0000"}
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
         * birthday :
         * ranking_attitude : 3.0000
         * city_value : haerbin
         * num_funs : 2
         * zuobiao_x : 126.5921173096
         * bizInfo : [{"ico_py":"0","ico_px":"0","city_value":"haerbin","biz_type":"unlock_company","biz_name":"开锁公司","certification_classify_name":"开锁修锁","sort":100,"photo_path":"classifyIco/kaisuo.png","must_cert":"0","is_show":"1","parent_id":55,"must_cert_id":null,"id":65},{"ico_py":"0","ico_px":"0","city_value":"haerbin","biz_type":"","biz_name":null,"certification_classify_name":"推荐分类","sort":110,"photo_path":"classifyIco/kong.jpg","must_cert":"0","is_show":"1","parent_id":0,"must_cert_id":null,"id":55}]
         * zuobiao_y : 45.7028007507
         * score : 5
         * head_url : https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132
         * merid : CM2000666988
         * ranking_last : 5.0000
         * id : 1
         * referee_code : EGRIRY
         * head_url_png : userXcxHead/100017.png
         * num_subscribe : 9
         * token_str : null
         * token_time : null
         * pay_pass : 323EE81C6B807724147ACEA9C159A148
         * create_time : {"date":3,"day":3,"hours":12,"minutes":58,"month":9,"nanos":0,"seconds":31,"time":1538542711000,"timezoneOffset":-480,"year":118}
         * openid : oM7Rr5QIJklM0o00DBR-VZi-1WzU
         * ranking_quality : 2.0000
         * sex : null
         * money_yue : 0.91
         * referee_user_id : 0
         * phoneno : 18346019592
         * area_names : null
         * work_names : 开锁修锁,推荐分类
         * acctno : 00110000000010308968
         * def_classify_id : 65
         * def_area_id : null
         * is_worker : 0
         * bind_idcard : 1
         * ranking_quick : 1.0000
         * username : GGGG
         * is_logout : 0
         * ranking_text : 5.0000,1.0000,2.0000,3.0000
         */

        private String birthday;
        private String ranking_attitude;
        private String city_value;
        private int num_funs;
        private double zuobiao_x;
        private double zuobiao_y;
        private int score;
        private String head_url;
        private String merid;
        private String ranking_last;
        private int id;
        private String referee_code;
        private String head_url_png;
        private int num_subscribe;
        private Object token_str;
        private Object token_time;
        private String pay_pass;
        private CreateTimeBean create_time;
        private String openid;
        private String ranking_quality;
        private Object sex;
        private double money_yue;
        private String referee_user_id;
        private String phoneno;
        private Object area_names;
        private String work_names;
        private String acctno;
        private int def_classify_id;
        private Object def_area_id;
        private String is_worker;
        private String bind_idcard;
        private String ranking_quick;
        private String username;
        private String is_logout;
        private String ranking_text;
        private List<BizInfoBean> bizInfo;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getRanking_attitude() {
            return ranking_attitude;
        }

        public void setRanking_attitude(String ranking_attitude) {
            this.ranking_attitude = ranking_attitude;
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

        public String getReferee_code() {
            return referee_code;
        }

        public void setReferee_code(String referee_code) {
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

        public String getRanking_quality() {
            return ranking_quality;
        }

        public void setRanking_quality(String ranking_quality) {
            this.ranking_quality = ranking_quality;
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

        public String getWork_names() {
            return work_names;
        }

        public void setWork_names(String work_names) {
            this.work_names = work_names;
        }

        public String getAcctno() {
            return acctno;
        }

        public void setAcctno(String acctno) {
            this.acctno = acctno;
        }

        public int getDef_classify_id() {
            return def_classify_id;
        }

        public void setDef_classify_id(int def_classify_id) {
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

        public String getRanking_quick() {
            return ranking_quick;
        }

        public void setRanking_quick(String ranking_quick) {
            this.ranking_quick = ranking_quick;
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

        public List<BizInfoBean> getBizInfo() {
            return bizInfo;
        }

        public void setBizInfo(List<BizInfoBean> bizInfo) {
            this.bizInfo = bizInfo;
        }

        public static class CreateTimeBean {
            /**
             * date : 3
             * day : 3
             * hours : 12
             * minutes : 58
             * month : 9
             * nanos : 0
             * seconds : 31
             * time : 1538542711000
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

        public static class BizInfoBean {
            /**
             * ico_py : 0
             * ico_px : 0
             * city_value : haerbin
             * biz_type : unlock_company
             * biz_name : 开锁公司
             * certification_classify_name : 开锁修锁
             * sort : 100
             * photo_path : classifyIco/kaisuo.png
             * must_cert : 0
             * is_show : 1
             * parent_id : 55
             * must_cert_id : null
             * id : 65
             */

            private String ico_py;
            private String ico_px;
            private String city_value;
            private String biz_type;
            private String biz_name;
            private String certification_classify_name;
            private int sort;
            private String photo_path;
            private String must_cert;
            private String is_show;
            private int parent_id;
            private Object must_cert_id;
            private int id;

            public String getIco_py() {
                return ico_py;
            }

            public void setIco_py(String ico_py) {
                this.ico_py = ico_py;
            }

            public String getIco_px() {
                return ico_px;
            }

            public void setIco_px(String ico_px) {
                this.ico_px = ico_px;
            }

            public String getCity_value() {
                return city_value;
            }

            public void setCity_value(String city_value) {
                this.city_value = city_value;
            }

            public String getBiz_type() {
                return biz_type;
            }

            public void setBiz_type(String biz_type) {
                this.biz_type = biz_type;
            }

            public String getBiz_name() {
                return biz_name;
            }

            public void setBiz_name(String biz_name) {
                this.biz_name = biz_name;
            }

            public String getCertification_classify_name() {
                return certification_classify_name;
            }

            public void setCertification_classify_name(String certification_classify_name) {
                this.certification_classify_name = certification_classify_name;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getPhoto_path() {
                return photo_path;
            }

            public void setPhoto_path(String photo_path) {
                this.photo_path = photo_path;
            }

            public String getMust_cert() {
                return must_cert;
            }

            public void setMust_cert(String must_cert) {
                this.must_cert = must_cert;
            }

            public String getIs_show() {
                return is_show;
            }

            public void setIs_show(String is_show) {
                this.is_show = is_show;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public Object getMust_cert_id() {
                return must_cert_id;
            }

            public void setMust_cert_id(Object must_cert_id) {
                this.must_cert_id = must_cert_id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
