public class Reverse {
    private void reverseString(char[] s) {
        swap (0, s);
    }

    private void swap(int ind, char[] s){
        char ch;
        int mid = s.length - ind;
        if (ind < mid) {
            ch = s[ind];
            s[ind] = s[mid - 1];
            s[mid - 1] = ch;
            swap(ind + 1, s);
        }
    }


    public  static void main(String arg[]) {
        Reverse reverse = new Reverse();
        char[] s = new char[]{'h','e','l','l','o','1', '2'};
        reverse.reverseString(s);
        System.out.println(s);

    }
}
