package org.example.ecology.filter;

import org.example.ecology.models.Person;

import java.util.List;

public interface PersonFilter {
public List<Person> filter(List<Person> personList);
}
