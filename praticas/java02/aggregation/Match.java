package aggregation;

public class Match {
    private String name;
    private int id;
    private Team homeTeam;
    private Team visitingTeam;
    private int homeTeamScore;
    private int visitingTeamScore;

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public Team getHomeTeam() {
        return this.homeTeam;
    }

    public Team getVisitingTeam() {
        return this.visitingTeam;
    }

    public int getHomeTeamScore() {
        return this.homeTeamScore;
    }

    public int getVisitingTeamScore() {
        return this.visitingTeamScore;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setVisitingTeam(Team visitingTeam) {
        this.visitingTeam = visitingTeam;
    }

    public Match(String name, int id, Team homeTeam, Team visitingTeam) {
        this.name = name;
        this.id = id;
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
    }

    public void show() {
        System.out.println();
        System.out.println("MATCH INFO:");
        System.out.println("\tNAME: " + this.name);
        System.out.println("\tID: " + this.id);
        System.out.println("\tSCORE:");
        System.out.println("\t\t" + this.homeTeam.getName() + " (homeTeam) ~ " + this.homeTeamScore);
        System.out.println("\t\t" + this.visitingTeam.getName() + " (visitingTeam) ~ " + this.visitingTeamScore);
    }

    public void changeScore(int homeTeamScore, int visitingTeamScore) {
        if (homeTeamScore >= 0) {
            this.homeTeamScore = homeTeamScore;
        }

        if (visitingTeamScore >= 0) {
            this.visitingTeamScore = visitingTeamScore;
        }
    }
}
