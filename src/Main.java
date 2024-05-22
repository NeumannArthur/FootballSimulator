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
                        System.out.println("Please check if your input is valid!");
                        seeSchedules(tournament);
                    }
                }
                clearConsole();
                scanner.close();
                break;

            case "2":
                System.out.println("Which matchday would you like to see?");
                int matchday = scanner.nextInt();
                tournament.getMatchdaySchedule(matchday);
                mainScreen(tournament);
                break;

            case "3":
                tournament.getSchedule();
                scanner.close();
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
        bundesligaTeams.add(new Team("Bayern Munich", "Germany"));
        bundesligaTeams.add(new Team("Borussia Dortmund", "Germany"));
        bundesligaTeams.add(new Team("RB Leipzig", "Germany"));
        bundesligaTeams.add(new Team("Bayer Leverkusen", "Germany"));
        bundesligaTeams.add(new Team("VfL Wolfsburg", "Germany"));
        bundesligaTeams.add(new Team("Eintracht Frankfurt", "Germany"));
        bundesligaTeams.add(new Team("Borussia Mönchengladbach", "Germany"));
        bundesligaTeams.add(new Team("SC Freiburg", "Germany"));
        bundesligaTeams.add(new Team("TSG Hoffenheim", "Germany"));
        bundesligaTeams.add(new Team("Union Berlin", "Germany"));
        bundesligaTeams.add(new Team("Hertha BSC", "Germany"));
        bundesligaTeams.add(new Team("Mainz 05", "Germany"));
        bundesligaTeams.add(new Team("FC Augsburg", "Germany"));
        bundesligaTeams.add(new Team("VfB Stuttgart", "Germany"));
        bundesligaTeams.add(new Team("Arminia Bielefeld", "Germany"));
        bundesligaTeams.add(new Team("1. FC Köln", "Germany"));
        bundesligaTeams.add(new Team("VfL Bochum", "Germany"));
        bundesligaTeams.add(new Team("SpVgg Greuther Fürth", "Germany"));

        Tournament bundesliga = new Tournament("Bundesliga", 2024, bundesligaTeams);
        bundesliga.createSchedule();

        mainScreen(bundesliga);

//        Person Franzi = new Person("Franzi", 20, true);
//        System.out.println(Franzi.getAge());
//        System.out.println(Franzi.getName());
//        Franzi.setName("Bob");
//        System.out.println(Franzi.getName());
//
//        System.out.println(Franzi.cool);
//        Franzi.makeCool(true);
//        System.out.println(Franzi.cool);

    }
}