import java.util.Scanner;

public class Startsida {
    public static void main(String[] args) throws Exception {

        Scanner tangentbordet = new Scanner(System.in);
        String Välkommstbild = "                       █\n" +
                "                       $                     .........\n" +
                "                      ███      .oo..     'oooo'oooo'ooooooooo....\n" +
                "                       $       $$$$$$$\n" +
                "                   .ooooooo.   $$!!!!!\n" +
                "                 .'.........'. $$!!!!!      o$$oo.   ...oo,oooo,oooo'ooo''\n" +
                "    $          .█'  oooooo   '.$$!!!!!      $$!!!!!       'oo''oooo''\n" +
                " ..█$ooo...    $                '!!''!.     $$!!!!!\n" +
                " $    ..  '''█$$$$$$$$$$$$$.    '    'oo.  $$!!!!!\n" +
                " !.......      '''..$$ $$ $$$   ..        '.$$!!''!\n" +
                " ██$$$!!!!!!!!ooo█......   '''  $$ $$ :o           'oo.\n" +
                " ██$$!!!$$!$$!!!!!!!oo.....     ' ''  o$$o .      ''oo..\n" +
                " ██$$!!!!!!!!!!!!!!!!!!!!!!!!!!!!ooooo..      'o  oo..    $\n" +
                " '██$$!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!oooooo..  ''   ,$\n" +
                "  '██$!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!$$\n" +
                "   '$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$!!!!!!!!!!!!!!!!!!,\n" +
                ".....$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$.....";
        System.out.println(Välkommstbild);

        String Titel = " _____                                                     _____ \n" +
                "( ___ )                                                   ( ___ )\n" +
                " |   |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|   |\n" +
                " |   |  ____ ___ _   _ _  __  ____  _   _ ___ ____  ____   |   |\n" +
                " |   | / ___|_ _| \\ | | |/ / / ___|| | | |_ _|  _ \\/ ___|  |   |\n" +
                " |   | \\___ \\| ||  \\| | ' /  \\___ \\| |_| || || |_) \\___ \\  |   |\n" +
                " |   |  ___) | || |\\  | . \\   ___) |  _  || ||  __/ ___) | |   |\n" +
                " |   | |____/___|_| \\_|_|\\_\\ |____/|_| |_|___|_|   |____/  |   |\n" +
                " |___|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|___|\n" +
                "(_____)                                                   (_____)";
        System.out.println(Titel);

        boolean validInput = false;
        while (!validInput) {
            System.out.println("               +---------------------------------+");
            System.out.println("               |     Would you like to play?     |");
            System.out.println("               +---------------------------------+");
            System.out.println("           +-------------+            +-------------+");
            System.out.println("           |     Yes     |     or     |     No      |");
            System.out.println("           +-------------+            +-------------+");
            String Startspelet = tangentbordet.nextLine();

            System.out.println(System.lineSeparator().repeat(50)); // Den här koden gör att varje gång efter du har
                                                                   // skrivit ett svar så separeras koden med femtio
                                                                   // rader.

            if (Startspelet.equalsIgnoreCase("Yes")) {
                System.out.println("               +---------------------------------+");
                System.out.println("               |        Loading the game...      |");
                System.out.println("               +---------------------------------+");
                System.out.println("");
                Instruktioner.game(args);

                validInput = true;

            } else if (Startspelet.equalsIgnoreCase("No")) {
                System.out.println("               +---------------------------------+");
                System.out.println("               |   Game not started. Goodbye!    |");
                System.out.println("               +---------------------------------+");
                System.out.println("");
                validInput = true;

            } else {
                System.out.println("Invalid input. Please enter 'Yes' or 'No'.");

            }
        }
        tangentbordet.close();
    }
}
