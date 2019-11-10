package emailapp;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String password;
	private int defaultpasswordlength = 10;
	private String department;
	private String email;
    private int mailboxcapacity = 500;
    private String alternateemail;
    private String companycode = "svcompany.com";
    
//    Constructor to receive firstname and lastname
    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        
//        Calling a method that will return the department
        this.department = getDepartment();
        
//        Calling a method that will return a random password
        this.password = randomPassword(defaultpasswordlength);
        System.out.println("YOUR PASSWORD: " + password);
        
//        Combine elements to generate email
        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companycode;
    }
    
//    Ask for department
    private String getDepartment() {
    	Scanner in = new Scanner(System.in);
    	System.out.print("New Worker: " + firstname + ". Department Code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
    	int deptChoice = in.nextInt();
    	if(deptChoice == 1) {
    		return "sales";
    	} else if(deptChoice == 2) {
    		return "development";
    	} else if(deptChoice == 3) {
    		return "accounting";
    	} else {
    		return "";
    	}
    }
    
//    Generate a random password
    private String randomPassword(int length) {
		String passwordset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
    	char[] password = new char[length];
    	for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordset.length());
			password[i] = passwordset.charAt(rand);
		}
		return new String(password);
	}
    
//    Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
    	this.mailboxcapacity = capacity;
    }
    
//    Set the alternate email
    public void setAlternateEmail(String altemail) {
    	this.alternateemail = altemail;
    }
    
//    Change the password
    public void changePassword(String password) {
    	this.password = password;
    }
    
    public int getMailboxCapacity() { return mailboxcapacity; }
    public String getAlternateEmail() { return alternateemail; }
    public String getPassword() { return password; }
    
    public String showInfo() {
    	return "DISPLAY NAME: " + firstname + " " + lastname +
    			"\nCOMPANY EMAIL: " + email +
    			"\nMAILBOX CAPACITY: " + mailboxcapacity + "mb";
    }
}
