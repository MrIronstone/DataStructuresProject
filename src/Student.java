public class Student{
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public

    Student(String n,String s, int id){
        this.name=n;
        this.surname=s;
        this.studentID=id;
    }

    @Override
    public boolean equals(Object obj) {
        int a = (int) obj;
        return this.studentID == a;
    }



}
