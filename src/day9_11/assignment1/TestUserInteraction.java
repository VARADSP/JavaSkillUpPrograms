package day9_11.assignment1;

public class TestUserInteraction {
    public static void main(String[] args) {
        try {
            
        
        UserInteraction interaction = new UserInteraction();
        interaction.start();
    }
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        }

}
