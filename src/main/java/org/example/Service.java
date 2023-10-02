package org.example;

import java.io.*;

public class Service {
    public static void serializeHouse(House house, String filename) throws Exception
    {
        if (house == null)
        {
            throw new Exception("Wrong house!");
        }

        try (ObjectOutput out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename))))
        {
            out.writeObject(house);
        }
        catch (IOException e)
        {
            throw new Exception("Wrong stream!");
        }
    }

    public static House deserializeHouse(String filename) throws IOException, ClassNotFoundException, ClassCastException
    {
        try (ObjectInput in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename))))
        {
            return (House) in.readObject();
        }
        catch (IOException e)
        {
            throw new IOException("Wrong stream!");
        }
        catch (ClassNotFoundException e)
        {
            throw new ClassNotFoundException("Wrong found class!");
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException("Wrong class cast!");
        }
    }
}
