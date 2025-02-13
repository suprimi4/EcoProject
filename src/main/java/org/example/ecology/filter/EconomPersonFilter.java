package org.example.ecology.filter;

import org.example.ecology.models.Person;

import java.util.ArrayList;
import java.util.List;

public class EconomPersonFilter implements PersonFilter {

    private final int maxConsumption;

    public EconomPersonFilter(int maxConsumption) {
        this.maxConsumption = maxConsumption;
    }

    public List<Person> filter(List<Person> personList) {
        List<Person> economPeopleList = new ArrayList<>();
        for (Person currentPerson : personList) {
            if (currentPerson.getWaterCountDay() < maxConsumption &&
                    currentPerson.getWaterCountNight() < maxConsumption &&
                    currentPerson.getGasCount() < maxConsumption &&
                    currentPerson.getElectroCountDay() < maxConsumption &&
                    currentPerson.getElectroCountNight() < maxConsumption) {
                economPeopleList.add(currentPerson);
            }
        }
        return economPeopleList;
    }
}
