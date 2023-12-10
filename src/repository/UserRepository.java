package repository;
import database.Connection;

public interface UserRepository extends repository{
    void readUserFile();
    void writeUserFile(String name, String nim, String id);
}
