public class JumpingOnTheClouds {

    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0})); // Expect 4
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0})); // Expect 3
        System.out.println(jumpingOnClouds(new int[]{0, 0})); // Expect 1
    }

    static int jumpingOnClouds(int[] c) {
        int cloud = 0;
        int jumps = 0;

        while (cloud < c.length - 1) {
            if (cloud + 2 <= c.length - 1 && c[cloud + 2] == 0) {
                cloud++;
            }
            cloud++;
            jumps++;
        }
        return jumps;
    }

}
