package com.example.jason_jukes.laihuo.bean;

/**
 * Created by Administrator on 2018/10/6 0006.
 */

public class LoginBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"token":"xYDQyYqSZ0mOaKGlCubnBHbdxpHEqyeI"}
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
         * token : xYDQyYqSZ0mOaKGlCubnBHbdxpHEqyeI
         */

        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
