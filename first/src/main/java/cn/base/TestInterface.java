package cn.base;

/**
 * Created by yuyi on 2018/9/22.
 */

public interface TestInterface {
    default void thisIsDefaultMethod(){
        System.out.println("thisIsDefaultMethod");
    };

    void thisIsAbsractMethod();
}
