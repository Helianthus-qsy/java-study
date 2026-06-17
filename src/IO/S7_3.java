package IO;

import java.io.*;

public class S7_3 {
    public static void main(String[] args) throws IOException {
        String src = "E:\\code\\ideacode\\spring6\\src\\a.txt";

        copyByISR_OSW_Char(src, "b1.txt");
        copyByISR_OSW_Array(src, "b2.txt");
        copyByFR_FW_Char(src, "b3.txt");
        copyByFR_FW_Array(src, "b4.txt");
        copyByBuffered(src, "b5.txt");

        System.out.println("文本文件拷贝完成！");
    }

    // 转换流：单个字符拷贝
    public static void copyByISR_OSW_Char(String src, String dest) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(src));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dest));

        int ch;
        while ((ch = isr.read()) != -1) {
            osw.write(ch);
        }

        isr.close();
        osw.close();
    }

    // 转换流：字符数组拷贝
    public static void copyByISR_OSW_Array(String src, String dest) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(src));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dest));

        char[] chars = new char[1024];
        int len;
        while((len = isr.read(chars))!=-1){
            osw.write(chars,0,len);
        }

        isr.close();
        osw.close();
    }

    // 字符流：单个字符拷贝
    public static void copyByFR_FW_Char(String src, String dest) throws IOException {
        FileReader fr = new FileReader(src);
        FileWriter fw = new FileWriter(dest);

        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fr.close();
        fw.close();
    }

    // 字符流：字符数组拷贝
    public static void copyByFR_FW_Array(String src, String dest) throws IOException {
        FileReader fr = new FileReader(src);
        FileWriter fw = new FileWriter(dest);

        char[] chars = new char[1024];
        int len;
        while ((len = fr.read(chars)) != -1) {
            fw.write(chars, 0, len);
        }

        fr.close();
        fw.close();
    }

    // 缓冲字符流：特殊方法按行拷贝
    public static void copyByBuffered(String src, String dest) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(src));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dest));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
