package com.example.jason_jukes.laihuo.bean;

import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/30 0030 11:37
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MessageMarketBean {


    /**
     * errorCode : 0000
     * errorMsg : 成功
     * dataObj : {"total":2,"page":0,"rows":10,"rtList":[{"topicLogList":[{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132","create_time":"2018-09-30 11:29:26","user_id":"100011","id":219,"topic_id":"185"},{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132","create_time":"2018-09-30 11:25:43","user_id":"1","id":218,"topic_id":"185"}],"head_url":"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132","create_time":"2018-09-30 11:25:40","user_id":"1","contents":"测试内容","sreplyList":[{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132","create_time":"2018-09-30 11:29:36","user_id":"100011","contents":"评论冰冰","id":179,"topic_id":"185","username":"张槟冰"},{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132","create_time":"2018-09-30 11:29:04","user_id":"1","contents":"回复","id":178,"topic_id":"185","username":"GGGG"}],"click_count":2,"id":185,"title":"","pics":"userBbsImage/userBbsImage-ZpOXFpYNPssg.png","username":"GGGG"}]}
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
         * total : 2
         * page : 0
         * rows : 10
         * rtList : [{"topicLogList":[{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132","create_time":"2018-09-30 11:29:26","user_id":"100011","id":219,"topic_id":"185"},{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132","create_time":"2018-09-30 11:25:43","user_id":"1","id":218,"topic_id":"185"}],"head_url":"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132","create_time":"2018-09-30 11:25:40","user_id":"1","contents":"测试内容","sreplyList":[{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132","create_time":"2018-09-30 11:29:36","user_id":"100011","contents":"评论冰冰","id":179,"topic_id":"185","username":"张槟冰"},{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132","create_time":"2018-09-30 11:29:04","user_id":"1","contents":"回复","id":178,"topic_id":"185","username":"GGGG"}],"click_count":2,"id":185,"title":"","pics":"userBbsImage/userBbsImage-ZpOXFpYNPssg.png","username":"GGGG"}]
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
             * topicLogList : [{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132","create_time":"2018-09-30 11:29:26","user_id":"100011","id":219,"topic_id":"185"},{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132","create_time":"2018-09-30 11:25:43","user_id":"1","id":218,"topic_id":"185"}]
             * head_url : https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132
             * create_time : 2018-09-30 11:25:40
             * user_id : 1
             * contents : 测试内容
             * sreplyList : [{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132","create_time":"2018-09-30 11:29:36","user_id":"100011","contents":"评论冰冰","id":179,"topic_id":"185","username":"张槟冰"},{"head_url":"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoTcUxr0HmWOh9nHHyMuCeYAGsznic6zEpOlzxujwucmhXomtPnGBEr9ht9ah66Xt2icvjfTtzKtEibQ/132","create_time":"2018-09-30 11:29:04","user_id":"1","contents":"回复","id":178,"topic_id":"185","username":"GGGG"}]
             * click_count : 2
             * id : 185
             * title :
             * pics : userBbsImage/userBbsImage-ZpOXFpYNPssg.png
             * username : GGGG
             */

            private String head_url;
            private String create_time;
            private String user_id;
            private String contents;
            private int click_count;
            private int id;
            private String title;
            private String pics;
            private String username;
            private List<TopicLogListBean> topicLogList;
            private List<SreplyListBean> sreplyList;

            public String getHead_url() {
                return head_url;
            }

            public void setHead_url(String head_url) {
                this.head_url = head_url;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getContents() {
                return contents;
            }

            public void setContents(String contents) {
                this.contents = contents;
            }

            public int getClick_count() {
                return click_count;
            }

            public void setClick_count(int click_count) {
                this.click_count = click_count;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPics() {
                return pics;
            }

            public void setPics(String pics) {
                this.pics = pics;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public List<TopicLogListBean> getTopicLogList() {
                return topicLogList;
            }

            public void setTopicLogList(List<TopicLogListBean> topicLogList) {
                this.topicLogList = topicLogList;
            }

            public List<SreplyListBean> getSreplyList() {
                return sreplyList;
            }

            public void setSreplyList(List<SreplyListBean> sreplyList) {
                this.sreplyList = sreplyList;
            }

            public static class TopicLogListBean {
                /**
                 * head_url : https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132
                 * create_time : 2018-09-30 11:29:26
                 * user_id : 100011
                 * id : 219
                 * topic_id : 185
                 */

                private String head_url;
                private String create_time;
                private String user_id;
                private int id;
                private String topic_id;

                public String getHead_url() {
                    return head_url;
                }

                public void setHead_url(String head_url) {
                    this.head_url = head_url;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTopic_id() {
                    return topic_id;
                }

                public void setTopic_id(String topic_id) {
                    this.topic_id = topic_id;
                }
            }

            public static class SreplyListBean {
                /**
                 * head_url : https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELmNSO5CqZFIXtrUd3RscFwaaYWcAVricrIvhiaLAAbfEG0BafsWQUOw4OL95dTUvDuO7um61Hv2KPQ/132
                 * create_time : 2018-09-30 11:29:36
                 * user_id : 100011
                 * contents : 评论冰冰
                 * id : 179
                 * topic_id : 185
                 * username : 张槟冰
                 */

                private String head_url;
                private String create_time;
                private String user_id;
                private String contents;
                private int id;
                private String topic_id;
                private String username;

                public String getHead_url() {
                    return head_url;
                }

                public void setHead_url(String head_url) {
                    this.head_url = head_url;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getContents() {
                    return contents;
                }

                public void setContents(String contents) {
                    this.contents = contents;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTopic_id() {
                    return topic_id;
                }

                public void setTopic_id(String topic_id) {
                    this.topic_id = topic_id;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }
            }
        }
    }
}
