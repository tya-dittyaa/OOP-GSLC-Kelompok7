package repository;

public interface TeamRepository extends Repository{
    void readTeamFile();
    void writeTeamFile(String teamName, int id);
}
