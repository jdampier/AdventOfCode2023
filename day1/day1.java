package day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File a = new File("day1\\input.txt");
        Scanner sc = new Scanner(a);
        ArrayList<Integer> sumArray = new ArrayList<>();

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String imDumb = "";
            int digitCount = 0;
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    digitCount++;
                    if (digitCount <= 2) {
                        imDumb += str.charAt(i);
                    }
                }
            }
            sumArray.add(Integer.parseInt(imDumb));
            for(int i = 0; i < sumArray.size(); i++) {
                if (sumArray.get(i) < 10) {
                    sumArray.set(i, (sumArray.get(i) + (sumArray.get(i)*10)));
                }
            }
        }
        
        int sum = 0;
        for(int i = 0; i < sumArray.size(); i++)
            sum += sumArray.get(i);
        System.err.println(sum);

        sc.close();
    }
}