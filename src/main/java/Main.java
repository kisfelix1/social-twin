import logics.Bot;
import logics.InstagramBot;
import logics.MessengerBot;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bot bot = chooseBot();
        bot.login();
        try {
            bot.loop();
        }catch (InterruptedException e){
            System.out.println("You interrupted the program!");
        } catch (FileNotFoundException e) {
            System.out.println("There is no file on the given path!");
        }
    }

    private static Bot chooseBot() {
        System.out.println("Which Bot do you want to use?");
        System.out.println("1 - Messenger");
        System.out.println("2 - Instagram");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        while(!choice.equals("1") && !choice.equals("2")) {
            System.out.println("Incorrect input!");
            choice = scanner.nextLine();
        }
        if(choice.equals("1")){
            return new MessengerBot();
        }else {
            return new InstagramBot();
        }
    }
}
