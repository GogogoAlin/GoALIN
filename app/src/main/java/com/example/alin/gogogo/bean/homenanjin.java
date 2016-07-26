package com.example.alin.gogogo.bean;

import java.io.Serializable;
import java.util.List;


public class homenanjin implements Serializable{
    private String a;
    private String b;
    private String c;
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
        private int total;

        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            private String goodAppraiseNum;
            private String img1;
            private String introduce;
            private String isGuideMap;
            private String isPay;
            private String isSound;
            private String shopId;
            private String shopName;

            public String getGoodAppraiseNum() {
                return goodAppraiseNum;
            }

            public void setGoodAppraiseNum(String goodAppraiseNum) {
                this.goodAppraiseNum = goodAppraiseNum;
            }

            public String getImg1() {
                return img1;
            }

            public void setImg1(String img1) {
                this.img1 = img1;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public String getIsGuideMap() {
                return isGuideMap;
            }

            public void setIsGuideMap(String isGuideMap) {
                this.isGuideMap = isGuideMap;
            }

            public String getIsPay() {
                return isPay;
            }

            public void setIsPay(String isPay) {
                this.isPay = isPay;
            }

            public String getIsSound() {
                return isSound;
            }

            public void setIsSound(String isSound) {
                this.isSound = isSound;
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
        }
    }
}
