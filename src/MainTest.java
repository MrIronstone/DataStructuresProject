

import java.util.Scanner;
public class MainTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println(
                    "0. Exit\n"+
                    "1. Add student\n"+
                    "2. Delete student\n"+
                    "3. Find student\n"+
                    "4. List all students\n"+
                    "5. List distinct names\n"+
                    "6. List name counts\n"+
                    "7. About\n"+
                    "Enter your selection: ");
            int answer = Integer.parseInt(input.nextLine());
            if (answer >= 0 && answer <= 7) {
                switch (answer) {
                    case 0:

                        while(true) {
                            System.out.println("Do you really want to exit? (Y/N) ");
                            String exitAnswer = input.nextLine();
                            if (exitAnswer.equals("Y"))
                                System.exit(0);
                            if (exitAnswer.equals("N"))
                                break;
                            else
                                System.out.println("Wrong Input, try again");
                        }
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:
                        System.out.println("The author of this program is \n" +
                                "Hüsamettin Demirtaş who studies at Celal Bayar University \n" +
                                "on Computer Engineer Department"
                        );
                }
            } else {
                System.out.println("Wrong Input, try again");
            }
        }
    }
}
