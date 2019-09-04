package com.nanrui.dwyy.utils;

import com.nanrui.dwyy.bean.BDZ_Message;

import java.util.ArrayList;
import java.util.List;

public class TestDataUtils {

    List<BDZ_Message> bdz_messageList = new ArrayList<>();
    public List<BDZ_Message> dataDispose(List<Object[]> objects){
        for (int i = 0; i < objects.size(); i++) {
            String bdzName_start = (String) objects.get(i)[0];
            String bdzCitycode_start = (String) objects.get(i)[1];
            Double bdzXcoord_start = (Double) objects.get(i)[2];
            Double bdzYcoord_start = (Double) objects.get(i)[3];
            BDZ_Message bdz_message = new BDZ_Message(bdzName_start,bdzXcoord_start,bdzYcoord_start,bdzCitycode_start);
            bdz_messageList.add(bdz_message);
        }
        return bdz_messageList;
    }

}
