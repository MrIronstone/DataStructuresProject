public class Student implements Comparable<Student> {
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
    public int compareTo(Student o) {
        if( this.getID() < o.getID())
            return -1;
        else if( this.getID() == o.getID())
            return 0;
        else
            return 1;
    }

    @Override
     /*
     This method makes the printing a student better
     Instead of printing its name on memory, it prints its fields.
     without this override it prints like "Student@49097b5d"
     with this override, it prints like [Hüsamettin Demirtaş 190315074]
     */
    public String toString() {
        String rStr = "["+ name + " " + surname + " "+ studentID +"]";
        return rStr;
    }
}

