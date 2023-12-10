package repository;

public interface TeamRepository extends repository{
    void readTeamFile();
    void writeTeamFile(String teamName, String id);
}
