package IO;

import java.io.*;

public class S7_2 {
    public static void main(String[] args) throws IOException {
        String src = "E:\\code\\ideacode\\spring6\\src\\music.mp3";
        String dest1 = "copy1.mp3";
        String dest2 = "copy2.mp3";

        long start1 = System.currentTimeMillis();
        copyByFileStream(src, dest1);
        long end1 = System.currentTimeMillis();
        System.out.println("字节流复制所用时间：" + (end1 - start1) + "毫秒");

        long start2 = System.currentTimeMillis();
        copyByBufferedStream(src, dest2);
        long end2 = System.currentTimeMillis();
        System.out.println("字节缓冲流复制所用时间：" + (end2 - start2) + "毫秒");
    }

    public static void copyByFileStream(String src, String dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);

        int b;
        while((b=fis.read())!=-1){
            fos.write(b);
        }

        fis.close();
        fos.close();
    }

    public static void copyByBufferedStream(String src, String dest) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }

        bis.close();
        bos.close();
    }
}
