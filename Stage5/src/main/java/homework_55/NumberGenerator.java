package homework_55;

import java.util.*;

/**
 * 5.5
 * Написать генератор блатных автомобильных номеров и реализовать поиск элементов в списке прямым перебором,
 * бинарным поиском, поиском с помощью HashSet и с помощью TreeSet. Измерить и сравнить длительность
 * 4-х видов поиска и написать результат в качестве решения домашнего задания.
 *
 * @author Oleg Bech
 * @email oleg071984@gmail.com
 */
public class NumberGenerator {

    private static List<String> numbers = new ArrayList<>();
    private final static String[] NUMBER_CHARS = new String[]{"C", "M", "T", "B", "A", "P", "O", "H", "E", "У"};

    public static void main(String[] args) {
        System.out.println("Формирование списка номеров..");
        numbers = numbersGemerator();
        System.out.println("Список номеров сформирован. Кол-во уникальных номеров: " + numbers.size());

        System.out.println(numbers.size());
        while (true) {
            System.out.println("Введите номер автомобиля:");
            String searchNumber = new Scanner(System.in).nextLine();

            bruteForceSearch(searchNumber);
            binarySearch(searchNumber);

            TreeSet<String> numbersTreeSet = new TreeSet<>(numbers);
            System.out.println("=======TreeSet======");
            long start = System.nanoTime();
            if (numbersTreeSet.contains(searchNumber)) {
                System.out.println("Номер найден. Время поиска: " + (System.nanoTime() - start) + "нс");
            } else {
                System.out.println("Номер не найден");
            }

            HashSet<String> numbersHashSet = new HashSet<>(numbers);
            System.out.println("=======HashSet======");
            long start1 = System.nanoTime();
            if (numbersHashSet.contains(searchNumber)) {
                System.out.println("Номер найден. Время поиска: " + (System.nanoTime() - start1) + "нс");
            } else {
                System.out.println("Номер не найден");
            }
        }
    }

    /**
     * Метод numbersGenerator()
     * Создание коллекции блатных номеров.
     *
     * @return коллекция блатных номеров.
     */
    private static List<String> numbersGemerator() {
        int regionCode = 1;
        List<String> result = new ArrayList<>();
        while (regionCode < 200) {
            for (String x : NUMBER_CHARS) {
                for (String y : NUMBER_CHARS) {
                    for (String z : NUMBER_CHARS) {
                        for (int j = 1; j < 1000; j++) {
                            if (regionCode < 100) {
                                result.add(String.format("%s%03d%s%s%02d", x, j, y, z, regionCode));
                            } else {
                                result.add(String.format("%s%03d%s%s%03d", x, j, y, z, regionCode));
                            }
                        }
                    }
                }
            }
            regionCode++;
        }
        return result;
    }

    private static void bruteForceSearch(String myNumber) {
        System.out.println("=======Поиск перебором======");
        long start = System.nanoTime();
        for (String number : numbers) {
            if (number.equals(myNumber)) {
                System.out.println("Номер найден. Время поиска: " + (System.nanoTime() - start) + "нс");
                break;
            }
        }
    }


    private static void binarySearch(String myNumber) {
        System.out.println("=======Двоичный поиск======");
        Collections.sort(numbers);
        long start = System.nanoTime();
        long result = Collections.binarySearch(numbers, myNumber);
        if (result != -1) {
            System.out.println("Номер найден. Время поиска: " + (System.nanoTime() - start) + "нс");
        } else {
            System.out.println("Номер не найден.");
        }
    }
}
