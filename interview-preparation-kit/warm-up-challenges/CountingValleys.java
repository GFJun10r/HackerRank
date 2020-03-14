public class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys(8,"UDDDUDUU")); //Expect 1
        System.out.println(countingValleys(10,"DUDUDUDDUU")); //Expect 4
        System.out.println(countingValleys(2,"DDUU")); //Expect 0
    }

    static int countingValleys(int n, String s) {
        int pos = 0;
        int valleys = 0;

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'D'){
                pos--;
            }else{
                pos++;
                if(pos == 0){
                    valleys++;
                }
            }
        }
        return valleys;
    }
}
