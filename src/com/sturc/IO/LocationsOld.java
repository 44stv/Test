package com.sturc.IO;

import java.io.*;
import java.util.*;

public class LocationsOld implements Map<Integer, LocationOld> {

    private static Map<Integer, LocationOld> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for(LocationOld LocationOld : locations.values()) {
                locFile.writeObject(LocationOld);
            }
        }
    }

    static {

        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;

            while (!eof) {
                try {
                    LocationOld LocationOld = (LocationOld) locFile.readObject();
                    System.out.println("Read Location " + LocationOld.getLocationID() + ": " + LocationOld.getDescription());
                    System.out.println("Found " + LocationOld.getExits().size() + " exits.");

                    locations.put(LocationOld.getLocationID() ,LocationOld);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (InvalidClassException e) {
            System.out.println("InvalidClassException: " + e.getMessage());
        } catch (IOException io) {
            io.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        }


    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public LocationOld get(Object key) {
        return locations.get(key);
    }

    @Override
    public LocationOld put(Integer key, LocationOld value) {
        return locations.put(key, value);
    }

    @Override
    public LocationOld remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends LocationOld> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<LocationOld> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, LocationOld>> entrySet() {
        return locations.entrySet();
    }
}
