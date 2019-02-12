public class GuessNumber extends GuessGame {

    private int guessNumber(int n) {
        int min = 0;
        int max = n;
        int num = 1;
        while (guess (num)!=0) {
            num =  min + (max - min) / 2 + 1 ;
            if (guess (num)==-1)  max = num - 1;
            if (guess (num)==1)  min = num;
        }
        return num;
    }

    public  static void main(String arg[]) {
        GuessNumber guessNumber = new GuessNumber();

        int target = 10;
        System.out.println(guessNumber.guessNumber(target));

    }
}
