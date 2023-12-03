import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day2p1 {
    public static void main(String[] args) throws FileNotFoundException {
        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;

        File a = new File("input.txt");
        Scanner sc = new Scanner(a);

        int shamelesslyEasyLineCount = 0;
        int sum = 0;
        while (sc.hasNextLine()) {
            shamelesslyEasyLineCount++;
            String split = sc.nextLine();
            split = split.substring(split.indexOf(':') + 2);
            String[] splArr = split.split("; ");
            try {
                boolean failed = false;
                for (int i = 0; i < splArr.length; i++) {
                    split = splArr[i].toString();
                    String[] commaSplit = split.split(", ");
                    for (int j = 0; j < commaSplit.length; j++) {
                        if (commaSplit[j].contains("r") && !commaSplit[j].contains("g")) {
                            String holdr = commaSplit[j];
                            holdr = holdr.replaceAll("[^0-9]", "");
                            int actualRed = Integer.parseInt(holdr);
                            if (actualRed > maxRed) {
                                failed = true;
                            }
                        }
                        else if (commaSplit[j].contains("b")) {
                            String holdr = commaSplit[j];
                            holdr = holdr.replaceAll("[^0-9]", "");
                            int actualBlue = Integer.parseInt(holdr);
                            if (actualBlue > maxBlue) {
                                failed = true;
                            }
                        }
                        else if (commaSplit[j].contains("g")) {
                            String holdr = commaSplit[j];
                            holdr = holdr.replaceAll("[^0-9]", "");
                            int actualGreen = Integer.parseInt(holdr);
                            if (actualGreen > maxGreen) {
                                failed = true;
                            }
                        }
                    }
                }
                if (!failed) {
                    sum += shamelesslyEasyLineCount;
                }
            } catch (Exception e) {
                continue;
            }
        }
        System.out.println(sum);
        sc.close();
    }
}