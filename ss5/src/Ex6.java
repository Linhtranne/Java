public class Ex6 {
    public static void main(String[] args) {
        int[] markingArray = new int[1000];
        int[] originalArray = {101, 202, 101, 303, 404, 303, 303, 505, 606, 707, 808, 909, 101, 111, 101, 202, 101, 303, 303, 101};

        for (int num : originalArray) {
            markingArray[num - 1]++;
        }

        int maxFrequency = 0;
        int maxValue = 0;

        for (int i = 0; i < markingArray.length; i++) {
            if (markingArray[i] > maxFrequency) {
                maxFrequency = markingArray[i];
                maxValue = i + 1;
            }
        }

        System.out.println("Phần tử xuất hiện nhiều nhất là: " + maxValue);
        System.out.println("Số lần xuất hiện: " + maxFrequency);

        System.out.print("Các phần tử có cùng số lần xuất hiện cao nhất: ");
        for (int i = 0; i < markingArray.length; i++) {
            if (markingArray[i] == maxFrequency) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}