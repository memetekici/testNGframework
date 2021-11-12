package com.techproed.Batch3SeleniumPractice.day9;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetdataFromExcel {

    @Test
    public void getDataFromExcel() throws IOException {
        String path = "C:\\Users\\lenovo\\IdeaProjects\\testNGframework\\src\\test\\java\\resources\\medal table.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("medal");
        //Sheet sheet1 = workbook.getSheetAt(1);

        System.out.println(sheet.getRow(6).getCell(1));
        System.out.println(sheet.getRow(7).getCell(1));

        int lastRow = sheet.getLastRowNum();

        for (int i = 0; i <= lastRow; i ++) {
            System.out.println(sheet.getRow(i).getCell(1));
        }

       for (int j = 1; j <= 5; j ++){
           System.out.print(sheet.getRow(1).getCell(j));
           System.out.println(sheet.getRow(11).getCell(j));
       }
    }
}
