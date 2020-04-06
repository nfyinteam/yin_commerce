package edu.nf.shopping.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Achine
 * @date 2020/4/5
 */
public class TimeMillisUtils {
    /**
     * 获取时间戳流水号
     * @return
     */
    public static String getCurrentTimeMillisName(){
        String[] str = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().split("-");
        return String.valueOf(str[0] + str[1] + str[2] + System.currentTimeMillis());
    }
}
