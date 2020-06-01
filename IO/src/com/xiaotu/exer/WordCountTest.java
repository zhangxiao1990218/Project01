package com.xiaotu.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 记录文本文件中每个字符出现的次数
 *
 * @author 张晓
 * @create 2020-04-26 16:58
 */
public class WordCountTest {

    @Test
    public void testWordCount(){

        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(new File("hello.txt"));
            fw = new FileWriter(new File("wordCount.txt"));

            Map<Character,Integer> mapCount = new HashMap<Character,Integer>();
            int read;
            while((read = fr.read())!=-1){
                char ch = (char)read;
                if(mapCount.containsKey(ch)){
                    mapCount.put(ch,((Integer)mapCount.get(ch))+1);
                }else {
                    mapCount.put(ch,1);
                }
            }

            //写出文件
            Set<Map.Entry<Character, Integer>> entries = mapCount.entrySet();
            Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
            while(iterator.hasNext()){

                Map.Entry<Character, Integer> next = iterator.next();

                switch (next.getKey()){
                    case ' ' :
                        fw.write("空格="+next.getValue()+"\n");
                        break;
                    case '\t'://表示tab 键字符
                        fw.write("tab键="+next.getValue()+"\n");
                        break;
                    case '\r'://表示回车
                        fw.write("回车="+next.getValue()+"\n");
                        break;
                    case '\n'://表示换行
                        fw.write("换行="+next.getValue()+"\n");
                        break;
                    default:
                        fw.write(next.getKey()+"="+next.getValue()+"\n");
                        break;
                }



            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }


}
