public class Main {

  // A. O(1) — без цикла
  public static long funcA(long n) {
    long steps = 1;
    long sum = n * (n + 1) / 2;
    return steps;
  }

  // L. O(log n) — цикл делит пополам
  public static long funcL(long n) {
    long steps = 0;
    long j = n;
    while (j > 1) {
      steps = steps + 1;
      j = j / 2;
    }
    return steps;
  }

  // B. O(n) — один цикл
  public static long funcB(long n) {
    long steps = 0;
    long sum = 0;
    for (long i = 1; i <= n; i++) {
      steps = steps + 1;
      sum = sum + i;
    }
    return steps;
  }

  // D. O(n log n)
  public static long funcD(long n) {
    long steps = 0;
    for (long i = 1; i <= n; i++) {
      long j = n;
      while (j > 1) {
        steps = steps + 1;
        j = j / 2;
      }
    }
    return steps;
  }

  // C. O(n^2)
  public static long funcC(long n) {
    long steps = 0;
    for (long i = 1; i <= n; i++) {
      for (long k = 1; k <= n; k++) {
        steps = steps + 1;
      }
    }
    return steps;
  }

  // E. O(2^n)
  public static long funcE(long n) {
    long steps = 0;
    long limit = 1;
    for (long i = 1; i <= n; i++) {
      limit = limit * 2;
    }
    for (long k = 1; k <= limit; k++) {
      steps = steps + 1;
    }
    return steps;
  }

  // F. O(n!)
  public static long funcF(long n) {
    long steps = 0;
    long limit = 1;
    for (long i = 1; i <= n; i++) {
      limit = limit * i;
    }
    for (long k = 1; k <= limit; k++) {
      steps = steps + 1;
    }
    return steps;
  }

  public static void main(String[] args) {
    // Набор 1
    long[] nPoly = {100, 200, 400, 800, 1600, 3200};

    System.out.println("=== Таблица 1. Полиномиальный ряд ===");
    System.out.printf("%-8s | %-6s | %-8s | %-8s | %-12s | %-12s%n",
            "n", "A O(1)", "L O(log n)", "B O(n)", "D O(n log n)", "C O(n^2)");
    System.out.println("------------------------------------------------------------------");

    for (long n : nPoly) {
      System.out.printf("%-8d | %-6d | %-10d | %-8d | %-12d | %-12d%n",
              n, funcA(n), funcL(n), funcB(n), funcD(n), funcC(n));
    }

    System.out.println("\n=== Таблица 2. Экспонента и факториал ===");
    System.out.printf("%-4s | %-10s | %-4s | %-12s%n", "n", "E O(2^n)", "n", "F O(n!)");
    System.out.println("------------------------------------------");

    long[] nExp = {8, 10, 12, 14, 16, 18};
    long[] nFact = {4, 5, 6, 7, 8, 9};

    for (int i = 0; i < nExp.length; i++) {
      long ne = nExp[i];
      long nf = nFact[i];
      System.out.printf("%-4d | %-10d | %-4d | %-12d%n",
              ne, funcE(ne), nf, funcF(nf));
    }
  }
}