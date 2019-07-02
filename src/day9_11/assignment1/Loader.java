package day9_11.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader extends Thread {
	private String filePathForUserLoginInfo;
	private String filePathForUserInfo;

	private static File sharedResource = new File("C:\\Users\\Varad\\eclipse-workspace\\Demo\\src\\day9_11\\assignment1\\SharedResource\\SharedFile.txt");
	private static Scanner scanner;
	private static String mode;
	private static File fileToRead;


	public static boolean isUsersListAvailable;
	public static ArrayList<User> users = new ArrayList<User>();


	//constructor
	public Loader(){
		File propertiesFile = new File("C:\\Users\\Varad\\eclipse-workspace\\Demo\\src\\day9_11\\assignment1\\properties.txt");
		try {
			setMode("READ");
			scanner = new Scanner(propertiesFile);
			filePathForUserInfo = scanner.nextLine();
			filePathForUserLoginInfo = scanner.nextLine();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}


	@Override
	public synchronized void start() {

		super.start();
		System.out.println("Loader Process Started");
		
	}



	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		Loader.mode = mode;
	}

	public synchronized boolean getUserInfo(){
		if(getMode().equals("READ")){
		fileToRead = new File(filePathForUserInfo);
		try {
			scanner = new Scanner(fileToRead);
			PrintWriter printToSharedResource = new PrintWriter(sharedResource);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				printToSharedResource.println(line);
			}
			scanner.close();
			printToSharedResource.close();

			setMode("WRITE");
			return true;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
		return false;
	}

	public synchronized void getUserLoginInfo(){
		if(getMode().equals("READ")){
			fileToRead = new File(filePathForUserLoginInfo);
			try {
				scanner = new Scanner(fileToRead);
				PrintWriter printToSharedResource = new PrintWriter(sharedResource);
				while(scanner.hasNextLine()){
					String line = scanner.nextLine();
					printToSharedResource.println(line);
				}
				
				scanner.close();
				printToSharedResource.close();
				setMode("READ");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			}
	}
	
	private String getUserRole(String userId) {
        String result = "";
	    try {
            Scanner scanningForUserRoles = new Scanner(new File(filePathForUserLoginInfo));
            String[] tokens;
            String line;
            while(scanningForUserRoles.hasNextLine()){
                line = scanningForUserRoles.nextLine();
                tokens = line.split(",");
                if(tokens[0].equals(userId)) {
                   
                    result = tokens[3] + ","+ result;
                }
            }
           
            scanningForUserRoles.close();
            
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	    return result;

	    
     
	    
	}

	public synchronized boolean mergeInfoAsObjects(){
		if(getMode().equals("WRITE")){
			try{
				scanner = new Scanner(sharedResource);
				String[] tokensForUserInfo;
				String lineForUserInfo;


				while(scanner.hasNextLine()){
					lineForUserInfo = scanner.nextLine();
					tokensForUserInfo = lineForUserInfo.split(",");
					String userRole = getUserRole(tokensForUserInfo[0]);
					users.add(new User(Integer.parseInt(tokensForUserInfo[0]), tokensForUserInfo[1], userRole, tokensForUserInfo[2], tokensForUserInfo[3], tokensForUserInfo[4], Long.parseLong(tokensForUserInfo[5])));
				}
				scanner.close();
				setMode("READ");
				return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
        return false;


	}
	

	@Override
	public void run() {

		super.run();
		boolean gotUserInfo = false;


		if(getMode().equals("READ")){
			gotUserInfo = getUserInfo();
		}
		if(getMode().equals("WRITE") && gotUserInfo==true){
		    isUsersListAvailable = mergeInfoAsObjects();
		}

		if(getMode().equals("READ")&&isUsersListAvailable == true){
			getUserLoginInfo();
		}
	
	}
}
