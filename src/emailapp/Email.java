package emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Email {
    public Scanner s = new Scanner(System.in);

    // Setting variables as private to not you directly
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    // Constructor to receive firstName, lastName

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Full name employee: " + this.firstName + "" + this.lastName);
        // Calling methods
        this.department = this.set_Department();
        this.password = this.generatePassword(8);
        this.email = this.generateEmail();

    }

    // Generate main method
    private String generateEmail() {
        return this.firstName.toLowerCase()+ "" + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "company.com";
    }
    // Asking for department
    private String set_Department() {
        System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do {
            System.out.println("Enter Department Code:");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose again");
            }
        }while(!flag);
        return null;
    }

    // Generate Random Password method
    private String generatePassword(int length) {
        Random r = new Random();
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smalChars = "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        String symbols = "!@#$%&?";
        String values = capitalChars + smalChars + number + symbols;
        String password ="";
        for(int i = 0; i <length; i++) {
            password = password + values.charAt(r.nextInt((values.length())));
        }
        return password;
    }

    // change password method
    public void set_Password() {
        boolean flag = false;
        do {
            System.out.print("Do you want to change password! (Y/N)");
            char choice = s.next().charAt(0);
            if(choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.print("Enter the current password:");
                String tempPassword = s.next();
                if(tempPassword.equals(this.password)) {
                    System.out.print("Enter the new password: ");
                    this.password = s.next();
                    System.out.println("Password changed successfully");
                }
                else {
                    System.out.println("Incorrect password");
                }

            }
            else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password changed option cancelled! ");
            }
            else {
                System.out.println("Enter Valid choice");
            }
        }while (!flag);
    }

    // set mailbox capacity method
    public void set_MailCapacity() {
        System.out.println("Current capacity= " + this.mailCapacity + "mb");
        System.out.print("Enter new mailbox capacity:");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    // set alternate email
    public void set_alternate_email() {
        System.out.print("Enter new alternate mail: ");
        this.alter_email = s.next();
        System.out.println("Alternate email is set:" + alter_email);
    }

    // Display user information method
    public void getInfo() {
        System.out.println("New :" + this.firstName + " " + this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox capacity: " + this.mailCapacity + "mb");
        System.out.println("Alternate mail: "+  this.alter_email);
    }

    // Store in file
    public void storeFile() {
        try{
            FileWriter in = new FileWriter("D:\\info.txt");
            in.write("First name: " + this.firstName);
            in.append("\nLast name: " + this.lastName);
            in.append("\nEmail: " + this.email);
            in.append("\nPassword: " + this.password);
            in.append("\nCapacity: " + this.mailCapacity);
            in.append("\nAlternate Mail: " + this.alter_email);
            in.close();
            System.out.println("Data stored....");
        }
        catch (Exception e){
            System.out.println((e));
        }
    }

    // Reading file method
    public void read_file() {
        try {
            FileReader f1 = new FileReader("D:\\info.txt");
            int i;
            while((i=f1.read())!= -1) {
                System.out.print((char)i);
            }

            f1.close();

        }catch (Exception e) {
            System.out.println(e);
        };
    }
}
