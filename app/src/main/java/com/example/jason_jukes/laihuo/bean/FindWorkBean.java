package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/2 0002.
 */

public class FindWorkBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"total":11,"page":1,"rows":10,"rtList":[{"order_title":"道里区-招家电维修","create_time_second":"13:56:51","order_status":"1","order_status_text":"未接单","area_name_two":"哈尔滨-道里区","order_desc_pics":"","id":628,"order_desc":"测试","create_time_day":"2018/10/02","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/jiadianweixiu.png"},{"order_title":"道里区-招通下水","create_time_second":"13:53:32","order_status":"1","order_status_text":"未接单","area_name_two":"哈尔滨-道里区","order_desc_pics":"","id":627,"order_desc":"李伟1","create_time_day":"2018/10/02","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招通下水","create_time_second":"21:07:48","area_name_two":"哈尔滨-道里区","order_price":1.33,"order_desc":"测试555","bid_id":336,"bid_count":1,"classify_photo_path":"classifyIco/tongxiashui.png","order_status":"1","order_status_text":"未接单","id":619,"create_time_day":"2018/10/01","order_type":"talk_price"},{"order_title":"道里区-招通下水","create_time_second":"14:30:03","order_status":"1","order_status_text":"未接单","area_name_two":"哈尔滨-道里区","order_desc_pics":"","id":614,"order_desc":"干就完了","create_time_day":"2018/09/30","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招通下水","create_time_second":"09:55:08","order_status":"1","order_status_text":"未接单","area_name_two":"哈尔滨-道里区","order_desc_pics":"workOrderDesc/workOrderDesc-SBUWMUlpizeI.jpg","id":612,"order_desc":"内容","create_time_day":"2018/09/30","bid_count":1,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招通下水","create_time_second":"21:09:35","area_name_two":"哈尔滨-道里区","order_price":1.44,"order_desc":"测试666","bid_id":337,"bid_count":1,"classify_photo_path":"classifyIco/tongxiashui.png","order_status":"7","order_status_text":"进行中","id":620,"create_time_day":"2018/10/01","order_type":"talk_price"},{"order_title":"道里区-招通下水","create_time_second":"20:55:52","order_status":"7","order_status_text":"进行中","area_name_two":"哈尔滨-道里区","order_price":1,"id":615,"order_desc":"测试111","create_time_day":"2018/10/01","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招通下水","create_time_second":"21:00:36","order_status":"3","order_status_text":"进行中","area_name_two":"哈尔滨-道里区","order_price":1.1,"id":616,"order_desc":"测试222","create_time_day":"2018/10/01","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招通下水","create_time_second":"13:34:39","area_name_two":"哈尔滨-道里区","order_desc_pics":"","order_price":1,"order_desc":"李伟","bid_count":0,"classify_photo_path":"classifyIco/tongxiashui.png","order_status":"5","order_status_text":"已完成","id":624,"create_time_day":"2018/10/02","order_type":"fixed_price"},{"order_title":"道里区-招通下水","create_time_second":"21:02:29","order_status":"5","order_status_text":"已完成","area_name_two":"哈尔滨-道里区","order_price":1.12,"id":617,"order_desc":"测试333","create_time_day":"2018/10/01","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"}]}
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
         * total : 11
         * page : 1
         * rows : 10
         * rtList : [{"order_title":"道里区-招家电维修","create_time_second":"13:56:51","order_status":"1","order_status_text":"未接单","area_name_two":"哈尔滨-道里区","order_desc_pics":"","id":628,"order_desc":"测试","create_time_day":"2018/10/02","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/jiadianweixiu.png"},{"order_title":"道里区-招通下水","create_time_second":"13:53:32","order_status":"1","order_status_text":"未接单","area_name_two":"哈尔滨-道里区","order_desc_pics":"","id":627,"order_desc":"李伟1","create_time_day":"2018/10/02","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招通下水","create_time_second":"21:07:48","area_name_two":"哈尔滨-道里区","order_price":1.33,"order_desc":"测试555","bid_id":336,"bid_count":1,"classify_photo_path":"classifyIco/tongxiashui.png","order_status":"1","order_status_text":"未接单","id":619,"create_time_day":"2018/10/01","order_type":"talk_price"},{"order_title":"道里区-招通下水","create_time_second":"14:30:03","order_status":"1","order_status_text":"未接单","area_name_two":"哈尔滨-道里区","order_desc_pics":"","id":614,"order_desc":"干就完了","create_time_day":"2018/09/30","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招通下水","create_time_second":"09:55:08","order_status":"1","order_status_text":"未接单","area_name_two":"哈尔滨-道里区","order_desc_pics":"workOrderDesc/workOrderDesc-SBUWMUlpizeI.jpg","id":612,"order_desc":"内容","create_time_day":"2018/09/30","bid_count":1,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招通下水","create_time_second":"21:09:35","area_name_two":"哈尔滨-道里区","order_price":1.44,"order_desc":"测试666","bid_id":337,"bid_count":1,"classify_photo_path":"classifyIco/tongxiashui.png","order_status":"7","order_status_text":"进行中","id":620,"create_time_day":"2018/10/01","order_type":"talk_price"},{"order_title":"道里区-招通下水","create_time_second":"20:55:52","order_status":"7","order_status_text":"进行中","area_name_two":"哈尔滨-道里区","order_price":1,"id":615,"order_desc":"测试111","create_time_day":"2018/10/01","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招通下水","create_time_second":"21:00:36","order_status":"3","order_status_text":"进行中","area_name_two":"哈尔滨-道里区","order_price":1.1,"id":616,"order_desc":"测试222","create_time_day":"2018/10/01","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"},{"order_title":"道里区-招通下水","create_time_second":"13:34:39","area_name_two":"哈尔滨-道里区","order_desc_pics":"","order_price":1,"order_desc":"李伟","bid_count":0,"classify_photo_path":"classifyIco/tongxiashui.png","order_status":"5","order_status_text":"已完成","id":624,"create_time_day":"2018/10/02","order_type":"fixed_price"},{"order_title":"道里区-招通下水","create_time_second":"21:02:29","order_status":"5","order_status_text":"已完成","area_name_two":"哈尔滨-道里区","order_price":1.12,"id":617,"order_desc":"测试333","create_time_day":"2018/10/01","bid_count":0,"order_type":"talk_price","classify_photo_path":"classifyIco/tongxiashui.png"}]
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
             * order_title : 道里区-招家电维修
             * create_time_second : 13:56:51
             * order_status : 1
             * order_status_text : 未接单
             * area_name_two : 哈尔滨-道里区
             * order_desc_pics :
             * id : 628
             * order_desc : 测试
             * create_time_day : 2018/10/02
             * bid_count : 0
             * order_type : talk_price
             * classify_photo_path : classifyIco/jiadianweixiu.png
             * order_price : 1.33
             * bid_id : 336
             */

            private String order_title;
            private String create_time_second;
            private String order_status;
            private String order_status_text;
            private String area_name_two;
            private String order_desc_pics;
            private int id;
            private String order_desc;
            private String create_time_day;
            private int bid_count;
            private String order_type;
            private String classify_photo_path;
            private double order_price;
            private int bid_id;

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

            public String getArea_name_two() {
                return area_name_two;
            }

            public void setArea_name_two(String area_name_two) {
                this.area_name_two = area_name_two;
            }

            public String getOrder_desc_pics() {
                return order_desc_pics;
            }

            public void setOrder_desc_pics(String order_desc_pics) {
                this.order_desc_pics = order_desc_pics;
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

            public void setOrder_price(double order_price) {
                this.order_price = order_price;
            }

            public int getBid_id() {
                return bid_id;
            }

            public void setBid_id(int bid_id) {
                this.bid_id = bid_id;
            }
        }
    }
}
