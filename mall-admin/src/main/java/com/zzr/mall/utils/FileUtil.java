package com.zzr.mall.utils;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUtil{
   public static final String LINUXDIR=File.separator+"usr"+File.separator+"local"
           +File.separator+"target"+File.separator+"uploads"+File.separator;
    public static final String WINDOWDIR="C:\\javaIO\\";

   public static String saveWindowPicture(MultipartFile picture,String uploadsPath) {
       String uri=null;
       //检查文件大小，文件最大为1M,和符合文件格式
       String name = picture.getOriginalFilename();
       boolean isPicture = RXUtils.picMatch(picture.getOriginalFilename());
       boolean overFlow=picture.getSize()/(1024*1024)>1;
       if(overFlow||!isPicture){
            return uri;
       }

       if (picture != null){
           // 原始文件名
           String originalFileName = picture.getOriginalFilename();
           // 获取图片后缀
           String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
           // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
           String picName = UUID.randomUUID().toString() + suffix;

            String picPath=uploadsPath+picName;
           File saveFile = new File(picPath);
           try {
               // 将上传的文件保存到服务器文件系统
               picture.transferTo(saveFile);
           } catch (IOException e) {
               e.printStackTrace();
           }
           uri=WINDOWDIR+picName;
       }
       return uri;
   }

    public static String saveLinxuPicture(MultipartFile picture,String uploadsPath) {
        String uri=null;
        //检查文件大小，文件最大为1M,和符合文件格式
        String name = picture.getOriginalFilename();
        boolean isPicture = RXUtils.picMatch(picture.getOriginalFilename());
        boolean overFlow=picture.getSize()/(1024*1024)>1;
        if(overFlow||!isPicture){
            return uri;
        }

        if (picture != null){
            // 原始文件名
            String originalFileName = picture.getOriginalFilename();
            // 获取图片后缀
            String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
            // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
            String picName = UUID.randomUUID().toString() + suffix;

            String picPath=uploadsPath+picName;
            File saveFile = new File(picPath);
            try {
                // 将上传的文件保存到服务器文件系统
                picture.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
              uri="/uploads/"+picName;
        }
        return uri;
    }


}
