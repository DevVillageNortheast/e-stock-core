package com.dvn.estock.core.configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.dvn.estock.core.util.ConstantEnv;

public class DatabaseConfig{

    private static final DatabaseConfig INSTANSE = new DatabaseConfig();

    private static String drive;
    private static String url;
    private static String user;
    private static String password;
    private static String dialect;

    private DatabaseConfig(){

    }

    static{

        try {
			FileReader arquivo = new FileReader(ConstantEnv.getDatabaseConfEnv());
			BufferedReader reader = new BufferedReader(arquivo);
            
            String linha = null;

            linha = reader.readLine();
            if(linha != null){DatabaseConfig.drive = linha;}else{DatabaseConfig.drive = "INDEFINIDO";}
            
            linha = reader.readLine();
            if(linha != null){DatabaseConfig.url = linha;}else{DatabaseConfig.url = "INDEFINIDO";}

            linha = reader.readLine();
            if(linha != null){DatabaseConfig.user = linha;}else{DatabaseConfig.user = "INDEFINIDO";}

            linha = reader.readLine();
            if(linha != null){DatabaseConfig.password = linha;}else{DatabaseConfig.password = "INDEFINIDO";}

            linha = reader.readLine();
            if(linha != null){DatabaseConfig.dialect = linha;}else{DatabaseConfig.dialect = "INDEFINIDO";}

            arquivo.close();
            reader.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }

    public static String getDrive(){
        return DatabaseConfig.drive;
    }
    public static String getUrl(){
        return DatabaseConfig.url;
    }
    public static String getUser(){
        return DatabaseConfig.user;
    }
    public static String getPassword(){
        return DatabaseConfig.password;
    }
    public static String getDialect(){
        return DatabaseConfig.dialect;
    }

    public static DatabaseConfig getInstanse(){
        return DatabaseConfig.INSTANSE;
    }

}