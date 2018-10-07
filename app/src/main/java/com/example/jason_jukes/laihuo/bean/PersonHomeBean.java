package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class PersonHomeBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"birthday":"","city_value":"haerbin","num_funs":2,"zuobiao_x":126.5921173096,"zuobiao_y":45.7028007507,"score":5,"head_url":"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132","rankingList":[{"ranking_attitude":3,"create_time":{"date":2,"day":2,"hours":13,"minutes":38,"month":9,"nanos":0,"seconds":17,"time":1538458697000,"timezoneOffset":-480,"year":118},"ranking_quality":2,"create_time_text":"2018-10-02 13:38:17","head_url":"https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132","work_order_id":624,"to_user_id":1,"ranking_last":5,"id":88,"ranking_quick":1,"from_user_id":100018,"ranking_text":"还不错","username":"葛国龙"}],"isMySubscribe":0,"merid":"CM2000666988","ranking_last":"5.0","id":1,"referee_code":"EGRIRY","isMyFuns":0,"head_url_png":"userXcxHead/100017.png","num_subscribe":9,"token_str":null,"token_time":null,"pay_pass":"323EE81C6B807724147ACEA9C159A148","create_time":{"date":3,"day":3,"hours":12,"minutes":58,"month":9,"nanos":0,"seconds":31,"time":1538542711000,"timezoneOffset":-480,"year":118},"openid":"oM7Rr5QIJklM0o00DBR-VZi-1WzU","sex":null,"money_yue":0.91,"referee_user_id":"0","phoneno":"18346019592","area_names":null,"work_names":"开锁修锁,推荐分类","acctno":"00110000000010308968","def_classify_id":65,"def_area_id":null,"is_worker":"0","bind_idcard":"1","userCustomCertList":[{"create_time_text":"2018-10-02 13:42:12","cert_title":"专业维修宇宙飞船","create_time":{"date":2,"day":2,"hours":13,"minutes":42,"month":9,"nanos":0,"seconds":12,"time":1538458932000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"workOrderDesc/workOrderDesc-AlbvhpYVCwUH.jpg","id":113},{"create_time_text":"2018-10-03 10:04:34","cert_title":"这个","create_time":{"date":3,"day":3,"hours":10,"minutes":4,"month":9,"nanos":0,"seconds":34,"time":1538532274000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png","id":115},{"create_time_text":"2018-10-03 10:27:44","cert_title":"谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了","create_time":{"date":3,"day":3,"hours":10,"minutes":27,"month":9,"nanos":0,"seconds":44,"time":1538533664000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png","id":116},{"create_time_text":"2018-10-03 10:42:08","cert_title":"不知道","create_time":{"date":3,"day":3,"hours":10,"minutes":42,"month":9,"nanos":0,"seconds":8,"time":1538534528000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png","id":118}],"username":"GGGG","is_logout":"0","ranking_text":"5.0000,1.0000,2.0000,3.0000"}
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
         * city_value : haerbin
         * num_funs : 2
         * zuobiao_x : 126.5921173096
         * zuobiao_y : 45.7028007507
         * score : 5
         * head_url : https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132
         * rankingList : [{"ranking_attitude":3,"create_time":{"date":2,"day":2,"hours":13,"minutes":38,"month":9,"nanos":0,"seconds":17,"time":1538458697000,"timezoneOffset":-480,"year":118},"ranking_quality":2,"create_time_text":"2018-10-02 13:38:17","head_url":"https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132","work_order_id":624,"to_user_id":1,"ranking_last":5,"id":88,"ranking_quick":1,"from_user_id":100018,"ranking_text":"还不错","username":"葛国龙"}]
         * isMySubscribe : 0
         * merid : CM2000666988
         * ranking_last : 5.0
         * id : 1
         * referee_code : EGRIRY
         * isMyFuns : 0
         * head_url_png : userXcxHead/100017.png
         * num_subscribe : 9
         * token_str : null
         * token_time : null
         * pay_pass : 323EE81C6B807724147ACEA9C159A148
         * create_time : {"date":3,"day":3,"hours":12,"minutes":58,"month":9,"nanos":0,"seconds":31,"time":1538542711000,"timezoneOffset":-480,"year":118}
         * openid : oM7Rr5QIJklM0o00DBR-VZi-1WzU
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
         * userCustomCertList : [{"create_time_text":"2018-10-02 13:42:12","cert_title":"专业维修宇宙飞船","create_time":{"date":2,"day":2,"hours":13,"minutes":42,"month":9,"nanos":0,"seconds":12,"time":1538458932000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"workOrderDesc/workOrderDesc-AlbvhpYVCwUH.jpg","id":113},{"create_time_text":"2018-10-03 10:04:34","cert_title":"这个","create_time":{"date":3,"day":3,"hours":10,"minutes":4,"month":9,"nanos":0,"seconds":34,"time":1538532274000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png","id":115},{"create_time_text":"2018-10-03 10:27:44","cert_title":"谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了","create_time":{"date":3,"day":3,"hours":10,"minutes":27,"month":9,"nanos":0,"seconds":44,"time":1538533664000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png","id":116},{"create_time_text":"2018-10-03 10:42:08","cert_title":"不知道","create_time":{"date":3,"day":3,"hours":10,"minutes":42,"month":9,"nanos":0,"seconds":8,"time":1538534528000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png","id":118}]
         * username : GGGG
         * is_logout : 0
         * ranking_text : 5.0000,1.0000,2.0000,3.0000
         */

        private String birthday;
        private String city_value;
        private int num_funs;
        private double zuobiao_x;
        private double zuobiao_y;
        private int score;
        private String head_url;
        private int isMySubscribe;
        private String merid;
        private String ranking_last;
        private int id;
        private String referee_code;
        private int isMyFuns;
        private String head_url_png;
        private int num_subscribe;
        private Object token_str;
        private Object token_time;
        private String pay_pass;
        private CreateTimeBean create_time;
        private String openid;
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
        private String username;
        private String is_logout;
        private String ranking_text;
        private List<RankingListBean> rankingList;
        private List<UserCustomCertListBean> userCustomCertList;

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

        public int getIsMySubscribe() {
            return isMySubscribe;
        }

        public void setIsMySubscribe(int isMySubscribe) {
            this.isMySubscribe = isMySubscribe;
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

        public int getIsMyFuns() {
            return isMyFuns;
        }

        public void setIsMyFuns(int isMyFuns) {
            this.isMyFuns = isMyFuns;
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

        public List<RankingListBean> getRankingList() {
            return rankingList;
        }

        public void setRankingList(List<RankingListBean> rankingList) {
            this.rankingList = rankingList;
        }

        public List<UserCustomCertListBean> getUserCustomCertList() {
            return userCustomCertList;
        }

        public void setUserCustomCertList(List<UserCustomCertListBean> userCustomCertList) {
            this.userCustomCertList = userCustomCertList;
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

        public static class RankingListBean extends MineEvaluateBean.DataObjBean.RtListBean {
            /**
             * ranking_attitude : 3
             * create_time : {"date":2,"day":2,"hours":13,"minutes":38,"month":9,"nanos":0,"seconds":17,"time":1538458697000,"timezoneOffset":-480,"year":118}
             * ranking_quality : 2
             * create_time_text : 2018-10-02 13:38:17
             * head_url : https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132
             * work_order_id : 624
             * to_user_id : 1
             * ranking_last : 5
             * id : 88
             * ranking_quick : 1
             * from_user_id : 100018
             * ranking_text : 还不错
             * username : 葛国龙
             */

//            private transient int ranking_attitude;
//            private transient CreateTimeBean create_time;
//            private transient int ranking_quality;
//            private transient String create_time_text;
//            private transient String head_url;
//            private transient int work_order_id;
//            private transient int to_user_id;
//            private transient double ranking_last;
//            private transient int id;
//            private transient int ranking_quick;
//            private transient int from_user_id;
//            private  transient String ranking_text;
//            private transient String username;

//            public int getRanking_attitude() {
//                return ranking_attitude;
//            }
//
//            public void setRanking_attitude(int ranking_attitude) {
//                this.ranking_attitude = ranking_attitude;
//            }
//
//            public CreateTimeBean getCreate_time() {
//                return create_time;
//            }
//
//            public void setCreate_time(CreateTimeBean create_time) {
//                this.create_time = create_time;
//            }
//
//            public int getRanking_quality() {
//                return ranking_quality;
//            }
//
//            public void setRanking_quality(int ranking_quality) {
//                this.ranking_quality = ranking_quality;
//            }

//            public String getCreate_time_text() {
//                return create_time_text;
//            }

//            public void setCreate_time_text(String create_time_text) {
//                this.create_time_text = create_time_text;
//            }

//            public String getHead_url() {
//                return head_url;
//            }
//
//            public void setHead_url(String head_url) {
//                this.head_url = head_url;
//            }
//
//            public int getWork_order_id() {
//                return work_order_id;
//            }
//
//            public void setWork_order_id(int work_order_id) {
//                this.work_order_id = work_order_id;
//            }
//
//            public int getTo_user_id() {
//                return to_user_id;
//            }
//
//            public void setTo_user_id(int to_user_id) {
//                this.to_user_id = to_user_id;
//            }
//
//            public double getRanking_last() {
//                return ranking_last;
//            }
//
//            public void setRanking_last(double ranking_last) {
//                this.ranking_last = ranking_last;
//            }
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }
//
//            public int getRanking_quick() {
//                return ranking_quick;
//            }
//
//            public void setRanking_quick(int ranking_quick) {
//                this.ranking_quick = ranking_quick;
//            }
//
//            public int getFrom_user_id() {
//                return from_user_id;
//            }
//
//            public void setFrom_user_id(int from_user_id) {
//                this.from_user_id = from_user_id;
//            }
//
//            public String getRanking_text() {
//                return ranking_text;
//            }
//
//            public void setRanking_text(String ranking_text) {
//                this.ranking_text = ranking_text;
//            }
//
//            public String getUsername() {
//                return username;
//            }
//
//            public void setUsername(String username) {
//                this.username = username;
//            }

            public static class CreateTimeBeanX {
                /**
                 * date : 2
                 * day : 2
                 * hours : 13
                 * minutes : 38
                 * month : 9
                 * nanos : 0
                 * seconds : 17
                 * time : 1538458697000
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

        public static class UserCustomCertListBean extends MineQuaBean.DataArrBean {
            /**
             * create_time_text : 2018-10-02 13:42:12
             * cert_title : 专业维修宇宙飞船
             * create_time : {"date":2,"day":2,"hours":13,"minutes":42,"month":9,"nanos":0,"seconds":12,"time":1538458932000,"timezoneOffset":-480,"year":118}
             * user_id : 1
             * cert_imgs : workOrderDesc/workOrderDesc-AlbvhpYVCwUH.jpg
             * id : 113
             */

//            private String create_time_text;
//            private String cert_title;
//            private CreateTimeBean create_time;
//            private int user_id;
//            private String cert_imgs;
//            private int id;

//            public String getCreate_time_text() {
//                return create_time_text;
//            }
//
//            public void setCreate_time_text(String create_time_text) {
//                this.create_time_text = create_time_text;
//            }
//
//            public String getCert_title() {
//                return cert_title;
//            }
//
//            public void setCert_title(String cert_title) {
//                this.cert_title = cert_title;
//            }
//
//            public CreateTimeBean getCreate_time() {
//                return create_time;
//            }
//
//            public void setCreate_time(CreateTimeBean create_time) {
//                this.create_time = create_time;
//            }
//
//            public int getUser_id() {
//                return user_id;
//            }
//
//            public void setUser_id(int user_id) {
//                this.user_id = user_id;
//            }
//
//            public String getCert_imgs() {
//                return cert_imgs;
//            }
//
//            public void setCert_imgs(String cert_imgs) {
//                this.cert_imgs = cert_imgs;
//            }
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }

            public static class CreateTimeBeanXX {
                /**
                 * date : 2
                 * day : 2
                 * hours : 13
                 * minutes : 42
                 * month : 9
                 * nanos : 0
                 * seconds : 12
                 * time : 1538458932000
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
