package BS;

import java.util.Scanner;

public class SHit {
    public  static void main(String[] args){
        Scanner scan = new Scanner (System.in);
        String meme="";
        String x = scan.nextLine();
        for (int i = 0, len = x.length(); i < len; i++) {
            char ch = x.charAt(i);
            if (i % 2 == 0) {
                meme+=(Character.toLowerCase(ch));
            } else {
                meme+=(Character.toUpperCase(ch));
            }
        }
        System.out.println(meme);
        System.out.println();
    }

}
