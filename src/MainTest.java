

import java.util.Scanner;

public class MainTest {



    public static void main(String[] args) {
        MyArrList<Student> arrList1 = new MyArrList<>();

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

                        while(true){
                            System.out.println("Please enter the name ");
                            String answerName = input.nextLine();

                            System.out.println("Please enter the surname ");
                            String answerSurname = input.nextLine();

                            System.out.println("Please enter the ID ");
                            int answerID = Integer.parseInt(input.nextLine());

                            for(int i = 0 ; i < arrList1.size() ; i++ ){
                                if(arrList1.equals(answerID))
                                    System.out.println("This ID already exists.");
                                    break;
                            }
                            break;


                        }
                        break;

                    case 2:
                        System.out.println("Please enter the ID that you want to delete");
                        String wantedToDeleteID = input.nextLine();

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
                        System.out.println("\nThe author of this program is \n" +
                                "Hüsamettin Demirtaş who studies at Celal Bayar University \n" +
                                "on Computer Engineer Department\n"
                        );
                }
            } else {
                System.out.println("Wrong Input, try again");
            }
        }
    }
}
