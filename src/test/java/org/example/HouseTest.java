package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HouseTest {
    @Test
    public void testConstructor() throws Exception
    {
        Data firstPersonData = new Data(30, 9, 2003);
        Data secondPersonData = new Data(10, 12, 2003);
        Data thirdPersonData = new Data(29, 4, 2003);
        Data fourthPersonData = new Data(11, 1, 1901);
        Data fifthPersonData = new Data(26, 2, 1902);
        Data sixthPersonData = new Data(23, 3, 1903);
        Person personFirst = new Person("Kayukin", "Ilya", "Aleksandrovich", firstPersonData);
        Person personSecond = new Person("Nelubin", "Ivan", "Sergeevich", secondPersonData);
        Person personThird = new Person("Romanovsky", "Vanya", "Mihailovich", thirdPersonData);
        Person personFourth = new Person("Igorev", "Igor", "Igorevich", fourthPersonData);
        Person personFifth = new Person("Sidorov", "Sidor", "Sidorovich", fifthPersonData);
        Person personSixth = new Person("Sergeev", "Sergei", "Sergeevich", sixthPersonData);
        List<Person> firstFlatList = new ArrayList<>(Arrays.asList(personFirst, personSecond, personThird));
        List<Person> secondFlatList = new ArrayList<>(Arrays.asList(personFourth, personFifth, personSixth));
        Flat firstFlat = new Flat(123, 45.6, firstFlatList);
        Flat secondFlat = new Flat(789, 101.1, secondFlatList);
        List<Flat> flats = new ArrayList<>(Arrays.asList(firstFlat, secondFlat));
        House house = new House("123456", "Omsk", "Karla Marksa", "26b", personFirst, flats);
        assertTrue("123456".equals(house.getNumber()) && "Omsk".equals(house.getAddressCity()) && "Karla Marksa".equals(house.getAddressStreet())
                && "26b".equals(house.getAddressNumber()) && personFirst.equals(house.getAdmin()) && flats.equals(house.getFlats()));
    }

    @Test(expected = Exception.class)
    public void testVoidCity() throws Exception
    {
        Data personDate = new Data(12, 3, 2004);
        Person person = new Person("Kayukin", "Ilya", "Aleksandrovich", personDate);
        List<Person> list = new ArrayList<>(List.of(person));
        Flat flat = new Flat(101, 67.6, list);
        List<Flat> flats = new ArrayList<>(List.of(flat));
        House house = new House("123456", "", "Karla Marksa", "26b", person, flats);
    }

    @Test(expected = Exception.class)
    public void testVoidFlatsList() throws Exception
    {
        Data personDate = new Data(12, 3, 2004);
        Person person = new Person("Kayukin", "Ilya", "Aleksandrovich", personDate);
        House house = new House("123456", "Omsk", "Karla Marksa", "26b", person, null);
    }
}