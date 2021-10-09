package test;

import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {


        Scanner scan = new Scanner (System.in);
        scan.useLocale(Locale.US);
        double x = scan.nextDouble ();
        double y = scan.nextDouble ();
        boolean insideCircle = y <= 2 - x * x;
        boolean onTheLeft = y >= x;
        boolean onTopFunctionYequalsX = y >= 0;
        boolean insideTheArea = insideCircle && (onTheLeft || onTopFunctionYequalsX);
        System.out.println(insideTheArea ? "Yes" : "No");
    }
}
