package cn.bushadie.excel.test;

import cn.bushadie.excel.ExcelUtils;
import org.junit.Test;

/**
 * @author jdmy
 * on 2019/3/26.
 **/
public class PoiTest {
    @Test
    public void xlsxReader() throws Exception {
        ExcelUtils.poiXlsxReader("static/1.xlsx");
    }
    @Test
    public void xlsReader() throws Exception {
        ExcelUtils.poiXlsReader("static/1.xls");

    }
    @Test
    public void mergeReader() throws Exception {
        ExcelUtils.poiXlsReader("static/合并.xls");
    }
}
