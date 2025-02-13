package org.example;

import org.example.ecology.filter.EconomPersonFilter;
import org.example.ecology.models.Person;
import org.example.ecology.reader.CSVPersonReader;
import org.example.ecology.writer.CSVPersonWriter;
import org.example.report_history.Report;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите путь до файла");
//        Path path = Paths.get(scanner.nextLine());
//        System.out.println("Введите максимальное потребление пользователя");
//        int maxConsumption = scanner.nextInt();
//        CSVPersonReader csvPersonReader = new CSVPersonReader(path);
//        List<Person> personList = csvPersonReader.getList();
//        EconomPersonFilter hf = new EconomPersonFilter(maxConsumption);
//        List<Person> economPeopleList = hf.filter(personList);
//        CSVPersonWriter csvPersonWriter = new CSVPersonWriter(path, economPeopleList);

        List<Report> reportList = new ArrayList<>();
        reportList.add(new Report(1L,
                "no_punkz",
                1,
                LocalDate.of(2021,9,25),
                "Из-за внешних факторов все никак не могу сделать задачу со стримами, не хватило времени"));
        reportList.add(new Report(1L,
                "no_punkz",
                2,
                LocalDate.of(2021,9,26),
                "Бился над компаратором, пытался накостылить через видимую внешнюю переменную, начал читать о решениях из чата"));
        reportList.add(new Report(1L,
                "no_punkz",
                2,
                LocalDate.of(2021,9,27),
                "Продолжаю мучать предпоследнюю задачу (теперь и Толяна), собес на котором узнал много нового"));

        System.out.println(Report.reportHistory(reportList,"no_punkz", 2));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {


        T[] result = (T[]) new Object[2];

        stream.forEach(e -> {
            if (result[0] == null || order.compare(e, result[0]) < 0) {
                result[0] = e;
            }
            if (result[1] == null || order.compare(e, result[1]) > 0) {
                result[1] = e;
            }
        });

        if (result[0] == null && result[1] == null) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(result[0], result[1]);
        }
    }

}