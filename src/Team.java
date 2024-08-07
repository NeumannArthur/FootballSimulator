import java.util.ArrayList;

public class Team {
    //Information about the team
    private int skill;
    final String name;
    final String country;
    final ArrayList<Player> roster;

    //Team's season stats
    private int playedMatches = 0;
    private int points = 0;
    private int wins = 0;
    private int draws = 0;
    private int losses = 0;
    private double teamStrength;


    //Constructor
    public Team(String name, String country) {
        this.name = name;
        this.country = country;
        this.roster = new ArrayList<>();
        this.teamStrength = calculateTeamStrength();
    }

    //handling having played a match
    public void updateStats() {
        playedMatches += 1;
        /* W/L/D logic */
    }

    //Setter/getter methods
    public int getPoints() {
        return this.points;
    }

    public void addPoints(int newPoints) {
        this.points += newPoints;
    }
    public int getWins() {
        return this.wins;
    }
    public void setWins() {
        wins += 1;
    }
      public int getLosses() {
        return this.losses;
    }
      public void setLosses() {
        losses += 1;
    }
      public int getDraws() {
        return this.draws;
    }
      public void setDraws() {
        draws += 1;
    }

    public String getName() {
        return this.name;
    }

    private double calculateTeamStrength() {
        if (roster.isEmpty()) {
            return Math.random() * 50 + 50;
        }
        return roster.stream().mapToDouble(Player::getTotalSkill).average().orElse(75);
    }

    public double getTeamStrength() {
        return this.teamStrength;
    }

    public void updateTeamStrength() {
        this.teamStrength = calculateTeamStrength();
    }

    public void playerTransferIn(Player player) {
        this.roster.add(player);
        updateTeamStrength();
    }

    public void playerTransferOut(Player player) {
        this.roster.remove(player);
        updateTeamStrength();
    }

    public ArrayList<Player> getRoster() {
        return this.roster;
    }


}