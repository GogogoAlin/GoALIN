package com.example.alin.gogogo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Three2 {
    /**
     * a : 0
     * b :
     * c :
     * d : {"rows":[{"comments":"3D导览","distance":">5km","name":"夫子庙导览图","shopId":"DP1020150401180514000101","size":"2960","smallUrl":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FA/wKgBflX-ddOAf4y2ADnlVtCNBeo788_small.png?r=0.9902344732797002","versionNum":"1.1"},{"comments":"3D导览","distance":">5km","name":"中华门导览图","shopId":"DP1020150402165929001001","size":"2261","smallUrl":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FA/wKgBflX-fhqART_sACdow7ehnFw644_small.png?r=0.5060421356223823","versionNum":"1.1"},{"comments":"3D导览","distance":">5km","name":"老门东导览图","shopId":"DP1020150409160103000102","size":"2769","smallUrl":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FA/wKgBgFX-fcuADktCAC127Dgr99A091_small.png?r=0.9970856092278646","versionNum":"1.1"}],"total":3}
     * e : 0
     */

    private String a;
    private String b;
    private String c;
    /**
     * rows : [{"comments":"3D导览","distance":">5km","name":"夫子庙导览图","shopId":"DP1020150401180514000101","size":"2960","smallUrl":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FA/wKgBflX-ddOAf4y2ADnlVtCNBeo788_small.png?r=0.9902344732797002","versionNum":"1.1"},{"comments":"3D导览","distance":">5km","name":"中华门导览图","shopId":"DP1020150402165929001001","size":"2261","smallUrl":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FA/wKgBflX-fhqART_sACdow7ehnFw644_small.png?r=0.5060421356223823","versionNum":"1.1"},{"comments":"3D导览","distance":">5km","name":"老门东导览图","shopId":"DP1020150409160103000102","size":"2769","smallUrl":"http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FA/wKgBgFX-fcuADktCAC127Dgr99A091_small.png?r=0.9970856092278646","versionNum":"1.1"}]
     * total : 3
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
         * comments : 3D导览
         * distance : >5km
         * name : 夫子庙导览图
         * shopId : DP1020150401180514000101
         * size : 2960
         * smallUrl : http://file.zhfzm.com/zouyizou_bss/group1/M00/00/FA/wKgBflX-ddOAf4y2ADnlVtCNBeo788_small.png?r=0.9902344732797002
         * versionNum : 1.1
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
            private String comments;
            private String distance;
            private String name;
            private String shopId;
            private String size;
            private String smallUrl;
            private String versionNum;

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getShopId() {
                return shopId;
            }

            public void setShopId(String shopId) {
                this.shopId = shopId;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getSmallUrl() {
                return smallUrl;
            }

            public void setSmallUrl(String smallUrl) {
                this.smallUrl = smallUrl;
            }

            public String getVersionNum() {
                return versionNum;
            }

            public void setVersionNum(String versionNum) {
                this.versionNum = versionNum;
            }
        }
    }
}
