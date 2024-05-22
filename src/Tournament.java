import java.util.ArrayList;
import java.util.Comparator;

public class Tournament {
    //Tournament information
    public String name;
    public int season;

    //Teams, schedules, tables, etc.
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private int currentMatchday;

    //Constructor
    public Tournament(String name, int season, ArrayList<Team> teamsList) {
        this.name = name;
        this.season = season;
        this.teams = teamsList;
        this.matches = new ArrayList<>();
        this.currentMatchday = 1;
    }

    public void createSchedule() {

        int numberOfTeams = this.teams.size();
        int numberOfMatchdays = numberOfTeams - 1;

        for (int matchday = 0; matchday < numberOfMatchdays; matchday++) {
            for (int i = 0; i < numberOfTeams / 2; i++) {
                int team1Index = (matchday + i) % (numberOfTeams - 1);
                int team2Index = (numberOfTeams - 1 - i + matchday) % (numberOfTeams - 1);

                //last team stays in place while others rotate around it
                if (i == 0) {
                    team2Index = numberOfTeams - 1;
                }

                Team team1 = teams.get(team1Index);
                Team team2 = teams.get(team2Index);
                Match match = new Match(team1, team2, matchday + 1);
                matches.add(match);
            }
        }
        // Second half of the season (teams switched)
        for (int matchday = 0; matchday < numberOfTeams - 1; matchday++) {
            for (int i = 0; i < numberOfTeams / 2; i++) {
                int team1Index = (matchday + i) % (numberOfTeams - 1);
                int team2Index = (numberOfTeams - 1 - i + matchday) % (numberOfTeams - 1);

                // last team stays in place while others rotate around it
                if (i == 0) {
                    team2Index = numberOfTeams - 1;
                }

                Team team1 = teams.get(team1Index);
                Team team2 = teams.get(team2Index);
                Match match = new Match(team2, team1, matchday + numberOfTeams);
                matches.add(match);
            }
        }
    }

    public void getSchedule() {
        for (Match match : matches) {
            System.out.println("Matchday " + match.getMatchday() + ": " + match.getTeam1().name + " vs " + match.getTeam2().name);
        }
    }

    public void getTeamSchedule(Team team) {
        System.out.println("Schedule for " + team.getName() + ":");
        for(Match match : matches) {
            if (match.getTeam1().equals(team) || match.getTeam2().equals(team)) {
                System.out.println("Matchday " + match.getMatchday() + ":\n" + match.getTeam1().name + " vs " + match.getTeam2().name);
            }
        }
    }

    public void getMatchdaySchedule(int matchday) {
        for(Match match : matches) {
            if (match.getMatchday() == matchday) {
                if (this.currentMatchday > matchday) {
                    System.out.println(match.getTeam1().name + " " + match.getScore().getFirst() + " : " + match.getScore().getSecond() + " " + match.getTeam2().name);
                } else {
                    System.out.println(match.getTeam1().name + " vs " + match.getTeam2().name);
                }
            }
        }
    }

    public void printTable() {
        if (currentMatchday == 0) {
            teams.sort(Comparator.comparing(Team::getName));
        } else {
            teams.sort(Comparator.comparingInt(Team::getPoints).reversed());
        }

        System.out.println("Place\tTeam\t\tPoints");
        System.out.println("-----\t\t----\t\t------");

        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            System.out.println((i + 1) + "\t" + team.name + "\t\t" + team.getPoints());
        }
    }



    public void playMatchday() {
        for (Match match : matches) {
            if (match.getMatchday() == currentMatchday) {
                match.play();
            }
        }
        currentMatchday++;
    }

    public int getCurrentMatchday() {
        return this.currentMatchday;
    }

    public ArrayList<Team> getTeamList() {
        return this.teams;
    }



}