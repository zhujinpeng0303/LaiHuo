package com.example.jason_jukes.laihuo.bean;

/**
 * 作者：Jason_Jukes on 2018/10/8 0008 14:54
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class ImgPostBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"fileName":"workOrderDesc/workOrderDesc-QlbLgCTOBSjK.jpg"}
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
         * fileName : workOrderDesc/workOrderDesc-QlbLgCTOBSjK.jpg
         */

        private String fileName;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
    }
}
