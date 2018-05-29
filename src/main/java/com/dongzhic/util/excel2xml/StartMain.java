package com.dongzhic.util.excel2xml;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.Map;

/**
 * Description:
 *
 * @author: dongzhic
 * @date: 2018/5/29 18:51
 */
@Slf4j
public class StartMain {

    private final String excelPath = "E:\\User.xlsx";

    public static void main(String[] args) {

    }


    public static Map<String, Object> excel2Map(String excelPath) {

        if (checkFile(excelPath)) {

        }


        return null;
    }

    /**
     * 判断文件是否存在
     * @param excelPath
     * @return
     */
    public static boolean checkFile(String excelPath) {

        boolean isEXCEL = true;
        File excelFile = new File("excelPath");
        //判断文件是否存在
        if(excelFile.exists()){
            isEXCEL = false;
        }
        //判断文件是否是excel文件
        String fileName = excelFile.getName();
        if(!fileName.endsWith("xls") && !fileName.endsWith("xlsx")){
            isEXCEL = false;
        }
        return isEXCEL;

    }



}
