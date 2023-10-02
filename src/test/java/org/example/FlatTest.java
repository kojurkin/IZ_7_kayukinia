package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FlatTest {
    @Test
    public void testFlatConstructor() throws Exception
    {
        Data date1 = new Data(30, 9, 2003);
        Data date2 = new Data(10, 12, 2003);
        Data date3 = new Data(29, 4, 2003);
        Person personFirst = new Person("Kayukin", "Ilya", "Aleksandrovich", date1);
        Person personSecond = new Person("Nelubin", "Ivan", "Sergeevich", date2);
        Person personThird = new Person("Romanovsky", "Vanya", "Mihailovich", date3);
        List<Person> flatPersons = new ArrayList<>(Arrays.asList(personFirst, personSecond, personThird));
        Flat flat = new Flat(101, 79.1, flatPersons);
        assertTrue(flat.getNumber() == 101 && Double.compare(flat.getArea(), 79.1) == 0 && flatPersons.equals(flat.getList()));
    }

    @Test(expected = Exception.class)
    public void testFlatNegativeNumber() throws Exception
    {
        Data date1 = new Data(30, 9, 2003);
        Data date2 = new Data(10, 12, 2003);
        Data date3 = new Data(29, 4, 2003);
        Person personFirst = new Person("Kayukin", "Ilya", "Aleksandrovich", date1);
        Person personSecond = new Person("Nelubin", "Ivan", "Sergeevich", date2);
        Person personThird = new Person("Romanovsky", "Vanya", "Mihailovich", date3);
        List<Person> flatPersons = new ArrayList<>(Arrays.asList(personFirst, personSecond, personThird));
        Flat flat = new Flat(-101, 79.1, flatPersons);
    }

    @Test(expected = Exception.class)
    public void testFlatNullList() throws Exception
    {
        Flat flat = new Flat(71, 27.3, null);
    }
}