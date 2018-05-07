package com.dmt.core.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mali.sahin
 * @since 3.05.2018.
 */
@Getter
@Setter
class Excel {


    private String FILE_NAME = "";
    private XSSFWorkbook workBook;
    XSSFSheet sheet;

    public Excel(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
        this.workBook = new XSSFWorkbook();
        this.sheet = this.workBook.createSheet("TEST");
    }

    private void prepareExcel(List list, Class type) {
        int rowNum = 0;
        for (Object item : list) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
        }
    }

    public  String Fields(Object clazz){
        Field[] fields =  clazz.getClass().getFields();

        return  "";
    }

    public List<String> rowHeaders(Object clazz) throws IllegalAccessException {
        Field[] fields = ((Class) clazz).getDeclaredFields();
        List<String> headerList = new ArrayList<String>();
        for (Field field : fields) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if(annotation.toString().equals("@Excelable(enabled=true)")){
                    System.out.println(field.getName());
                    headerList.add(field.getName());
                }
            }
        }
        return headerList;
    }


}
