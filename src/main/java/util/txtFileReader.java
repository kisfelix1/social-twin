package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class txtFileReader {
    private static final String fileName = "src/main/resources/names.txt";

    public static List<String> getNamesOfTxt() throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        List<String> names = new ArrayList<>();
        while (sc.hasNextLine())
            names.add(sc.nextLine());
        return names;
    }
}
