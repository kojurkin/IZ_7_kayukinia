package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void testPersonConstructor() throws Exception
    {
        Data personData = new Data(12, 3, 2004);
        Person person = new Person("Kayukin", "Ilya", "Aleksandrovich", personData);

        assertTrue("Kayukin".equals(person.getSurname()) && "Ilya".equals(person.getName()) && "Aleksandrovich".equals(person.getPatronymic())
                && personData.equals(person.getDate()));
    }

    @Test(expected = Exception.class)
    public void testPersonVoidName() throws Exception
    {
        Data personData = new Data(12, 3, 2004);
        Person person = new Person("Kayukin", "", "Aleksandrovich", personData);
    }

    @Test(expected = Exception.class)
    public void testPersonNullDate() throws Exception
    {
        Person person = new Person("Kayukin", "Ilya", "Aleksandrovich", null);
    }
}