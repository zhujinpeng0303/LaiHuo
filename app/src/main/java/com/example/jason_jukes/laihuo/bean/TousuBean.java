package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class TousuBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataArr : [{"name":"对客户态度差","id":74,"type":"complain_tipoff","value":"to_client_bad_attitude_cp"},{"name":"与客户发生争吵","id":73,"type":"complain_tipoff","value":"with_client_brawl_cp"},{"name":"威胁客户","id":72,"type":"complain_tipoff","value":"menace_client_cp"}]
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
         * name : 对客户态度差
         * id : 74
         * type : complain_tipoff
         * value : to_client_bad_attitude_cp
         */

        private String name;
        private int id;
        private String type;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
