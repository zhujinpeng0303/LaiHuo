package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class PartWorkBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"total":4,"page":1,"rows":10,"rtList":[{"order_title":"道里区-招通下水","create_time":{"date":8,"day":1,"hours":12,"minutes":6,"month":9,"nanos":0,"seconds":6,"time":1538971566000,"timezoneOffset":-480,"year":118},"area_name_two":"哈尔滨-道里区","order_create_time_day":"2018/10/07","order_price":"","order_desc":"开机键","bid_count":2,"classify_photo_path":"classifyIco/tongxiashui.png","order_create_time_second":"13:18:13","to_user_id":1,"id":108,"invite_create_time_text":"2018-10-08 12:06:06","order_id":676,"order_type":"talk_price","from_user_id":1},{"order_title":"道里区-招钟点工","create_time":{"date":5,"day":5,"hours":15,"minutes":55,"month":9,"nanos":0,"seconds":59,"time":1538726159000,"timezoneOffset":-480,"year":118},"area_name_two":"哈尔滨-道里区","order_create_time_day":"2018/10/05","order_price":"","order_desc":"②可还价，token=gggg》创建者，待选择工人","bid_count":4,"classify_photo_path":"classifyIco/zhongdiangong.png","order_create_time_second":"14:36:27","to_user_id":1,"id":106,"invite_create_time_text":"2018-10-05 15:55:59","order_id":634,"order_type":"talk_price","from_user_id":1},{"order_title":"道里区-招家电维修","create_time":{"date":2,"day":2,"hours":13,"minutes":57,"month":9,"nanos":0,"seconds":43,"time":1538459863000,"timezoneOffset":-480,"year":118},"area_name_two":"哈尔滨-道里区","order_create_time_day":"2018/10/02","order_price":"","order_desc":null,"bid_count":0,"classify_photo_path":"classifyIco/jiadianweixiu.png","order_create_time_second":"13:56:51","to_user_id":1,"id":104,"invite_create_time_text":"2018-10-02 13:57:43","order_id":628,"order_type":"talk_price","from_user_id":100015}]}
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
         * total : 4
         * page : 1
         * rows : 10
         * rtList : [{"order_title":"道里区-招通下水","create_time":{"date":8,"day":1,"hours":12,"minutes":6,"month":9,"nanos":0,"seconds":6,"time":1538971566000,"timezoneOffset":-480,"year":118},"area_name_two":"哈尔滨-道里区","order_create_time_day":"2018/10/07","order_price":"","order_desc":"开机键","bid_count":2,"classify_photo_path":"classifyIco/tongxiashui.png","order_create_time_second":"13:18:13","to_user_id":1,"id":108,"invite_create_time_text":"2018-10-08 12:06:06","order_id":676,"order_type":"talk_price","from_user_id":1},{"order_title":"道里区-招钟点工","create_time":{"date":5,"day":5,"hours":15,"minutes":55,"month":9,"nanos":0,"seconds":59,"time":1538726159000,"timezoneOffset":-480,"year":118},"area_name_two":"哈尔滨-道里区","order_create_time_day":"2018/10/05","order_price":"","order_desc":"②可还价，token=gggg》创建者，待选择工人","bid_count":4,"classify_photo_path":"classifyIco/zhongdiangong.png","order_create_time_second":"14:36:27","to_user_id":1,"id":106,"invite_create_time_text":"2018-10-05 15:55:59","order_id":634,"order_type":"talk_price","from_user_id":1},{"order_title":"道里区-招家电维修","create_time":{"date":2,"day":2,"hours":13,"minutes":57,"month":9,"nanos":0,"seconds":43,"time":1538459863000,"timezoneOffset":-480,"year":118},"area_name_two":"哈尔滨-道里区","order_create_time_day":"2018/10/02","order_price":"","order_desc":null,"bid_count":0,"classify_photo_path":"classifyIco/jiadianweixiu.png","order_create_time_second":"13:56:51","to_user_id":1,"id":104,"invite_create_time_text":"2018-10-02 13:57:43","order_id":628,"order_type":"talk_price","from_user_id":100015}]
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
             * order_title : 道里区-招通下水
             * create_time : {"date":8,"day":1,"hours":12,"minutes":6,"month":9,"nanos":0,"seconds":6,"time":1538971566000,"timezoneOffset":-480,"year":118}
             * area_name_two : 哈尔滨-道里区
             * order_create_time_day : 2018/10/07
             * order_price :
             * order_desc : 开机键
             * bid_count : 2
             * classify_photo_path : classifyIco/tongxiashui.png
             * order_create_time_second : 13:18:13
             * to_user_id : 1
             * id : 108
             * invite_create_time_text : 2018-10-08 12:06:06
             * order_id : 676
             * order_type : talk_price
             * from_user_id : 1
             */

            private String order_title;
            private CreateTimeBean create_time;
            private String area_name_two;
            private String order_create_time_day;
            private String order_price;
            private String order_desc;
            private int bid_count;
            private String classify_photo_path;
            private String order_create_time_second;
            private int to_user_id;
            private int id;
            private String invite_create_time_text;
            private int order_id;
            private String order_type;
            private int from_user_id;

            public String getOrder_title() {
                return order_title;
            }

            public void setOrder_title(String order_title) {
                this.order_title = order_title;
            }

            public CreateTimeBean getCreate_time() {
                return create_time;
            }

            public void setCreate_time(CreateTimeBean create_time) {
                this.create_time = create_time;
            }

            public String getArea_name_two() {
                return area_name_two;
            }

            public void setArea_name_two(String area_name_two) {
                this.area_name_two = area_name_two;
            }

            public String getOrder_create_time_day() {
                return order_create_time_day;
            }

            public void setOrder_create_time_day(String order_create_time_day) {
                this.order_create_time_day = order_create_time_day;
            }

            public String getOrder_price() {
                return order_price;
            }

            public void setOrder_price(String order_price) {
                this.order_price = order_price;
            }

            public String getOrder_desc() {
                return order_desc;
            }

            public void setOrder_desc(String order_desc) {
                this.order_desc = order_desc;
            }

            public int getBid_count() {
                return bid_count;
            }

            public void setBid_count(int bid_count) {
                this.bid_count = bid_count;
            }

            public String getClassify_photo_path() {
                return classify_photo_path;
            }

            public void setClassify_photo_path(String classify_photo_path) {
                this.classify_photo_path = classify_photo_path;
            }

            public String getOrder_create_time_second() {
                return order_create_time_second;
            }

            public void setOrder_create_time_second(String order_create_time_second) {
                this.order_create_time_second = order_create_time_second;
            }

            public int getTo_user_id() {
                return to_user_id;
            }

            public void setTo_user_id(int to_user_id) {
                this.to_user_id = to_user_id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getInvite_create_time_text() {
                return invite_create_time_text;
            }

            public void setInvite_create_time_text(String invite_create_time_text) {
                this.invite_create_time_text = invite_create_time_text;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public String getOrder_type() {
                return order_type;
            }

            public void setOrder_type(String order_type) {
                this.order_type = order_type;
            }

            public int getFrom_user_id() {
                return from_user_id;
            }

            public void setFrom_user_id(int from_user_id) {
                this.from_user_id = from_user_id;
            }

            public static class CreateTimeBean {
                /**
                 * date : 8
                 * day : 1
                 * hours : 12
                 * minutes : 6
                 * month : 9
                 * nanos : 0
                 * seconds : 6
                 * time : 1538971566000
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
