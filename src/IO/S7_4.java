package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class S7_4 {
    public static void main(String[] args) throws IOException {
       //向指定的txt文件中写入键盘输入的内容，然后再重新读取该文件的内容，显示到控制台上。
        Scanner sc = new Scanner(System.in);
        String fileName = "student.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        System.out.println("请输入要写入的内容：");
        String line = sc.nextLine();
        bw.write(line);
        bw.newLine();
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String s2 ;
        while((s2=br.readLine())!=null){
            System.out.println(s2);
        }

       //键盘录入5个学生信息(姓名, 成绩)，按照成绩从高到低追加存入上述的文本文件中。

        ArrayList<Student> list = new ArrayList<Student>();
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入第" + (i + 1) + "个学生的成绩：");
            double score = Double.parseDouble(sc.nextLine());
            list.add(new Student(name, score));
        }

        Collections.sort(list);

        BufferedWriter bw2 = new BufferedWriter(new FileWriter(fileName,true));
        bw2.write("学生信息：");
        bw2.newLine();
        for(Student s:list){
            bw2.write(s.name+","+s.score);
            bw2.newLine();
        }
        System.out.println("学生信息已按成绩从高到低追加写入文件。");
        sc.close();
        bw2.close();
    }
}

class Student implements Comparable<Student> {
    String name;
    double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.score,this.score);
    }
}
