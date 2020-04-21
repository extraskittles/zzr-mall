package com.zzr.mall.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Base64Utils2 {
    public static void main(String[] args) {
        String path = Base64Utils2.savePic("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACoAAAAqCAMAAADyHTlpAAAA6lBMVEVHcEz/YBb/Zh7/Xxb/ZjP/f3//Xxb/Xxb/Xxb/Xxb/YBb/YBv/Xxf/YBj/bST/Xxb/Xxb/Xxb/Yhj/YBb/cRz/YBb/YBj/Xxb/Xxb/Xxf/YBb/ZBv/YRb/YBb/Xxb/Xxb/Yhb/YBb/Xxb/Xxb/Xxf/Yxz/YBn/Xxb/YBf/Xxb/YRb/Zhn/YBf/YBf/YBb/bST/Xxb/Xxb/Xxn/YRj/Zhn/Xxb/Xxb/Xxb/YRj/Xxb/YBb/////Xxf/YBb/aR7/YBn/Yhr/Xxf/YBf/YBb/YBb/cxf/YBj/YBj/YBb/Xxf/Xxb/YRj/ZiL/XxbA9t/yAAAATXRSTlMAfBmyBQLz/ub7rCWmXw57+cs+iQnENdz0mLccUYo43jnfwO12JD39d7NEFKS8bwfU8TNUCvi9yhXD7wHGchFHJ5lNnPcLSnTnpcxeD2lN0mwAAAEcSURBVDjL7dLXcsIwFATQdZVswDa99w7pvfee7P//Th7ABALY5IHJTCb7qjOjK90F1pWEJhkYqSVGUhEMTdcFgITwWmrwtWrP63YAaGyFz9ijBkBSDacqJQBylaeT/3T91LCzmdnzTNY2FlKXzN1NwfNLj3QX0YolCuT9lS87F6QtrMo8daos4/mBudvrE/1gb+uYfHlCmVVnjkYZ14FIYdLmM+UR0N/4+p3GaEYAADfJ013rcGdjfxsAEDH5PkvbJmOLfylGsz1N9Tijy350NNmEJll3ltGPOpNfdCCs2vJF1Swx8OlQUglaqkI5HNM+G0YQNRrsjymbxeCuFJv0aSmsVyWf5sM7mCcBHKVT4TSV3sSfDVfMz+gv5xMwK2WjDeLAxgAAAABJRU5ErkJggg==", "C:\\javaIO");
        System.out.println(path);

    }

    public static String savePic(String baseImg,String dirpath){
        //验证是否是base64格式字符串
        String rgex = "data:image/(.*?);base64";
        String type = getSubUtilSimple(baseImg, rgex);
        if(!(type.equals("gif")||type.equals("jpg")||type.equals("png"))){
            return null;
        }
        //需要对base64字符串进行处理
        baseImg = baseImg.replaceFirst("data:(.+?);base64,", "");
        byte[] b = Base64.decodeBase64(baseImg);
        //拼接文件路径
        //随机生成图片的名字，同时根据类型结尾
        String fileName = UUID.randomUUID().toString() + "." + type;
        File file = new File(dirpath);
        if (!file.exists() ||!file.isDirectory()) {
            file.mkdirs();
        }
        File imageFile = new File(dirpath + "/" + fileName);
        FileOutputStream os=null;
        try {
            os = new FileOutputStream(imageFile);
            os.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dirpath + "/" + fileName;
    }

    public static String getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            return m.group(1);
        }
        return "";


    }
}
