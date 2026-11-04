public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;



        MagicWord m = new MagicWord();

        while (!gameOver){
            System.out.println(m);
            System.out.println("Enter word or letter: ");
            String s = Input.readString();
            System.out.println();
            m.shoot(s);
            if (m.wins()){
                gameOver = true;
                System.out.println("You win!!! The hidden word was: " + m.getHiddenword());
            } else {
                if (m.looses()){
                    System.out.println("You loose. The hidden word was: " + m.getHiddenword());
                    gameOver = true;
                }
            }

        }
    }
}
