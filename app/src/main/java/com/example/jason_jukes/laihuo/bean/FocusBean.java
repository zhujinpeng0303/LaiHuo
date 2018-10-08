package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class FocusBean {

    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"total":2,"page":1,"rows":10,"rtList":[{"pay_pass":"323EE81C6B807724147ACEA9C159A148","create_time":{"date":30,"day":0,"hours":10,"minutes":0,"month":8,"nanos":0,"seconds":31,"time":1538272831000,"timezoneOffset":-480,"year":118},"openid":"oM7Rr5aW2YSPj6uctAU6X0EuaIe4","city_value":"haerbin","money_yue":0.03,"num_funs":1,"referee_user_id":"0","phoneno":"18545523468","create_time_text":"2018-09-30 10:00:31","score":5,"head_url":"https://image.lhservice.hrbyuantu.com/userXcxHead/0000.png","acctno":"00110000000010308924","to_user_id":100015,"is_worker":"0","bind_idcard":"1","merid":"CM2000666954","ranking_last":"4.0","id":72,"from_user_id":1,"username":"未设置","num_subscribe":0,"is_logout":"0"},{"birthday":"","city_value":"haerbin","num_funs":1,"zuobiao_x":126.6692504883,"zuobiao_y":45.7732887268,"score":0,"head_url":"https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132","merid":"CM2000666896","ranking_last":"0.0","id":71,"head_url_png":"userXcxHead/100011.png","from_user_id":1,"num_subscribe":0,"pay_pass":"323EE81C6B807724147ACEA9C159A148","create_time":{"date":30,"day":0,"hours":9,"minutes":43,"month":8,"nanos":0,"seconds":25,"time":1538271805000,"timezoneOffset":-480,"year":118},"openid":"oM7Rr5SwHIUZpgW5p1v5Tqc4qsWI","money_yue":0,"referee_user_id":"0","phoneno":"13351273451","create_time_text":"2018-09-30 09:43:25","acctno":"00110000000010308920","to_user_id":100011,"is_worker":"1","bind_idcard":"1","username":"张槟冰","is_logout":"0"}]}
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
         * total : 2
         * page : 1
         * rows : 10
         * rtList : [{"pay_pass":"323EE81C6B807724147ACEA9C159A148","create_time":{"date":30,"day":0,"hours":10,"minutes":0,"month":8,"nanos":0,"seconds":31,"time":1538272831000,"timezoneOffset":-480,"year":118},"openid":"oM7Rr5aW2YSPj6uctAU6X0EuaIe4","city_value":"haerbin","money_yue":0.03,"num_funs":1,"referee_user_id":"0","phoneno":"18545523468","create_time_text":"2018-09-30 10:00:31","score":5,"head_url":"https://image.lhservice.hrbyuantu.com/userXcxHead/0000.png","acctno":"00110000000010308924","to_user_id":100015,"is_worker":"0","bind_idcard":"1","merid":"CM2000666954","ranking_last":"4.0","id":72,"from_user_id":1,"username":"未设置","num_subscribe":0,"is_logout":"0"},{"birthday":"","city_value":"haerbin","num_funs":1,"zuobiao_x":126.6692504883,"zuobiao_y":45.7732887268,"score":0,"head_url":"https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132","merid":"CM2000666896","ranking_last":"0.0","id":71,"head_url_png":"userXcxHead/100011.png","from_user_id":1,"num_subscribe":0,"pay_pass":"323EE81C6B807724147ACEA9C159A148","create_time":{"date":30,"day":0,"hours":9,"minutes":43,"month":8,"nanos":0,"seconds":25,"time":1538271805000,"timezoneOffset":-480,"year":118},"openid":"oM7Rr5SwHIUZpgW5p1v5Tqc4qsWI","money_yue":0,"referee_user_id":"0","phoneno":"13351273451","create_time_text":"2018-09-30 09:43:25","acctno":"00110000000010308920","to_user_id":100011,"is_worker":"1","bind_idcard":"1","username":"张槟冰","is_logout":"0"}]
         */

        private int total;
        private int page;
        private int rows;
        private List<RtListBean> rtList;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public List<RtListBean> getRtList() {
            return rtList;
        }

        public void setRtList(List<RtListBean> rtList) {
            this.rtList = rtList;
        }

        public static class RtListBean {
            /**
             * pay_pass : 323EE81C6B807724147ACEA9C159A148
             * create_time : {"date":30,"day":0,"hours":10,"minutes":0,"month":8,"nanos":0,"seconds":31,"time":1538272831000,"timezoneOffset":-480,"year":118}
             * openid : oM7Rr5aW2YSPj6uctAU6X0EuaIe4
             * city_value : haerbin
             * money_yue : 0.03
             * num_funs : 1
             * referee_user_id : 0
             * phoneno : 18545523468
             * create_time_text : 2018-09-30 10:00:31
             * score : 5
             * head_url : https://image.lhservice.hrbyuantu.com/userXcxHead/0000.png
             * acctno : 00110000000010308924
             * to_user_id : 100015
             * is_worker : 0
             * bind_idcard : 1
             * merid : CM2000666954
             * ranking_last : 4.0
             * id : 72
             * from_user_id : 1
             * username : 未设置
             * num_subscribe : 0
             * is_logout : 0
             * birthday :
             * zuobiao_x : 126.6692504883
             * zuobiao_y : 45.7732887268
             * head_url_png : userXcxHead/100011.png
             */

            private String pay_pass;
            private CreateTimeBean create_time;
            private String openid;
            private String city_value;
            private double money_yue;
            private int num_funs;
            private String referee_user_id;
            private String phoneno;
            private String create_time_text;
            private int score;
            private String head_url;
            private String acctno;
            private int to_user_id;
            private String is_worker;
            private String bind_idcard;
            private String merid;
            private String ranking_last;
            private int id;
            private int from_user_id;
            private String username;
            private int num_subscribe;
            private String is_logout;
            private String birthday;
            private double zuobiao_x;
            private double zuobiao_y;
            private String head_url_png;

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

            public String getCity_value() {
                return city_value;
            }

            public void setCity_value(String city_value) {
                this.city_value = city_value;
            }

            public double getMoney_yue() {
                return money_yue;
            }

            public void setMoney_yue(double money_yue) {
                this.money_yue = money_yue;
            }

            public int getNum_funs() {
                return num_funs;
            }

            public void setNum_funs(int num_funs) {
                this.num_funs = num_funs;
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

            public String getCreate_time_text() {
                return create_time_text;
            }

            public void setCreate_time_text(String create_time_text) {
                this.create_time_text = create_time_text;
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

            public String getAcctno() {
                return acctno;
            }

            public void setAcctno(String acctno) {
                this.acctno = acctno;
            }

            public int getTo_user_id() {
                return to_user_id;
            }

            public void setTo_user_id(int to_user_id) {
                this.to_user_id = to_user_id;
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

            public int getFrom_user_id() {
                return from_user_id;
            }

            public void setFrom_user_id(int from_user_id) {
                this.from_user_id = from_user_id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getNum_subscribe() {
                return num_subscribe;
            }

            public void setNum_subscribe(int num_subscribe) {
                this.num_subscribe = num_subscribe;
            }

            public String getIs_logout() {
                return is_logout;
            }

            public void setIs_logout(String is_logout) {
                this.is_logout = is_logout;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
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

            public String getHead_url_png() {
                return head_url_png;
            }

            public void setHead_url_png(String head_url_png) {
                this.head_url_png = head_url_png;
            }

            public static class CreateTimeBean {
                /**
                 * date : 30
                 * day : 0
                 * hours : 10
                 * minutes : 0
                 * month : 8
                 * nanos : 0
                 * seconds : 31
                 * time : 1538272831000
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
}
