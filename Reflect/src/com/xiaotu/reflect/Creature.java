package com.xiaotu.reflect;

import java.io.Serializable;

/**
 * @author 张晓
 * @create 2020-04-28 9:23
 */
public class Creature <T> implements Serializable {

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    private void eat(){
        System.out.println("生物吃东西");
    }
}
