package org.example.filter;

import org.example.models.Person;

import java.util.List;

public interface PersonFilter {
public List<Person> filter(List<Person> personList);
}
