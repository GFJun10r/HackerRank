public class Hourglasses {

    public static void main(String[] args) {
        int[][] case1 = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int[][] case2 = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        System.out.println(hourglassSum(case1)); //expect 28
        System.out.println(hourglassSum(case2)); //expect 19
    }

    static int hourglassSum(int[][] arr) {
        int maxSum = -Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = singleHourglassSum(i, j, arr);
                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }

    private static int singleHourglassSum(int i, int j, int[][] arr) {
        int sum = arr[i][j] +
                arr[i][j + 1] +
                arr[i][j + 2] +
                arr[i + 1][j + 1] +
                arr[i + 2][j] +
                arr[i + 2][j + 1] +
                arr[i + 2][j + 2];
        return sum;
    }

}
