package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class PartWorkBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"total":0,"page":1,"rows":10,"rtList":[]}
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
         * total : 0
         * page : 1
         * rows : 10
         * rtList : []
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

            private String order_title;
            private String create_time_second;
            private String order_status;
            private String order_status_text;
            private int id;
            private String order_desc;
            private String create_time_day;
            private int bid_count;
            private String order_type;
            private String classify_photo_path;
            private String order_price;
            private String area_name_two;

            public String getArea_name_two() {
                return area_name_two;
            }

            public void setArea_name_two(String area_name_two) {
                this.area_name_two = area_name_two;
            }

            public String getOrder_title() {
                return order_title;
            }

            public void setOrder_title(String order_title) {
                this.order_title = order_title;
            }

            public String getCreate_time_second() {
                return create_time_second;
            }

            public void setCreate_time_second(String create_time_second) {
                this.create_time_second = create_time_second;
            }

            public String getOrder_status() {
                return order_status;
            }

            public void setOrder_status(String order_status) {
                this.order_status = order_status;
            }

            public String getOrder_status_text() {
                return order_status_text;
            }

            public void setOrder_status_text(String order_status_text) {
                this.order_status_text = order_status_text;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOrder_desc() {
                return order_desc;
            }

            public void setOrder_desc(String order_desc) {
                this.order_desc = order_desc;
            }

            public String getCreate_time_day() {
                return create_time_day;
            }

            public void setCreate_time_day(String create_time_day) {
                this.create_time_day = create_time_day;
            }

            public int getBid_count() {
                return bid_count;
            }

            public void setBid_count(int bid_count) {
                this.bid_count = bid_count;
            }

            public String getOrder_type() {
                return order_type;
            }

            public void setOrder_type(String order_type) {
                this.order_type = order_type;
            }

            public String getClassify_photo_path() {
                return classify_photo_path;
            }

            public void setClassify_photo_path(String classify_photo_path) {
                this.classify_photo_path = classify_photo_path;
            }

            public String getOrder_price() {
                return order_price;
            }

            public void setOrder_price(String order_price) {
                this.order_price = order_price;
            }

        }

    }
}
