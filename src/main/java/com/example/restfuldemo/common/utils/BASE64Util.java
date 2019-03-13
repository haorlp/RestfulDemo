package com.example.restfuldemo.common.utils;

import java.util.Base64;

public class BASE64Util {
    /**
     * @desc 基于java8 封装base64加密函数
     * @Author Hadwin1991
     * @date 2018/10/16
     * @return
     */
    public static String encodeBASE64(String data)
    {
        Base64.Encoder encoder = Base64.getEncoder();
        String strEncodeBASE64Text = "";
        try
        {
            byte b[] = data.getBytes("UTF-8");
            strEncodeBASE64Text = encoder.encodeToString(b);
        }catch (Exception e)
        {
//            throw e;
            System.out.println("Error in data encryption\n");
        }
        return strEncodeBASE64Text;
    }

    /**
     * @desc 基于java8 封装base64解密函数
     * @Author Hadwin1991
     * @date 2018/10/16
     * @return
     */
    public static String decodeBASE64(String data)
    {
        Base64.Decoder decoder = Base64.getDecoder();
        String strDecodeBASE64Text = "";
        try
        {
            strDecodeBASE64Text = new String(decoder.decode(data), "UTF-8");
        }catch (Exception e)
        {
//            throw e;
            System.out.println("Error in data encryption\n");
        }
        return strDecodeBASE64Text;
    }
}
