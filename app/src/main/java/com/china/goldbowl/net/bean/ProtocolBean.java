package com.china.goldbowl.net.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 隐私列表数据
 * Created by congcong on 2020/4/7
 */
public class ProtocolBean implements Serializable {

    /**
     * code : 200
     * data : {"list":[{"code":"protocol_borrow","name":"Loan agreement","value":"/h5/protocol_borrow.jsp"},{"code":"protocol_privacy","name":"Privacy Policy","value":"/h5/protocol_privacy.jsp"},{"code":"protocol_register","name":"Terms of Service","value":"/h5/protocol_register.jsp"}]}
     * msg : The query was successful.
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean implements Serializable {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable{
            /**
             * code : protocol_borrow
             * name : Loan agreement
             * value : /h5/protocol_borrow.jsp
             */

            private String code;
            private String name;
            private String value;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
