import java.util.Locale;

public class MagicWord {
    private static final int MAX_FAILS = 10;
    private static String[] WORD = {
            "hola", "pitufo", "derekcumbia", "funenespaña", "denmeoro" , "pepesaurio", "nochatgpt"
    };
    private String hiddenword;
    private boolean[] correctLetters;
    private int fails;

    public MagicWord() {
        fails = 0;
        int alea = (int) (Math.random() * WORD.length);
        hiddenword = WORD[alea];
        correctLetters = new boolean[hiddenword.length()];
        for (int i = 0; i < hiddenword.length(); i++){
            correctLetters[i] = false;
        }
        System.out.println(hiddenword);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < hiddenword.length();i++){
             if (!correctLetters[i]){
                 s += "_";
             }else{
                 s += hiddenword.charAt(i);
             }
        }
        return s;
    }

    public String getHiddenword(){
        return hiddenword;
    }

    public boolean wins(){
        for (int i = 0; i < correctLetters.length;i++){
            if (!correctLetters[i]){
                return false;
            }
        }
        return true;
    }

    public boolean looses(){
        return fails > MAX_FAILS;
    }

    public void shoot(String wordOrLetter){
        boolean acierto = false;
        if (wordOrLetter.length() == 1){
            for (int i = 0; i < hiddenword.length();i++){
                if (wordOrLetter.toLowerCase().charAt(0) == hiddenword.toLowerCase().charAt(i)) {
                    correctLetters[i] = true;
                    acierto = true;
                }
            }
            if (!acierto){
                fails++;
            }
        }else{
            if (hiddenword.toLowerCase().equals(wordOrLetter.toLowerCase())){
                for (int i = 0; i < correctLetters.length; i++){
                    correctLetters[i] = true;
                }
            } else{
                fails = MAX_FAILS + 1;
            }
        }
    }
}
