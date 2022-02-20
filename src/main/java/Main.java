public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver();
        output(solver.solve(input()));
    }

    private static void output(Solver.Response response) {

    }

    private static Solver.Request input() {
        double[][] arr = {
                {1, 5, 1, 1},
                {10, 1, 1, 13},
                {2, 2, 10, 14}
        };
        return new Solver().new Request(arr, 0.0031);
    }
}
