import java.util.Objects;

public class Match {

    //Teams that are playing the match and the according score as a Tuple
    private Team team1;
    private Team team2;
    private Tuple<Integer, Integer> score;

    //Match facts
    private int matchday;


    public Match(Team team1, Team team2, int matchday) {
        this.team1 = team1;
        this.team2 = team2;
        this.score = new Tuple<>(0, 0);
        this.matchday = matchday;
    }

    // result logic
    public void getResult(Tuple<Integer, Integer> score) {
        team1.updateStats();
        team2.updateStats();

        if (score.getFirst() > score.getSecond()) {
            team1.addPoints(3);
            team1.setWins();
            team2.setLosses();

        } else if (Objects.equals(score.getFirst(), score.getSecond())){
            team1.addPoints(1);
            team2.addPoints(1);
            team1.setDraws();
            team2.setDraws();

        } else {
            team2.addPoints(3);
            team2.setWins();
            team1.setLosses();

        }
    }

    public Team getTeam1() {
        return this.team1;
    }

    public Team getTeam2() {
        return this.team2;
    }

    public int getMatchday() {
        return this.matchday;
    }

    // simulation logic
    public void play() {
        score.setFirst(0);
        score.setSecond(0);
        int scoreTeam1 = (int) (Math.random() * 100);
        int scoreTeam2 = (int) (Math.random() * 100);
        score.setFirst(scoreTeam1);
        score.setSecond(scoreTeam2);
        getResult(score);
    }

    public Tuple<Integer, Integer> getScore() {
        return this.score;
    }

}