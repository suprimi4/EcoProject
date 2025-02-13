package org.example.ecology.writer;

import org.example.ecology.models.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class CSVPersonWriter implements PersonWriter {
    private final Path path;
    private final List<Person> list;

    public CSVPersonWriter(Path path, List<Person> list) {
        this.path = path;
        this.list = list;
        write();
    }

    @Override
    public void write() {
        File writeFile = path.resolve("EconomPeopleList.csv").toFile();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeFile))) {
            for (Person item : list) {
                bufferedWriter.write(item.toString());
                bufferedWriter.newLine();
            }
            System.out.println("Файл " + writeFile.getName() + " успешно создан в указанной вами директории");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи файла");
        }
    }
}
