package edu.nf.shopping;

import java.util.UUID;

/**
 * @author lishun
 * @date 2020/3/13
 */
public class GetUUIDUtil {

    public String getUUId(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }
}
