package aggregation;

public class TestAggregation {
    public static void main(String[] args) {
        Team gremio = new Team("Grêmio", 66);

        gremio.addPlayer(new Player("Douglas Costa", 1, 6));
        gremio.addPlayer(new Player("Jaminton Campaz", 2, 3));
        gremio.addPlayer(new Player("Miguel Borja", 3, 32));
        gremio.addPlayer(new Player("Rafinha", 4, 23));
        gremio.addPlayer(new Player("Aldemir Ferreira", 5, 56));
        gremio.addPlayer(new Player("Mathias Villasanti", 6, 74));
        gremio.addPlayer(new Player("Diego Souza", 7, 97));
        gremio.addPlayer(new Player("Pedro Geromel", 8, 12));
        gremio.addPlayer(new Player("Ruan Tressoldi", 9, 54));
        gremio.addPlayer(new Player("Jean Pyerre", 10, 87));
        gremio.addPlayer(new Player("Gabriel Chapecó", 11, 10));

        gremio.show();

        Team inter = new Team("Internacional", 87);

        inter.addPlayer(new Player("Paolo Guerrero", 1, 45));
        inter.addPlayer(new Player("Taison", 2, 75));
        inter.addPlayer(new Player("Yuri Alberto Monteiro", 3, 12));
        inter.addPlayer(new Player("Gabriel Mercado", 4, 4));
        inter.addPlayer(new Player("Carlos Palacios", 5, 43));
        inter.addPlayer(new Player("Patrick", 6, 70));
        inter.addPlayer(new Player("Gustavo Maia", 7, 56));
        inter.addPlayer(new Player("Daniel", 8, 28));
        inter.addPlayer(new Player("Paulo Victor", 9, 42));
        inter.addPlayer(new Player("Kaique Rocha", 10, 16));
        inter.addPlayer(new Player("Renzo Saravia", 11, 66));

        inter.show();

        Match grenal = new Match("Grenal", 418, gremio, inter);

        grenal.changeScore(3, 1);

        grenal.show();

        gremio.removePlayer("Diego Souza");
        gremio.removePlayer(4);

        gremio.show();
    }
}
