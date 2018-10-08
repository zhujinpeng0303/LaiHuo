package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/1 0001.
 */

public class WithdrawBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataArr : []
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

        private String check_status_text;
        private String transfer_status_text;
        private String create_time_text;
        private String money;

        public String getCheck_status_text() {
            return check_status_text;
        }

        public void setCheck_status_text(String check_status_text) {
            this.check_status_text = check_status_text;
        }

        public String getTransfer_status_text() {
            return transfer_status_text;
        }

        public void setTransfer_status_text(String transfer_status_text) {
            this.transfer_status_text = transfer_status_text;
        }

        public String getCreate_time_text() {
            return create_time_text;
        }

        public void setCreate_time_text(String create_time_text) {
            this.create_time_text = create_time_text;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }

}
