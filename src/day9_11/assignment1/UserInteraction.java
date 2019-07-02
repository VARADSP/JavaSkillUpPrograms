package day9_11.assignment1;

public class UserInteraction extends Thread {

	@Override
	public synchronized void start() {

		super.start();
		System.out.println("Welcome To The User Management System");

	}

	@Override
	public void run() {
		super.run();

		Loader loaderProcess = new Loader();
		loaderProcess.start();
		
		try {
            loaderProcess.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	    Finder finderProcess = new Finder();
        finderProcess.start();    
    
		

	}
	
}
