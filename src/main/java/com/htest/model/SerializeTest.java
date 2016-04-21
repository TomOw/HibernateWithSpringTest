package com.htest.model;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tomasz on 21.04.2016.
 */
public class SerializeTest {

    public static void main(String[] args) throws IOException, SQLException {

        List<String> list = new ArrayList<String>();
        list.add("foo");
        list.add("bar");
        list.add("baz");
        list.add("brąćżźbd");

// write to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        for (String element : list) {
            out.writeUTF(element);
        }
        byte[] bytes = baos.toByteArray();

        System.out.println("bajty: " + Arrays.toString(bytes));
        System.out.println(bytes.length);

// read from byte array
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        DataInputStream in = new DataInputStream(bais);
        while (in.available() > 0) {
            String element = in.readUTF();
            System.out.println(element);
        }
    }
}
