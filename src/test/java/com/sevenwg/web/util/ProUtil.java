package com.sevenwg.web.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;

public class ProUtil {
    public Properties properties;

    public ProUtil(String filename) {
        this.properties = ReadProperties(filename);
    }

    public Properties ReadProperties(String filename) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            BufferedInputStream In = new BufferedInputStream(fileInputStream);
            properties.load(In);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String GetProperties(String key) {
        if(this.properties.containsKey(key)) {
            return this.properties.getProperty(key);
        }
        else {
            return "";
        }
    }

    public int GetLines() {
        return properties.size();
    }

    public static void main(String[] args) {
        ProUtil proUtil = new ProUtil("element.properties");
        System.out.println(proUtil.GetProperties("username"));
    }


}
