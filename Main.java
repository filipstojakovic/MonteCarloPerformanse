import java.util.Scanner;

/**
 * @author Filip Stojakovic
 */
public class Main
{
    public static final String RANDOM_NUMBER_TEXT = "unesite broj slučajnih brojeva:";
    public static final String DECIMAL_PRECISION_TEXT = "unesite broj decimala preciznosti (0-10):";
    private static Scanner scanner = new Scanner(System.in);
    private static final String text = "Unesite:\n" +
            "1 - broj slučajno generisanih vrijednosti\n" +
            "2 - broj decimala koje treba da se poklope sa pravom vrijednošću\n" +
            "0 - kraj";

    public static void main(String[] args)
    {
        int input;
        do
        {
            input = getNumberInput(text, 0, 2);
            if (input == 1)
                firstMethod();
            else if (input == 2)
                secondMethod();

        } while (input != 0);

        scanner.close();
    }


    private static void firstMethod()
    {
        int inputNumber = getNumberInput(RANDOM_NUMBER_TEXT, 1, Integer.MAX_VALUE);

        int numbersInCircle = 0;
        for (int i = 0; i < inputNumber; i++)
        {
            double sqrt = getRandomSqrt();
            if (sqrt <= 1)
                numbersInCircle++;
        }
        double pi_result = 4.0 * numbersInCircle / inputNumber;
        System.out.println(pi_result);
    }

    private static double getRandomSqrt()
    {
        double x = Math.random();
        double y = Math.random();
        return Math.sqrt(x * x + y * y);
    }

    private static void secondMethod()
    {
        int inputPrecision = getNumberInput(DECIMAL_PRECISION_TEXT, 0, 10); //example 2
        double precision = Math.pow(10, -inputPrecision);   // 1/10^2

        double pi_result = 0;
        int numbersInCircle = 0;
        int n = 0;
        while (!(Math.abs(Math.PI - pi_result) < precision))
        {
            double sqrt = getRandomSqrt();
            if (sqrt <= 1)
                numbersInCircle++;

            n++;
            pi_result = 4.0 * numbersInCircle / n;
        }
        System.out.println(String.format("%." + inputPrecision + "f", pi_result));
    }


    //get input from range [min,max] including min,max
    private static int getNumberInput(String text, int min, int max)
    {
        int input = min;
        do
        {
            System.out.println(text);
            try
            {
                input = scanner.nextInt();

            } catch (Exception ex)
            {
                scanner = new Scanner(System.in);
            }
        } while (!(min <= input && input <= max));

        return input;
    }

}
