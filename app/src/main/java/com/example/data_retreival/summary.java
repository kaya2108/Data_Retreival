package com.example.data_retreival;

public class summary {
    private String xs;
    private String s;
    private String m;
    private String l;
    private String xl;
    private String xxl;
    private String xxxl;

    public summary(String xs, String s, String m, String l, String xl, String xxl, String xxxl) {
        this.xs = xs;
        this.s = s;
        this.m = m;
        this.l = l;
        this.xl = xl;
        this.xxl = xxl;
        this.xxxl = xxxl;
    }

    public String getXs() {
        return xs;
    }

    public String getS() {
        return s;
    }

    public String getM() {
        return m;
    }

    public String getL() {
        return l;
    }

    public String getXl() {
        return xl;
    }

    public String getXxl() {
        return xxl;
    }

    public String getXxxl() {
        return xxxl;
    }
}
