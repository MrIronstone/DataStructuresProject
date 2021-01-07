import java.util.HashSet;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) {
        MyArrList<Student> arrList1 = new MyArrList<>();
        HashSet<Student> HashList1 = new HashSet<>();

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
                            // infinite loop if user doesn't input correctly
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
                        /*
                        This option adds the student to the list, tree and hash structures. You should get from
                        the user student id, name and surname before adding student. New student should be
                        added to the appropriate positions of the structures according to its student id (i.e
                        student id is the key).
                         */

                        System.out.println("Please enter name");
                        String name = input.nextLine();

                        System.out.println("Please enter surname");
                        String surname = input.nextLine();

                        System.out.println("Please enter id");
                        int id = Integer.parseInt(input.nextLine());


                        boolean isContain = false;
                        for(int i = 0 ; i < arrList1.size(); i++){
                            if( arrList1.get(i).getID() == id){
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
                            arrList1.add(newStudent);
                            HashList1.add(newStudent);
                            /*
                            if(arrList1.size()==0)
                                // The place where the adding is done to all data structures
                                arrList1.add(newStudent);
                            else{
                                int i = 0;
                                while( id > arrList1.get(i).getID()){
                                    i++;
                                }
                                // The place where the adding is done to all data structures
                                arrList1.add(i,newStudent);
                            }
                            */
                        }


                        break;

                    case 2:
                        /*
                        First get the student id from the user and (if found) delete this student from all
                        structures.
                        */
                        System.out.println("Please enter the ID that you want delete");
                        int wantedToDeleteID = Integer.parseInt(input.nextLine());
                        int index = 0;
                        boolean isFound = false;
                        for(int i = 0 ; i < arrList1.size(); i++){
                            if( arrList1.get(i).getID() == wantedToDeleteID){
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
                        /*
                        First get the student id from the user and (if found) and print this student’s properties
                        to the screen. Also print the number of search levels (how many hops) that you found
                        the student from the list, tree and hash.
                        */
                        System.out.println("Please enter the ID that you want print");
                        int wantedToPrint = Integer.parseInt(input.nextLine());
                        int index2 = 0;
                        boolean isFound2 = false;
                        for(int i = 0 ; i < arrList1.size(); i++){
                            if( arrList1.get(i).getID() == wantedToPrint){
                                isFound2 = true;
                                break;
                            }
                            isFound2=false;
                            index2++;
                        }
                        if(isFound2){
                            //
                            System.out.print("[");
                            System.out.print(arrList1.get(index2).getID());
                            System.out.print(", ");
                            System.out.print(arrList1.get(index2).getName());
                            System.out.print(", ");
                            System.out.print(arrList1.get(index2).getSurname());
                            System.out.println("]");

                        }
                        else {
                            System.out.println("The ID doesn't exist");
                        }

                        break;
                    case 4:
                        /*
                        If the user selects option 4, first ask him from which data structure he/she want to
                        operate and print all the student’s information according to selection by traversing
                        related structure.
                        */

                        break;
                    case 5:
                        /*
                        Print to the screen all the distinct “names” (use only names, not surnames) from your
                        data structures. (i.e. not list duplicate names to the screen).
                         */

                        break;
                    case 6:
                        /*
                        Show that how many of each “name” included in the data structures. (use only names,
                        not surnames). For example you can print like following format:
                        emre : 2
                        sevcan : 3
                        zeynep : 1
                         */

                        break;
                    case 7:
                        /*
                        7. Print the author(s) of the program (your student id, name and surname
                         */
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
