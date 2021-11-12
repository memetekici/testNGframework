package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcel() throws IOException {
        //Store the path of the file in a string
        String path ="C:\\Users\\lenovo\\IdeaProjects\\testNGframework\\src\\test\\java\\resources\\Capitals (2).xlsx";
        //Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
        //Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0);
        //Go to first row
        Row row = sheet.getRow(0);
        //Go to first cell on that first row and print
        Cell cell = row.getCell(0);
        System.out.println("Data in the first cell : " + cell);
        //Go to second cell on that first row and print
        Cell cell1 = row.getCell(1);
        System.out.println(cell1);
        // Go to 2nd row first cell
        //WE CAn CHAIN GET THE DATA
        String france = workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(france);
        //Go to 3rd row 2nd cell-chain row and cell
        String name = workbook.getSheetAt(0).getRow(2).getCell(1).toString();
        System.out.println(name);
        Assert.assertTrue(name.equals("Ottowa"));

        //Find the number of row
        int rowCount = sheet.getLastRowNum();//Getting the last row number that is used.Index Start at 0.This gives up 1 less
        System.out.println("row count : " +(++rowCount));

        //Find the number of used row
        int numOfPhysicalRow=sheet.getPhysicalNumberOfRows();//Index Start at 1. This will give us only the number of row that is used
        System.out.println("Number Cell That is Used : "+numOfPhysicalRow);

        //Print countr,capital key value pairs as map object
        //{France=Paris},{Canada,Ottowa}
        Map<String,String> capitals = new HashMap<>();
        int countryColumn = 0;
        int capitalColumn = 1;
        for(int rowNumber = 1; rowNumber < rowCount; rowNumber ++){
            String country = sheet.getRow(rowNumber).getCell(countryColumn).toString();
            System.out.println(country);//All Country
            String capital = sheet.getRow(rowNumber).getCell(capitalColumn).toString();
            System.out.println(capital);
            capitals.put(country,capital);

        }
        System.out.println(capitals);
        fileInputStream.close();
        workbook.close();



    }
}
