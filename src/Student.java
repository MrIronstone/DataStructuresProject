public class Student implements Comparable
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


    @Override
    public int compareTo(Object o) {
        Student comparedStudent = (Student) o;
        if( this.getID() > comparedStudent.getID())
            return 1;
        else if( this.getID() == comparedStudent.getID() )
            return 0;
        else
            return -1;
    }

}
