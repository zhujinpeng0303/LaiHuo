package com.example.jason_jukes.laihuo.bean;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by Administrator on 2018/10/3 0003.
 */

public class MineQuaBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataArr : [{"create_time_text":"2018-10-02 13:42:12","cert_title":"专业维修宇宙飞船","create_time":{"date":2,"day":2,"hours":13,"minutes":42,"month":9,"nanos":0,"seconds":12,"time":1538458932000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"workOrderDesc/workOrderDesc-AlbvhpYVCwUH.jpg","id":113},{"create_time_text":"2018-10-03 10:04:34","cert_title":"这个","create_time":{"date":3,"day":3,"hours":10,"minutes":4,"month":9,"nanos":0,"seconds":34,"time":1538532274000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png","id":115},{"create_time_text":"2018-10-03 10:27:44","cert_title":"谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了谁啊，咋地了","create_time":{"date":3,"day":3,"hours":10,"minutes":27,"month":9,"nanos":0,"seconds":44,"time":1538533664000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png","id":116},{"create_time_text":"2018-10-03 10:42:08","cert_title":"不知道","create_time":{"date":3,"day":3,"hours":10,"minutes":42,"month":9,"nanos":0,"seconds":8,"time":1538534528000,"timezoneOffset":-480,"year":118},"user_id":1,"cert_imgs":"userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png,userBbsImage/userBbsImage-stTKZXtbLnNU.png","id":118}]
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
         * create_time_text : 2018-10-02 13:42:12
         * cert_title : 专业维修宇宙飞船
         * create_time : {"date":2,"day":2,"hours":13,"minutes":42,"month":9,"nanos":0,"seconds":12,"time":1538458932000,"timezoneOffset":-480,"year":118}
         * user_id : 1
         * cert_imgs : workOrderDesc/workOrderDesc-AlbvhpYVCwUH.jpg
         * id : 113
         */

        private String create_time_text;
        private String cert_title;
        private CreateTimeBean create_time;
        private int user_id;
        private String cert_imgs;
        private int id;

        public String getCreate_time_text() {
            return create_time_text;
        }

        public void setCreate_time_text(String create_time_text) {
            this.create_time_text = create_time_text;
        }

        public String getCert_title() {
            return cert_title;
        }

        public void setCert_title(String cert_title) {
            this.cert_title = cert_title;
        }

        public CreateTimeBean getCreate_time() {
            return create_time;
        }

        public void setCreate_time(CreateTimeBean create_time) {
            this.create_time = create_time;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getCert_imgs() {
            return cert_imgs;
        }

        public void setCert_imgs(String cert_imgs) {
            this.cert_imgs = cert_imgs;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static class CreateTimeBean {
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
