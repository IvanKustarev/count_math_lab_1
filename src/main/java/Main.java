import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver();
        output(solver.solve(input()));
    }

    private static void output(Solver.Response response) {
        System.out.print("\n\nОтветы: ");
        System.out.println(Arrays.toString(response.getAnswer()));
        System.out.println("Количество итерраций = " + response.getIterationCount());
        System.out.print("Вектор погрешностей: ");
        System.out.println(response.getErrRates().toString());
    }

    private static Solver.Request input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод данных из консоли - 0, из файла - 1");
        try {
            if (Integer.parseInt(scanner.nextLine().toLowerCase().trim()) == 0) {
                return consoleInput();
            } else {
                return fileInput();
            }
        } catch (NumberFormatException e) {
            System.err.println("Была введена неправильная цифра!");
            System.exit(1);
            return null;
        }

//        double[][] arr = {
//                {2, 2, 10, 14},
//                {10, 1, 1, 12},
//                {2, 10 ,1, 13}
//        };
//        return new Solver().new Request(arr, 0.0033);
    }

    private static Solver.Request consoleInput() {
        Scanner scanner = new Scanner(System.in);
        Solver.Request request = new Solver().new Request();
        try {
            System.out.println("Введите размерность матрицы!");
            int arrSize = scanner.nextInt();
            double[][] srcMatrix = new double[arrSize][arrSize + 1];
            System.out.println("Введите точность:");
            request.setErrRate(scanner.nextDouble());
            System.out.println("Введите коэффициенты матрицы и свободные члены через проблеы и с разделение строк:");
            for (int i = 0; i < srcMatrix.length; i++) {
                for (int j = 0; j < srcMatrix[0].length; j++) {
                    srcMatrix[i][j] = scanner.nextDouble();
                }
            }
            request.setSrcMatrix(srcMatrix);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неправильный ввод!");
            System.exit(1);
            return request;
        }
    }

    private static Solver.Request fileInput() {
        Solver.Request request = new Solver().new Request();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите путь к файлу:");
            scanner = new Scanner(new File(scanner.nextLine()));
            int arrSize = scanner.nextInt();
            double[][] srcMatrix = new double[arrSize][arrSize + 1];
            request.setErrRate(scanner.nextDouble());
            for (int i = 0; i < srcMatrix.length; i++) {
                for (int j = 0; j < srcMatrix[0].length; j++) {
                    srcMatrix[i][j] = scanner.nextDouble();
                }
            }
            request.setSrcMatrix(srcMatrix);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неправильный ввод!");
            System.exit(1);
            return request;
        }
    }
}
