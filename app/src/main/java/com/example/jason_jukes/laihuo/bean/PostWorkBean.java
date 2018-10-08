package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class PostWorkBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataArr : [{"order_title":"道里区-招通下水","create_time_second":"09:55","order_status":"1","order_status_text":"询价中","id":612,"order_desc":"内容","create_time_day":"09/30","bid_count":1,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招开锁修锁","create_time_second":"14:26","order_status":"1","order_status_text":"未抢单","order_price":0,"id":4,"order_desc":"工单描述","create_time_day":"09/30","bid_count":0,"order_type":"unlock_company","classify_photo_path":"classifyIco/kaisuo.png"},{"order_title":"道里区-招开锁修锁","create_time_second":"14:26","order_status":"1","order_status_text":"未抢单","order_price":0,"id":3,"order_desc":"工单描述","create_time_day":"09/30","bid_count":0,"order_type":"unlock_company","classify_photo_path":"classifyIco/kaisuo.png"},{"order_title":"道里区-招月嫂","create_time_second":"14:07","order_status":"9","order_status_text":"已取消","id":613,"order_desc":"内容","create_time_day":"09/30","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/yuesao.png"}]
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
         * order_title : 道里区-招通下水
         * create_time_second : 09:55
         * order_status : 1
         * order_status_text : 询价中
         * id : 612
         * order_desc : 内容
         * create_time_day : 09/30
         * bid_count : 1
         * order_type : talk_price
         * classify_photo_path : classifyIco/tongxiashui.png
         * order_price : 0
         */

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
        private String order_desc_pics;
        private double order_price;

        public String getOrder_desc_pics() {
            return order_desc_pics;
        }

        public void setOrder_desc_pics(String order_desc_pics) {
            this.order_desc_pics = order_desc_pics;
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

        public double getOrder_price() {
            return order_price;
        }

        public void setOrder_price(int order_price) {
            this.order_price = order_price;
        }
    }
}
