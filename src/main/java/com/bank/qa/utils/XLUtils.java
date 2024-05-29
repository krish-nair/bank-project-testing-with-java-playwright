package com.bank.qa.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtils {
    public static FileInputStream fis;
    public static FileOutputStream fos;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String filePath, String sheetName) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(sheetName);
        int rowNum = ws.getLastRowNum();
        fis.close();
        wb.close();
        return rowNum;
    }
    public static int getCellCount(String filePath, String sheetName, int rowNum) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        fis.close();
        wb.close();
        return cellCount;
    }

    public static  String getCellData(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);
        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        }
        catch (Exception e){
            data = "";
        }
        wb.close();
        fis.close();
        return data;
    }
    public static void setCellData(String filePath, String sheetName, int rowNum, int colNum, String data) throws IOException {
        fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook();
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNum);
        cell = row.createCell(colNum);
        cell.setCellValue(data);
        fos = new FileOutputStream(filePath);
        wb.write(fos);
        wb.close();
        fis.close();
        fos.close();
    }
}
