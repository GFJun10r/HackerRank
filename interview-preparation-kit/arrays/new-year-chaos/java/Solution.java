import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];
            String[] qItems = scanner.nextLine().split(" ");

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }
        scanner.close();
    }

    static void minimumBribes(int[] q) {
        int totalBribes = 0;

        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 2 || q[i] > q.length) {
                System.out.println("Too chaotic");
                return;
            }
        }

        if (q.length == 1) {
            System.out.println(0);
            return;
        }

        if (q.length == 2) {
            if (q[0] > q[1]) {
                swapAndCountBribe(q, 0, 1);
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        boolean notFinished = true;
        while (notFinished) {
            int partialBribes = 0;
            for (int first = 0; first < q.length - 2; first++) {
                int second = first + 1;
                int third = first + 2;

                if (q[first] > q[second]) {
                    swapAndCountBribe(q, first, second);
                    partialBribes++;
                }
                if (q[third] < q[second]) {
                    swapAndCountBribe(q, third, second);
                    partialBribes++;
                    if (q[first] > q[second]) {
                        swapAndCountBribe(q, first, second);
                        partialBribes++;
                    }
                }
            }
            if (partialBribes == 0) {
                notFinished = false;
            } else {
                totalBribes += partialBribes;
            }
        }
        System.out.println(totalBribes);
    }

    private static void swapAndCountBribe(int[] q, int a, int b) {
        int aux = q[b];
        q[b] = q[a];
        q[a] = aux;
    }

}
