package com.china.goldbowl.net.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 首页数据
 * Created by congcong on 2020/4/7
 */
public class MainBean implements Serializable {
    /**
     * repaymentAmount : 0
     * processList : []
     * cardInfo : {}
     * auth : {"result":0,"qualified":0,"total":4}
     * isBorrow : false
     * repaymentRemark :
     * borrowState :
     * title : DoubleCash
     * productInfo : [{"onceHandlingFee":300,"realAmount":2400,"amount":3000,"repaymentAmount":3020.58,"isOpen":true,"dayLimit":7,"repayTime":"13 Apr 2020","interest":20.58,"onceServiceFee":300,"applicationDate":"07 Apr 2020"}]
     * total : 3000
     * esignType : 0
     * isRepay : false
     * loanCeiling : 7000
     * borrowCount : 0
     * applicationDate :
     */

    private int repaymentAmount;
    private CardInfoBean cardInfo;
    private AuthBean auth;
    private boolean isBorrow;
    private String repaymentRemark;
    private String borrowState;
    private String title;
    private String total;
    private int esignType;
    private boolean isRepay;
    private int loanCeiling;
    private int borrowCount;
    private String applicationDate;
    private List<?> processList;
    private List<ProductInfoBean> productInfo;

    public int getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(int repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }

    public CardInfoBean getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfoBean cardInfo) {
        this.cardInfo = cardInfo;
    }

    public AuthBean getAuth() {
        return auth;
    }

    public void setAuth(AuthBean auth) {
        this.auth = auth;
    }

    public boolean isIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(boolean isBorrow) {
        this.isBorrow = isBorrow;
    }

    public String getRepaymentRemark() {
        return repaymentRemark;
    }

    public void setRepaymentRemark(String repaymentRemark) {
        this.repaymentRemark = repaymentRemark;
    }

    public String getBorrowState() {
        return borrowState;
    }

    public void setBorrowState(String borrowState) {
        this.borrowState = borrowState;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getEsignType() {
        return esignType;
    }

    public void setEsignType(int esignType) {
        this.esignType = esignType;
    }

    public boolean isIsRepay() {
        return isRepay;
    }

    public void setIsRepay(boolean isRepay) {
        this.isRepay = isRepay;
    }

    public int getLoanCeiling() {
        return loanCeiling;
    }

    public void setLoanCeiling(int loanCeiling) {
        this.loanCeiling = loanCeiling;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public List<?> getProcessList() {
        return processList;
    }

    public void setProcessList(List<?> processList) {
        this.processList = processList;
    }

    public List<ProductInfoBean> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<ProductInfoBean> productInfo) {
        this.productInfo = productInfo;
    }

    public static class CardInfoBean implements Serializable{
    }

    public static class AuthBean implements Serializable{
        /**
         * result : 0
         * qualified : 0
         * total : 4
         */

        private int result;
        private int qualified;
        private int total;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public int getQualified() {
            return qualified;
        }

        public void setQualified(int qualified) {
            this.qualified = qualified;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    public static class ProductInfoBean implements Serializable{
        /**
         * onceHandlingFee : 300
         * realAmount : 2400
         * amount : 3000
         * repaymentAmount : 3020.58
         * isOpen : true
         * dayLimit : 7
         * repayTime : 13 Apr 2020
         * interest : 20.58
         * onceServiceFee : 300
         * applicationDate : 07 Apr 2020
         */

        private int onceHandlingFee;
        private int realAmount;
        private int amount;
        private double repaymentAmount;
        private boolean isOpen;
        private int dayLimit;
        private String repayTime;
        private double interest;
        private int onceServiceFee;
        private String applicationDate;

        public int getOnceHandlingFee() {
            return onceHandlingFee;
        }

        public void setOnceHandlingFee(int onceHandlingFee) {
            this.onceHandlingFee = onceHandlingFee;
        }

        public int getRealAmount() {
            return realAmount;
        }

        public void setRealAmount(int realAmount) {
            this.realAmount = realAmount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public double getRepaymentAmount() {
            return repaymentAmount;
        }

        public void setRepaymentAmount(double repaymentAmount) {
            this.repaymentAmount = repaymentAmount;
        }

        public boolean isIsOpen() {
            return isOpen;
        }

        public void setIsOpen(boolean isOpen) {
            this.isOpen = isOpen;
        }

        public int getDayLimit() {
            return dayLimit;
        }

        public void setDayLimit(int dayLimit) {
            this.dayLimit = dayLimit;
        }

        public String getRepayTime() {
            return repayTime;
        }

        public void setRepayTime(String repayTime) {
            this.repayTime = repayTime;
        }

        public double getInterest() {
            return interest;
        }

        public void setInterest(double interest) {
            this.interest = interest;
        }

        public int getOnceServiceFee() {
            return onceServiceFee;
        }

        public void setOnceServiceFee(int onceServiceFee) {
            this.onceServiceFee = onceServiceFee;
        }

        public String getApplicationDate() {
            return applicationDate;
        }

        public void setApplicationDate(String applicationDate) {
            this.applicationDate = applicationDate;
        }
    }

    /**
     * msg : The query succeeded.
     * code : 200
     * data : {"repaymentAmount":0,"processList":[],"cardInfo":{},"auth":{"result":0,"qualified":0,"total":4},"isBorrow":false,"repaymentRemark":"","borrowState":"","title":"DoubleCash","productInfo":[{"onceHandlingFee":300,"realAmount":2400,"amount":3000,"repaymentAmount":3020.58,"isOpen":true,"dayLimit":7,"repayTime":"13 Apr 2020","interest":20.58,"onceServiceFee":300,"applicationDate":"07 Apr 2020"}],"total":"3000","esignType":0,"isRepay":false,"loanCeiling":7000,"borrowCount":0,"applicationDate":""}
     */


}
