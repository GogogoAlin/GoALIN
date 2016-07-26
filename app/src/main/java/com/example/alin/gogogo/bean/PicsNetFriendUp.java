package com.example.alin.gogogo.bean;

import java.util.List;

/**
 * Created by Alin on 2016/7/23.
 */
public class PicsNetFriendUp {

    /**
     * a : 0
     * b :
     * c :
     * d : {"rows":[{"comments":"测试一下来","id":"20150825125929001900","img":"http://file.zhfzm.com/zouyizou_app/group1/M00/00/F3/wKgBf1Xb9jKANZxhAAL8t82RKLY698.jpg","username":"大掌柜"},{"comments":"","id":"20150624092352000600","img":"http://file.zhfzm.com/zouyizou_app/group1/M00/00/9C/wKgBgVWKBi2AGo1nAACmhZXRKRw485.jpg","username":"黄河浊"},{"comments":"全球去","id":"20150624005632000500","img":"http://file.zhfzm.com/zouyizou_app/group1/M00/00/9C/wKgBflWJj3KAeb2vAAXWaJu1yc4439.jpg","username":"黄河浊"}],"total":3}
     * e : 0
     */

    private String a;
    private String b;
    private String c;
    /**
     * rows : [{"comments":"测试一下来","id":"20150825125929001900","img":"http://file.zhfzm.com/zouyizou_app/group1/M00/00/F3/wKgBf1Xb9jKANZxhAAL8t82RKLY698.jpg","username":"大掌柜"},{"comments":"","id":"20150624092352000600","img":"http://file.zhfzm.com/zouyizou_app/group1/M00/00/9C/wKgBgVWKBi2AGo1nAACmhZXRKRw485.jpg","username":"黄河浊"},{"comments":"全球去","id":"20150624005632000500","img":"http://file.zhfzm.com/zouyizou_app/group1/M00/00/9C/wKgBflWJj3KAeb2vAAXWaJu1yc4439.jpg","username":"黄河浊"}]
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
         * comments : 测试一下来
         * id : 20150825125929001900
         * img : http://file.zhfzm.com/zouyizou_app/group1/M00/00/F3/wKgBf1Xb9jKANZxhAAL8t82RKLY698.jpg
         * username : 大掌柜
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
            private String id;
            private String img;
            private String username;

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
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
