package cn.bushadie.excel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author jdmy
 * on 2019/3/26.
 **/
public class ExcelUtils {
    public static void hutoolXlsxReader(String filePath){
        ExcelReader reader=ExcelUtil.getReader(FileUtil.file(filePath));
        List<List<Object>> list=reader.read();
        for(List<Object> item: list) {
            System.out.println(item);
        }
    }
    public static void hutoolXlsReader(String filePath){
        hutoolXlsxReader(filePath);
    }

    public static void poiXlsxReader(String filePath) throws Exception {
        File file=ResourceUtils.getFile("classpath:"+filePath);
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet=wb.getSheetAt(0);
        // 获得总列数
        int columnNumber=sheet.getRow(0).getPhysicalNumberOfCells();
        // 获得总行数
        int rowNum=sheet.getLastRowNum();
        for(int i=0;i<rowNum;i++) {
            XSSFRow row=sheet.getRow(i);
            for(int j=0;j<columnNumber;j++) {
                String value=row.getCell(j).getRawValue();
                System.out.print(value + "--");
            }
            System.out.println("");
        }
    }

    public static void poiXlsReader(String filePath) throws Exception{
        File file=ResourceUtils.getFile("classpath:"+filePath);
        poiXlsReader(file);
    }
    public static void poiXlsReader(InputStream inputStream) throws Exception{
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
        poiXlsReader(wb);
    }
    public static void poiXlsReader(HSSFWorkbook wb){
        HSSFSheet sheet=wb.getSheetAt(0);
        // 获得总列数
        int columnNumber=sheet.getRow(0).getPhysicalNumberOfCells();
        // 获得总行数
        int rowNum=sheet.getLastRowNum();
        for(int i=0;i<rowNum;i++) {
            HSSFRow row=sheet.getRow(i);
            for(int j=0;j<columnNumber;j++) {
                row.getCell(j).setCellType(CellType.STRING);
                String value=row.getCell(j).getStringCellValue();
                System.out.print(value + "--");
            }
            System.out.println();
        }
    }
    public static void poiXlsReader(File file) throws Exception{
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
        poiXlsReader(wb);
    }

}
