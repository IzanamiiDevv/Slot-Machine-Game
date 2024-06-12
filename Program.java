import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Game game = new Game();
        char response;
        do {
            game.play();
        } while (false);
    }
}

class Game {
    private char data[] = {'A','B','C'};
    private char picked[] = {'0','0','0'};

    private void generateTable(char picked[]) {
        System.out.println("+---------+---------+---------+");
        System.out.println("|         |         |         |");
        System.out.println(String.format("|    %c    |    %c    |    %c    |",picked[0],picked[1],picked[2]));
        System.out.println("|         |         |         |");
        System.out.println("+---------+---------+---------+");
    }

    public void play(){
        for(int i = 0; i < picked.length; i++) {
            pick(i);
        }
    }

    private void pick(int index){
        Random random = new Random();
        if(picked[index] != '0')return;
        
        for (int i = 0; i <= 20; i++) {
            generateTable(picked);
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int temp = random.nextInt(0, data.length);
            picked[index] = data[temp];
            if(i == 20)break;
            clearConsole();
        }

    }
    
    private void clearConsole() {
        try {
            if (System.getProperty("os.name").startsWith("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}