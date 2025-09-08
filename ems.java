import java.util.*;
import java.lang.reflect.Constructor;

 class Snapshot {
 	void 
 }
 
 class Employee {
        String Emp_name;
        String Emp_id;
        String Address;
        String Mail_id;
        String Mobile_no;
        
        public Employee (Employee other) {
            this.Emp_name = other.Emp_name;
            this.Address = other.Address;
            this.Mail_id = other.Mail_id;
            this.Mobile_no = other.Mobile_no;
        }
        
        void updateInfo(String Emp_name, String Address, String Mail_id, String Mobile_no) {
            this.Emp_name = Emp_name;
            this.Address = Address;
            this.Mail_id = Mail_id;
            this.Mobile_no = Mobile_no;
        }
        
        void getSalary() {
        }
        
    }
    
    class Programmer extends Employee {
    	float bp;
    	public Programmer (Programmer other) {
    	super(other);
    	}	
    	@Override
    	void getSalary() {
	    	float gross = (1 + (97 + 10)/100) * bp;
    		float net = gross - (((12 + 1)/100) * bp);
    		System.out.println("Gross pay: " + gross + "\nNet pay: " + net);
    	}	
    }
    
    class AssistantProfessor extends Employee {
    	float bp;
    	public AssistantProfessor (AssistantProfessor other) {
    	super(other);
    	}
    	@Override
    	void getSalary() {
	    	float gross = (1 + (110 + 20)/100) * bp;
    		float net = gross - (((12 + 5)/100) * bp);
    		System.out.println("Gross pay: " + gross + "\nNet pay: " + net);
    	}
    }
    
    class AssociateProfessor extends Employee {
    	float bp;
    	public AssociateProfessor (AssociateProfessor other) {
    	super(other);
    	}
    	@Override
    	void getSalary() {
	    	float gross = (1 + (130 + 30)/100) * bp;
    		float net = gross - (((12 + 10)/100) * bp);
    		System.out.println("Gross pay: " + gross + "\nNet pay: " + net);
    	}
    }
    
    class Professor extends Employee {
    	float bp;
    	public Professor (Professor other) {
    	super(other);
    	}
    	@Override
    	void getSalary() {
	    	float gross = (1 + (140 + 40)/100) * bp;
    		float net = gross - (((12 + 15)/100) * bp);
    		System.out.println("Gross pay: " + gross + "\nNet pay: " + net);
    	}
    }
    
class Ems {
    
    public static void main(String[] args) {
        ArrayList<Employee> ems = new ArrayList<>();
        ArrayList<Employee> snapshot = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        while (bool) {
            System.out.println("Choose any options (1-6):\n 1.Add New Employee Details\n 2.Search For Employee\n 3.Update Existing Employee Details\n 4.Delete Employee\n 5.Print All Employee Details\n 6.Create a snapshot\n 7.Revert Previous Changes\n 8. Exit");
            int opt1 = sc.nextInt();
            int opt2;
            sc.nextLine();
            switch (opt1) {
                case 1:
                    System.out.println("Enter the no.of employees: ");
                    int limit = sc.nextInt();
                    sc.nextLine(); 
                    for (int i = 0; i < limit; i++) {
                        System.out.println("Choose Designation (1-4):\n 1.Programmer\n 2.Assistant Professor\n 3.Associate Professor\n 4.Professor");
                        opt2 = sc.nextInt();
                        switch (opt2) {
                        case 1:
                        	Programmer programmer = new Programmer();
                        	sc.nextLine();
	                        System.out.println("Enter the name of employee: ");
        	                programmer.Emp_name = sc.nextLine();
        	                System.out.println("Enter the employee ID: ");
        	                programmer.Emp_id = sc.nextLine();
        	                System.out.println("Enter the address: ");
        	                programmer.Address = sc.nextLine();
        	                System.out.println("Enter the mail ID: ");
        	                programmer.Mail_id = sc.nextLine();
        	                System.out.println("Enter the mobile no: ");
        	                programmer.Mobile_no = sc.nextLine();
        	                System.out.println("Enter the basic pay: ");
        	                programmer.bp = sc.nextFloat();
        	                ems.add(programmer);
        	                break;
                        case 2:
                        	AssistantProfessor assistantprof = new AssistantProfessor();
                        	sc.nextLine();
	                        System.out.println("Enter the name of employee: ");
        	                assistantprof.Emp_name = sc.nextLine();
        	                System.out.println("Enter the employee ID: ");
        	                assistantprof.Emp_id = sc.nextLine();
        	                System.out.println("Enter the address: ");
        	                assistantprof.Address = sc.nextLine();
        	                System.out.println("Enter the mail ID: ");
        	                assistantprof.Mail_id = sc.nextLine();
        	                System.out.println("Enter the mobile no: ");
        	                assistantprof.Mobile_no = sc.nextLine();
        	                System.out.println("Enter the basic pay: ");
        	                assistantprof.bp = sc.nextFloat();
        	                ems.add(assistantprof);
        	                break;
                        case 3:
                        	AssociateProfessor associateprof = new AssociateProfessor();
                        	sc.nextLine();
	                        System.out.println("Enter the name of employee: ");
        	                associateprof.Emp_name = sc.nextLine();
        	                System.out.println("Enter the employee ID: ");
        	                associateprof.Emp_id = sc.nextLine();
        	                System.out.println("Enter the address: ");
        	                associateprof.Address = sc.nextLine();
        	                System.out.println("Enter the mail ID: ");
        	                associateprof.Mail_id = sc.nextLine();
        	                System.out.println("Enter the mobile no: ");
        	                associateprof.Mobile_no = sc.nextLine();
        	                System.out.println("Enter the basic pay: ");
        	                associateprof.bp = sc.nextFloat();
        	                ems.add(associateprof);
        	                break;
        	        case 4:
                        	Professor prof = new Professor();
                        	sc.nextLine();
	                        System.out.println("Enter the name of employee: ");
        	                prof.Emp_name = sc.nextLine();
        	                System.out.println("Enter the employee ID: ");
        	                prof.Emp_id = sc.nextLine();
        	                System.out.println("Enter the address: ");
        	                prof.Address = sc.nextLine();
        	                System.out.println("Enter the mail ID: ");
        	                prof.Mail_id = sc.nextLine();
        	                System.out.println("Enter the mobile no: ");
        	                prof.Mobile_no = sc.nextLine();
        	                System.out.println("Enter the basic pay: ");
        	                prof.bp = sc.nextFloat();
        	                ems.add(prof);
        	                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter the employee ID to search for: ");
                    String id = sc.nextLine();
                    boolean flag = false;
                    for (Employee employee : ems) {
                        if (employee.Emp_id.equalsIgnoreCase(id)) {
                            System.out.println("Employee Found: " + "\nName: " + employee.Emp_name + "\nID: " + employee.Emp_id + "\nAddress: " + employee.Address + "\nMail ID: " + employee.Mail_id + "\nContact number:" + employee.Mobile_no + "\n");
                            employee.getSalary();
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("Employee Not Found");
                    }
                    break;
                case 3:
                    System.out.println("Enter the employee ID to update: ");
                    id = sc.nextLine();
                    for (Employee employee : ems) {
                        if (employee.Emp_id.equalsIgnoreCase(id)) {
                            System.out.println("Enter updated details:\n 1) Name:");
                            String nameNew = sc.nextLine();
                            System.out.println("2) Address: ");
                            String addressNew = sc.nextLine();
                            System.out.println("3) Mail ID: ");
                            String mailNew = sc.nextLine();
                            System.out.println("4) Contact no: ");
                            String contactNew = sc.nextLine();
                            employee.updateInfo(nameNew, addressNew, mailNew, contactNew);
                            System.out.println("Contact Updated Successfully");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the employee ID to delete: ");
                    id = sc.nextLine();
                    for (int i = 0; i < ems.size(); i++) {
                        if (ems.get(i).Emp_id.equalsIgnoreCase(id)) {
                            ems.remove(i);
                            System.out.println("Employee Details Deleted Successfully");
                            break;
                        }
                    }
                    break;
                case 5:
                    for (Employee employee : ems) {
                        System.out.println("Name: " + employee.Emp_name + "\nID: " + employee.Emp_id + "\nAddress: " + employee.Address + "\nMail ID: " + employee.Mail_id + "\nContact number:" + employee.Mobile_no + "\n");
                        employee.getSalary();
                    }
                    break;
                case 6:
			for (Employee employee : ems) { 
                		Constructor<employee> constructor = employee.class.getConstructor(Object.class);
				snapshot.add(constructor.newInstance(employee));
				}
			break;
		case 7:
			System.out.println("1.Revert Back To Last Snapshot\n 2.Undo Last Operation");
			int opt3 = sc.nextInt();
			switch(opt3) {
			case 1:
				ems.clear();
				for (Employee employee : snapshot) { 
                		Constructor<employee> constructor = employee.class.getConstructor(Object.class);
				ems.add(constructor.newInstance(employee));
				}	
				break;
			case 2:
			
				break;
			}
			break;
                case 8:
                    bool = false;
                    break;
            }
        }
    }
}
