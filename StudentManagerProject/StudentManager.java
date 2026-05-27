import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Student{
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

public class StudentManager{

    public static int askprompt(Scanner scanner){
                int choice;
                System.out.println(" ");
                System.out.println("1. Add Student");
                System.out.println("2. View Student");
                System.out.println("3. Delete Student"); 
                System.out.println("4. Exit");  
                System.out.println(" ");
                System.out.print("Enter Your Choice: "); 
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println("===================");

                return choice;             
    }

    public static Student addstudent(Scanner scanner, int id){

        String name;
        int age;
        int rollno;
        String faculty;
        int sem;

        System.out.println(" ");
            System.out.print("Enter name: ");
            name = scanner.nextLine();

            
            System.out.print("Enter age: ");
            age = scanner.nextInt();
            scanner.nextLine();
            while(true){
                if(age > 30){
                    System.out.print("Age can't be greater than 30, Enter again(for "+id+"):");
                    age = scanner.nextInt();
                    scanner.nextLine();
                }else if(age >= 18)break;
                else{
                    System.out.print("Age can't be less than 18, Enter again(for "+id+"):");
                    age = scanner.nextInt();
                    scanner.nextLine();
                }

            }


            System.out.print("Enter rollno: ");
            rollno = scanner.nextInt();
            scanner.nextLine();
            while(true){
                
                if(rollno > 35){
                    System.out.print("Roll no. cannot be greater than 35. Enter again(for "+id+"):");
                    rollno = scanner.nextInt();
                    scanner.nextLine();
                }else if(rollno >= 1)break;
                else{
                    System.out.print("Roll no. cannot be less than 1. Enter again(for "+id+"):");
                    rollno = scanner.nextInt();
                    scanner.nextLine();
                }

            }


            System.out.print("Enter faculty (\"BCA\", \"BITM\", \"BscCSIT\"): ");
            faculty = scanner.nextLine();
            while(true){

                if(faculty.equals("BCA")|| faculty.equals("BITM") || faculty.equals("BscCSIT"))break;
                else{

                    System.out.print("Faculty can be BCA, BITM or BscCSIT. You entered "+faculty+". Enter again(for "+id+"):");
                    faculty = scanner.nextLine();
                }

            }


            System.out.print("Enter sem: ");
            sem = scanner.nextInt();
            scanner.nextLine();
            while(true){

                if(sem > 8){
                    System.out.print("Semester cannot be greater than 8. Enter again(for "+id+"):");
                    sem = scanner.nextInt();
                    scanner.nextLine();
                }else if(sem >= 1)break;
                else{
                    System.out.print("Semester cannot be less than 1. Enter again(for "+id+"):");
                    sem = scanner.nextInt();
                    scanner.nextLine();
                }

            }           
            
            
            System.out.println("\nAdded Student with ID: " + id);
            System.out.println("===================");
            
            return new Student(id, name, age, rollno, faculty, sem);
    }

    public static void viewstudent(Scanner scanner, ArrayList<Student> s){
         
    }

    public static void deletestudent(){}

    public static void main(String []args){
        int choice;
        int id = 1;

        int searchid;
        int deleteid;

        boolean idsearchstatus = false;
        

        Scanner scanner = new Scanner(System.in);   
        ArrayList<Student> s = new ArrayList<>(); 
        // arraylist is a type of class having generics


        System.out.println("===== Student Management System =====");

        
        mainloop:
        while(true){
            try {
                choice = askprompt(scanner);

                if(choice < 1 || choice > 4){
                    System.out.println("\n! Invalid Choice Try again");
                    continue;
                } 
                switch(choice){

                    case 1:
                        
                        while(true){
                            try {
                                s.add(addstudent(scanner, id));
                                id++;
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("\n Invalid input Try again");
                                scanner.nextLine();
                            } 
                        }
                    
                    case 2:
                        while(true){
                            try {

                                
                                viewstudent(scanner,s);
                                
                                System.out.println(" ");
                                System.out.print("Enter Id(0 for all): ");
                                searchid = scanner.nextInt();
                                scanner.nextLine();

                                idsearchstatus = false;

                                int size = s.size();
                                if(size == 0 && searchid ==0 ){
                                    System.out.println("\nThere are 0 students");
                                    break;
                                }else if (searchid == 0 ){
                                    System.out.println("\nPrinting all student details");
                                    for (int i = 0; i < s.size(); i++) {
                                            System.out.println("\n" + s.get(i));
                                            
                                        }
                                    idsearchstatus = true;
                                    break;
                                }
                                
                                
                                
                                for (int i = 0; i < size; i++) {
                                    if (searchid == s.get(i).getId()){
                                        System.out.println("\n" + s.get(i));
                                        idsearchstatus = true;
                                        break;
                                    }
                                    
                                }

                                System.out.println("===================");

                                if( idsearchstatus) break;
                                else{
                                    System.out.println("\nCouldnot find id. Try again");
                                }

                                
                                
                            } catch (InputMismatchException e) {
                                System.out.println("\nInvalid input Try again");
                                scanner.nextLine();
                                continue;
                            }
                            
                        }
                        
                    
                    case 3:
                        while(true){
                            try {
                                System.out.println(" ");
                                System.out.print("Enter Id to delete: ");
                                deleteid = scanner.nextInt();
                                scanner.nextLine();

                                idsearchstatus = false;

                                for (int i = 0; i < s.size(); i++) {
                                    if (deleteid == s.get(i).getId()) {
                                        s.remove(i);
                                        idsearchstatus = true;
                                        break;
                                    }
                                }

                                if( idsearchstatus) break;
                                else{
                                    System.out.println("\nCouldnot find id. Try again");
                                    continue;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\nInvalid input Try again");
                                scanner.nextLine();
                                continue;
                            }
                            
                        }
                        System.out.println("\nStudent "+ deleteid +" deleted successfully");
                        System.out.println("===================");
                        break;

                    case 4:
                        break mainloop;
                    
                    default:
                        break;
            }
                    
              
            } catch (InputMismatchException e) {
                System.out.println("\n!invalid input. Try again");
                scanner.nextLine();
                continue;
            } 
             
        }
        scanner.close();
        System.out.println("The program is terminated. Thank you for using this app 🙏");
        

    }
}
