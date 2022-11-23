package com.heidelberg.screen.common;

import java.util.Calendar;

public class Constants {
    public static Short DATA_STATUS_ACTIVE = 1;
    public static Short DATA_STATUS_INACTIVE = 255;
    public static Long BUY_COMPANY_ID_CA = 5657632662572074629L;
    public static Long BRAND_ID_CA = 4869801378135125235L;
    public static Short SHOP_TYPE_OFFLINE = 1;

    public static String RES_STATUS_SUCCESS = "200";
    public static String RES_STATUS_NO_DATA = "000";
    public static String RES_STATUS_ERROR = "404";

    public static String RES_MSG_SUCCESS = "success";
    public static String RES_MSG_NO_DATA = "no data";
    public static String RES_MSG_ERROR = "error";


    public static Calendar LONGLONGAGO = Calendar.getInstance();

    static {
        LONGLONGAGO.set(1970, 0, 01);
    }

}
