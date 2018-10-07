package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/3 0003.
 */

public class HomeBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"bannerList":[{"create_time":{"date":12,"day":3,"hours":18,"minutes":41,"month":8,"nanos":0,"seconds":55,"time":1536748915000,"timezoneOffset":-480,"year":118},"img_url":"businessBannerImg/d1.png","city_value":"haerbin","id":66,"href":"","sort":4,"title":"本平台所有资金委托第三方支付机构（中投科信）监管","status":"1"}],"cityIndexMap":{"city_name":"哈尔滨","count_workers":1,"city_value":"haerbin","count_wait_selectuser_order":12}}
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
         * bannerList : [{"create_time":{"date":12,"day":3,"hours":18,"minutes":41,"month":8,"nanos":0,"seconds":55,"time":1536748915000,"timezoneOffset":-480,"year":118},"img_url":"businessBannerImg/d1.png","city_value":"haerbin","id":66,"href":"","sort":4,"title":"本平台所有资金委托第三方支付机构（中投科信）监管","status":"1"}]
         * cityIndexMap : {"city_name":"哈尔滨","count_workers":1,"city_value":"haerbin","count_wait_selectuser_order":12}
         */

        private CityIndexMapBean cityIndexMap;
        private List<BannerListBean> bannerList;

        public CityIndexMapBean getCityIndexMap() {
            return cityIndexMap;
        }

        public void setCityIndexMap(CityIndexMapBean cityIndexMap) {
            this.cityIndexMap = cityIndexMap;
        }

        public List<BannerListBean> getBannerList() {
            return bannerList;
        }

        public void setBannerList(List<BannerListBean> bannerList) {
            this.bannerList = bannerList;
        }

        public static class CityIndexMapBean {
            /**
             * city_name : 哈尔滨
             * count_workers : 1
             * city_value : haerbin
             * count_wait_selectuser_order : 12
             */

            private String city_name;
            private int count_workers;
            private String city_value;
            private int count_wait_selectuser_order;

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public int getCount_workers() {
                return count_workers;
            }

            public void setCount_workers(int count_workers) {
                this.count_workers = count_workers;
            }

            public String getCity_value() {
                return city_value;
            }

            public void setCity_value(String city_value) {
                this.city_value = city_value;
            }

            public int getCount_wait_selectuser_order() {
                return count_wait_selectuser_order;
            }

            public void setCount_wait_selectuser_order(int count_wait_selectuser_order) {
                this.count_wait_selectuser_order = count_wait_selectuser_order;
            }
        }

        public static class BannerListBean {
            /**
             * create_time : {"date":12,"day":3,"hours":18,"minutes":41,"month":8,"nanos":0,"seconds":55,"time":1536748915000,"timezoneOffset":-480,"year":118}
             * img_url : businessBannerImg/d1.png
             * city_value : haerbin
             * id : 66
             * href :
             * sort : 4
             * title : 本平台所有资金委托第三方支付机构（中投科信）监管
             * status : 1
             */

            private CreateTimeBean create_time;
            private String img_url;
            private String city_value;
            private int id;
            private String href;
            private int sort;
            private String title;
            private String status;

            public CreateTimeBean getCreate_time() {
                return create_time;
            }

            public void setCreate_time(CreateTimeBean create_time) {
                this.create_time = create_time;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getCity_value() {
                return city_value;
            }

            public void setCity_value(String city_value) {
                this.city_value = city_value;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public static class CreateTimeBean {
                /**
                 * date : 12
                 * day : 3
                 * hours : 18
                 * minutes : 41
                 * month : 8
                 * nanos : 0
                 * seconds : 55
                 * time : 1536748915000
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
