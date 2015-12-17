package algorithms.implementations;

import java.util.Scanner;

public class AngryProfessor {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int tests = in.nextInt();

    for (int i = 0; i < tests; i++) {
      int totalStudents = in.nextInt();
      int requiredStudents = in.nextInt();

      int earlyStudents = 0;

      for (int j = 0; j < totalStudents; j++) {
        if (in.nextInt() <= 0) {
          earlyStudents++;
        }
      }

      if (earlyStudents < requiredStudents) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }

    in.close();
  }

}
