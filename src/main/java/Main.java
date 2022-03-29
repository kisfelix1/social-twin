import logics.Bot;
import logics.InstagramBot;
import logics.MessengerBot;

import java.util.Scanner;

public class Main {
    static Bot bot;
    public static void main(String[] args) {
        String choice = chooseBot();
        if(choice.equals("1")){
            bot = new MessengerBot();
        }else if(choice.equals("2")){
            bot = new InstagramBot();
        }
    }

    private static String chooseBot() {
        System.out.println("Which Bot do you want to use?");
        System.out.println("1 - Messenger");
        System.out.println("2 - Instagram");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        while(!scanner.nextLine().equals("1") && !scanner.nextLine().equals("2")) {
            System.out.println("Incorrect input!");
            choice = scanner.nextLine();
        }
        return choice;
    }
}
