package com.restaurant.workshopmongodb.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decodingParam(String param){
        try{
            return URLDecoder.decode(param, "UTF-8");
        } catch(UnsupportedEncodingException e){
            return "";
        }
    }
}
