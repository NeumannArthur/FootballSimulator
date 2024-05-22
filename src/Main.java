import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
            case "1":
                System.out.println("Enter team name");
                String teamOption = scanner.nextLine();

                for (Team team : tournament.getTeamList()) {
                    if (Objects.equals(teamOption, team.getName())) {
                        tournament.getTeamSchedule(team);
                        mainScreen(tournament);
                        break;
                    } else {
                        System.out.println("Did you spell the team name correctly? \n\n\n");
                        seeSchedules(tournament);
                    }
                }
                clearConsole();
                scanner.close();
                break;

            case "2":
                System.out.println("Which matchday would you like to see?");
                int matchday = scanner.nextInt();
                if (matchday > 34) { System.out.println("The season only has 34 machtdays!!!"); }
                tournament.getMatchdaySchedule(matchday);
                mainScreen(tournament);
                break;

            case "3":
                tournament.getSchedule();
                mainScreen(tournament);
                break;

            case "4":
                mainScreen(tournament);
                scanner.close();
                break;

            default:
                System.out.println("Please enter a valid option!");
                seeSchedules(tournament);
                break;
        }
    }


    public static void mainScreen(Tournament bundesliga) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\nWelcome to the bundesliga game!");
        System.out.println("1. See table?\n2. Play matchday\n3. See schedules\n4. quit");
        String start = scanner.nextLine();
        switch(start) {
            case "1":
                clearConsole();
                bundesliga.printTable();
                mainScreen(bundesliga);
                break;

            case "2":
                clearConsole();
                if (bundesliga.getCurrentMatchday() == 35) {
                    System.out.println("The season is over!");
                    mainScreen(bundesliga);
                    break;
                }
                System.out.println("Playing matchday " + bundesliga.getCurrentMatchday());
                bundesliga.playMatchday();
                mainScreen(bundesliga);
                break;

            case "3":
                clearConsole();
                System.out.println("\n\n\n");
                seeSchedules(bundesliga);
                break;

            case "4":
                System.out.println("Thank you for playing!");
                scanner.close();
                break;

            default:
                System.out.println("Please enter a valid option!!!");
                mainScreen(bundesliga);
        }
    }



    public static void main(String[] args) {

        ArrayList<Team> bundesligaTeams = new ArrayList<>();
        bundesligaTeams.add(new Team("Bayern", "Germany"));
        bundesligaTeams.add(new Team("Dortmund", "Germany"));
        bundesligaTeams.add(new Team("Leipzig", "Germany"));
        bundesligaTeams.add(new Team("Leverkusen", "Germany"));
        bundesligaTeams.add(new Team("Wolfsburg", "Germany"));
        bundesligaTeams.add(new Team("Frankfurt", "Germany"));
        bundesligaTeams.add(new Team("Gladbach", "Germany"));
        bundesligaTeams.add(new Team("Freiburg", "Germany"));
        bundesligaTeams.add(new Team("Hoffenheim", "Germany"));
        bundesligaTeams.add(new Team("Union", "Germany"));
        bundesligaTeams.add(new Team("Hertha", "Germany"));
        bundesligaTeams.add(new Team("Mainz#", "Germany"));
        bundesligaTeams.add(new Team("Augsburg", "Germany"));
        bundesligaTeams.add(new Team("VfB", "Germany"));
        bundesligaTeams.add(new Team("Bielefeld", "Germany"));
        bundesligaTeams.add(new Team("FC Köln", "Germany"));
        bundesligaTeams.add(new Team("Bochum", "Germany"));
        bundesligaTeams.add(new Team("KSC", "Germany"));

        Tournament bundesliga = new Tournament("Bundesliga", 2024, bundesligaTeams);
        bundesliga.createSchedule();

        mainScreen(bundesliga);

    }
}