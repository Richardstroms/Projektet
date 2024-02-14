public class Instruktioner {
    public static void game(String[] args) throws Exception {

        Thread.sleep(1000);
        System.out.println(System.lineSeparator().repeat(20));
        System.out.println("               +---------------------------------+");
        System.out.println("               |        GAME INSTRUCTIONS        |");
        System.out.println("               |                                 |");
        System.out.println("               |                                 |");
        System.out.println("               |  In sink ships your goal is to  |");
        System.out.println("               |  guess the positions of the     |");
        System.out.println("               |  oppositions boats. If either   |");
        System.out.println("               |  all of your or the oppositions |");
        System.out.println("               |  boats ur sunken then the game  |");
        System.out.println("               |  is over.                       |");
        System.out.println("               |                                 |");
        System.out.println("               +---------------------------------+");
        System.out.println("");

        Thread.sleep(7000);
        System.out.println(System.lineSeparator().repeat(50));
        Spelet.start(args);
    }
}
