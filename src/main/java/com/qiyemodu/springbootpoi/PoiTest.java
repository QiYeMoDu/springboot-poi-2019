package com.qiyemodu.springbootpoi;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author QiYeMoDu
 * @version 1.0
 * ===========================================================
 * @function 这个类用来测试excle上传功能
 * ===========================================================
 * @date 2019/12/20 22:14
 */
@RestController
public class PoiTest {

    @PostMapping("/upload")
    public String uploadExcel(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            Workbook book = null;
            //文本对象
            book = new XSSFWorkbook(inputStream);
            //获取表数量
            int sheetsNumber = book.getNumberOfSheets();
            //获取sheet表对象
            Sheet sheet = book.getSheetAt(0);
            //获取sheet表有多少行
            int allRowNum = sheet.getLastRowNum();
            //注意此处排除第一行(一般都为列名),包含最后一行
            for (int i = 1; i <= allRowNum; i++) {
                //行对象
                Row row = sheet.getRow(i); //获取第1行
                if (row != null) {
                    System.out.println(row.getCell(1).toString());
                    System.out.println(row.getCell(2).toString());
                    System.out.println(row.getCell(3).toString());
                    System.out.println(row.getCell(4).toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传成功";
    }
}

