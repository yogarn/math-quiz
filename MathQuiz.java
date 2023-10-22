import java.util.Scanner;

public class MathQuiz {
    public static boolean isCorrect(int numberFirst, int numberSecond, char operator, double answer) {
        switch (operator) {
            case '+':
                if (numberFirst + numberSecond == answer) {
                    return true;
                } else {
                    return false;
                }
            case '-':
                if (numberFirst - numberSecond == answer) {
                    return true;
                } else {
                    return false;
                }
            case '*':
                if (numberFirst * numberSecond == answer) {
                    return true;
                } else {
                    return false;
                }
            case '/':
                if ((double) numberFirst / numberSecond == answer) {
                    return true;
                } else {
                    return false;
                }
            }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long timeStart = System.currentTimeMillis();
        int correctAnswer = 0;
        int wrongAnswer = 0;
        int questionCounter = 1;
        System.out.print("Enter maximum question you want to answer : ");
        int questionMaximum = input.nextInt();
        while (questionCounter <= questionMaximum) {
            int numberFirst = (int) (Math.random() * 10);
            int numberSecond = (int) (Math.random() * 10);

            numberSecond = numberSecond != 0 ? numberSecond : numberSecond + 1;

            int operatorRand = (int) (Math.random() * 10 % 4 + 1);
            char operator = ' ';

            switch (operatorRand) {
                case 1:
                    operator = '+';
                    break;
                case 2:
                    operator = '-';
                    break;
                case 3:
                    operator = '*';
                    break;
                case 4:
                    operator = '/';
                    break;
            }

            System.out.printf("%d %c %d : ", numberFirst, operator, numberSecond);
            double answer = input.nextDouble();
            
            if (isCorrect(numberFirst, numberSecond, operator, answer)) {
                correctAnswer++;
                System.out.println("Correct answer!");
            } else {
                wrongAnswer++;
                System.out.println("Wrong answer!");
            }

            questionCounter++;
        }
        long timeEnd = (System.currentTimeMillis() - timeStart);
        System.out.printf("You've answered %d correct question and %d wrong question in %d seconds!", correctAnswer, wrongAnswer, timeEnd/1000);
        input.close();
    }
}
