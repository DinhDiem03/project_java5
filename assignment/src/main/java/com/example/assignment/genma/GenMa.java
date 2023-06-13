package com.example.assignment.genma;
/*
 *  @author diemdz
 */

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class GenMa {

    public String genMaHoaDon(){
        String ma = "HD"+ RandomStringUtils.randomNumeric(5);
        return ma;
    }

    public String genMaGioHang(){
        String ma = "GH"+ RandomStringUtils.randomNumeric(5);
        return ma;
    }
}
