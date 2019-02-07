package cn.bushadie.java11;

import org.junit.Test;

import java.io.FileOutputStream;

/**
 * @author jdmy
 * on 2019/2/7.
 **/
public class InputStreamTest {
    @Test
    public void testName() throws Exception {
        var cl = this.getClass().getClassLoader();
        try (var is = cl.getResourceAsStream("file"); var os = new FileOutputStream("file2")) {
            is.transferTo(os); // 把输入流中的所有数据直接自动地复制到输出流中
        }
    }
}
