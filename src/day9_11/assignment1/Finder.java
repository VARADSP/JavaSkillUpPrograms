package day9_11.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class Finder extends Thread {
    private String userId,userName,userAddress,userRole,userCity,userTelephoneNumber,userSalary;
    private static Scanner scanner;
    private boolean isLoggedIn =false;
    private static File sharedResource = new File("C:\\Users\\Varad\\eclipse-workspace\\Demo\\src\\day9_11\\assignment1\\SharedResource\\SharedFile.txt");
	@Override
	public synchronized void start() {

		super.start();
		
		System.out.println("Finder process started");
		authenticate();
	}
	
	public synchronized void authenticate() {
	   int countDown = 3;
	   boolean isFound=false;
	   String username,password,line = null;
	   String tokens[];
	   do {
	       scanner = new Scanner(System.in);
	       try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
	       System.out.println("----------------------------------------------------------------------------------------------------------------------");
	       System.out.println("Enter your user name");
	       username = scanner.next();
	       System.out.println("Enter your password for "+username);
           password = scanner.next();
           try {
            scanner = new Scanner(sharedResource);
            while(scanner.hasNext()) {
                line = scanner.nextLine();
                if(line.contains(username)) {
                    tokens = line.split(",");
                    if(tokens[1].trim().equals(username) && tokens[2].trim().equals(password)) {
                        System.out.println("Authentication is successful");
                        isFound=true;
                        break;
                    }
                }    
            }  
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
           if(isFound==false) {
               --countDown;
               System.err.println("Either username or password is wrong. Please try again.");      
           }else {
               break;   
           }
	   }while(countDown != 0);
	   
	      if(countDown == 0) {
	          System.err.println("The System gets closed because the data you have provided is not valid. Please re-confirm it.");
	          System.exit(1);
	      }  
	      displayInfo(line);
	}
	
	public void displayInfo(String userInfo) {
	    isLoggedIn = true;
	    String tokens[] = userInfo.split(",");
	    String userId = tokens[0];
	    for(User user : Loader.users) {
	        if(user.getUserId().toString().equals(userId)) {
	            System.out.println("-------------------------------------------");
	        this.userId = user.getUserId().toString();
	        this.userName = user.getName();
	        this.userAddress = user.getAddress();
	        this.userCity = user.getCity();
	        this.userRole = user.getUserRole();
	        this.userSalary = user.getSalary();
	        this.userTelephoneNumber = user.getTelNumber().toString();
	        getEmployeeInfo();
	        if(userRole.contains("admin")) {
	            getMenu("admin");
	        }
	        else if(userRole.contains("manager")) {
	            getMenu("manager");
	        }
	        else {
	            getMenu("employee");
	        }
	        
	        
	        }
	    }
	    
	    
	}
	private void getEmployeeInfo() {
	    System.out.println("-------------------------------------------");
        System.out.println("User ID :"+userId);
        System.out.println("User Name :"+userName);
        System.out.println("User Role :"+userRole);
        System.out.println("User Address :"+userAddress);
        System.out.println("User City :"+userCity);
        System.out.println("User Telephone :"+userTelephoneNumber);
        System.out.println("User Salary :"+userSalary);               
        System.out.println("-------------------------------------------");
	}
	
	
	private void getMenu(String filter) {
	    if(isLoggedIn == true) {
	    scanner = new Scanner(System.in);
	    System.out.println("-------------------"+filter+" dashboard-------------------------");
	   // if(filter.equals("admin") || filter.equals("manager")) {  
	    do {
	        if(filter.equals("admin") || filter.equals("manager")) {
	        System.out.println("Display a list(Press L) ==> Submenus");
	        System.out.println("Search For Employee(Press S) ==> Submenus");
	        }
	        System.out.println("Display User Information(D)");
	        System.out.println("Log Off (O)");
	        System.out.println("Exit (X)");
	        String input = scanner.next();
	        if(filter.trim().equals("employee")) {
	            if(input.trim().equals("L") || input.trim().equals("S")) {
	                input = "default";
	            }
	        }
	        switch(input) {
	        case "L":getSubmenu("list",filter);break;
	        case "S":getSubmenu("search",filter);break;
	        case "D":getEmployeeInfo();break;
	        case "O":logOff();break;
	        case "X" :System.out.println("Exiting System..."); System.exit(0);break;
	        default:System.out.println("Invalid input provided for role "+filter);break;
	        }	        
	    }while(true);
	    }
	    else { System.out.println("Employee"); }
	    }
//	}
	
	
	private void logOff() {
	    this.isLoggedIn = false;
	    this.userAddress = null;
	    this.userCity = null;
	    this.userId = null;
	    this.userName = null;
	    this.userRole = null;
	    this.userSalary  = null;
	    this.userTelephoneNumber = null;
	    System.out.println("User Logged Off");
	    authenticate();
	}
	
	private void getSubmenu(String filterForMenu,String filterForRole) {
	    do {
	        System.out.println("\t 1.Back to Main Menu(B)");
            if(filterForRole.equals("manager") || filterForRole.equals("admin")) {
                System.out.println("\t 2.Press \"E\" for Employees");
            }
            if(filterForRole.equals("admin")) {
                System.out.println("\t 3.\"M\" for Manager");
            }
            if(filterForRole.equals("admin")) {
                System.out.println("\t 4. \"A\" for Admin");
            }
            if(filterForRole.equals("admin")) {
                System.out.println("\t 5. \"All\" for all"); 
            }
            String input = scanner.next();
            if(filterForRole.trim().equals("manager")) {
                if(input.trim().equals("All") || input.trim().equals("A") || input.trim().equals("M")) {
                    input = "default";
                }
            }
            switch(input) {
            case "B":getMenu(filterForRole);break;
            case "E" : if(filterForMenu.equals("list")) {getList("employee");} if(filterForMenu.equals("search")) {search("employee");};break;
            case "M" : if(filterForMenu.equals("list")) {getList("manager");} if(filterForMenu.equals("search")) {search("manager");};break;
            case "A" : if(filterForMenu.equals("list")) {getList("admin");} if(filterForMenu.equals("search")) {search("admin");};break;
            case "All" : if(filterForMenu.equals("list")) {getList("All");} if(filterForMenu.equals("search")) {search("All");};break;
            default:System.out.println("Invalid input provided for role "+filterForRole);break;
            }           
	    }while(true);
	}
	
	
	
	private void search(String filter) {
	    Set<User> sortedSet = new HashSet<User>();   
	    
	    
	    for(User u : Loader.users) {
	        String user = u.toString();
	        if(user.contains(filter.trim())) {
	            sortedSet.add(u);
	        }
	    }
//	    System.out.println("Prepared Set : ");
//	    System.out.println(sortedSet);
	    System.out.println("Enter name/address/city/telephone/salary to search and filter the results");
	    String filterValue = scanner.next();

	    System.out.println("Search Results : ");
	    Iterator<User> it = sortedSet.iterator();
	    boolean isFound = false;
        while(it.hasNext()) {
          User value = it.next();
          String searchIn = value.toString();
          if(searchIn.contains(filterValue.trim())) {
              System.out.println(searchIn);
              isFound = true;
          }
         }
        if(isFound==false) {
            System.out.println("No search results found for given parameter!");
        }
	}
	
	private void getList(String filter) {
	    for(User user : Loader.users) {
	        if(user.getUserRole().contains(filter) || filter.equals("All")) {
	            System.out.println(user + "\n");
	        }
	    }
	}
	

	@Override
	public void run() {

		super.run();
	
	}

}
