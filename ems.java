import java.util.*;
import java.lang.reflect.Constructor;

abstract class Stack {
    protected int top = -1;
    abstract void push(int value);
    abstract int pop();
    abstract int peek();
    abstract boolean isFull();
    abstract boolean isEmpty();
    abstract int size();
}

class ArrayStack extends Stack {
    private final int SIZE = 5;
    private int[] stack = new int[SIZE];
    private int count = 0;

    public void push(int value) {
        top = (top + 1) % SIZE;
        stack[top] = value;
        if (count < SIZE) count++;
    }

    public int pop() {
        if (count == 0) return -1;
        int value = stack[top];
        top = (top - 1 + SIZE) % SIZE;
        count--;
        return value;
    }

    public int peek() {
        if (count == 0) return -1;
        return stack[top];
    }

    public boolean isFull() {
        return count == SIZE;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }
}

class CircularEmployeeStack {
    private final int SIZE = 5;
    private Employee[] stack = new Employee[SIZE];
    private int top = -1;
    private int count = 0;

    public void push(Employee employee) {
            Constructor<?> constructor = employee.getClass().getConstructor(employee.getClass());
            Employee copy = (Employee) constructor.newInstance(employee);
            top = (top + 1) % SIZE;
            stack[top] = copy;
            if (count < SIZE) count++;
            }

    public Employee pop() {
        if (count == 0) return null;
        Employee value = stack[top];
        top = (top - 1 + SIZE) % SIZE;
        count--;
        return value;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}

class Snapshot {
    public void write(ArrayList<Employee> targetList, ArrayList<Employee> sourceList) {
        targetList.clear();
        for (Employee employee : sourceList) {
                Constructor<?> constructor = employee.getClass().getConstructor(employee.getClass());
                Employee copy = (Employee) constructor.newInstance(employee);
                targetList.add(copy);
    }
}

class UndoMethods {
    private ArrayStack addStack = new ArrayStack();
    private CircularEmployeeStack updateStack = new CircularEmployeeStack();
    private CircularEmployeeStack deleteStack = new CircularEmployeeStack();

    public void undo_add(ArrayList<Employee> ems) {
        int count = addStack.pop();
        for (int i = 0; i < count && !ems.isEmpty(); i++) {
            ems.remove(ems.size() - 1);
        }
        System.out.println("Undo Add: Removed " + count + " employee(s).");
    }

    public void record_add(int count) {
        addStack.push(count);
    }

    public void undo_update(ArrayList<Employee> ems) {
        Employee restored = updateStack.pop();
        if (restored == null) return;
        for (int i = 0; i < ems.size(); i++) {
            if (ems.get(i).Emp_id.equalsIgnoreCase(restored.Emp_id)) {
                ems.set(i, restored);
                System.out.println("Undo Update: Restored employee ID " + restored.Emp_id);
                return;
            }
        }
    }

    public void record_update(Employee employee) {
        updateStack.push(employee);
    }

    public void undo_delete(ArrayList<Employee> ems) {
        Employee restored = deleteStack.pop();
        if (restored != null) {
            ems.add(restored);
            System.out.println("Undo Delete: Restored employee ID " + restored.Emp_id);
        }
    }

    public void record_delete(Employee employee) {
        deleteStack.push(employee);
    }
}

class Employee {
    String Emp_name;
    String Emp_id;
    String Address;
    String Mail_id;
    String Mobile_no;

    public Employee() {}

    public Employee(Employee other) {
        this.Emp_name = other.Emp_name;
        this.Emp_id = other.Emp_id;
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

    void getSalary() {}
}

class Programmer extends Employee {
    float bp;

    public Programmer() {}

    public Programmer(Programmer other) {
        super(other);
        this.bp = other.bp;
    }

    public Programmer(Employee other) {
        super(other);
    }

    @Override
    void getSalary() {
        float gross = (1 + (97 + 10) / 100f) * bp;
        float net = gross - (((12 + 1) / 100f) * bp);
        System.out.println("Gross pay: " + gross + "\nNet pay: " + net);
    }
}

class AssistantProfessor extends Employee {
    float bp;

    public AssistantProfessor() {}

    public AssistantProfessor(AssistantProfessor other) {
        super(other);
        this.bp = other.bp;
    }

    public AssistantProfessor(Employee other) {
        super(other);
    }

    @Override
    void getSalary() {
        float gross = (1 + (110 + 20) / 100f) * bp;
        float net = gross - (((12 + 5) / 100f) * bp);
        System.out.println("Gross pay: " + gross + "\nNet pay: " + net);
    }
}

class AssociateProfessor extends Employee {
    float bp;

    public AssociateProfessor() {}

    public AssociateProfessor(AssociateProfessor other) {
        super(other);
        this.bp = other.bp;
    }

    public AssociateProfessor(Employee other) {
        super(other);
    }

    @Override
    void getSalary() {
        float gross = (1 + (130 + 30) / 100f) * bp;
        float net = gross - (((12 + 10) / 100f) * bp);
        System.out.println("Gross pay: " + gross + "\nNet pay: " + net);
    }
}

class Professor extends Employee {
    float bp;

    public Professor() {}

    public Professor(Professor other) {
        super(other);
        this.bp = other.bp;
    }

    public Professor(Employee other) {
        super(other);
    }

    @Override
    void getSalary() {
        float gross = (1 + (140 + 40) / 100f) * bp;
        float net = gross - (((12 + 15) / 100f) * bp);
        System.out.println("Gross pay: " + gross + "\nNet pay: " + net);
    }
}

class InputHelper {

    public static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer:");
            }
        }
    }
    
      public static int readFloat(Scanner sc) {
        while (true) {
            try {
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid float:");
            }
        }
    }

   public static String readString(Scanner sc) {
        return sc.nextLine();
    }
}

public class EMS {
    public static void main(String[] args) {
        ArrayList<Employee> ems = new ArrayList<>();
        ArrayList<Employee> snapshotList = new ArrayList<>();
        ArrayStack methodStack = new ArrayStack();
        Snapshot snapshot = new Snapshot();
        UndoMethods undo = new UndoMethods()
        boolean bool = true;

        while (bool) {
            System.out.println("Choose any options (1-8):\n 1.Add New Employee Details\n 2.Search For Employee\n 3.Update Existing Employee Details\n 4.Delete Employee\n 5.Print All Employee Details\n 6.Create a snapshot\n 7.Undo Operations\n 8.Exit");
            int opt1 = 0;
            try (Scanner sc = new Scanner(System.in)) {
                opt1 = readInt(sc);
                if (opt1 < 1 || opt1 > 8) {
                    System.out.println("Invalid option. Please choose between 1 and 8.");
                    continue;
                }
            }
            if (opt1 == 1 || opt1 == 3 || opt1 == 4) {
                methodStack.push(opt1);
                if (methodStack.isFull()) {
                    snapshot.write(snapshotList, ems);
                    System.out.println("Snapshot created due to full operation stack.");
                }
            }

            switch (opt1) {
                case 1:
                    int limit = 0;
                    while (true) {
                        try (Scanner sc = new Scanner(System.in)){
                            System.out.println("Enter the number of employees to add: ");
                            limit = readInt(sc);
                            if (limit < 0) {
                                System.out.println("Please enter a non-negative number.");
                                continue;
                            }
                            break;
                        }
                    }

                    for (int i = 0; i < limit; i++) {
                        int opt2 = 0;
                        while (true) {
                            try (Scanner sc = new Scanner(System.in)) {
                                System.out.println("Choose Designation (1-4):\n 1.Programmer\n 2.Assistant Professor\n 3.Associate Professor\n 4.Professor");
                                opt2 = readInt(sc);                                  continue;
                                }
                                break;
                            }
                            finally {  if (opt2 < 1 || opt2 > 4) {
                                    System.out.println("Invalid designation option.");
                        }

                        Employee base = new Employee();
                        try (Scanner sc = new Scanner(System.in)) {
                        System.out.println("Enter the name of employee: ");
                        base.Emp_name = readString(sc);
                        System.out.println("Enter the employee ID: ");
                        base.Emp_id = readString(sc);
                        System.out.println("Enter the address: ");
                        base.Address = readString(sc);
                        System.out.println("Enter the mail ID: ");
                        base.Mail_id = readString(sc);
                        System.out.println("Enter the mobile number: ");
                        base.Mobile_no = readString(sc);
                        }
                        finally { System.out.println("Employee details collected successfully"); }

                        float bp = 0;
                        while (true) {
                            try (Scanner sc = new Scanner(System.in){
                                System.out.println("Enter the basic pay: ");
                                bp = readFloat(sc);                                    continue;
                                }
                                break;
                                finally { if (bp < 0) {
                                    System.out.println("Basic pay cannot be negative."); }}
                    }

                        Employee employee = null;
                        switch (opt2) {
                            case 1:
                                Programmer programmer = new Programmer(base);
                                programmer.bp = bp;
                                employee = programmer;
                                break;
                            case 2:
                                AssistantProfessor assistant = new AssistantProfessor(base);
                                assistant.bp = bp;
                                employee = assistant;
                                break;
                            case 3:
                                AssociateProfessor associate = new AssociateProfessor(base);
                                associate.bp = bp;
                                employee = associate;
                                break;
                            case 4:
                                Professor professor = new Professor(base);
                                professor.bp = bp;
                                employee = professor;
                                break;
                        }

                        ems.add(employee);
                    }
                    undo.record_add(limit);
                    break;

                case 2:
                    System.out.println("Enter the employee ID to search for: ");
                    String id = readString();
                    boolean flag = false;
                    for (Employee employee : ems) {
                        if (employee.Emp_id.equalsIgnoreCase(id)) {
                            System.out.println("Employee Found: " + "\nName: " + employee.Emp_name + "\nID: " + employee.Emp_id + "\nAddress: " + employee.Address + "\nMail ID: " + employee.Mail_id + "\nContact number:" + employee.Mobile_no);
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
                    id = readString();
                    for (Employee employee : ems) {
                        if (employee.Emp_id.equalsIgnoreCase(id)) {
                            undo.record_update(employee);
                            System.out.println("Enter updated details:\n 1) Name:");
                            String nameNew = readString();
                            System.out.println("2) Address: ");
                            String addressNew = readString();
                            System.out.println("3) Mail ID: ");
                            String mailNew = readString();
                            System.out.println("4) Contact no: ");
                            String contactNew = readString();
                            employee.updateInfo(nameNew, addressNew, mailNew, contactNew);
                            System.out.println("Contact Updated Successfully");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Enter the employee ID to delete: ");
                    id = readString();                    
                    for (int i = 0; i < ems.size(); i++) {
                        if (ems.get(i).Emp_id.equalsIgnoreCase(id)) {
                            undo.record_delete(ems.get(i));
                            ems.remove(i);
                            System.out.println("Employee Details Deleted Successfully");
                            break;
                        }
                    }
                    break;

                case 5:
                    for (Employee employee : ems) {
                        System.out.println("Name: " + employee.Emp_name + "\nID: " + employee.Emp_id + "\nAddress: " + employee.Address + "\nMail ID: " + employee.Mail_id + "\nContact number:" + employee.Mobile_no);
                        employee.getSalary();
                    }
                    break;

                case 6:
                    snapshot.write(snapshotList, ems);
                    System.out.println("Snapshot created successfully.");
                    break;

                case 7:
                    System.out.println("Undo Options:");
                    System.out.println("1. Revert Back To Last Snapshot");
                    System.out.println("2. Undo Add Operation");
                    System.out.println("3. Undo Update Operation");
                    System.out.println("4. Undo Delete Operation");
                    int undoOpt = 0;
                    try (Scanner sc = new Scanner) {
                        undoOpt = readInt(sc);
                    }
                    finally {
                        if (undoOpt < 1 || undoOpt > 2) System.out.println("Select options between 1-4"); }

                    switch (undoOpt) {
                        case 1:
                            snapshot.write(ems, snapshotList);
                            System.out.println("Reverted to last snapshot.");
                            break;
                        case 2:
                            undo.undo_add(ems);
                            break;
                        case 3:
                            undo.undo_update(ems);
                            break;
                        case 4:
                            undo.undo_delete(ems);
                            break;
                        default:
                            System.out.println("Invalid undo option.");
                    }
                    break;

                case 8:
                    bool = false;
                    break;
            }
        }
    }
}
