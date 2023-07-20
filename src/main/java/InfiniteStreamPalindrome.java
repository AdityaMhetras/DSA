import java.util.Objects;

public class InfiniteStreamPalindrome {
    public static void main(String[] args) {
        String str = "aabaa";
//        String str = "aaa";

        checkPalindrome(str);
    }

    public static void checkPalindrome(String str) {

        if(Objects.nonNull(str)) {
            long mod = 1000000000+7;
            long prime = 7;
            long primeMultiplier = 1;
            long fw = 0;
            long bw = 0;


            for(int i = 0 ; i < str.length(); i++) {

                fw = (fw % mod + (getCharValue(str.charAt(i))% mod * primeMultiplier% mod)% mod) % mod;
                bw = ((bw% mod * prime)% mod + getCharValue(str.charAt(i))) % mod;

                if(fw == bw) {
                    System.out.println(str.substring(0,i+1)+" : true");
                }else {
                    System.out.println(str.substring(0,i+1)+" : false");
                }

                primeMultiplier = (primeMultiplier % mod * prime % mod) % mod;

            }
        }

    }

    public static long getCharValue(char c) {
        return c - 'a'+1;
    }
}
