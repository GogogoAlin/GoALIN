package com.example.alin.gogogo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public class GiftDetail {

    /**
     * a : 0
     * b :
     * c :
     * d : {"address":"江苏省南京市秦淮区贡院街122号（江南贡院斜对面）","businessCode":"IB20150416083802000302","buyRule":"在线订购","categoryId":"1403","goodAppraiseNum":"0","goodsId":"SP1420160127142101001101","goodsName":"发光头箍","goodsSales":"萌萌达的发光头箍","goodsSeq":"32011400010035","goodsSn":"","imgList":["http://file.zhfzm.com/zouyizou_bss/group1/M00/00/01/rBABkVaoYZaAY-pjAAaw4Iw_AgU110.jpg?r=0.44008460195196586"],"introduction":"以状元帽为原型设计的一款玩具，适合儿童和追逐时尚的人群。萌萌的状元帽造型配合光电效果，让你在人群中做一枚闪闪惹人爱的状元郎。","isBuy":"1","isReserve":"0","isReserveModify":"","isTop":"1","latitude":"32.020736","longitude":"118.790537","preferentialPrice":"15.00","preferentialType":"02","price":"15.00","shopId":"DP1420150909170031000102","shopName":"秦淮礼物","validEndDate":"","validStartDate":"","validTime":"3"}
     * e : 0
     */

    private String a;
    private String b;
    private String c;
    /**
     * address : 江苏省南京市秦淮区贡院街122号（江南贡院斜对面）
     * businessCode : IB20150416083802000302
     * buyRule : 在线订购
     * categoryId : 1403
     * goodAppraiseNum : 0
     * goodsId : SP1420160127142101001101
     * goodsName : 发光头箍
     * goodsSales : 萌萌达的发光头箍
     * goodsSeq : 32011400010035
     * goodsSn :
     * imgList : ["http://file.zhfzm.com/zouyizou_bss/group1/M00/00/01/rBABkVaoYZaAY-pjAAaw4Iw_AgU110.jpg?r=0.44008460195196586"]
     * introduction : 以状元帽为原型设计的一款玩具，适合儿童和追逐时尚的人群。萌萌的状元帽造型配合光电效果，让你在人群中做一枚闪闪惹人爱的状元郎。
     * isBuy : 1
     * isReserve : 0
     * isReserveModify :
     * isTop : 1
     * latitude : 32.020736
     * longitude : 118.790537
     * preferentialPrice : 15.00
     * preferentialType : 02
     * price : 15.00
     * shopId : DP1420150909170031000102
     * shopName : 秦淮礼物
     * validEndDate :
     * validStartDate :
     * validTime : 3
     */

    private DBean d;
    private String e;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public DBean getD() {
        return d;
    }

    public void setD(DBean d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public static class DBean {
        private String address;
        private String businessCode;
        private String buyRule;
        private String categoryId;
        private String goodAppraiseNum;
        private String goodsId;
        private String goodsName;
        private String goodsSales;
        private String goodsSeq;
        private String goodsSn;
        private String introduction;
        private String isBuy;
        private String isReserve;
        private String isReserveModify;
        private String isTop;
        private String latitude;
        private String longitude;
        private String preferentialPrice;
        private String preferentialType;
        private String price;
        private String shopId;
        private String shopName;
        private String validEndDate;
        private String validStartDate;
        private String validTime;
        private List<String> imgList;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBusinessCode() {
            return businessCode;
        }

        public void setBusinessCode(String businessCode) {
            this.businessCode = businessCode;
        }

        public String getBuyRule() {
            return buyRule;
        }

        public void setBuyRule(String buyRule) {
            this.buyRule = buyRule;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getGoodAppraiseNum() {
            return goodAppraiseNum;
        }

        public void setGoodAppraiseNum(String goodAppraiseNum) {
            this.goodAppraiseNum = goodAppraiseNum;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsSales() {
            return goodsSales;
        }

        public void setGoodsSales(String goodsSales) {
            this.goodsSales = goodsSales;
        }

        public String getGoodsSeq() {
            return goodsSeq;
        }

        public void setGoodsSeq(String goodsSeq) {
            this.goodsSeq = goodsSeq;
        }

        public String getGoodsSn() {
            return goodsSn;
        }

        public void setGoodsSn(String goodsSn) {
            this.goodsSn = goodsSn;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getIsBuy() {
            return isBuy;
        }

        public void setIsBuy(String isBuy) {
            this.isBuy = isBuy;
        }

        public String getIsReserve() {
            return isReserve;
        }

        public void setIsReserve(String isReserve) {
            this.isReserve = isReserve;
        }

        public String getIsReserveModify() {
            return isReserveModify;
        }

        public void setIsReserveModify(String isReserveModify) {
            this.isReserveModify = isReserveModify;
        }

        public String getIsTop() {
            return isTop;
        }

        public void setIsTop(String isTop) {
            this.isTop = isTop;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getPreferentialPrice() {
            return preferentialPrice;
        }

        public void setPreferentialPrice(String preferentialPrice) {
            this.preferentialPrice = preferentialPrice;
        }

        public String getPreferentialType() {
            return preferentialType;
        }

        public void setPreferentialType(String preferentialType) {
            this.preferentialType = preferentialType;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getShopId() {
            return shopId;
        }

        public void setShopId(String shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getValidEndDate() {
            return validEndDate;
        }

        public void setValidEndDate(String validEndDate) {
            this.validEndDate = validEndDate;
        }

        public String getValidStartDate() {
            return validStartDate;
        }

        public void setValidStartDate(String validStartDate) {
            this.validStartDate = validStartDate;
        }

        public String getValidTime() {
            return validTime;
        }

        public void setValidTime(String validTime) {
            this.validTime = validTime;
        }

        public List<String> getImgList() {
            return imgList;
        }

        public void setImgList(List<String> imgList) {
            this.imgList = imgList;
        }
    }
}
