import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class StudentManager{

    public static int askprompt(Scanner scanner){
    	while(true) {
    		try {
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
                
                if(choice < 1 || choice > 4){
                    System.out.println("\n! Invalid Choice Try again");
                    continue;
                }

                return choice;    
                
	    	}  catch (InputMismatchException e) {
	            System.out.println("\n!invalid input. Try again");
	            scanner.nextLine();
	        }
    	}
    	
    }

    public static boolean addstudent(Scanner scanner, int id, ArrayList<Student> s){
      
        try {
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
                    }else if(age >= 18) break;
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
                    }else if(rollno >= 1) break;
                    else{
                        System.out.print("Roll no. cannot be less than 1. Enter again(for "+id+"):");
                        rollno = scanner.nextInt();
                        scanner.nextLine();
                    }

                }


                System.out.print("Enter faculty (\"BCA\", \"BITM\", \"BscCSIT\"): ");
                faculty = scanner.nextLine();
                while(true){

                    if(faculty.equalsIgnoreCase("BCA")|| faculty.equals("BITM") || faculty.equals("BscCSIT")) break;
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
                    }else if(sem >= 1) break;
                    else{
                        System.out.print("Semester cannot be less than 1. Enter again(for "+id+"):");
                        sem = scanner.nextInt();
                        scanner.nextLine();
                    }

                }           
                
                
                System.out.println("\nAdded Student with ID: " + id);
                System.out.println("===================");
                
                s.add(new Student(id, name, age, rollno, faculty, sem));
                
                return true;
            } catch (InputMismatchException e) {
                System.out.println("\n Invalid input Try again");
                scanner.nextLine();
                return false;
            }
    }

    public static boolean viewstudent(Scanner scanner, ArrayList<Student> s){

        int searchid;
        boolean idsearchstatus;
         try {

                                
                                
                                
                                System.out.println(" ");
                                System.out.print("Enter Id(0 for all): ");
                                searchid = scanner.nextInt();
                                scanner.nextLine();

                                idsearchstatus = false;

                                int size = s.size();
                                if(size == 0 && searchid ==0 ){
                                    System.out.println("\nThere are 0 students");
                                    System.out.println("===================");
                                    return false;
                                }else if (searchid == 0 ){
                                    System.out.println("\nPrinting all student details");
                                    for (int i = 0; i < s.size(); i++) {
                                            System.out.println("\n" + s.get(i));
                                            
                                        }
                                    idsearchstatus = true;
                                    System.out.println("===================");
                                    return false;
                                }
                                
                                
                                
                                
                                for (int i = 0; i < size; i++) {
                                    if (searchid == s.get(i).getId()){
                                        System.out.println("\n" + s.get(i));
                                        idsearchstatus = true;
                                        System.out.println("===================");
                                        return false;
                                    }
                                    
                                }

                                

                                if(idsearchstatus) return false;
                                else{
                                    System.out.println("\nCouldnot find id. Try again");
                                    return true;
                                }

                                
                                
                            } catch (InputMismatchException e) {
                                System.out.println("\nInvalid input Try again");
                                scanner.nextLine();
                                return true;
                            }
    }

    public static boolean deletestudent(Scanner scanner, ArrayList<Student> s){
        boolean idsearchstatus;
        int deleteid;

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
                }
            }

            if(!idsearchstatus){
                System.out.println("\nCouldnot find id. Try again");
                return false;
            }

            System.out.println("\nStudent "+ deleteid +" deleted successfully");
            System.out.println("===================");

            return true;
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input Try again");
            scanner.nextLine();
            return false;
        }
    }

    public static void main(String []args){
        int choice;
        int id = 1;

        boolean addstatus;
        boolean searchstatus;
        boolean deletestatus;
        

        Scanner scanner = new Scanner(System.in);   
        ArrayList<Student> s = new ArrayList<>(); 
        //  arraylist is a type of class having generics


        System.out.println("===== Student Management System =====");

        try{
            mainloop:
            while(true){
                    choice = askprompt(scanner);
                     
                    switch(choice){

                        case 1:
                            
                            while(true){
                                addstatus = addstudent(scanner, id, s);
                                if(addstatus)
                                {
                                    id++;
                                    break;
                                }
                            }
                            break;
                        
                        case 2:
                            while(true){
                                searchstatus = viewstudent(scanner,s);
                                if(!searchstatus)
                                    break;
                            }
                            break;
                        
                        case 3:
                            while(true){
                                deletestatus = deletestudent(scanner, s);
                                if(deletestatus)
                                    break;
                                
                            }
                            break;
                        
                        case 4:
                            break mainloop;
                        
                        default:
                            break;
                }
                        
                
                 
                
            }
            scanner.close();
            System.out.println("The program is terminated. Thank you for using this app 🙏");


        } catch(Exception e){
            System.out.println("The program is terminated. Thank you for using this app 🙏");
        }
            
        

    }
}
