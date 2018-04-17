package com.sturc.IO;

import java.io.*;
import java.util.*;

public class LocationsOld implements Map<Integer, LocationOld> {

    private static Map<Integer, LocationOld> Locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for(LocationOld LocationOld : Locations.values()) {
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

                    Locations.put(LocationOld.getLocationID() ,LocationOld);
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
        return Locations.size();
    }

    @Override
    public boolean isEmpty() {
        return Locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return Locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return Locations.containsValue(value);
    }

    @Override
    public LocationOld get(Object key) {
        return Locations.get(key);
    }

    @Override
    public LocationOld put(Integer key, LocationOld value) {
        return Locations.put(key, value);
    }

    @Override
    public LocationOld remove(Object key) {
        return Locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends LocationOld> m) {

    }

    @Override
    public void clear() {
        Locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return Locations.keySet();
    }

    @Override
    public Collection<LocationOld> values() {
        return Locations.values();
    }

    @Override
    public Set<Entry<Integer, LocationOld>> entrySet() {
        return Locations.entrySet();
    }
}
