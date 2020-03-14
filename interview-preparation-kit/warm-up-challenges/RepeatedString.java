public class RepeatedString {
    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));//Should return 7
        System.out.println(repeatedString("a", 10));//Should return 10
        System.out.println(repeatedString("bc", 10));//Should return 0
        System.out.println(repeatedString("abc", 1));//Should return 1
    }

    static long repeatedString(String s, long n) {
        int stringOcurrencies;
        long stringRepInN;
        long allOcurrencies;

        if(n <= s.length()) {
            return evalOcurrencies(s, n);
        }

        stringOcurrencies = evalOcurrencies(s, s.length());

        if(stringOcurrencies == 0){
            return stringOcurrencies;
        }

        stringRepInN = n / s.length();
        allOcurrencies = stringRepInN * stringOcurrencies;
        allOcurrencies += evalOcurrencies(s, (n % s.length()));

        return allOcurrencies;
    }

    private static int evalOcurrencies(String s, long numOfChars) {
        int ocurrencies = 0;
        for (int i = 0; i < numOfChars; i++){
            if (s.charAt(i) == 'a'){
                ocurrencies++;
            }
        }
        return ocurrencies;
    }
}
