package Chapter8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExploreExceptions {
    static void main() {
        Scanner sc = new Scanner(System.in);

        String name;
        double quotient;
        double numerator, denominator;

        try {
            System.out.print("Please enter your name: ");
            name = sc.nextLine();

            System.out.print("Please enter the numerator: ");
            numerator = sc.nextDouble();

            System.out.print("Please enter the denominator: ");
            denominator = sc.nextDouble();

            quotient = numerator / denominator;

            System.out.println("The quotient is : " + quotient);

//            System.out.format("""
//                    Name        :   %s
//                    Numerator   :   %d
//                    Denominator :   %d
//                    Quotient    :   %d""", name, numerator, denominator, quotient);
        } catch (InputMismatchException e) {
            System.err.println("Incorrect input type. " + e.getCause());
        }
        catch(ArithmeticException ex){
            System.err.println("Cannot divide by zero");
        }
    }
}
