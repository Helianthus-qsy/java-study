package IO;

import java.io.File;

public class S7_1 {
    static void main() {
        File f = new File("D:\\test");
        if(!f.exists()||!f.isDirectory()){
            System.out.println("指定目录不存在");
        } else{
            File[] files = f.listFiles();
            boolean flag = false;
            for(File f1 : files){
                if(f1.isFile()&&f1.getName().endsWith(".exe")){
                    System.out.println(f1.getName());
                    flag = true;
                }
            }
            if(!flag){
                System.out.println("没有exe文件");
            }
        }
    }
}
