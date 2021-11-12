package aggregation;

import java.util.*;

public class Team {
    private String name;
    private int id;
    private List<Player> players;

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Team(String name, int id) {
        this.name = name;
        this.id = id;
        this.players = new ArrayList<Player>();
    }

    public Team(String name, int id, List<Player> players) {
        this.name = name;
        this.id = id;
        this.players = players;
    }

    public void show() {
        System.out.println();
        System.out.println("TEAM INFO:");
        System.out.println("\tNAME: " + this.name);
        System.out.println("\tID: " + this.id);
        System.out.println("\tNUMBER OF PLAYERS: " + this.players.size());
        System.out.println("\tPLAYERS:");

        for (Player player : this.players) {
            System.out.print("\t\t");
            player.show(); 
        }
    }

    public void addPlayer(Player player) {
        if (player != null) {
            this.players.add(player);
        }
    }

    public void removePlayer(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.players.removeIf(player -> player.getName().equals(name));
        }
    }

    public void removePlayer(int number) {
        this.players.removeIf(player -> player.getNumber() == number);
    }
}
