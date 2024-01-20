package javaTester;

public class Topic_03_System_Info {
    //lấy ra thông tin hệ điều hành
    public static void main(String args[]){
        String osName = System.getProperty("os.name");
        System.out.println(osName);
    }
}
