package com.xiaotu.exer;

import org.junit.Test;

/**
 *
 * 转义字符测试
 *
 * @author 张晓
 * @create 2020-04-26 17:30
 */
public class EscapeCharacterTest {

    @Test
    public void test(){
        System.out.println("****************************");
        //\r的作用应该是到这一行的最前边，并且覆盖掉文章内容。
        System.out.print("我是中国人\r我出生在河北邯郸\n");
        System.out.print("我是中国人\n我出生在\n河北\t邯郸");


    }

}
