package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class InputOutput {
    public void writeArray(int[] arr, String name) throws Exception
    {
        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(name)))
        {
            for (int i : arr)
            {
                stream.writeInt(i);
            }
        }
        catch (IOException e)
        {
            throw new Exception("Wrong stream!");
        }
    }
    public int[] readArray(int n, String name) throws Exception
    {
        int[] arr = new int[n];
        try (DataInputStream stream = new DataInputStream(new FileInputStream(name)))
        {
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = stream.readInt();
            }
        }
        catch (IOException e)
        {
            throw new Exception("Wrong stream!");
        }
        return arr;
    }

    public void writeArraySym(int[] arr, String name) throws Exception
    {
        try (OutputStreamWriter stream = new OutputStreamWriter(new FileOutputStream(name), StandardCharsets.UTF_8))
        {
            for (int i: arr)
            {
                stream.write(i + " ");
            }
        }
        catch (IOException e)
        {
            throw new Exception("Wrong stream!");
        }
    }

    public int[] readArraySym(int n, String name) throws Exception
    {
        int[] arr = new int[n];
        try (InputStreamReader stream = new InputStreamReader(new FileInputStream(name), StandardCharsets.UTF_8))
        {
            StringBuilder str = new StringBuilder();
            int index = 0;
            int elem;
            while (((elem = stream.read()) != -1))
            {
                char symbol = (char) elem;
                if (symbol != ' ')
                {
                    str.append(symbol);
                }
                else
                {
                    if (n == index)
                    {
                        break;
                    }
                    arr[index] = Integer.parseInt(str.toString());
                    index++;
                    str = new StringBuilder();
                }
            }
        }
        catch (IOException e)
        {
            throw new Exception("Wrong stream!");
        }
        return arr;
    }

    public int[] readArrayIndex(int n, int index, String name) throws Exception
    {
        if (index > n || index < 0)
        {
            throw new Exception("Wrong index!");
        }
        int[] arr = new int[n - index];
        try (RandomAccessFile file = new RandomAccessFile(name, "r"))
        {
            file.seek(index * 4L);
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = file.readInt();
            }
        }
        catch (IOException e)
        {
            throw new Exception("Wrong stream!");
        }
        return arr;
    }

    public List<String> getFiles(File file, String end) throws Exception
    {
        if (file == null)
        {
            throw new Exception("Wrong file!");
        }
        else if ("".equals(end) || end == null)
        {
            throw new Exception("Wrong file extension");
        }
        String[] files = file.list();
        List<String> l = new ArrayList<>();
        assert files != null;
        for (String s : files) {
            if (s.endsWith(end)) {
                l.add(s);
            }
        }
        return l;
    }
}
