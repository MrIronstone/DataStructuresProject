import java.util.*;

public class MainTest {

    public static void main(String[] args) {

        MyArrList<Student> arrList1 = new MyArrList<>();
        BinarySearchTree<Student> Tree1 = new BinarySearchTree<>();
        HashSet<Student> HashList1 = new HashSet<>();

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println(
                    "\n0. Exit\n"+
                    "1. Add student\n"+
                    "2. Delete student\n"+
                    "3. Find student\n"+
                    "4. List all students\n"+
                    "5. List distinct names\n"+
                    "6. List name counts\n"+
                    "7. About\n"+
                    "Enter your selection: ");

            String answer = input.nextLine();{
                switch (answer) {
                    case "0" -> {

                        while (true) {
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
                    }
                    case "1" -> {
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
                        for (int i = 0; i < arrList1.size(); i++) {
                            if (arrList1.get(i).getID() == id) {
                                isContain = true;
                                break;
                            }
                            isContain = false;
                        }
                        if (isContain) {
                            System.out.println("This ID already exist");
                        } else {
                            Student newStudent = new Student(name, surname, id);
                            arrList1.add(newStudent);
                            Tree1.insertIteratively(newStudent);
                            HashList1.add(newStudent);
                        }
                    }

                    case "2" -> {
                        /*
                        First get the student id from the user and (if found) delete this student from all
                        structures.
                        */
                        System.out.println("Please enter the ID that you want delete");
                        int wantedToDeleteID = Integer.parseInt(input.nextLine());
                        int index = 0;
                        boolean isFound = false;
                        for (int i = 0; i < arrList1.size(); i++) {
                            if (arrList1.get(i).getID() == wantedToDeleteID) {
                                isFound = true;
                                break;
                            }
                            isFound = false;
                            index++;
                        }
                        if (isFound) {
                            // The place where the deletion is done from all data structures
                            arrList1.remove(index);
                            Tree1.deleteRecursively(Tree1.root,arrList1.get(index));
                            HashList1.remove(arrList1.get(index));
                        } else {
                            System.out.println("The ID doesn't exist");
                        }
                    }
                    case "3" -> {
                        /*
                        First get the student id from the user and (if found) and print this student’s properties
                        to the screen. Also print the number of search levels (how many hops) that you found
                        the student from the list, tree and hash.
                        */
                        System.out.println("Please enter the ID that you want print");
                        int wantedToPrint = Integer.parseInt(input.nextLine());
                        int index2 = 0;
                        boolean isFound2 = false;
                        for (int i = 0; i < arrList1.size(); i++) {
                            if (arrList1.get(i).getID() == wantedToPrint) {
                                isFound2 = true;
                                break;
                            }
                            isFound2 = false;
                            index2++;
                        }
                        if (isFound2) {
                            //
                            System.out.print("[");
                            System.out.print(arrList1.get(index2).getID());
                            System.out.print(", ");
                            System.out.print(arrList1.get(index2).getName());
                            System.out.print(", ");
                            System.out.print(arrList1.get(index2).getSurname());
                            System.out.println("]");

                        } else {
                            System.out.println("The ID doesn't exist");
                        }
                    }
                    case "4" -> {
                        /*
                        If the user selects option 4, first ask him from which data structure he/she want to
                        operate and print all the student’s information according to selection by traversing
                        related structure.
                        */
                        while (true) {
                            System.out.println("Which Data Structure do you want to print ?" +
                                    "\n 1 For List" +
                                    "\n 2 For Binary Search Tree" +
                                    "\n 3 For Hash");

                            int answerForPrint = Integer.parseInt(input.nextLine());
                            switch (answerForPrint) {
                                case 1: {

                                    System.out.println(arrList1.toString());
                                    break;
                                }
                                case 2: {
                                    while (true) {

                                        System.out.println("Which traversal do you want to use to print Tree?" +
                                                "\n 1 For PreOrder" +
                                                "\n 2 For InOrder" +
                                                "\n 3 For PostOrder");

                                        int answerForTreeTraversal = Integer.parseInt(input.nextLine());
                                        switch (answerForTreeTraversal) {
                                            case 1 -> {
                                                Tree1.printPreorder();
                                            }
                                            case 2 -> {
                                                Tree1.printInorder();
                                            }
                                            case 3 -> {
                                                Tree1.printPostorder();
                                            }
                                            default -> System.out.println("You Typed Wrong, Try again");
                                        }
                                        break;
                                    }
                                    break;
                                }
                                case 3:
                                    for (Student gezici : HashList1)
                                        System.out.println(gezici);
                                    break;
                                default:
                                    System.out.println("You Typed Wrong, Try Again");
                            }
                            break;
                        }
                    }
                    case "5" -> {
                        /*
                        Print to the screen all the distinct “names” (use only names, not surnames) from your
                        data structures. (i.e. not list duplicate names to the screen).
                         */
                        String[] names = new String[arrList1.size()];
                        for (int i = 0; i < arrList1.size(); i++) {
                            names[i] = arrList1.get(i).getName();
                        }


                        List<String> list = Arrays.asList(names);

                        System.out.println("All Names : " + list);

                        HashSet<String> set = new HashSet<>(list);

                        System.out.println("No duplicates : " + set);

                    }
                    case "6" -> {
                        /*
                        Show that how many of each “name” included in the data structures. (use only names,
                        not surnames). For example you can print like following format:
                        emre : 2
                        sevcan : 3
                        zeynep : 1
                         */
                        TreeMap<String, Integer> myMap = new TreeMap<>();

                        //tokenize the input
                        String[] tokens = new String[arrList1.size()];
                        for (int i = 0; i < arrList1.size(); i++) {
                            tokens[i] = arrList1.get(i).getName();
                        }

                        int count;

                        for (String token : tokens) {
                            String word = token.toLowerCase();

                            if (myMap.containsKey(word)) //is word in map?
                            {
                                count = myMap.get(word);
                                myMap.put(word, count + 1);
                            } else
                                myMap.put(word, 1); //add new word
                        }

                        System.out.print("Name Counts : ");
                        System.out.println(myMap);

                    }
                    case "7" -> {
                        /*
                        7. Print the author(s) of the program (your student id, name and surname
                         */
                        System.out.println("\nThe author of this program is \n" +
                                "Hüsamettin Demirtaş who studies at Celal Bayar University \n" +
                                "on Computer Engineer Department\n");
                    }
                    default -> System.out.println("Wrong Input, Try Again");
                }
            }
        }
    }
}
