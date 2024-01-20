package javaTester;

public class Topic_09_Array {
    int[] studentAge = {15, 10, 20,22};
    static String[] studentName = {"Nguyễn Văn A", "Lê Thanh Lâm"};
    public static void main(String[] args){
        String[] studentAddress = new String[5];
        studentAddress[0]="Đặng Ngọc Anh 1";
        studentAddress[1]="Đặng Ngọc Anh 2";
        studentAddress[2]="Đặng Ngọc Anh 3";
        studentAddress[3]="Đặng Ngọc Anh 4";
        studentAddress[4]="Đặng Ngọc Anh 5";
        studentAddress[5]="Đặng Ngọc Anh 6";

        System.out.println(studentName[0]);

        Topic_09_Array topic = new Topic_09_Array();

        System.out.println(topic.studentAge[0]);
    }

}
