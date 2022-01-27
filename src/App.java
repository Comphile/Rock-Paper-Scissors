import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        String title = "Rock Paper Scissor";
        String[] rounds = { "1", "3", "5", "7", "Cancel" };
        String[] options = { "Rock", "Paper", "Scissors", "Cancel" };
        int x = JOptionPane.showOptionDialog(null, "How many rounds do you want to play", "Rock Paper Scissors",
                JOptionPane.DEFAULT_OPTION, 3, null, rounds, rounds[0]);
        int loop ;
        if (rounds[x] .equals("Cancel"))
            return;
        loop = Integer.parseInt(rounds[x]);

        int won = 0;
        int lost = 0;
        for (int i = 0; i < loop;) {

            int userans = JOptionPane.showOptionDialog(null, "Choose your option", "Rock Paper Scissors",
                    JOptionPane.DEFAULT_OPTION, 3, null, options, options[0]);
            if (options[userans].equals("Cancel"))
                return;

            int compans = (int) (Math.random() * 3.0D);
            // int compans = 0;
            String val = RPS(userans, compans);
            JOptionPane.showMessageDialog(null,
                    "Computer Chooses " + options[compans] + "\n" + RPS(userans, compans) + " the round! ",
                    "Rock Paper Scissor",
                    JOptionPane.INFORMATION_MESSAGE);
            if (val.equals("You won"))
                won++;
            if (val.equals("You lost"))
                lost++;
            if (!val.equals("Tied"))
                i++;
            if (won > loop - won)
                break;
            if (lost > loop - lost)
                break;

        }

        if (won > loop - won) {
            JOptionPane.showMessageDialog(null, "You Won the Game with score: " + won + ":" + lost, title, 2);
        } else
            JOptionPane.showMessageDialog(null, "You Lost the Game with score: " + won + ":" + lost, title,2);

    }

    public static String RPS(int userans, int compans) {
        if (compans == userans) {
            return "Tied";
        } else if (compans == 0) {
            return userans == 1 ? "You won" : "You lost";
        } else if (compans == 1) {
            return userans == 2 ? "You won" : "You lost";
        } else {
            return userans == 0 ? "You won" : "You lost";
        }
    }
}
