import java.util.Scanner;
public class Input {

    private static Scanner scanner;

    public static String readString(){
        if (scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();
    }

    public static int readInt(){
        if (scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner.nextInt();
    }

}
