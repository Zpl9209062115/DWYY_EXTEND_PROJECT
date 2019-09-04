package com.nanrui.dwyy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nanrui.dwyy.DwyyApplication;

import java.io.*;
import java.util.ArrayList;

public class JsonUtils {
    // 存储文件列表
    private ArrayList<String> fileList = new ArrayList<>();

    /**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getFile(File path){
        File[] listFile = path.listFiles();
        for (File a : listFile){
            if (a.isDirectory()){
                //循环调用getFile()方法
                getFile(new File(a.getAbsolutePath()));
            } else if (a.isFile()){
                fileList.add(a.getAbsolutePath());
            }
        }
        return fileList;
    }

}
