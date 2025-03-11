public class Ex1 {
    public static void main(String[] args) {
        String str1="Học";
        String str2="lập trình";
        String str3="java";
        StringBuilder sb = new StringBuilder();
        sb.append(str1).append(" ").append(str2).append(" ").append(str3);

        String result = sb.toString().toUpperCase();

        System.out.println("Chuỗi sau khi hoàn thành: " + result);
    }
}