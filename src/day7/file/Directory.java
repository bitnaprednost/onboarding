package day7.file;

import java.util.*;
import java.util.function.Predicate;

public class Directory implements File, Comparable<File>{
    private final String name;
    private Set<File> files;
    private Directory previousDirectory;
    private static final String TYPE = "directory";

    private Directory(String name) {
        files = new LinkedHashSet<>();
        this.name = name;
        previousDirectory = null;
    }

    private Directory(Directory directory){
        name = directory.name;
        if(directory.previousDirectory!=null) previousDirectory = new Directory(directory.previousDirectory);
    }

    public static Directory from(String name) {
        return new Directory(name);
    }

    public File getFileFromPosition(int i) {
        for(Iterator<File> iter = files.iterator();iter.hasNext();iter.next(), i--) {
            if(i==0) return iter.next();
        }
        throw new NoSuchElementException();
    }

    public Directory findShallow(String fileName) {
        for(File file : files){
            if(fileName.equals(file.getName())) return (Directory) file;
        }
        throw new NoSuchElementException();
    }

    private void findAll(List<File> list, Predicate<File> predicate){
        if(predicate.test(this)) list.add(this);

        for(File file : files) {
            if(file instanceof Directory) ((Directory) file).findAll(list, predicate);
            else if(predicate.test(file)) list.add(file);
        }
    }

    private List<File> findAll(Predicate<File> predicate) {
        List<File> list = new ArrayList<>();
        findAll(list, predicate);
        return list;
    }

    private List<File> findAllSameName(String fileName) {
        return findAll((file)->file.getName().equals(fileName));
    }

    public Directory findMinDirectory(long left, long capacity) {
        List<File> list = findAll((file)->file.getType().equals("directory") && file.getSize() + left > capacity);
        Optional<File> directory = list.stream().min(Comparable::compareTo);
        return (Directory) directory.orElseThrow(NoSuchElementException::new);
    }

    private Optional<File> findFirst(String fileName, String type) {
        if (name.equals(fileName) && type.equals(TYPE)) return Optional.of(this);

        List<File> list = findAllSameName(fileName);
        for (File file : list) {
            if (type.equals(file.getType())) return Optional.of(file);
        }
        return Optional.empty();
    }

    public FileImpl findFirstFile(String fileName){
        Optional<File> file = findFirst(fileName, "file");
        return (FileImpl) file.orElseThrow(NoSuchElementException::new);
    }

    public Directory findFirstDirectory(String fileName){
        Optional<File> file = findFirst(fileName, "directory");
        return (Directory) file.orElseThrow(NoSuchElementException::new);
    }

    public Directory findFirstDirectory(Directory directory){
        Optional<File> file = findFirst(directory.name, "directory");
        return (Directory) file.orElseThrow(NoSuchElementException::new);
    }

    public void addFile(File file) {
        files.add(file);
    }
    public void getSizeCriterion(List<Directory> list, long maxSize) {
        long size = getSize();
        if(size<=maxSize) list.add(this);

        for (File file : files) {
            if(file instanceof Directory) ((Directory) file).getSizeCriterion(list, maxSize);
        }
    }

    public Directory getCurrent() {
        return new Directory(this);
    }

    public Optional<Directory> getPreviousDirectory() {
        if(previousDirectory==null) return Optional.empty();

        return Optional.of(new Directory(previousDirectory));
    }

    void setPreviousDirectory(Directory previousDirectory) {
        this.previousDirectory = new Directory(previousDirectory);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public long getSize() {
        return files.stream().mapToLong(File::getSize).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Directory directory)) return false;

        if (!name.equals(directory.name)) return false;
        return Objects.equals(previousDirectory, directory.previousDirectory);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (previousDirectory != null ? previousDirectory.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(File file) {
        long size1 = getSize();
        long size2 = file.getSize();

        return Long.compare(size1, size2);
    }
}
