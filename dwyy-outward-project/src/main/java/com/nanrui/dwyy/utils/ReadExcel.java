package com.nanrui.dwyy.utils;

import com.nanrui.dwyy.bean.BDZ_Coord;
import com.nanrui.dwyy.bean.GS_BDZ;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    List<GS_BDZ> gs_bdzList = new ArrayList<>();
    List<BDZ_Coord> bdz_coordList = new ArrayList<>();
    GS_BDZ gs_bdz = null;
    BDZ_Coord bdz_coord = null;

    public List<GS_BDZ> readSourceData_GS_BDZ(String pathName) throws Exception {
        //1.读取Excel文档对象
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(pathName));
        //2.获取要解析的表格（第一个表格）
        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
        //获得最后一行的行号
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {//遍历每一行
            //3.获得要解析的行
            HSSFRow row = sheet.getRow(i);
            //4.获得每个单元格中的内容（String）
            gs_bdz = new GS_BDZ(
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getNumericCellValue(),
                    row.getCell(3).getStringCellValue(),
                    row.getCell(4).getStringCellValue(),
                    row.getCell(5).getStringCellValue(),
                    row.getCell(6).getNumericCellValue(),
                    row.getCell(7).getStringCellValue(),
                    row.getCell(8).getStringCellValue(),
                    "甘肃",
                    "gansu"
            );
            gs_bdzList.add(gs_bdz);
        }
        return gs_bdzList;
    }


    public List<BDZ_Coord> readSourceData_BDZ_Coord(String pathName) throws Exception {
        //1.读取Excel文档对象
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(pathName));
        //2.获取要解析的表格（第一个表格）
        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
        //获得最后一行的行号
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {//遍历每一行
            //3.获得要解析的行
            HSSFRow row = sheet.getRow(i);
            for (int j = 1;j<41;j++){
                row.getCell(j).getCellType();
            }

            Double valueDouble = 0.0;
            String valueString = "";

            bdz_coord = new BDZ_Coord();

            valueDouble = disposeDoubleValue(row.getCell(1));
            bdz_coord.setOID(valueDouble);
            valueString = disposeStringValue(row.getCell(2));
            bdz_coord.setSBMC(valueString);
            valueDouble = disposeDoubleValue(row.getCell(3));
            bdz_coord.setX_COORD(valueDouble);
            valueDouble = disposeDoubleValue(row.getCell(4));
            bdz_coord.setY_COORD(valueDouble);
            valueString = disposeStringValue(row.getCell(6));
            bdz_coord.setYXBH(valueString);
            valueDouble = disposeDoubleValue(row.getCell(7));
            bdz_coord.setSBZLX(valueDouble);
            valueDouble = disposeDoubleValue(row.getCell(8));
            bdz_coord.setSSZRQ(valueDouble);
            valueDouble = disposeDoubleValue(row.getCell(9));
            bdz_coord.setSTATE_ID(valueDouble);
            valueDouble = disposeDoubleValue(row.getCell(10));
            bdz_coord.setFHJD(valueDouble);
            valueString = disposeStringValue(row.getCell(11));
            bdz_coord.setCONNECTION(valueString);
            valueString = disposeStringValue(row.getCell(12));
            bdz_coord.setSBID(valueString);
            valueString = disposeStringValue(row.getCell(13));
            bdz_coord.setSBMC(valueString);
            valueDouble = disposeDoubleValue(row.getCell(14));
            bdz_coord.setDYDJ(valueDouble);
            valueString = disposeStringValue(row.getCell(15));
            bdz_coord.setYXDW(valueString);
            valueDouble = disposeDoubleValue(row.getCell(16));
            bdz_coord.setFHDX(valueDouble);
            valueString = disposeStringValue(row.getCell(17));
            bdz_coord.setSFBZ(valueString);
            valueString = disposeStringValue(row.getCell(18));
            bdz_coord.setBZDX(valueString);
            valueString = disposeStringValue(row.getCell(19));
            bdz_coord.setBZYS(valueString);
            valueString = disposeStringValue(row.getCell(20));
            bdz_coord.setBZFW(valueString);
            valueString = disposeStringValue(row.getCell(21));
            bdz_coord.setPLFS(valueString);
            valueString = disposeStringValue(row.getCell(22));
            bdz_coord.setDHZS(valueString);
            valueDouble = disposeDoubleValue(row.getCell(23));
            bdz_coord.setX(valueDouble);
            valueDouble = disposeDoubleValue(row.getCell(24));
            bdz_coord.setY(valueDouble);
            valueDouble = disposeDoubleValue(row.getCell(25));
            bdz_coord.setTYPE(valueDouble);
            valueString = disposeStringValue(row.getCell(26));
            bdz_coord.setGRIDSIZE(valueString);
            valueString = disposeStringValue(row.getCell(27));
            bdz_coord.setBZXSZD(valueString);
            valueString = disposeStringValue(row.getCell(28));
            bdz_coord.setBZNR(valueString);
            valueString = disposeStringValue(row.getCell(29));
            bdz_coord.setSSDS(valueString);
            valueString = disposeStringValue(row.getCell(30));
            bdz_coord.setKZFHID(valueString);
            valueDouble = disposeDoubleValue(row.getCell(31));
            bdz_coord.setAPPTYPE(valueDouble);
            valueString = disposeStringValue(row.getCell(32));
            bdz_coord.setRLBZ(valueString);
            valueString = disposeStringValue(row.getCell(33));
            bdz_coord.setSSKX(valueString);
            valueString = disposeStringValue(row.getCell(34));
            bdz_coord.setSSTQLX(valueString);
            valueString = disposeStringValue(row.getCell(35));
            bdz_coord.setSSTQ(valueString);
            valueString = disposeStringValue(row.getCell(36));
            bdz_coord.setYHBH(valueString);
            valueDouble = disposeDoubleValue(row.getCell(37));
            bdz_coord.setVERSIONID(valueDouble);
            valueString = disposeStringValue(row.getCell(38));
            bdz_coord.setSSDKX(valueString);
            valueString = disposeStringValue(row.getCell(39));
            bdz_coord.setSSDKXZX(valueString);
            valueDouble = disposeDoubleValue(row.getCell(38));
            bdz_coord.setPBZRL(valueDouble);
            valueString = disposeStringValue(row.getCell(40));
            bdz_coord.setSFYC(valueString);
            valueString = disposeStringValue(row.getCell(41));
            bdz_coord.setSFDXKGZ(valueString);


            //4.获得每个单元格中的内容（String）
            bdz_coordList.add(bdz_coord);
            /*String stringCellValue1 = row.getCell(1).getStringCellValue();
            double stringCellValue2 = row.getCell(2).getNumericCellValue();
            String stringCellValue3 = row.getCell(3).getStringCellValue();
            String stringCellValue4 = row.getCell(4).getStringCellValue();
            String stringCellValue5 = row.getCell(5).getStringCellValue();
            double stringCellValue6 = row.getCell(6).getNumericCellValue();
            String stringCellValue7 = row.getCell(7).getStringCellValue();
            String stringCellValue8 = row.getCell(8).getStringCellValue();
            System.out.println(
                    stringCellValue1 + "--" +
                    stringCellValue2 + "--" +
                    stringCellValue3 + "--" +
                    stringCellValue4 + "--" +
                    stringCellValue5 + "--" +
                    stringCellValue6  + "--" +
                    stringCellValue7  + "--" +
                    stringCellValue8
            );*/
        }
        return bdz_coordList;
    }

    public Double disposeDoubleValue(HSSFCell cell){
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
            case HSSFCell.CELL_TYPE_BLANK:
                return 0.0;
            default:
                return 0.0;
        }
    }

    public String disposeStringValue(HSSFCell cell){
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case HSSFCell.CELL_TYPE_BLANK:
                return "";
            default:
                return "";
        }
    }
}
