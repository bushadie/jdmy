package cn.bushadie.excel.test;


import cn.bushadie.excel.ExcelUtils;
import org.junit.Test;

/**
 * @author jdmy
 * on 2019/3/26.
 **/
public class HutoolTest {
    @Test
    public void xlsxReader(){
        ExcelUtils.hutoolXlsxReader("static/1.xlsx");
    }
    @Test
    public void xlsReader(){
        ExcelUtils.hutoolXlsReader("static/1.xls");
    }

    /**
     * 第二行合并
     * 多个个合并,位置处于左边的那一格
     */
    @Test
    public void mergeReader(){
        ExcelUtils.hutoolXlsReader("static/合并.xls");
    }
}
