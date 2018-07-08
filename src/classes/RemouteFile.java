package classes;

import java.util.Objects;

/**
 * Created by Damien on 05.07.2018.
 */
public class RemouteFile {

    private boolean isDirectory;
    private String name;
    private String filePath;
    private long size = -1;

//    public boolean isDirectory() {
//        return isDirectory;
//    }
//
//    public void setDirectory(boolean directory) {
//        isDirectory = directory;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }
//
//    public long getSize() {
//        return size;
//    }
//
//    public void setSize(long size) {
//        this.size = size;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RemouteFile that = (RemouteFile) o;
//        return isDirectory == that.isDirectory &&
//                size == that.size &&
//                Objects.equals(name, that.name) &&
//                Objects.equals(filePath, that.filePath);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(isDirectory, name, filePath, size);
//    }
//
//    @Override
//    public String toString() {
//        return "RemouteFile{" +
//                "isDirectory=" + isDirectory +
//                ", name='" + name + '\'' +
//                ", filePath='" + filePath + '\'' +
//                ", size=" + size +
//                '}';
//    }
}
