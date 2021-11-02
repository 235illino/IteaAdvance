package homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class TerminalImpl {
    private File fileHome = new File("/home/ilya");
    private File fileChange = new File(fileHome.getAbsolutePath());
    private Scanner scanner = new Scanner(System.in);




    public void manageTerminal() {

        boolean exit = false;
        while (!exit) {
            outputAllFiles(fileChange);
            String[] strings = scanner.nextLine().split(" ");
            String userInput = strings[0];
            String dir = null;
            if (strings.length > 1) {
                dir = strings[1];
            }

            switch (userInput) {
                case "..":
                    fileChange = new File(fileChange.getParent());
                    break;
                case "exit":
                    exit = true;
                    break;
                case "cd":
                    if (dir != null) {
                        fileChange = new File(dirInput(dir));
                        if (!fileChange.isDirectory()) {
                            fileChange = enterCorrectDirectory(fileChange);
                        }
                    }
                    break;
                default:
                    File fileForRead = new File(fileChange + "/" + userInput);
                    if (fileForRead.isFile()) {
                        if (fileForRead.canRead()) {
                            Scanner sc = null;
                            try {
                                sc = new Scanner(fileForRead);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            while (sc.hasNextLine()) {
                                System.out.println(sc.nextLine());
                            }
                        } else {
                            System.out.println("Can't read this file");
                        }
                    }
                    System.out.println("Incorrect args");
                    break;

            }

        }

    }

    private File enterCorrectDirectory(File dir) {

        fileChange = new File(fileChange.getParent());
        while (true) {
            dir = fileChange;
            System.out.println("Enter wright dir");
            outputAllFiles(dir);
            String[] strings = scanner.nextLine().split(" ");
            String userInput = strings[0];
            String newPath = null;
            if (strings.length > 1) {
                newPath = strings[1];
            }
            if (newPath != null) {
                dir = new File(dirInput(newPath));
            }
            if (dir.isDirectory()) {
                break;
            }

        }
        return dir;
    }

    private String dirInput(String userInput) {

        return fileChange.getAbsolutePath() + "/" + userInput;
    }

    private void outputAllFiles(File file) {
        File[] files = file.listFiles();
        Arrays.sort(files, Comparator.comparing(File::isDirectory).reversed());
        for (File f : files) {
            System.out.println(f.getName());
        }

    }
}
