package org.example;

import org.example.filter.EconomPersonFilter;
import org.example.models.Person;
import org.example.reader.CSVPersonReader;
import org.example.writer.CSVPersonWriter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до файла");
        Path path = Paths.get(scanner.nextLine());
        System.out.println("Введите максимальное потребление пользователя");
        int maxConsumption = scanner.nextInt();
        CSVPersonReader csvPersonReader = new CSVPersonReader(path);
        List<Person> personList = csvPersonReader.getList();
        EconomPersonFilter hf = new EconomPersonFilter(maxConsumption);
        List<Person> economPeopleList = hf.filter(personList);
        CSVPersonWriter csvPersonWriter = new CSVPersonWriter(path, economPeopleList);
    }

}