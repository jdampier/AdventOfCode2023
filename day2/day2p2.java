import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day2p2 {
    public static void main(String[] args) throws FileNotFoundException {
        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;

        File a = new File("input.txt");
        Scanner sc = new Scanner(a);

        int shamelesslyEasyLineCount = 0;
        int sum = 0;
        int powersum = 0;
        while (sc.hasNextLine()) {
            shamelesslyEasyLineCount++;
            String split = sc.nextLine();
            split = split.substring(split.indexOf(':') + 2);
            String[] splArr = split.split("; ");
            int highestRed = 0;
            int highestBlue = 0;
            int highestGreen = 0;
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
                            if (actualRed > highestRed) {
                                highestRed = actualRed;
                            }
                        }
                        else if (commaSplit[j].contains("b")) {
                            String holdr = commaSplit[j];
                            holdr = holdr.replaceAll("[^0-9]", "");
                            int actualBlue = Integer.parseInt(holdr);
                            if (actualBlue > maxBlue) {
                                failed = true;
                            }
                            if (actualBlue > highestBlue) {
                                highestBlue = actualBlue;
                            }
                        }
                        else if (commaSplit[j].contains("g")) {
                            String holdr = commaSplit[j];
                            holdr = holdr.replaceAll("[^0-9]", "");
                            int actualGreen = Integer.parseInt(holdr);
                            if (actualGreen > maxGreen) {
                                failed = true;
                            }
                            if (actualGreen > highestGreen) {
                                highestGreen = actualGreen;
                            }
                        }
                    }
                }
                if (!failed) {
                    sum += shamelesslyEasyLineCount;
                }
                powersum += (highestRed * highestBlue * highestGreen);
            } catch (Exception e) {
                continue;
            }
        }
        System.out.println(powersum);
        sc.close();
    }
}