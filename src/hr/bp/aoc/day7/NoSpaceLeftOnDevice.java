package hr.bp.aoc.day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class NoSpaceLeftOnDevice {
    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day7/inputday7.txt";
        String input = readFile(filePath);
        //System.out.println(input);

        ArrayList<Directory> directories = new ArrayList<Directory>();

        Directory root = new Directory("/", null);
        Directory currentDirectory = root;

        for (String line : input.split("\n")) {
            String[] command = line.split(" ");
            if (command[0].equals("$")) {
                if (command[1].equals("cd")) {
                    if (command[2].equals("/")) {
                        currentDirectory = root;
                    } else if (command[2].equals("..")) {
                        currentDirectory = currentDirectory.getParent();
                    } else {
                        // moves in one level
                        //current directory je sad zapravo command[2]
                        if (currentDirectory.getDir(command[2]) != null) {
                            currentDirectory = currentDirectory.getDir(command[2]);
                        } else {
                            currentDirectory = new Directory(command[2], currentDirectory);
                        }

                    }
                }
            } else if (command[0].equals("dir")) {
                Directory newDirectory = new Directory(command[1], currentDirectory);
                currentDirectory.addFile(newDirectory);
                directories.add(newDirectory);
                //currentDirectory = newDirectory;
            } else {
                File newFile = new File(command[1], Integer.parseInt(command[0]));
                currentDirectory.addFile(newFile);
            }
        }

        /*
        for (int i = 0; i < directories.size(); i++) {
            System.out.println("name: "+directories.get(i).getName() +" parent:"+ directories.get(i).getParent().getName()+" size "+directories.get(i).size());
        }
        System.out.println(root.size());
         */

        //Part One
        int sumTotalSizes = 0;
        for (int i = 0; i < directories.size(); i++) {
            if (directories.get(i).size() <= 100000) {
                sumTotalSizes += directories.get(i).size();
            }
        }
        System.out.println(sumTotalSizes);


        //Part Two
        int usedSpace = root.size();
        int unusedSpace = 70000000 - usedSpace;

        ArrayList<Directory> directoriesDelete = directoriesToDelete(directories,unusedSpace);
        Directory minDirectory = findMinDirectory(directoriesDelete);
        System.out.println(minDirectory.size());
    }

    private static String readFile(String file_path) {

        String string = "";
        try {
            string = new String(Files.readAllBytes(Paths.get(file_path)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return string;
    }

    private static ArrayList<Directory> directoriesToDelete(ArrayList<Directory> directories,int unusedSpace){
        ArrayList<Directory> directoriesDelete = new ArrayList<Directory>();
        for (int i = 0; i < directories.size(); i++) {
            int sizeOfDirectory = directories.get(i).size();
            if ((unusedSpace + sizeOfDirectory) >= 30000000) {
                directoriesDelete.add(directories.get(i));
            }
        }
        return directoriesDelete;
    }
    private static Directory findMinDirectory(ArrayList<Directory> directories){
        Directory minDirectory = directories.get(0);
        for (int i = 1; i < directories.size(); i++) {
            if (directories.get(i).size() < minDirectory.size()) {
                minDirectory = directories.get(i);
            }
        }
        return minDirectory;
    }
}
