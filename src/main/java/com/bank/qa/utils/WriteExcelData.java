package com.bank.qa.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelData {
    FileInputStream fis;
    public void writeExcelData(String sheetName, int rowNo, int cNo, String data) {
        try {
            fis = new FileInputStream("D:\\MyProjects\\playwright\\bank-project-testing-with-java-playwright\\src\\main\\resources\\data\\test-data.xlsx");
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNo);
            Cell cell = row.getCell(cNo);
            cell.setCellValue(data);
            FileOutputStream fos = new FileOutputStream("D:\\MyProjects\\playwright\\bank-project-testing-with-java-playwright\\src\\main\\resources\\data\\test-data.xlsx");
            workbook.write(fos);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
