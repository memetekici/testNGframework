package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    //Create a new class: WriteExcel
    //Create a new method: writeExcel()
    @Test
    public void writeExcel() throws IOException {
        //Store the path of the file as string and open the file
        String path ="C:\\Users\\lenovo\\IdeaProjects\\testNGframework\\src\\test\\java\\resources\\Capitals (2).xlsx";

        //Open the workbook
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0);
        //Go to the first row
        Row row = sheet.getRow(0);
        //Create a cell on the 3rd index on the first row(D1)
        Cell cell4 = row.createCell(3);
        //Write “POPULATION” on that cell
        cell4.setCellValue("POPULATION");
        //row.createCell(3).setCellValue("POPULATION");//Short version

        //Create a cell on the 2nd row 4th cell(index3), and write 150000 D2 in the excel
        sheet.getRow(1).createCell(3).setCellValue("150000");
        //Create a cell on the 3rd row 4th cell(index3), and write 250000
        sheet.getRow(2).createCell(3).setCellValue("250000");
        //Create a cell on the 4th row 4th cell(index3), and write 54000
        sheet.getRow(3).createCell(3).setCellValue("54000");
        //Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //Close the file
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }

}
