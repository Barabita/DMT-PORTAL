package com.dmt.core.util;

import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */

public class ExcelExportUtil {


    private XSSFWorkbook workbook;
    private XSSFSheet worksheet;
    private List<String> header;
    private String exportDir;

    public ExcelExportUtil(List<String> header) {
        super();
        workbook = new XSSFWorkbook();
        worksheet = workbook.createSheet("Export");
        this.header = header;
        addHeader();
    }

    public ExcelExportUtil(String workSheetName, List<String> header) {
        workbook = new XSSFWorkbook();
        worksheet = workbook.createSheet(workSheetName);
        this.header = header;
        addHeader();
    }

    public ExcelExportUtil(List<String> header, String exportDir) {
        super();
        workbook = new XSSFWorkbook();
        worksheet = workbook.createSheet("Export");
        this.header = header;
        this.exportDir = exportDir;
        addHeader();
    }

    public void addHeader(){
        XSSFRow row = worksheet.createRow(0);

        XSSFFont font = workbook.createFont();
        font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
        //font.setColor(new XSSFColor());
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);

        int i = 0;
        for(String s :header){
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(new XSSFRichTextString(s));
            cell.setCellStyle(style);
            i++;
        }
    }

    public XSSFRow addRow(int rowNum) {
        XSSFRow row = worksheet.createRow(rowNum + 1);
        return row;
    }

    public XSSFCell addCell(int rowNum, int cellNum, String val) {
        XSSFRow row = worksheet.getRow(rowNum + 1);
        XSSFCell cell = row.createCell(cellNum);
        cell.setCellValue(new XSSFRichTextString(val));
        cell.setCellType(cell.CELL_TYPE_STRING);
        return cell;
    }

    public XSSFCell addCell(int rowNum, int cellNum, Long val) {
        XSSFRow row = worksheet.getRow(rowNum + 1);
        XSSFCell cell = row.createCell(cellNum);
        cell.setCellValue(val.intValue());
        cell.setCellType(cell.CELL_TYPE_NUMERIC);
        return cell;
    }

    public XSSFCell addCell(int rowNum, int cellNum, Double val) {
        XSSFRow row = worksheet.getRow(rowNum + 1);
        XSSFCell cell = row.createCell(cellNum);
        cell.setCellValue(val.doubleValue());
        cell.setCellType(cell.CELL_TYPE_NUMERIC);
        return cell;
    }

    public XSSFCell addCell(int rowNum, int cellNum, Timestamp val) {
        XSSFRow row = worksheet.getRow(rowNum + 1);
        XSSFCell cell = row.createCell(cellNum);
        Date date = null;
        if(val != null)
            date = new Date(val.getTime());
        cell.setCellValue(date);
      /*HSSFCellStyle cellStyle = workbook.createCellStyle();
      cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("dd/mm/yyyy h:mm"));
      cell.setCellStyle(cellStyle);*/
        return cell;
    }


    /**
     * @return Filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String writeFile() throws FileNotFoundException,
            IOException {
        Random rand = new Random();
        return writeFile("EXCEL" + "_" + rand.nextInt(10000), "xlsx");
    }

    public String writeFile(String name, String extension) throws IOException {

        String fileName = exportDir + name + "." + extension;
        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();

        return fileName;
    }

    /**
     * @return Filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public OutputStream getFileOutputStream() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        return outputStream;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public List<String> getHeader() {
        return header;
    }}
