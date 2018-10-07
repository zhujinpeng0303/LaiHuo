package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/4 0004.
 */

public class NearbyPersonBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataArr : [{"birthday":"","city_value":"haerbin","latitude":45.7732887268,"num_funs":5,"zuobiao_x":126.6692504883,"zuobiao_y":45.7732887268,"score":0,"head_url":"https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132","merid":"CM2000666896","ranking_last":"0.0","id":100011,"referee_code":null,"head_url_png":"userXcxHead/100011.png","num_subscribe":0,"token_str":null,"token_time":null,"longitude":126.6692504883,"pay_pass":"323EE81C6B807724147ACEA9C159A148","create_time":{"date":1,"day":1,"hours":18,"minutes":39,"month":9,"nanos":0,"seconds":6,"time":1538390346000,"timezoneOffset":-480,"year":118},"openid":"oM7Rr5SwHIUZpgW5p1v5Tqc4qsWI","sex":null,"money_yue":0,"referee_user_id":"0","phoneno":"13351273451","acctno":"00110000000010308920","is_worker":"1","bind_idcard":"1","name":"张槟冰","juli":15313,"iconPath":"https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132","username":"张槟冰","is_logout":"0"}]
     */

    private String errorCode;
    private String errorMsg;
    private List<DataArrBean> dataArr;

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

    public List<DataArrBean> getDataArr() {
        return dataArr;
    }

    public void setDataArr(List<DataArrBean> dataArr) {
        this.dataArr = dataArr;
    }

    public static class DataArrBean {
        /**
         * birthday :
         * city_value : haerbin
         * latitude : 45.7732887268
         * num_funs : 5
         * zuobiao_x : 126.6692504883
         * zuobiao_y : 45.7732887268
         * score : 0
         * head_url : https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132
         * merid : CM2000666896
         * ranking_last : 0.0
         * id : 100011
         * referee_code : null
         * head_url_png : userXcxHead/100011.png
         * num_subscribe : 0
         * token_str : null
         * token_time : null
         * longitude : 126.6692504883
         * pay_pass : 323EE81C6B807724147ACEA9C159A148
         * create_time : {"date":1,"day":1,"hours":18,"minutes":39,"month":9,"nanos":0,"seconds":6,"time":1538390346000,"timezoneOffset":-480,"year":118}
         * openid : oM7Rr5SwHIUZpgW5p1v5Tqc4qsWI
         * sex : null
         * money_yue : 0
         * referee_user_id : 0
         * phoneno : 13351273451
         * acctno : 00110000000010308920
         * is_worker : 1
         * bind_idcard : 1
         * name : 张槟冰
         * juli : 15313
         * iconPath : https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132
         * username : 张槟冰
         * is_logout : 0
         */

        private String birthday;
        private String city_value;
        private double latitude;
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
        private double longitude;
        private String pay_pass;
        private CreateTimeBean create_time;
        private String openid;
        private Object sex;
        private double money_yue;
        private String referee_user_id;
        private String phoneno;
        private String acctno;
        private String is_worker;
        private String bind_idcard;
        private String name;
        private int juli;
        private String iconPath;
        private String username;
        private String is_logout;

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

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
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

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
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

        public String getAcctno() {
            return acctno;
        }

        public void setAcctno(String acctno) {
            this.acctno = acctno;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getJuli() {
            return juli;
        }

        public void setJuli(int juli) {
            this.juli = juli;
        }

        public String getIconPath() {
            return iconPath;
        }

        public void setIconPath(String iconPath) {
            this.iconPath = iconPath;
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

        public static class CreateTimeBean {
            /**
             * date : 1
             * day : 1
             * hours : 18
             * minutes : 39
             * month : 9
             * nanos : 0
             * seconds : 6
             * time : 1538390346000
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
}
