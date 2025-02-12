package org.example.reader;

import org.example.models.Person;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CSVPersonReader implements PersonReader {
    private final Path path;
    private final List<Person> list;


    public CSVPersonReader(Path path) {
        this.path = path;

        list = read();

    }

    @Override
    public List<Person> read() {
        File readFile = path.resolve("data.csv").toFile();
        List<Person> peopleList = new ArrayList<>();
        String csvLine = "";
        String[] data = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(readFile))) {
            bufferedReader.readLine();
            while ((csvLine = bufferedReader.readLine()) != null) {
                data = csvLine.split("\\|");
                peopleList.add(new Person(Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]),
                        Integer.parseInt(data[4]),
                        Integer.parseInt(data[5]),
                        Integer.parseInt(data[6])));
            }

        } catch (IOException ignored) {
            throw new RuntimeException("Ошибка при чтении файла.");
        }
        return peopleList;
    }

    public List<Person> getList() {
        return list;
    }


}
