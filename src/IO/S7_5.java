package IO;

import java.io.*;

public class S7_5 {
    //复制指定目录中的指定类型（如.java）的文件到另一个目录中。
        public static void main(String[] args) throws IOException {
            File srcDir = new File("srcDir");
            File destDir = new File("destDir");

            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            File[] files = srcDir.listFiles();
            if (files == null) {
                System.out.println("源目录不存在或为空！");
                return;
            }

            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    copyFile(file, new File(destDir, file.getName()));
                    System.out.println(file.getName() + " 复制完成。");
                }
            }
        }

        public static void copyFile(File src, File dest) throws IOException {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }

            bis.close();
            bos.close();
        }
    }
