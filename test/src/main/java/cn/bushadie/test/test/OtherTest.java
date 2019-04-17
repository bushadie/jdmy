package cn.bushadie.test.test;

import cn.hutool.core.util.IdUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author jdmy
 * on 2018/12/9.
 **/
public class OtherTest {

    /**
     * immutable  不可更改
     */
    @Test
    public void test1(){
        List<String> list=List.of("a","b");
        list.add("c");
        System.out.println("list = "+list);
    }

    /**
     * 随机生成id
     */
    @Test
    public void idTest(){
        System.out.println(IdUtil.simpleUUID().length());
        for(int i=0;i<100;i++) {
            System.out.println(IdUtil.simpleUUID());
        }
    }
}
