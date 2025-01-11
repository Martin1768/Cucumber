package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
    private String fileName = null;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ExcelReader(String fileName) {
        this.fileName = fileName;
    }

    public ExcelReader() {
        this("testsetUsers.xlsx");
    }

    public List<Map<String, String>> getAllSheetCells(String sheetName) throws IOException {
        List<Map<String, String>> sheetCells = new ArrayList<>();

        try (FileInputStream xlsxFile = new FileInputStream(Constants.EXCEL_FILE_PATH + fileName)) {
            XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            Row headerRow = sheet.getRow(0);
            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                Map<String, String> rowCells = new LinkedHashMap<>();
                int columns = row.getPhysicalNumberOfCells();
                for (int j = 0; j < columns; j++) {
                    String columnName = headerRow.getCell(j).toString();
                    String cellValue = row.getCell(j).toString();
                    rowCells.put(columnName, cellValue);
                }
                sheetCells.add(rowCells);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sheetCells;
    }
}
