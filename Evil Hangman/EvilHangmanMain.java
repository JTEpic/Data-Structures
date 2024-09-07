import java.io.FileNotFoundException;

public class EvilHangmanMain
{
    public static void main(String[] args) throws FileNotFoundException
    {
        EvilHangman evil = new EvilHangman("dictionary.txt", true);
        //EvilHangman evil = new EvilHangman("dictionary.txt", false);
        evil.playGame();
    }
}
