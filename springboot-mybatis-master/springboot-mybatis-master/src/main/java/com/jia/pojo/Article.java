package com.jia.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
public class Article {

    private long no;
    private String TI;
    private String AU;
    private String TC;
    private String PY;
    private String AB;

    public Article() {
    }

    public Article(long no, String TI, String AU, String TC, String PY, String AB) {
        this.no = no;
        this.TI = TI;
        this.AU = AU;
        this.TC = TC;
        this.PY = PY;
        this.AB = AB;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getTI() {
        return TI;
    }

    public void setTI(String TI) {
        this.TI = TI;
    }

    public String getAU() {
        return AU;
    }

    public void setAU(String AU) {
        this.AU = AU;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public String getPY() {
        return PY;
    }

    public void setPY(String PY) {
        this.PY = PY;
    }

    public String getAB() {
        return AB;
    }

    public void setAB(String AB) {
        this.AB = AB;
    }
}
