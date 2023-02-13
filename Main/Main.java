package Main;

public class Main extends Thread {
    public static void main(String[] args) {
        // Run this to execute the whole program

        // A new thread for clearing the console
        Main clear = new Main();
        clear.start();

        new MainFrame().setVisible(true);

    }

    public void run()
    {
        while (true) {
            try {
                // Clear the console every 10 seconds
                Thread.sleep(10000);
                System.out.print("\033[H\033[2J");  
                System.out.println("\nNOTE: Console will be cleared every 10 seconds."); 
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}