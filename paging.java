import java.util.Scanner;

public class PagingSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ms, ps, nop, np, rempages, x, y, offset, pa;
        int[] s = new int[10];
        int[][] fno = new int[10][20];

        System.out.print("\nEnter total memory size: ");
        ms = sc.nextInt();

        System.out.print("Enter page size: ");
        ps = sc.nextInt();

        nop = ms / ps;
        System.out.println("Total number of pages: " + nop);

        System.out.print("\nEnter number of processes: ");
        np = sc.nextInt();

        rempages = nop;

        for (int i = 1; i <= np; i++) {
            System.out.print("\nEnter number of pages required for process [" + i + "]: ");
            s[i] = sc.nextInt();

            if (s[i] > rempages) {
                System.out.println("Memory full! Cannot allocate pages for process " + i + ".");
                break;
            }

            rempages -= s[i];
            System.out.println("Enter frame numbers for process [" + i + "]:");
            for (int j = 0; j < s[i]; j++) {
                System.out.print(" Page " + j + " -> Frame: ");
                fno[i][j] = sc.nextInt();
            }
        }

        System.out.print("\nEnter process number, page number, and offset: ");
        x = sc.nextInt();
        y = sc.nextInt();
        offset = sc.nextInt();

        if (x > np || y >= s[x] || offset >= ps) {
            System.out.println("\nInvalid input!");
        } else {
            pa = fno[x][y] * ps + offset;
            System.out.println("\nPhysical Address = " + pa);
        }

        sc.close();
    }
}
