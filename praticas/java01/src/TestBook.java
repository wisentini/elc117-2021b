public class TestBook {
    public static void main(String[] args) {
        Book book1 = new Book("REST API Design Rulebook", "Mark Masse", "O'Reilly Media, Inc", 9781449310509L, 2011, 400, 198.54);
        Book book2 = new Book("Uma breve introdução à Mineração de Dados", "Joaquim Vinicius Carvalho Assunção", "Novatec", 9786586057508L, 2020, 192, 53.00);
        
        book1.show();
        book2.show();
    }
}
