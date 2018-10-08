package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/30 0030 16:43
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class AddressBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataArr : [{"area_name":"道里区","address":"详细","user_id":1,"tel":"15215151515","id":194,"area_id":237,"area_name_top":"哈尔滨","username":"测试","city_id":236},{"area_name":"道里区","address":"详细地址","user_id":1,"tel":"15555555555","id":195,"area_id":237,"area_name_top":"哈尔滨","username":"测试测试","city_id":236}]
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
         * area_name : 道里区
         * address : 详细
         * user_id : 1
         * tel : 15215151515
         * id : 194
         * area_id : 237
         * area_name_top : 哈尔滨
         * username : 测试
         * city_id : 236
         */

        private String area_name;
        private String address;
        private int user_id;
        private String tel;
        private int id;
        private int area_id;
        private String area_name_top;
        private String username;
        private int city_id;

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }

        public String getArea_name_top() {
            return area_name_top;
        }

        public void setArea_name_top(String area_name_top) {
            this.area_name_top = area_name_top;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }
    }
}
