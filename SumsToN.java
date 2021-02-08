import java.util.Scanner;

/*	
 *	CS4050-01
 *	Larsen Close
 * Greg Dews
 * Suart Griffin
 *	Exercise 2
 */

public class SumsToN {

   public static void main(String[] args) {

      System.out.println(
            "\n\nCombinatorial solutions for numbers 0 to N, which sum to N. Exclusively increasing order [left to right], without repetitions.");
      Scanner scan = new Scanner(System.in);

      System.out.println("Enter Integer N for combinatorial summations: ");

      int n = scan.nextInt();

      sum_some_sums(n);
      scan.close();
      System.out.println();

   }

   private static void sum_some_sums(int n) {

      int sums[] = new int[n];

      summing(sums, 0, n, n);
   }

   private static void summing(int sums[], int index, int starting, int last) {

      if (last < 0) {
         return;
      }
      if (last == 0) {

         for (int i = 0; i < index; i++)
            System.out.print(sums[i] + " ");
         System.out.println();
         return;
      }
      int previous;

      if (index == 0) {
         previous = 1;
      } else {
         previous = sums[index - 1];
      }

      for (int i = previous; i <= starting; i++) {
         sums[index] = i;
         summing(sums, index + 1, starting, last - i);
      }
   }
}
