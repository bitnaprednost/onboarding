package hr.bp.aoc.day7;

import hr.bp.aoc.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class NoSpaceLeftOnDevice {
    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day7/inputday7.txt";
        String[] lines = InputUtil.readLines(filePath);

        Directory root = new Directory("/", null);
        List<Directory> directories = createHierarchy(lines, root);

        //Part One
        int sumOfSizes = sumOfSizesOfAtMost100000(directories);
        System.out.println(sumOfSizes);


        //Part Two
        List<Directory> directoriesDelete = DirectoryUtil.directoriesToDelete(directories, root);
        Directory minDirectory = DirectoryUtil.findMinDirectory(directoriesDelete,root);
        System.out.println(minDirectory.size());
    }

    private static List<Directory> createHierarchy(String[] lines, Directory root) {
        List<Directory> directories = new ArrayList<>();
        Directory currentDirectory = root;
        for (String s : lines) {
            String[] command = s.split(" ");
            if (command[0].equals("$")) {
                if (command[1].equals("cd")) {
                    if (command[2].equals("/")) {
                        currentDirectory = root;
                    } else if (command[2].equals("..")) {
                        currentDirectory = currentDirectory.getParent();
                    } else {
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
            } else {
                File newFile = new File(command[1], Integer.parseInt(command[0]));
                currentDirectory.addFile(newFile);
            }
        }
        return directories;
    }

    private static int sumOfSizesOfAtMost100000(List<Directory> directories) {
        int sumTotalSizes = 0;
        for (Directory directory : directories) {
            if (directory.size() <= 100000) {
                sumTotalSizes += directory.size();
            }
        }
        return sumTotalSizes;
    }


}
