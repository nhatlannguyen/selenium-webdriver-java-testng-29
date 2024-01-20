package javaTester;

import java.sql.SQLOutput;
import java.util.Random;

public class Topic_06_Random {
    //Java builtin (cung cấp sawnc - lấy ra sử dụng
    // Java Libraries (do 1 tổ chức/cá nhân tự viết)
    public static void main(String[] args){
        Random rand = new Random();
        System.out.println(rand.nextInt(99999));
        System.out.println(rand.nextInt());

        System.out.println(rand.nextDouble());
        System.out.println(rand.nextFloat());
        System.out.println(rand.nextBoolean());

        System.out.println("chibeo" + rand.nextInt(99999) + "@gmail.net");
        System.out.println("chibeo" + rand.nextInt(99999) + "@gmail.net");
        System.out.println("chibeo" + rand.nextInt(99999) + "@gmail.net");
        System.out.println("chibeo" + Math.round(Math.random()*1000000) + "@gmail.net");
        System.out.println("chibeo" + Math.round(Math.random()*1000000) + "@gmail.net");
    }
}
