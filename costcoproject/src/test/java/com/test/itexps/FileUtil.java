/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.itexps;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author rajes
 */
public class FileUtil {
    public static  Login getLoginData() throws Exception {
      Login login=null;
      
      FileInputStream inputStream = new FileInputStream(new File("c:\\data\\costcologin.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        //getting first worksheet
        Sheet firstSheet = workbook.getSheetAt(0);
        //get first row
        Row r =  firstSheet.getRow(0);
        Cell c = r.getCell(1); //username value
        String username= c.getStringCellValue();
         r =  firstSheet.getRow(1);
         c = r.getCell(1); //pass value
        String password= c.getStringCellValue();
                 login = new Login(username, password);
       
        System.out.println (login);
        inputStream.close();
      return login;
  }
}
