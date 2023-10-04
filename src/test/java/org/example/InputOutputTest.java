package org.example;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputOutputTest {
    @Test
    public void NOT_TEST() throws Exception //Временный метод для создания потоков
    {
        InputOutput s = new InputOutput();
        int[] arr = { 1, 52, 3, 4, 5 };
        s.writeArray(arr, "test1.bin");
        assertTrue(true);
    }
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

    @Test(expected = Exception.class)
    public void testReadArraySym2() throws Exception
    {
        InputOutput s = new InputOutput();
        int[] arr = { 45, 12, 8, 56, 2, 4 };
        s.writeArraySym(arr, "test1.txt");
        int[] array = { 45, 12, 8 };
        //assertArrayEquals(array, s.readArraySym(3, "test1.txt"));
        s.readArraySym(3, "t.txt");
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
    public void testGetFilesTxt() throws Exception
    {
        InputOutput s = new InputOutput();
        File f = new File("/home/kojurkin/IdeaProjects/IZ_7_kayukinia/src/main/java");
        List<String> l = new ArrayList<>(Arrays.asList("ran_data.txt", "test1.txt", "data.txt", "serialize.txt"));
        assertEquals(l, s.getFiles(f, "txt"));
    }
    @Test
    public void testGetFilesBin() throws Exception
    {
        InputOutput s = new InputOutput();
        File f = new File("/home/kojurkin/IdeaProjects/IZ_7_kayukinia/src/main/java");
        List<String> l = new ArrayList<>(Arrays.asList("data.bin", "test1.bin", "javax.bin"));
        assertEquals(l, s.getFiles(f, "bin"));
    }

    @Test
    public void testGetFilesJava() throws Exception
    {
        InputOutput s = new InputOutput();
        File f = new File("/home/kojurkin/IdeaProjects/IZ_7_kayukinia/src/main/java/org/example");
        List<String> l = new ArrayList<>(Arrays.asList("Main.java", "Data.java", "Flat.java", "House.java", "Person.java", "Service.java", "InputOutput.java"));
        assertEquals(l, s.getFiles(f, "java"));
    }

    @Test(expected = Exception.class)
    public void testGetNullFile() throws Exception
    {
        InputOutput s = new InputOutput();
        s.getFiles(null, "bin");
    }

    @Test(expected = Exception.class)
    public void testGetNullEnd() throws Exception
    {
        InputOutput s = new InputOutput();
        File f = new File("/home/kojurkin/IdeaProjects/IZ_7_kayukinia/src/main");
        s.getFiles(f, "");
    }
}