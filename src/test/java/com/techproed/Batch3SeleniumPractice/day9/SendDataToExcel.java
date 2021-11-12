package com.techproed.Batch3SeleniumPractice.day9;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendDataToExcel {

    @Test
    public void SendDataToExcel() throws IOException {
        String path="src/test/java/resources/medal table.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheet("medal");
        int lastRow=sheet.getLastRowNum();
        int lastCell=sheet.getRow(11).getLastCellNum();
        System.out.println(lastCell);
        List<String> infoAust =new ArrayList<>();
        for (int i = 1; i <lastCell ; i++) {
            infoAust.add(sheet.getRow(11).getCell(i).toString());
        }
        Sheet sheet1 =workbook.getSheetAt(0);
        for (int i = 0; i < infoAust.size(); i++) {
            sheet1.getRow(1).createCell(i).setCellValue(infoAust.get(i));
        }
        FileOutputStream fileOutputStream =new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
