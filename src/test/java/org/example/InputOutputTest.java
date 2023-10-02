package org.example;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputOutputTest {
    @Test
    public void testReadArray1() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 1, 2, 3, 4, 5 };
        s.writeArray(arr, "test1.bin");
        assertArrayEquals(arr, s.readArray(5, "test1.bin"));
    }

    @Test
    public void testReadArray2() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 27, 31, 46, 54, 77, 92 };
        s.writeArray(arr, "test1.bin");
        int[] array = { 27, 31, 46 };
        assertArrayEquals(array, s.readArray(3, "test1.bin"));
    }

    @Test
    public void testReadArray3() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = new int[0];
        s.writeArray(arr, "test1.bin");
        assertArrayEquals(arr, s.readArray(0, "test1.bin"));
    }

    @Test
    public void testReadArray4() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { -27, 31, 46, -54, 77, 92 };
        s.writeArray(arr, "test1.bin");
        int[] array = { -27, 31, 46, -54 };
        assertArrayEquals(array, s.readArray(4, "test1.bin"));
    }

    @Test(expected = Exception.class)
    public void testReadArray5() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 1, 2, 3, 4, 5 };
        s.writeArray(arr, "test1.bin");
        s.readArray(6, "test1.bin");
    }

    @Test
    public void testReadArraySym1() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 12, 45, 8, 96, 7 };
        s.writeArraySym(arr, "test1.txt");
        assertArrayEquals(arr, s.readArraySym(5, "test1.txt"));
    }

    @Test
    public void testReadArraySym2() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 45, 12, 8, 56, 2, 4 };
        s.writeArraySym(arr, "test1.txt");
        int[] array = { 45, 12, 8 };
        assertArrayEquals(array, s.readArraySym(3, "test1.txt"));
    }

    @Test
    public void testReadArraySym3() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = new int[0];
        s.writeArraySym(arr, "test1.txt");
        assertArrayEquals(arr, s.readArraySym(0, "test1.txt"));
    }

    @Test
    public void testReadArraySym4() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 28, -79, 56, 14, 3 };
        s.writeArraySym(arr, "test1.txt");
        assertArrayEquals(arr, s.readArraySym(5, "test1.txt"));
    }

    /*@Test(expected = Exception.class)
    public void testReadArraySym5() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 28, -79, 56, 14, 3 };
        s.writeArraySym(arr, "test1.txt");
        s.readArraySym(5, "test1.txt");
        assertArrayEquals(arr, s.readArraySym(5, "test1.txt"));
    }*/

    @Test
    public void testReadArrayIndex1() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 28, -79, 56, 14, 3 };
        s.writeArray(arr, "test1.bin");
        int[] array = { 56, 14, 3 };
        assertArrayEquals(array, s.readArrayIndex(5, 2, "test1.bin"));
    }

    @Test
    public void testReadArrayIndex2() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 1, 784, 1256, -46, 123, -7 };
        s.writeArray(arr, "test1.bin");
        int[] array = { 1, 784, 1256, -46, 123, -7 };
        assertArrayEquals(array, s.readArrayIndex(6, 0, "test1.bin"));
    }

    @Test
    public void testReadArrayIndex3() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 78, 52, -1, -2, -56, 7489, 1, 0, -56, 456 };
        s.writeArray(arr, "test1.bin");
        int[] array = { 7489, 1, 0, -56, 456 };
        assertArrayEquals(array, s.readArrayIndex(10, 5, "test1.bin"));
    }

    @Test
    public void testReadArrayIndex4() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 78, 52, -1, -2, -56, 7489, 1, 0, -56, 456 };
        s.writeArray(arr, "test1.bin");
        int[] array = { 456 };
        assertArrayEquals(array, s.readArrayIndex(10, 9, "test1.bin"));
    }

    @Test(expected = Exception.class)
    public void testReadArrayIndex5() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 78, 52, -1, -2, -56, 7489, 1, 0, -56, 456 };
        s.writeArray(arr, "test1.bin");
        s.readArrayIndex(10, -1, "test1.bin");
    }

    @Test(expected = Exception.class)
    public void testReadArrayIndex6() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 78, 52, -1, -2, -56, 7489, 1, 0, -56, 456 };
        s.writeArray(arr, "test1.bin");
        s.readArrayIndex(10, 11, "test1.bin");
    }

    @Test
    public void testGetFiles1() throws Exception
    {
        InputOutput s = new InputOutput();
        File f = new File("D:\\IdeaProjects\\lessons\\Laba_7\\src\\main\\java");//Нужно указать путь к папке java
        List<String> l = new ArrayList<>(Arrays.asList("data.txt", "ran_data.txt", "serialize.txt", "test1.txt", "test_ser.txt"));
        assertEquals(l, s.getFiles(f, "txt"));
    }
    @Test
    public void testGetFiles2() throws Exception
    {
        InputOutput s = new InputOutput();
        File f = new File("D:\\IdeaProjects\\lessons\\Laba_7\\src\\main\\java");
        List<String> l = new ArrayList<>(Arrays.asList("data.bin", "javax.bin", "test1.bin"));
        assertEquals(l, s.getFiles(f, "bin"));
    }

    @Test
    public void testGetFiles3() throws Exception
    {
        InputOutput s = new InputOutput();
        File f = new File("D:\\IdeaProjects\\lessons\\Laba_7\\src\\main\\java\\org\\example");
        List<String> l = new ArrayList<>(Arrays.asList("Data.java", "Flat.java", "House.java", "InputOutput.java", "Main.java", "Person.java", "Service.java"));
        assertEquals(l, s.getFiles(f, "java"));
    }

    @Test
    public void testGetFiles4() throws Exception
    {
        InputOutput s = new InputOutput();
        File f = new File("D:\\IdeaProjects\\lessons\\Laba_7\\.idea");
        List<String> l = new ArrayList<>(Arrays.asList("compiler.xml", "encodings.xml", "jarRepositories.xml", "misc.xml", "vcs.xml", "workspace.xml"));
        assertEquals(l, s.getFiles(f, "xml"));
    }

    @Test(expected = Exception.class)
    public void testGetFiles5() throws Exception
    {
        InputOutput s = new InputOutput();
        s.getFiles(null, "bin");
    }

    @Test(expected = Exception.class)
    public void testGetFiles6() throws Exception
    {
        InputOutput s = new InputOutput();
        File f = new File("\"D:\\\\IdeaProjects\\\\lessons\\\\Laba_7\\\\src\\\\main\\\\java");
        s.getFiles(f, "");
    }
}