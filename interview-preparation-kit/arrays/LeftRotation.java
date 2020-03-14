import java.util.Arrays;

public class LeftRotation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5}, 4)));//expected [5 1 2 3 4]
        System.out.println(Arrays.toString(rotLeft(new int[]{1}, 5)));//expected [1]
        System.out.println(Arrays.toString(rotLeft(new int[]{1, 2}, 5)));//expected [2 1]
    }

    static int[] rotLeft(int[] a, int d) {
        int aLength = a.length;
        int[] rotated = new int[aLength];

        if(aLength == d || aLength == 1)
            return a;

        if(d / aLength > 0)
            d = d % aLength;

        for(int i = 0; i < aLength; i++){
            int diff = i - d;
            int newIndex;

            if(diff < 0){
                newIndex = diff + aLength;
            }else{
                newIndex = diff;
            }
            rotated[newIndex] = a[i];
        }

        return rotated;
    }
}
