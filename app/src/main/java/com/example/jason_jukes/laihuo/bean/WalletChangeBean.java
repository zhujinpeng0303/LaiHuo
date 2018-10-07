package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class WalletChangeBean {


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

            private String foreign_type_text;
            private String create_time_text;
            private String add_or_sub;
            private String money;

            public String getForeign_type_text() {
                return foreign_type_text;
            }

            public void setForeign_type_text(String foreign_type_text) {
                this.foreign_type_text = foreign_type_text;
            }

            public String getCreate_time_text() {
                return create_time_text;
            }

            public void setCreate_time_text(String create_time_text) {
                this.create_time_text = create_time_text;
            }

            public String getAdd_or_sub() {
                return add_or_sub;
            }

            public void setAdd_or_sub(String add_or_sub) {
                this.add_or_sub = add_or_sub;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }
        }

    }
}
