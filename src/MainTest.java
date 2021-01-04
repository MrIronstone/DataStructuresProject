

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
                        System.out.println("Please enter name");
                        String name = input.nextLine();

                        System.out.println("Please enter surname");
                        String surname = input.nextLine();

                        System.out.println("Please enter id");
                        int id = Integer.parseInt(input.nextLine());

                        boolean isContain = false;
                        for(int i = 0 ; i < arrList1.size(); i++){
                            if(arrList1.get(i).getID() == id){
                                isContain = true;
                                break;
                            }
                            isContain=false;
                        }
                        if(isContain){
                            System.out.println("This ID already exist");
                        }
                        else{
                            Student newStudent = new Student(name,surname,id);
                            if(arrList1.size()==0)
                                // The place where the adding is done to all data structures
                                arrList1.add(newStudent);
                            else{
                                int i = 0;
                                while(id > arrList1.get(i).getID()){
                                    i++;
                                }
                                // The place where the adding is done to all data structures
                                arrList1.add(i,newStudent);
                            }
                        }


                        break;

                    case 2:
                        System.out.println("Please enter the ID that you want delete");
                        int wantedToDeleteID = Integer.parseInt(input.nextLine());
                        int index = 0;
                        boolean isFound = false;
                        for(int i = 0 ; i < arrList1.size(); i++){
                            if(arrList1.get(i).getID() == wantedToDeleteID){
                                isFound = true;
                                break;
                            }
                            isFound=false;
                            index++;
                        }
                        if(isFound){
                            // The place where the deletion is done from all data structures
                            arrList1.remove(index);
                        }
                        else {
                            System.out.println("The ID doesn't exist");
                        }

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
