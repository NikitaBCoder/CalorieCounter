import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int Goal = 10000;
        HashMap<Integer, ArrayList<Integer>> heshtablica = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < 12; i++){
            ArrayList<Integer> days = new ArrayList<>();
            for (int d = 0; d < 30; d++) {
                days.add(0);
            }
            heshtablica.put(i, days);
        }

        System.out.println(heshtablica);

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0 && userInput != 4){
            if (userInput == 1){
                System.out.println("Введите название месяца:");
                String TakeMonth = scanner.next();
                int NumberOfMonth = NumberMonth(TakeMonth);
                if (NumberOfMonth == 12){
                    System.out.println("Неправильно введен месяц!!!!!");
                }else {
                    System.out.println("Введите номер дня:");
                    int NumberOfDay = scanner.nextInt();
                    System.out.println("Введите количество шагов:");
                    int NumberOfSteps = scanner.nextInt();

                    ArrayList<Integer> num1 = heshtablica.get(NumberOfMonth);
                    System.out.println(num1);
                    int num2 = num1.get(NumberOfDay);
                    System.out.println(num2);
                    num1.set(NumberOfDay - 1, NumberOfSteps);

                    ArrayList<Integer> num3 = heshtablica.get(NumberOfMonth);
                    System.out.println(num3);
                    System.out.println(num2);
                }

            } else if (userInput == 2) {
                System.out.println("Введите название месяца:");
                String TakeMonth = scanner.next();
                int NumberOfMonth = NumberMonth(TakeMonth);

                ArrayList<Integer> num1 = heshtablica.get(NumberOfMonth);
                String NumberOfStepsTaken = "";
                int NumberOfStepsPerMonth = 0;
                int MaxNumberOfStepsPerMonth = 0;
                int BestEpisode = 0;
                int count = 0;
                for (int i = 0; i < num1.size(); i++){
                    int ChisloSpiska = num1.get(i);
                    int Chislo = i + 1;
                    NumberOfStepsTaken = NumberOfStepsTaken + " " + Chislo + " день: " + ChisloSpiska + ",";
                    NumberOfStepsPerMonth = NumberOfStepsPerMonth + ChisloSpiska;

                    if (ChisloSpiska > MaxNumberOfStepsPerMonth){
                        MaxNumberOfStepsPerMonth = ChisloSpiska;
                    }

                    if (ChisloSpiska >= Goal) {
                        if (++count > BestEpisode) {
                            BestEpisode = count;
                        }
                    } else {
                        count = 0;
                    }
                }

                double AverageNumberofSteps = NumberOfStepsPerMonth / 2.0;
                double DistanceTraveled = (NumberOfStepsPerMonth * 75.0) / 100000.0;
                double NumberOfKilocaloriesBurned = (NumberOfStepsPerMonth * 50.0) / 1000.0;

                System.out.println("Количество пройденных шагов по дням: " + NumberOfStepsTaken);
                System.out.println("Общее количество шагов за месяц: " + NumberOfStepsPerMonth);
                System.out.println("Максимальое пройденное количество шагов в месяце: " + MaxNumberOfStepsPerMonth);
                System.out.println("Среднее количество шагов: " + AverageNumberofSteps);
                System.out.println("Пройденная дистанция (в км): " + DistanceTraveled);
                System.out.println("Количество сожженых килокалорий: " + NumberOfKilocaloriesBurned);
                System.out.println("Лучшая серия: " + BestEpisode);

            } else if (userInput == 3) {
                System.out.println("Введите нужную цель:");
                Goal = scanner.nextInt();
            } else {
                System.out.println("Введенное значение не соответствует номеру меню!!! Введите правильное значение!!! ");
            }
            printMenu();
            System.out.println(heshtablica);
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
        scanner.close();
    }

    public static void printMenu(){
        System.out.printf(" 1. Ввести количество шагов за определенный день;%n 2. Напечатать статистику за определенный месяц;%n 3. Изменить цель по количеству шагов в день;%n 4. Выйти из приложения.%n" );
    }

    public static int NumberMonth (String takeMonth) {
        int num = 12;
        if (Objects.equals(takeMonth, "Январь") || Objects.equals(takeMonth, "январь")) {
            num = 0;
        }else if (Objects.equals(takeMonth, "Февраль") || Objects.equals(takeMonth, "февраль")) {
            num = 1;
        }else if (Objects.equals(takeMonth, "Март") || Objects.equals(takeMonth, "март")) {
            num = 2;
        }else if (Objects.equals(takeMonth, "Апрель") || Objects.equals(takeMonth, "апрель")) {
            num = 3;
        }else if (Objects.equals(takeMonth, "Май") || Objects.equals(takeMonth, "май")) {
            num = 4;
        }else if (Objects.equals(takeMonth, "Июнь") || Objects.equals(takeMonth, "июнь")) {
            num = 5;
        }else if (Objects.equals(takeMonth, "Июль") || Objects.equals(takeMonth, "июль")) {
            num = 6;
        }else if (Objects.equals(takeMonth, "Август") || Objects.equals(takeMonth, "август")) {
            num = 7;
        }else if (Objects.equals(takeMonth, "Сентябрь") || Objects.equals(takeMonth, "сентябрь")) {
            num = 8;
        }else if (Objects.equals(takeMonth, "Октябрь") || Objects.equals(takeMonth, "октябрь")) {
            num = 9;
        }else if (Objects.equals(takeMonth, "Ноябрь") || Objects.equals(takeMonth, "ноябрь")) {
            num = 10;
        }else if (Objects.equals(takeMonth, "Декабрь") || Objects.equals(takeMonth, "декабрь")) num = 11;
        return num;
    }


}

