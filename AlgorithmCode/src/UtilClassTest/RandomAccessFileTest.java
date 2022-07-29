package UtilClassTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        Employee e1 = new Employee("zhuhaowen", 24);
        Employee e2 = new Employee("xiaoZhouRong", 26);
        RandomAccessFile ra = new RandomAccessFile("src\\UtilClassTest\\employee.txt", "rw");
        ra.write(e1.name.getBytes());
        ra.writeInt(e1.age);
        ra.write(e2.name.getBytes());
        ra.writeInt(e2.age);
        ra.close();
        RandomAccessFile raf = new RandomAccessFile("src\\UtilClassTest\\employee.txt",  "r");
        int len = 8;
        //跳过第一个员工信息，其名字8字节，年龄4字节
        raf.skipBytes(12);
        System.out.println("第二个员工信息");
        String str = "";
        for (int i = 0; i < len; i++) {
            str = str + (char) raf.readByte();
        }
        System.out.println("name:" + str);
        System.out.println("age:" + raf.readInt());
        System.out.println("First employee's information:");
        //将文件指针移动到文件开始位置
        raf.seek(0);
        str = "";
        for (int i = 0; i < len; i++) {
            str = str + (char) raf.readByte();
        }
        System.out.println("name:" + str);
        System.out.println("age:" + raf.readInt());
        raf.close();
    }
}

class Employee {
    String name;
    int age;
    final static int LEN = 8;

    public Employee(String name, int age) {
        if (name.length() > LEN) {
            name = name.substring(0, 8);
        } else {
            while (name.length() < LEN) {
                name = name + "\u0000";
            }
        }
        this.name = name;
        this.age = age;
    }
}