package repository;
import database.Connection;

public interface UserRepository extends Repository{
    void readUserFile();
    void writeUserFile(String name, String nim, int id);
}
