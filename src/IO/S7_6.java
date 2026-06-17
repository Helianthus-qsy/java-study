package IO;

import java.io.*;
import java.util.Arrays;

public class S7_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\code\\ideacode\\spring6\\src\\s.txt"));
        String str = br.readLine();
        br.close();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\code\\ideacode\\spring6\\src\\ss.txt"));
        bw.write(chars);
        bw.close();

        System.out.println("排序前：" + str);
        System.out.println("排序后：" + new String(chars));
    }
}
