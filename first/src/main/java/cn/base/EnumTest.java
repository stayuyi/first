package cn.base;

import lombok.ToString;
@ToString

public enum EnumTest {
    BLACK("黑色","深沉"),RED("红色","喜庆"),YELLOW("黄色","鲜艳");

    private EnumTest(String a,String b){
        this.a=a;
        this.b=b;
    };
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }




}
