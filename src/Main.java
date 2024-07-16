import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {

    //Scanner methods and logic

    private static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    private static void seeSchedules(Tournament tournament) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to see\n1. a team's schedule\n2.a matchday schedule\n3. entire schedule?\n4. back");
        String scheduleOption = scanner.nextLine();

        switch(scheduleOption) {
            case "1" -> {
                System.out.println("Enter team name");
                String teamOption = scanner.nextLine();
                boolean goodName = false;

                for (Team team : tournament.getTeamList()) {
                    if (Objects.equals(teamOption, team.getName())) {
                        tournament.getTeamSchedule(team);
                        mainScreen(tournament);
                        goodName = true;
                        break;
                    }
                }
                if (! goodName) {
                    System.out.println("Please enter a valid team Name! \n\n\n");
                    seeSchedules(tournament);
                    break;
                }
                clearConsole();
                scanner.close();
            }

            case "2" -> {
                System.out.println("Which matchday would you like to see?");
                int matchday = scanner.nextInt();
                if (matchday > 34) { System.out.println("The season only has 34 machtdays!!!"); }
                tournament.getMatchdaySchedule(matchday);
                mainScreen(tournament);
            }

            case "3" -> {
                tournament.getSchedule();
                mainScreen(tournament);
            }

            case "4" -> {
                mainScreen(tournament);
                scanner.close();
            }

            default -> {
                System.out.println("Please enter a valid option!");
                seeSchedules(tournament);
            }
        }
    }


    public static void mainScreen(Tournament bundesliga) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\nWelcome to the bundesliga game!");
        System.out.println("1. See table?\n2. Play matchday\n3. See schedules\n4. quit");
        String start = scanner.nextLine();
        switch(start) {
            case "1" -> {
                clearConsole();
                bundesliga.printTable();
                mainScreen(bundesliga);
            }

            case "2" -> {
                clearConsole();
                if (bundesliga.getCurrentMatchday() == 35) {
                    System.out.println("The season is over!");
                    mainScreen(bundesliga);
                    break;
                }
                System.out.println("Playing matchday " + bundesliga.getCurrentMatchday());
                bundesliga.playMatchday();
                mainScreen(bundesliga);
            }

            case "3" -> {
                clearConsole();
                System.out.println("\n\n\n");
                seeSchedules(bundesliga);
            }

            case "4" -> {
                System.out.println("Thank you for playing!");
                scanner.close();
            }

            default -> {
                System.out.println("Please enter a valid option!!!");
                mainScreen(bundesliga);
            }
        }
    }



    public static void main(String[] args) {

        ArrayList<Team> bundesligaTeams = new ArrayList<>();

        //create the teams and add them directly to the league
        Team bayern = new Team("Bayern", "Germany");
        Team dortmund = new Team("Dortmund", "Germany");
        Team leipzig = new Team("Leipzig", "Germany");
        Team leverkusen = new Team("Leverkusen", "Germany");
        Team wolfsburg = new Team("Wolfsburg", "Germany");
        Team frankfurt = new Team("Frankfurt", "Germany");
        Team gladbach = new Team("Gladbach", "Germany");
        Team freiburg = new Team("Freiburg", "Germany");
        Team hoffenheim = new Team("Hoffenheim", "Germany");
        Team union = new Team("Union", "Germany");
        Team hertha = new Team("Hertha", "Germany");
        Team mainz = new Team("Mainz", "Germany");
        Team augsburg = new Team("Augsburg", "Germany");
        Team vfb = new Team("VfB", "Germany");
        Team bielefeld = new Team("Bielefeld", "Germany");
        Team koln = new Team("Köln", "Germany");
        Team bochum = new Team("Bochum", "Germany");
        Team ksc = new Team("KSC", "Germany");

        bundesligaTeams.add(bayern);
        bundesligaTeams.add(dortmund);
        bundesligaTeams.add(leipzig);
        bundesligaTeams.add(leverkusen);
        bundesligaTeams.add(wolfsburg);
        bundesligaTeams.add(frankfurt);
        bundesligaTeams.add(gladbach);
        bundesligaTeams.add(freiburg);
        bundesligaTeams.add(hoffenheim);
        bundesligaTeams.add(union);
        bundesligaTeams.add(hertha);
        bundesligaTeams.add(mainz);
        bundesligaTeams.add(augsburg);
        bundesligaTeams.add(vfb);
        bundesligaTeams.add(bielefeld);
        bundesligaTeams.add(koln);
        bundesligaTeams.add(bochum);
        bundesligaTeams.add(ksc);

        //AI-Generated goalkeepers en masse, so that each team has at least one player
        //allows me to utilize the TeamStrength functionality
        Player keeper1 = new Player("Max Steelhand", 28, "goalkeeper");
        keeper1.setSkill("GK jumping", 88);
        keeper1.setSkill("GK catching", 85);
        keeper1.setSkill("GK passing", 82);
        keeper1.setSkill("GK positioning", 87);
        keeper1.setSkill("GK reflexes", 86);
        bayern.playerTransferIn(keeper1);

        Player keeper2 = new Player("Felix Quickleap", 24, "goalkeeper");
        keeper2.setSkill("GK jumping", 90);
        keeper2.setSkill("GK catching", 84);
        keeper2.setSkill("GK passing", 85);
        keeper2.setSkill("GK positioning", 82);
        keeper2.setSkill("GK reflexes", 89);
        dortmund.playerTransferIn(keeper2);

        Player keeper3 = new Player("Lars Irongrip", 31, "goalkeeper");
        keeper3.setSkill("GK jumping", 86);
        keeper3.setSkill("GK catching", 89);
        keeper3.setSkill("GK passing", 83);
        keeper3.setSkill("GK positioning", 88);
        keeper3.setSkill("GK reflexes", 85);
        leipzig.playerTransferIn(keeper3);

        Player keeper4 = new Player("Tobias Netmaster", 26, "goalkeeper");
        keeper4.setSkill("GK jumping", 87);
        keeper4.setSkill("GK catching", 85);
        keeper4.setSkill("GK passing", 84);
        keeper4.setSkill("GK positioning", 86);
        keeper4.setSkill("GK reflexes", 88);
        leverkusen.playerTransferIn(keeper4);

        Player keeper5 = new Player("Erik Swiftdive", 29, "goalkeeper");
        keeper5.setSkill("GK jumping", 89);
        keeper5.setSkill("GK catching", 86);
        keeper5.setSkill("GK passing", 87);
        keeper5.setSkill("GK positioning", 84);
        keeper5.setSkill("GK reflexes", 88);
        wolfsburg.playerTransferIn(keeper5);

        Player keeper6 = new Player("Hans Skyscraper", 33, "goalkeeper");
        keeper6.setSkill("GK jumping", 90);
        keeper6.setSkill("GK catching", 88);
        keeper6.setSkill("GK passing", 86);
        keeper6.setSkill("GK positioning", 89);
        keeper6.setSkill("GK reflexes", 85);
        frankfurt.playerTransferIn(keeper6);

        Player keeper7 = new Player("Lukas Catlike", 25, "goalkeeper");
        keeper7.setSkill("GK jumping", 88);
        keeper7.setSkill("GK catching", 85);
        keeper7.setSkill("GK passing", 84);
        keeper7.setSkill("GK positioning", 83);
        keeper7.setSkill("GK reflexes", 91);
        gladbach.playerTransferIn(keeper7);

        Player keeper8 = new Player("Otto Wallblocker", 30, "goalkeeper");
        keeper8.setSkill("GK jumping", 86);
        keeper8.setSkill("GK catching", 88);
        keeper8.setSkill("GK passing", 85);
        keeper8.setSkill("GK positioning", 87);
        keeper8.setSkill("GK reflexes", 86);
        freiburg.playerTransferIn(keeper8);

        Player keeper9 = new Player("Viktor Safehands", 27, "goalkeeper");
        keeper9.setSkill("GK jumping", 88);
        keeper9.setSkill("GK catching", 89);
        keeper9.setSkill("GK passing", 84);
        keeper9.setSkill("GK positioning", 86);
        keeper9.setSkill("GK reflexes", 87);
        hoffenheim.playerTransferIn(keeper9);

        Player keeper10 = new Player("Karl Goaldenial", 32, "goalkeeper");
        keeper10.setSkill("GK jumping", 87);
        keeper10.setSkill("GK catching", 86);
        keeper10.setSkill("GK passing", 85);
        keeper10.setSkill("GK positioning", 88);
        keeper10.setSkill("GK reflexes", 86);
        union.playerTransferIn(keeper10);

        Player keeper11 = new Player("Friedrich Netsaver", 28, "goalkeeper");
        keeper11.setSkill("GK jumping", 89);
        keeper11.setSkill("GK catching", 87);
        keeper11.setSkill("GK passing", 86);
        keeper11.setSkill("GK positioning", 85);
        keeper11.setSkill("GK reflexes", 88);
        hertha.playerTransferIn(keeper11);

        Player keeper12 = new Player("Ralf Stonewall", 31, "goalkeeper");
        keeper12.setSkill("GK jumping", 86);
        keeper12.setSkill("GK catching", 87);
        keeper12.setSkill("GK passing", 85);
        keeper12.setSkill("GK positioning", 88);
        keeper12.setSkill("GK reflexes", 86);
        mainz.playerTransferIn(keeper12);

        Player keeper13 = new Player("Dieter Shotblocker", 29, "goalkeeper");
        keeper13.setSkill("GK jumping", 88);
        keeper13.setSkill("GK catching", 86);
        keeper13.setSkill("GK passing", 84);
        keeper13.setSkill("GK positioning", 87);
        keeper13.setSkill("GK reflexes", 87);
        augsburg.playerTransferIn(keeper13);

        Player keeper14 = new Player("Jurgen Quickhands", 26, "goalkeeper");
        keeper14.setSkill("GK jumping", 87);
        keeper14.setSkill("GK catching", 86);
        keeper14.setSkill("GK passing", 85);
        keeper14.setSkill("GK positioning", 84);
        keeper14.setSkill("GK reflexes", 90);
        vfb.playerTransferIn(keeper14);

        Player keeper15 = new Player("Markus Elasticman", 27, "goalkeeper");
        keeper15.setSkill("GK jumping", 89);
        keeper15.setSkill("GK catching", 87);
        keeper15.setSkill("GK passing", 86);
        keeper15.setSkill("GK positioning", 85);
        keeper15.setSkill("GK reflexes", 88);
        bielefeld.playerTransferIn(keeper15);

        Player keeper16 = new Player("Stefan Acrobat", 30, "goalkeeper");
        keeper16.setSkill("GK jumping", 90);
        keeper16.setSkill("GK catching", 87);
        keeper16.setSkill("GK passing", 85);
        keeper16.setSkill("GK positioning", 86);
        keeper16.setSkill("GK reflexes", 88);
        koln.playerTransferIn(keeper16);

        Player keeper17 = new Player("Wolfgang Ironwall", 28, "goalkeeper");
        keeper17.setSkill("GK jumping", 87);
        keeper17.setSkill("GK catching", 86);
        keeper17.setSkill("GK passing", 85);
        keeper17.setSkill("GK positioning", 88);
        keeper17.setSkill("GK reflexes", 87);
        bochum.playerTransferIn(keeper17);

        Player keeper18 = new Player("Klaus Safenet", 29, "goalkeeper");
        keeper18.setSkill("GK jumping", 1);
        keeper18.setSkill("GK catching", 1);
        keeper18.setSkill("GK passing", 1);
        keeper18.setSkill("GK positioning", 1);
        keeper18.setSkill("GK reflexes", 1);
        ksc.playerTransferIn(keeper18);

        //initialize Bundesliga and it's simulation
        Tournament bundesliga = new Tournament("Bundesliga", 2024, bundesligaTeams);
        bundesliga.createSchedule();

        for (Team team : bundesligaTeams) {
            Random random = new Random();
            for (int i = 0; i < 22; i++) { // 23 players per team
                String position = getRandomPosition(i + 1);
                Player player = new Player("Player" + i, 20 + random.nextInt(15), position);
                initializePlayerSkills(player);
                team.playerTransferIn(player);
            }
        }

        mainScreen(bundesliga);




    }

    private static String getRandomPosition(int index) {
        if (index == 0) return "goalkeeper";
        if (index < 9) return "defender";
        if (index < 17) return "midfielder";
        else return "attacker";
    }

    private static void initializePlayerSkills(Player player) {
        Random random = new Random();
        for(String skill: player.getSkills().keySet()) {
            player.setSkill(skill, 60 + random.nextInt(41));
        }
    }
}