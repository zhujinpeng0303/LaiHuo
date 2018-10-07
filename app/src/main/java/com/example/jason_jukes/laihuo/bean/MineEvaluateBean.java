package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class MineEvaluateBean {

    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"total":1,"page":1,"rows":10,"rtList":[{"ranking_attitude":3,"create_time":{"date":2,"day":2,"hours":13,"minutes":38,"month":9,"nanos":0,"seconds":17,"time":1538458697000,"timezoneOffset":-480,"year":118},"ranking_quality":2,"create_time_text":"2018-10-02 13:38:17","head_url":"https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132","work_order_id":624,"to_user_id":1,"ranking_last":5,"id":88,"ranking_quick":1,"from_user_id":100018,"ranking_text":"还不错","username":"葛国龙"}]}
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
         * total : 1
         * page : 1
         * rows : 10
         * rtList : [{"ranking_attitude":3,"create_time":{"date":2,"day":2,"hours":13,"minutes":38,"month":9,"nanos":0,"seconds":17,"time":1538458697000,"timezoneOffset":-480,"year":118},"ranking_quality":2,"create_time_text":"2018-10-02 13:38:17","head_url":"https://wx.qlogo.cn/mmopen/vi_32/ZoCv9TibmVrTwZnsvxkl7D3TGBchHIvPdoxUWkyP8fZazQIjNU8RREYmIhPXcprKicBgOhCc4ZPpwPHAEykrZjvA/132","work_order_id":624,"to_user_id":1,"ranking_last":5,"id":88,"ranking_quick":1,"from_user_id":100018,"ranking_text":"还不错","username":"葛国龙"}]
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

            private int ranking_attitude;
            private CreateTimeBean create_time;
            private int ranking_quality;
            private String create_time_text;
            private String head_url;
            private int work_order_id;
            private int to_user_id;
            private double ranking_last;
            private int id;
            private int ranking_quick;
            private int from_user_id;
            private String ranking_text;
            private String username;

            public int getRanking_attitude() {
                return ranking_attitude;
            }

            public void setRanking_attitude(int ranking_attitude) {
                this.ranking_attitude = ranking_attitude;
            }

            public CreateTimeBean getCreate_time() {
                return create_time;
            }

            public void setCreate_time(CreateTimeBean create_time) {
                this.create_time = create_time;
            }

            public int getRanking_quality() {
                return ranking_quality;
            }

            public void setRanking_quality(int ranking_quality) {
                this.ranking_quality = ranking_quality;
            }

            public String getCreate_time_text() {
                return create_time_text;
            }

            public void setCreate_time_text(String create_time_text) {
                this.create_time_text = create_time_text;
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

            public int getTo_user_id() {
                return to_user_id;
            }

            public void setTo_user_id(int to_user_id) {
                this.to_user_id = to_user_id;
            }

            public double getRanking_last() {
                return ranking_last;
            }

            public void setRanking_last(int ranking_last) {
                this.ranking_last = ranking_last;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getRanking_quick() {
                return ranking_quick;
            }

            public void setRanking_quick(int ranking_quick) {
                this.ranking_quick = ranking_quick;
            }

            public int getFrom_user_id() {
                return from_user_id;
            }

            public void setFrom_user_id(int from_user_id) {
                this.from_user_id = from_user_id;
            }

            public String getRanking_text() {
                return ranking_text;
            }

            public void setRanking_text(String ranking_text) {
                this.ranking_text = ranking_text;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public static class CreateTimeBean {
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
    }
}
