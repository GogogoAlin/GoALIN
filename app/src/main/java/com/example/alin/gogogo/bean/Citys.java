package com.example.alin.gogogo.bean;

import java.util.List;

/**
 * Created by Alin on 2016/7/20.
 */
public class Citys {

    /**
     * a : 0
     * b :
     * c :
     * d : {"rows":[{"areaId":"3201","areaName":"南京市","backgroundImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/F9/wKgBflX2Xi-ABs72AAKu3jhmShI548.jpg","defaultImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/F9/wKgBflX2Xi-ABs72AAKu3jhmShI548.jpg","isOpen":"1","latitude":"32.058127","longitude":"118.798164"},{"areaId":"3202","areaName":"无锡市","backgroundImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/7F/wKgBgVVxa2KAHkblAACNkNXDQ9Y101.jpg","defaultImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/7F/wKgBf1VwU2OAQb3fAABMAGVjsAo421.jpg","isOpen":"1","latitude":"31.49117","longitude":"120.31191"},{"areaId":"3203","areaName":"徐州市","backgroundImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/7F/wKgBgVVxa2KAHkblAACNkNXDQ9Y101.jpg","defaultImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/7F/wKgBgFVwU6CAK83MAAA4AXxS6O4604.jpg","isOpen":"1","latitude":"34.205768","longitude":"117.284124"},{"areaId":"3204","areaName":"常州市","backgroundImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/7F/wKgBf1Vxh1uAQ6t8AAGf942pMmo665.jpg","defaultImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/7F/wKgBgVVwU-GAKJ-4AAAdOTiqkUk106.jpg","isOpen":"1","latitude":"31.811226","longitude":"119.974062"},{"areaId":"3205","areaName":"苏州市","backgroundImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/7F/wKgBgVVxd_iAMj4DAAEcjWgssko106.jpg","defaultImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/7F/wKgBflVwVRaAP3BqAABDLxOgugM982.jpg","isOpen":"1","latitude":"31.298974","longitude":"120.585297"},{"areaId":"3211","areaName":"镇江市","backgroundImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/7F/wKgBgVVxa2KAHkblAACNkNXDQ9Y101.jpg","defaultImg":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/7F/wKgBgFVwViiAHNriAABX2sJEWHk396.jpg","isOpen":"1","latitude":"32.187849","longitude":"119.425836"}]}
     * e : 0
     */

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
        /**
         * areaId : 3201
         * areaName : 南京市
         * backgroundImg : http://file.zhfzm.com/zouyizou_bss/group1/M00/00/F9/wKgBflX2Xi-ABs72AAKu3jhmShI548.jpg
         * defaultImg : http://file.zhfzm.com/zouyizou_bss/group1/M00/00/F9/wKgBflX2Xi-ABs72AAKu3jhmShI548.jpg
         * isOpen : 1
         * latitude : 32.058127
         * longitude : 118.798164
         */

        private List<RowsBean> rows;

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            private String areaId;
            private String areaName;
            private String backgroundImg;
            private String defaultImg;
            private String isOpen;
            private String latitude;
            private String longitude;

            public String getAreaId() {
                return areaId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public String getBackgroundImg() {
                return backgroundImg;
            }

            public void setBackgroundImg(String backgroundImg) {
                this.backgroundImg = backgroundImg;
            }

            public String getDefaultImg() {
                return defaultImg;
            }

            public void setDefaultImg(String defaultImg) {
                this.defaultImg = defaultImg;
            }

            public String getIsOpen() {
                return isOpen;
            }

            public void setIsOpen(String isOpen) {
                this.isOpen = isOpen;
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
        }
    }
}
