package com.zzr.mall.utils;


import java.io.*;
import java.util.Properties;

public class IOUtils {
    ///通过类加载器方式
    public static String getResourceValue(String resourcePath, String key) throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = IOUtils.class.getClassLoader().getResourceAsStream(resourcePath);
        String aa = null;
        try {
            properties.load(resourceAsStream);
            aa = properties.getProperty(key);
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        }
        return aa;
    }

    public static String getRealPathValue(String realPath, String key) throws IOException {
        Properties properties = new Properties();
        BufferedReader bufferedReader = null;
        String value = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(realPath));
            properties.load(bufferedReader);
            value = properties.getProperty(key);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return value;

    }

    public static void main(String[] args) {
      /*  String key="aa";
        String path="aa.properties";
        String value = null;
        try {
            value = IOUtils.getValue(path, key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(value);
    }*/

        String key = "aa";
        String path = "C:\\Users\\extra\\Java-project\\skittlesNote2\\src\\main\\resources\\aa.properties";
        String value = null;
        try {
            value = IOUtils.getRealPathValue(path, key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(value);
    }
}
