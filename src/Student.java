public class Student
{
    private String name;
    private String surname;
    private int studentID;

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public int getID(){
        return studentID;
    }

    Student(String n,String s, int id){
        this.name=n;
        this.surname=s;
        this.studentID=id;
    }
}
