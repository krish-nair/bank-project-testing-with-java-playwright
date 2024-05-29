package com.bank.qa.utils;

import com.bank.qa.playwrightfactory.PlaywrightFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelData {
    FileInputStream fis;
    public String getExcelData(String sheetName, int rowNo, int cNo) {
        String data = "";

        try {
            fis = new FileInputStream("D:\\MyProjects\\playwright\\bank-project-testing-with-java-playwright\\src\\main\\resources\\data\\test-data.xlsx");
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNo);
            Cell cell = row.getCell(cNo);
            data = cell.getStringCellValue();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return data;
    }
}
