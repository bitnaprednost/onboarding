package hr.bp.aoc.day7;

import java.util.ArrayList;
import java.util.List;

public class DirectoryUtil {
    static List<Directory> directoriesToDelete(List<Directory> directories, Directory root) {
        int usedSpace = root.size();
        int unusedSpace = 70000000 - usedSpace;
        List<Directory> directoriesDelete = new ArrayList<>();
        for (Directory directory : directories) {
            int sizeOfDirectory = directory.size();
            if ((unusedSpace + sizeOfDirectory) >= 30000000) {
                directoriesDelete.add(directory);
            }
        }
        return directoriesDelete;
    }

    static Directory findMinDirectory(List<Directory> directories, Directory root) {
        List<Directory> directoriesDelete = directoriesToDelete(directories, root);
        Directory minDirectory = directoriesDelete.get(0);
        for (int i = 1; i < directoriesDelete.size(); i++) {
            if (directoriesDelete.get(i).size() < minDirectory.size()) {
                minDirectory = directoriesDelete.get(i);
            }
        }
        return minDirectory;
    }
}
