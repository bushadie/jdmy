package cn.bushadie.test.test;

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
}
