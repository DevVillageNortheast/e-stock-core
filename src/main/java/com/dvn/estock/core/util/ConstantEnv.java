package com.dvn.estock.core.util;

import java.util.Map;

import com.github.shyiko.dotenv.DotEnv;

public class ConstantEnv{
    
    private static final ConstantEnv INSTANSE = new ConstantEnv();
    
    private static String DATABASE_CONF_DIR;

    private ConstantEnv(){

    }

    static {
        Map<String, String> dotEnv = DotEnv.load();
        ConstantEnv.DATABASE_CONF_DIR = dotEnv.get("DATABASE_CONF_DIR");
    }

    public static String getDatabaseConfEnv(){
        return ConstantEnv.DATABASE_CONF_DIR;
    }

    public static ConstantEnv getInstanse(){
        return ConstantEnv.INSTANSE;
    }
}