import java.util.*;

class Cms {
    public static class Info {
        String name;
        String num;

        void updateInfo(String name, String num) {
            this.name = name;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        ArrayList<Info> cms = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        while (bool) {
            System.out.println("Choose any options (1-6):\n 1.Add New Contacts\n 2.Search For Contact\n 3.Update Existing Contacts\n 4.Delete Contacts\n 5.Print All Contacts\n 6. Exit");
            int opt = sc.nextInt();
            sc.nextLine(); // Consume newline character
            switch (opt) {
                case 1:
                    System.out.println("Enter the no.of contacts: ");
                    int limit = sc.nextInt();
                    sc.nextLine(); // Consume newline character
                    for (int i = 0; i < limit; i++) {
                        Info info = new Info();
                        System.out.println("Enter the name of contact: ");
                        info.name = sc.nextLine();
                        System.out.println("Enter the contact number: ");
                        info.num = sc.nextLine();
                        cms.add(info);
                    }
                    break;
                case 2:
                    System.out.println("Enter the contact to search for: ");
                    String name = sc.nextLine();
                    boolean flag = false;
                    for (Info info : cms) {
                        if (info.name.equalsIgnoreCase(name)) {
                            System.out.println("Contact Found: " + info.num);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("Contact Not Found");
                    }
                    break;
                case 3:
                    System.out.println("Enter the contact to update: ");
                    name = sc.nextLine();
                    for (Info info : cms) {
                        if (info.name.equalsIgnoreCase(name)) {
                            System.out.println("Enter updated details:\n 1) Name:");
                            String nameNew = sc.nextLine();
                            System.out.println("2) Number: ");
                            String num = sc.nextLine();
                            info.updateInfo(nameNew, num);
                            System.out.println("Contact Updated Successfully");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the contact to delete: ");
                    name = sc.nextLine();
                    for (int i = 0; i < cms.size(); i++) {
                        if (cms.get(i).name.equalsIgnoreCase(name)) {
                            cms.remove(i);
                            System.out.println("Contact Deleted Successfully");
                            break;
                        }
                    }
                    break;
                case 5:
                    for (Info info : cms) {
                        System.out.println("Name: " + info.name + "\nNumber: " + info.num + "\n");
                    }
                    break;
                case 6:
                    bool = false;
                    break;
            }
        }
    }
}
