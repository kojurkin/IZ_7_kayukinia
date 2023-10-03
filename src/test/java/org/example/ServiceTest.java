package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ServiceTest {
    @Test
    public void testSerializeHouse1() throws Exception
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
        Service.serializeHouse(house, "serializeHouse.txt");
        House answer = Service.deserializeHouse("serializeHouse.txt");
        assertEquals(house, answer);
    }

    @Test
    public void testSerializeHouse2() throws Exception
    {
        Data date1 = new Data(30, 9, 2003);
        Data date2 = new Data(10, 12, 2003);
        Data date3 = new Data(29, 4, 2003);
        Person personFirst = new Person("Kayukin", "Ilya", "Aleksandrovich", date1);
        Person personSecond = new Person("Nelubin", "Ivan", "Sergeevich", date2);
        Person personThird = new Person("Romanovsky", "Vanya", "Mihailovich", date3);
        List<Person> flatPersons = new ArrayList<>(Arrays.asList(personFirst, personSecond, personThird));
        Flat flat = new Flat(101, 79.1, flatPersons);
        List<Flat> flats = new ArrayList<>(Arrays.asList(flat));
        House house = new House("123456", "Omsk", "Karla Marksa", "26b", personFirst, flats);
        Service.serializeHouse(house, "serializeHouse.txt");
        House answer = Service.deserializeHouse("serializeHouse.txt");
        assertEquals(house, answer);
    }

    @Test(expected = Exception.class)
    public void testSerializeHouse3() throws Exception
    {
        Service.serializeHouse(null, "test_ser.txt");
    }
}