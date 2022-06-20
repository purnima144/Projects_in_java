package projects;
import java.util.*;

class Employee{
    private int empno;
    private String ename;
    private int salary;

    //constructor to set the values
    Employee(int empno, String ename, int salary){
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    //since variables are private, so to access them outside the employee class define get method
    public int getEmpno(){
        return empno;
    }
    public int getSalary(){
        return salary;
    }
    public String getEname(){
        return ename;
    }
    //override toString method to get our desired output
    public String toString(){
        return empno+" "+ename+" "+salary;
    }
}

public class CRUD {
    public static void main(String[] args){

        System.out.println("**********************WELCOME TO DATABASE OF EMPLOYEE**********************");
        System.out.println();
        System.out.println("######## CHOOSE THE OPERATION YOU WANT TO PERFORM ########");
        List<Employee> c = new ArrayList<>();
        Scanner s = new Scanner(System.in);//for integer instance
        Scanner s1 = new Scanner(System.in);//for string instance
        int choice;
        do{
            System.out.println("-------------------------------------");
            System.out.println("SELECT 1. TO INSERT DATA");
            System.out.println("SELECT 2. TO DISPLAY RECORDS");
            System.out.println("SELECT 3. TO PERFORM SEARCH");
            System.out.println("SELECT 4. TO DELETE DATA");
            System.out.println("SELECT 5. TO UPDATE DATA");
            System.out.println("SELECT 0. TO EXIT FROM DATABASE");
            System.out.print("Enter Your Choice: ");
            choice = s.nextInt();
            System.out.println("-------------------------------------");
            switch (choice) {
            case 1:
                System.out.print("Enter Empno : ");
                int eno = s.nextInt();
                System.out.print("Enter EmpName : ");
                String ename = s1.nextLine();
                System.out.print("Enter EmpSalary : ");
                int salary = s.nextInt();
                c.add(new Employee(eno, ename, salary));//add the information to the list
                break;
            case 2:
                System.out.println("-------------------------------------");
                Iterator<Employee> itr = (Iterator<Employee>) c.iterator();
                while (itr.hasNext()) {
                    Employee e = itr.next();
                    System.out.println(e);
                }
                System.out.println("-------------------------------------");
                break;
            case 3:
                boolean found = false;
                System.out.print("Enter the Empno to search : ");
                int empno = s.nextInt();
                System.out.println("-------------------------------------");
                itr = (Iterator<Employee>) c.iterator();
                while (itr.hasNext()) {
                    Employee e = itr.next();
                    if(e.getEmpno() == empno){
                        System.out.println(e);
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("Record Not Found");
                }
                System.out.println("-------------------------------------");
                break;
            case 4:
                found = false;
                System.out.print("Enter the Empno to Delete : ");
                empno = s.nextInt();
                System.out.println("-------------------------------------");
                itr = (Iterator<Employee>) c.iterator();
                while (itr.hasNext()) {
                    Employee e = itr.next();
                    if(e.getEmpno() == empno){
                        itr.remove();
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("Record Not Found");
                }
                else{
                    System.out.println("Record Deleted Successfully....!!!");
                }
                System.out.println("-------------------------------------");
                break;
            case 5:
                found = false;
                System.out.print("Enter the Empno to Update : ");
                empno = s.nextInt();
                System.out.println("-------------------------------------");
                ListIterator<Employee> li = (ListIterator<Employee>) c.iterator();
                while (li.hasNext()) {
                    Employee e = li.next();
                    if(e.getEmpno() == empno){
                        System.out.print("Enter new Name: ");
                        ename = s1.nextLine();
                        System.out.print("Enter new Salary: ");
                        salary = s.nextInt();
                        li.set(new Employee(empno,ename,salary));
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("Record Not Found");
                }
                else{
                    System.out.println("Record Updated Successfully....!!!");
                }
                System.out.println("-------------------------------------");
                break;
            case 0:
                break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(choice != 0);
    }

    }

