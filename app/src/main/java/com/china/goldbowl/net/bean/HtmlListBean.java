package com.china.goldbowl.net.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by congcong on 2020/4/7
 */
public class HtmlListBean implements Serializable {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable{
        /**
         * name : 关于我们
         * code : h5_about_us
         * value : /h5/aboutUs.jsp
         */

        private String name;
        private String code;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
