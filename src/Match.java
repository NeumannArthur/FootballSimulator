import java.util.Objects;
import java.util.Random;

public class Match {

    //Teams that are playing the match and the according score as a Tuple
    private Team team1;
    private Team team2;
    private Tuple<Integer, Integer> score;
    private static final double Home_Advantage = 1.1;
    private static final Random random = new Random();

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
        double team1Strength = team1.getTeamStrength() * Home_Advantage;
        double team2Strength = team2.getTeamStrength();

        int scoreTeam1 = simulateScore(team1Strength);
        int scoreTeam2 = simulateScore(team2Strength);

        score.setFirst(scoreTeam1);
        score.setSecond(scoreTeam2);
        getResult(score);
    }

    private int simulateScore(double teamStrength) {
        double lambda = Math.log(teamStrength) / 3;
        return getPoissonRandom(lambda);
    }

    private int getPoissonRandom(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= random.nextDouble();
        } while (p > L);

        return k-1;
    }


    public Tuple<Integer, Integer> getScore() {
        return this.score;
    }

}