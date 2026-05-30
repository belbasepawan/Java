public class Student{
    private int id;
    private String name;
    private int age;
    private int rollno;
    private String faculty;
    private int sem;

    // Constructor
    public Student(int id, String name, int age, int rollno, String faculty, int sem){
        this.id = id;
        this.name = name;
        this.age = age;
        this.rollno = rollno;
        this.faculty = faculty;
        this.sem = sem;
    }
    
    // Getter functions
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int getRollno(){
        return this.rollno;
    }

    public String getFaculty(){
        return this.faculty;
    }

    public int getSem(){
        return this.sem;
    }

    //string
    @Override
    public String toString(){

        return
            "ID: " + id +
            "\nName: " + name +
            "\nAge: " + age +
            "\nRoll No: " + rollno +
            "\nFaculty: " + faculty +
            "\nSemester: " + sem;
    }

}   
