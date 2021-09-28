import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileManagement {

    public static void getFolderContents(File folder) throws IOException {
        File[] files = folder.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getName());
            } else {
                System.out.println(f.getCanonicalPath());
                getFolderContents(f);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String homeFolder = System.getProperty("user.home");
        String separator = File.separator;
        String lineSeparator = System.getProperty("line.separator");

        File currentFolder = new File(homeFolder);
        File newFile = new File(currentFolder, separator + "example.txt");
        System.out.println(currentFolder.getCanonicalPath());
        System.out.println(currentFolder.isDirectory());
        System.out.println(newFile.getCanonicalPath());
        System.out.println(newFile.isFile());
        System.out.println(newFile.exists());

        //getFolderContents(currentFolder);
        //System.out.println(newFile.delete());

        try (FileWriter fw= new FileWriter(newFile,true);
             BufferedWriter bw = new BufferedWriter(fw)
        ) {
            bw.write("This is the first line" + lineSeparator);
            bw.write("This is the second line" + lineSeparator);
            for(int i = 0; i < 10000000; i++) {
                bw.write(i + lineSeparator);
            }
        }

//        try(
//        FileReader fr = new FileReader(newFile);
//        BufferedReader br = new BufferedReader(fr);
//        ) {
//            List<String> myLines = br.lines().filter(line -> line.startsWith("This")).collect(Collectors.toList());
//            for(String s : myLines) {
//                System.out.println(s);
//            }
//        }

        Path currentDirectory = Paths.get(homeFolder);
        System.out.println( Files.isDirectory(currentDirectory));
        Path report = Paths.get(homeFolder + separator + "report.txt");
        Files.writeString(report, "This is report 1" + lineSeparator);
        Files.writeString(report, "Everything is ok." + lineSeparator, StandardOpenOption.APPEND);

        List<String> reportContents= List.of("Matt", "Susan", "Dave", "Jim", "Diane");
        Files.write(report,reportContents, StandardOpenOption.APPEND);

        List<String> fileContents = Files.readAllLines(report);
        System.out.println(fileContents);

        Scanner scanner = new Scanner(newFile);
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}

