package com.example.alin.gogogo.bean;

import java.util.List;

/**
 * Created by Alin on 2016/7/20.
 */
public class Hotel {

    /**
     * a : 0
     * b :
     * c :
     * d : {"rows":[{"averagePrice":"568","browseNum":"525","categoryId":"1104","categoryName":"星级酒店","distance":">5km","goodAppraiseNum":"9","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/45/wKgBgVU-ItCALs5bAACJgFwvBrM172_small.jpg?r=0.20026788399327244","isMeetingroom":"1","isParkinglot":"1","isPay":"1","isReserve":"0","isRestaurant":"1","isTop":"1","isWifi":"1","keyword":"商务,国信,状元楼,状元境,大酒店","latitude":"32.022107","longitude":"118.788121","preferentialType":"","recommendReason":"五星级","shopId":"DP1120150413164118003402","shopName":"南京国信状元楼大酒店"},{"averagePrice":"361","browseNum":"191","categoryId":"1104","categoryName":"星级酒店","distance":">5km","goodAppraiseNum":"3","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/00/rBABEVYDad2AN2_PABWp2Cye7Zo087_small.png?r=0.5273388820990215","isMeetingroom":"1","isParkinglot":"1","isPay":"1","isReserve":"0","isRestaurant":"1","isTop":"1","isWifi":"1","keyword":"精品,钞库街,十八号,生活酒店","latitude":"32.018202","longitude":"118.787847","preferentialType":"","recommendReason":"四星级","shopId":"DP1120150909173722000201","shopName":"南京钞库街十八号生活酒店"},{"averagePrice":"877","browseNum":"108","categoryId":"1101","categoryName":"商务酒店  ","distance":">5km","goodAppraiseNum":"5","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/03/rBABkVbMHWKAd1tvAALP9Iv5LhM479_small.png?r=0.13999446295201778","isMeetingroom":"1","isParkinglot":"1","isPay":"1","isReserve":"0","isRestaurant":"1","isTop":"1","isWifi":"1","keyword":"","latitude":"32.022145","longitude":"118.794733","preferentialType":"","recommendReason":"其他","shopId":"DP1120160223170142000101","shopName":"南京夜泊秦淮君亭酒店"},{"averagePrice":"233","browseNum":"144","categoryId":"1102","categoryName":"快捷酒店","distance":">5km","goodAppraiseNum":"2","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FB/wKgBf1YCZw-AdVBgAAJisIwOFJM752_small.jpg?r=0.48664298513904214","isMeetingroom":"0","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"0","isTop":"0","isWifi":"1","keyword":"快捷,商务","latitude":"32.026021","longitude":"118.790522","preferentialType":"","recommendReason":"三星级","shopId":"DP1120150923164741000102","shopName":"如家快捷酒店(南京夫子庙太平南路店)"},{"averagePrice":"187","browseNum":"96","categoryId":"1102","categoryName":"快捷酒店","distance":">5km","goodAppraiseNum":"4","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/51/wKgBflVJh_2AUMc0AADvJbka9Jo985_small.jpg?r=0.19280515918945618","isMeetingroom":"0","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"0","isTop":"0","isWifi":"1","keyword":"7天,连锁,夫子庙,景区店,地铁站","latitude":"32.024835","longitude":"118.786731","preferentialType":"01","recommendReason":"三星级","shopId":"DP1120150506111904000102","shopName":"7天连锁酒店(南京夫子庙地铁站景区店）"},{"averagePrice":"158","browseNum":"155","categoryId":"1101","categoryName":"商务酒店","distance":">5km","goodAppraiseNum":"6","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/5C/wKgBflVQYsaAdyYuAACtFRQ8tIo644_small.jpg?r=0.024832943438711785","isMeetingroom":"0","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":"商务,舒适,尚客,三山街地铁","latitude":"32.023337","longitude":"118.782071","preferentialType":"","recommendReason":"三星级","shopId":"DP1120150511160605008302","shopName":"南京尚客快捷酒店(夫子庙三山街地铁站店)"},{"averagePrice":"379","browseNum":"102","categoryId":"1101","categoryName":"商务酒店","distance":">5km","goodAppraiseNum":"5","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/45/wKgBgVU-INeAMC4_AABsiyrdCqk314_small.jpg?r=0.8308631600021317","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":"商务,豪华,桔子,水晶,夫子庙","latitude":"32.023253","longitude":"118.783409","preferentialType":"","recommendReason":"五星级","shopId":"DP1120150413170240004002","shopName":"桔子水晶（南京夫子庙酒店）"},{"averagePrice":"529","browseNum":"85","categoryId":"1104","categoryName":"星级酒店","distance":">5km","goodAppraiseNum":"3","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/45/wKgBgVU-IVuACF0CAABs-46st8M146_small.jpg?r=0.7463413163101691","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":"商务,豪华,水游城,假日酒店","latitude":"32.023739","longitude":"118.785952","preferentialType":"","recommendReason":"五星级","shopId":"DP1120150413170016003902","shopName":"南京水游城假日酒店"},{"averagePrice":"119","browseNum":"69","categoryId":"1102","categoryName":"快捷酒店","distance":">5km","goodAppraiseNum":"2","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/5B/wKgBgFVLKkuAPX_tAACU7QTR0Fs391_small.jpg?r=0.9554119427979295","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"0","isTop":"0","isWifi":"1","keyword":"商务,舒适,快捷,布丁,金一村","latitude":"32.023943","longitude":"118.787992","preferentialType":"01","recommendReason":"三星级","shopId":"DP1120150507170351005002","shopName":"布丁酒店金一村（南京夫子庙店）"},{"averagePrice":"448","browseNum":"74","categoryId":"1104","categoryName":"星级酒店","distance":">5km","goodAppraiseNum":"3","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FA/wKgBf1X7zXmAF--yAAEXe3nvPQM479_small.jpg?r=0.6794660095243582","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":"商务,豪华,涵田,城市酒店,城市","latitude":"32.023558","longitude":"118.787063","preferentialType":"02","recommendReason":"四星级","shopId":"DP1120150413165802003802","shopName":"南京涵田城市酒店"},{"averagePrice":"141","browseNum":"60","categoryId":"1102","categoryName":"快捷酒店","distance":">5km","goodAppraiseNum":"3","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/51/wKgBgVVJhZ-ATaLEAAC4WPfVpko507_small.jpg?r=0.9557271294062537","isMeetingroom":"0","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":",商务,7天,优品,连锁,夫子庙店","latitude":"32.023794","longitude":"118.788967","preferentialType":"01","recommendReason":"三星级","shopId":"DP1120150506110838000301","shopName":"7天优品酒店（南京夫子庙店）（原7天连锁酒店）"},{"averagePrice":"185","browseNum":"38","categoryId":"1101","categoryName":"商务酒店","distance":">5km","goodAppraiseNum":"2","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/50/wKgBgVVIbtyAZL2LAACUPNSrBAY939_small.jpg?r=0.6528626277599698","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":"商务,挂牌三星,舒适,悦华,大酒店","latitude":"32.023249","longitude":"118.788368","preferentialType":"02","recommendReason":"三星级","shopId":"DP1120150505151925000602","shopName":"南京悦华大酒店"},{"averagePrice":"133","browseNum":"53","categoryId":"1102","categoryName":"快捷酒店","distance":">5km","goodAppraiseNum":"1","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/51/wKgBgFVJekKAFbXwAAB8CBYK_qM225_small.jpg?r=0.5523340071207449","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":",快捷,舒适,都市客栈,夫子庙二店,健康路","latitude":"32.022797","longitude":"118.787283","preferentialType":"01","recommendReason":"其他","shopId":"DP1120150506102010002102","shopName":"都市客栈（南京建康路店夫子庙二店）"}],"total":27}
     * e : 0
     */

    private String a;
    private String b;
    private String c;
    /**
     * rows : [{"averagePrice":"568","browseNum":"525","categoryId":"1104","categoryName":"星级酒店","distance":">5km","goodAppraiseNum":"9","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/45/wKgBgVU-ItCALs5bAACJgFwvBrM172_small.jpg?r=0.20026788399327244","isMeetingroom":"1","isParkinglot":"1","isPay":"1","isReserve":"0","isRestaurant":"1","isTop":"1","isWifi":"1","keyword":"商务,国信,状元楼,状元境,大酒店","latitude":"32.022107","longitude":"118.788121","preferentialType":"","recommendReason":"五星级","shopId":"DP1120150413164118003402","shopName":"南京国信状元楼大酒店"},{"averagePrice":"361","browseNum":"191","categoryId":"1104","categoryName":"星级酒店","distance":">5km","goodAppraiseNum":"3","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/00/rBABEVYDad2AN2_PABWp2Cye7Zo087_small.png?r=0.5273388820990215","isMeetingroom":"1","isParkinglot":"1","isPay":"1","isReserve":"0","isRestaurant":"1","isTop":"1","isWifi":"1","keyword":"精品,钞库街,十八号,生活酒店","latitude":"32.018202","longitude":"118.787847","preferentialType":"","recommendReason":"四星级","shopId":"DP1120150909173722000201","shopName":"南京钞库街十八号生活酒店"},{"averagePrice":"877","browseNum":"108","categoryId":"1101","categoryName":"商务酒店  ","distance":">5km","goodAppraiseNum":"5","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/03/rBABkVbMHWKAd1tvAALP9Iv5LhM479_small.png?r=0.13999446295201778","isMeetingroom":"1","isParkinglot":"1","isPay":"1","isReserve":"0","isRestaurant":"1","isTop":"1","isWifi":"1","keyword":"","latitude":"32.022145","longitude":"118.794733","preferentialType":"","recommendReason":"其他","shopId":"DP1120160223170142000101","shopName":"南京夜泊秦淮君亭酒店"},{"averagePrice":"233","browseNum":"144","categoryId":"1102","categoryName":"快捷酒店","distance":">5km","goodAppraiseNum":"2","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FB/wKgBf1YCZw-AdVBgAAJisIwOFJM752_small.jpg?r=0.48664298513904214","isMeetingroom":"0","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"0","isTop":"0","isWifi":"1","keyword":"快捷,商务","latitude":"32.026021","longitude":"118.790522","preferentialType":"","recommendReason":"三星级","shopId":"DP1120150923164741000102","shopName":"如家快捷酒店(南京夫子庙太平南路店)"},{"averagePrice":"187","browseNum":"96","categoryId":"1102","categoryName":"快捷酒店","distance":">5km","goodAppraiseNum":"4","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/51/wKgBflVJh_2AUMc0AADvJbka9Jo985_small.jpg?r=0.19280515918945618","isMeetingroom":"0","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"0","isTop":"0","isWifi":"1","keyword":"7天,连锁,夫子庙,景区店,地铁站","latitude":"32.024835","longitude":"118.786731","preferentialType":"01","recommendReason":"三星级","shopId":"DP1120150506111904000102","shopName":"7天连锁酒店(南京夫子庙地铁站景区店）"},{"averagePrice":"158","browseNum":"155","categoryId":"1101","categoryName":"商务酒店","distance":">5km","goodAppraiseNum":"6","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/5C/wKgBflVQYsaAdyYuAACtFRQ8tIo644_small.jpg?r=0.024832943438711785","isMeetingroom":"0","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":"商务,舒适,尚客,三山街地铁","latitude":"32.023337","longitude":"118.782071","preferentialType":"","recommendReason":"三星级","shopId":"DP1120150511160605008302","shopName":"南京尚客快捷酒店(夫子庙三山街地铁站店)"},{"averagePrice":"379","browseNum":"102","categoryId":"1101","categoryName":"商务酒店","distance":">5km","goodAppraiseNum":"5","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/45/wKgBgVU-INeAMC4_AABsiyrdCqk314_small.jpg?r=0.8308631600021317","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":"商务,豪华,桔子,水晶,夫子庙","latitude":"32.023253","longitude":"118.783409","preferentialType":"","recommendReason":"五星级","shopId":"DP1120150413170240004002","shopName":"桔子水晶（南京夫子庙酒店）"},{"averagePrice":"529","browseNum":"85","categoryId":"1104","categoryName":"星级酒店","distance":">5km","goodAppraiseNum":"3","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/45/wKgBgVU-IVuACF0CAABs-46st8M146_small.jpg?r=0.7463413163101691","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":"商务,豪华,水游城,假日酒店","latitude":"32.023739","longitude":"118.785952","preferentialType":"","recommendReason":"五星级","shopId":"DP1120150413170016003902","shopName":"南京水游城假日酒店"},{"averagePrice":"119","browseNum":"69","categoryId":"1102","categoryName":"快捷酒店","distance":">5km","goodAppraiseNum":"2","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/5B/wKgBgFVLKkuAPX_tAACU7QTR0Fs391_small.jpg?r=0.9554119427979295","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"0","isTop":"0","isWifi":"1","keyword":"商务,舒适,快捷,布丁,金一村","latitude":"32.023943","longitude":"118.787992","preferentialType":"01","recommendReason":"三星级","shopId":"DP1120150507170351005002","shopName":"布丁酒店金一村（南京夫子庙店）"},{"averagePrice":"448","browseNum":"74","categoryId":"1104","categoryName":"星级酒店","distance":">5km","goodAppraiseNum":"3","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FA/wKgBf1X7zXmAF--yAAEXe3nvPQM479_small.jpg?r=0.6794660095243582","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":"商务,豪华,涵田,城市酒店,城市","latitude":"32.023558","longitude":"118.787063","preferentialType":"02","recommendReason":"四星级","shopId":"DP1120150413165802003802","shopName":"南京涵田城市酒店"},{"averagePrice":"141","browseNum":"60","categoryId":"1102","categoryName":"快捷酒店","distance":">5km","goodAppraiseNum":"3","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/51/wKgBgVVJhZ-ATaLEAAC4WPfVpko507_small.jpg?r=0.9557271294062537","isMeetingroom":"0","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":",商务,7天,优品,连锁,夫子庙店","latitude":"32.023794","longitude":"118.788967","preferentialType":"01","recommendReason":"三星级","shopId":"DP1120150506110838000301","shopName":"7天优品酒店（南京夫子庙店）（原7天连锁酒店）"},{"averagePrice":"185","browseNum":"38","categoryId":"1101","categoryName":"商务酒店","distance":">5km","goodAppraiseNum":"2","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/50/wKgBgVVIbtyAZL2LAACUPNSrBAY939_small.jpg?r=0.6528626277599698","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":"商务,挂牌三星,舒适,悦华,大酒店","latitude":"32.023249","longitude":"118.788368","preferentialType":"02","recommendReason":"三星级","shopId":"DP1120150505151925000602","shopName":"南京悦华大酒店"},{"averagePrice":"133","browseNum":"53","categoryId":"1102","categoryName":"快捷酒店","distance":">5km","goodAppraiseNum":"1","img1":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/51/wKgBgFVJekKAFbXwAAB8CBYK_qM225_small.jpg?r=0.5523340071207449","isMeetingroom":"1","isParkinglot":"1","isPay":"0","isReserve":"0","isRestaurant":"1","isTop":"0","isWifi":"1","keyword":",快捷,舒适,都市客栈,夫子庙二店,健康路","latitude":"32.022797","longitude":"118.787283","preferentialType":"01","recommendReason":"其他","shopId":"DP1120150506102010002102","shopName":"都市客栈（南京建康路店夫子庙二店）"}]
     * total : 27
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
        private int total;
        /**
         * averagePrice : 568
         * browseNum : 525
         * categoryId : 1104
         * categoryName : 星级酒店
         * distance : >5km
         * goodAppraiseNum : 9
         * img1 : http://file.zhfzm.com/zouyizou_bss/group1/M00/00/45/wKgBgVU-ItCALs5bAACJgFwvBrM172_small.jpg?r=0.20026788399327244
         * isMeetingroom : 1
         * isParkinglot : 1
         * isPay : 1
         * isReserve : 0
         * isRestaurant : 1
         * isTop : 1
         * isWifi : 1
         * keyword : 商务,国信,状元楼,状元境,大酒店
         * latitude : 32.022107
         * longitude : 118.788121
         * preferentialType :
         * recommendReason : 五星级
         * shopId : DP1120150413164118003402
         * shopName : 南京国信状元楼大酒店
         */

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
            private String averagePrice;
            private String browseNum;
            private String categoryId;
            private String categoryName;
            private String distance;
            private String goodAppraiseNum;
            private String img1;
            private String isMeetingroom;
            private String isParkinglot;
            private String isPay;
            private String isReserve;
            private String isRestaurant;
            private String isTop;
            private String isWifi;
            private String keyword;
            private String latitude;
            private String longitude;
            private String preferentialType;
            private String recommendReason;
            private String shopId;
            private String shopName;

            public String getAveragePrice() {
                return averagePrice;
            }

            public void setAveragePrice(String averagePrice) {
                this.averagePrice = averagePrice;
            }

            public String getBrowseNum() {
                return browseNum;
            }

            public void setBrowseNum(String browseNum) {
                this.browseNum = browseNum;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

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

            public String getIsMeetingroom() {
                return isMeetingroom;
            }

            public void setIsMeetingroom(String isMeetingroom) {
                this.isMeetingroom = isMeetingroom;
            }

            public String getIsParkinglot() {
                return isParkinglot;
            }

            public void setIsParkinglot(String isParkinglot) {
                this.isParkinglot = isParkinglot;
            }

            public String getIsPay() {
                return isPay;
            }

            public void setIsPay(String isPay) {
                this.isPay = isPay;
            }

            public String getIsReserve() {
                return isReserve;
            }

            public void setIsReserve(String isReserve) {
                this.isReserve = isReserve;
            }

            public String getIsRestaurant() {
                return isRestaurant;
            }

            public void setIsRestaurant(String isRestaurant) {
                this.isRestaurant = isRestaurant;
            }

            public String getIsTop() {
                return isTop;
            }

            public void setIsTop(String isTop) {
                this.isTop = isTop;
            }

            public String getIsWifi() {
                return isWifi;
            }

            public void setIsWifi(String isWifi) {
                this.isWifi = isWifi;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
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

            public String getPreferentialType() {
                return preferentialType;
            }

            public void setPreferentialType(String preferentialType) {
                this.preferentialType = preferentialType;
            }

            public String getRecommendReason() {
                return recommendReason;
            }

            public void setRecommendReason(String recommendReason) {
                this.recommendReason = recommendReason;
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
