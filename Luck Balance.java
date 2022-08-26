import java.util.Arrays;
import java.util.Scanner;
public class LuckBalance {

    static class Contest implements Comparable<Contest> {
        int l,t;

        @Override
        public int compareTo(Contest o) {
            if(t == o.t) {
                return (this.l - o.l);
            }else {
                return -(this.t - o.t);
            }
        }
    }
    public static void main(String[] args) {
        int N, K;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        int total = 0;
        int t,l;
        Contest[] contests = new Contest[N];
        int importCnt = 0;
        for (int i = 0; i < N; i++) {

            l = scanner.nextInt();
            t = scanner.nextInt();
            total += l;
            if(t == 1) {
                importCnt++;
            }
            Contest contest = new Contest();
            contest.l = l;
            contest.t = t;

            contests[i] = contest;
        }

        Arrays.sort(contests);

        int winCnt = importCnt - K;
        if(winCnt <= 0) {
            System.out.println(total);
            return;
        }

        for (int i = 0; i < winCnt; i++) {
            total -= 2 * contests[i].l;
        }
        System.out.println(total);



    }
}