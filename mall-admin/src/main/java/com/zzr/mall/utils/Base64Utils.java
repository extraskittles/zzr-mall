package com.zzr.mall.utils;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Base64Utils {


    // 图片路劲层级分隔符
    private static String separator = "/";


    public static void main(String[] args)  {
        Base64Utils t = new Base64Utils();
        //在这里可以直接写入base64的值进行测试
        String path = null;
        try {
            path = t.saveImg("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACoAAAAqCAMAAADyHTlpAAAA6lBMVEVHcEz/YBb/Zh7/Xxb/ZjP/f3//Xxb/Xxb/Xxb/Xxb/YBb/YBv/Xxf/YBj/bST/Xxb/Xxb/Xxb/Yhj/YBb/cRz/YBb/YBj/Xxb/Xxb/Xxf/YBb/ZBv/YRb/YBb/Xxb/Xxb/Yhb/YBb/Xxb/Xxb/Xxf/Yxz/YBn/Xxb/YBf/Xxb/YRb/Zhn/YBf/YBf/YBb/bST/Xxb/Xxb/Xxn/YRj/Zhn/Xxb/Xxb/Xxb/YRj/Xxb/YBb/////Xxf/YBb/aR7/YBn/Yhr/Xxf/YBf/YBb/YBb/cxf/YBj/YBj/YBb/Xxf/Xxb/YRj/ZiL/XxbA9t/yAAAATXRSTlMAfBmyBQLz/ub7rCWmXw57+cs+iQnENdz0mLccUYo43jnfwO12JD39d7NEFKS8bwfU8TNUCvi9yhXD7wHGchFHJ5lNnPcLSnTnpcxeD2lN0mwAAAEcSURBVDjL7dLXcsIwFATQdZVswDa99w7pvfee7P//Th7ABALY5IHJTCb7qjOjK90F1pWEJhkYqSVGUhEMTdcFgITwWmrwtWrP63YAaGyFz9ijBkBSDacqJQBylaeT/3T91LCzmdnzTNY2FlKXzN1NwfNLj3QX0YolCuT9lS87F6QtrMo8daos4/mBudvrE/1gb+uYfHlCmVVnjkYZ14FIYdLmM+UR0N/4+p3GaEYAADfJ013rcGdjfxsAEDH5PkvbJmOLfylGsz1N9Tijy350NNmEJll3ltGPOpNfdCCs2vJF1Swx8OlQUglaqkI5HNM+G0YQNRrsjymbxeCuFJv0aSmsVyWf5sM7mCcBHKVT4TSV3sSfDVfMz+gv5xMwK2WjDeLAxgAAAABJRU5ErkJggg==","C:\\javaIO");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //输出路径
        System.out.println(path);
    }



    public static String saveImg(String baseImg,String path)    {
        //定义一个正则表达式的筛选规则，为了获取图片的类型
        String rgex = "data:image/(.*?);base64";
        String type = getSubUtilSimple(baseImg, rgex);
        if(!(type.equals("gif")||type.equals("jpg")||type.equals("png"))){
            return null;
        }
        //去除base64图片的前缀
        baseImg = baseImg.replaceFirst("data:(.+?);base64,", "");
        byte[] b=null;
        /*byte[] bs;*/
        OutputStream os = null;
        String fileName = "";
        //把图片转换成二进制

            b = Base64.decodeBase64(baseImg.replaceAll(" ", "+"));

        //随机生成图片的名字，同时根据类型结尾
        fileName = UUID.randomUUID().toString() + "." + type;
        File file = new File(path);
        if (!file.exists() ||!file.isDirectory()) {
            file.mkdirs();
        }
        File imageFile = new File(path + "/" + fileName);
        // 保存
        try {
            os = new FileOutputStream(imageFile);
            os.write(b);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.getLocalizedMessage();
                }
            }
        }

        return path + separator + fileName;
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
