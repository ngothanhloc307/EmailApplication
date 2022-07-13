package emailapp;
import java.util.*;
public class EmailApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // User info
        System.out.print("Enter first name:");
        String f_name = sc.next();
        System.out.print("Enter last name: ");
        String l_name = sc.next();

        // creating object for Email class
        Email em1 = new Email(f_name, l_name);
        int choice = -1;
        do {
            System.out.println("\n*********\nEnter your choice\n1.Show Info\n" +
                    "2.Change Password\n3.Change mailbox capacity\n" +
                    "4.Set alternate mail.\n5.Stored Data in file\n6.Display data from file\n7.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_Password();
                    break;
                case 3:
                    em1.set_MailCapacity();
                    break;
                case 4:
                    em1.set_alternate_email();
                    break;
                case 5:
                    em1.storeFile();
                    break;
                case 6:
                    em1.read_file();
                    break;
                case 7:
                    System.out.println("Thank you for using application!");
                    break;
                default:
                    System.out.println("Invalid choice\nEnter proper choice again");
            }
        }while (choice !=7);

    }
}
