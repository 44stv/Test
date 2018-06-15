package com.sturc.Set;

import java.util.HashSet;
import java.util.Set;


public abstract class HeavenlyBody {

    //private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;


    public HeavenlyBody(String name, double orbitalPeriod, bodyType bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, bodyType);
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public static Key createKey(String name, bodyType bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public final boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody body = (HeavenlyBody) obj;
            return this.key.equals(body.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "name='" + key.name + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                ", bodyType=" + key.bodyType +
                '}';
    }

    public static final class Key {

        private String name;
        private bodyType bodyType;

        private Key(String name, com.sturc.Set.bodyType bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public com.sturc.Set.bodyType getBodyType() {
            return bodyType;
        }


        @Override
        public int hashCode() {

            //System.out.println("hashcode() in Key class is called.");

            final int prime = 31;
            int result = 1;

            result = prime * result + this.name.hashCode();
            result = prime * result + this.bodyType.hashCode();

            return result;
        }

        @Override
        public boolean equals(Object obj) {

            //System.out.println("equal() in Key class is called.");

            if (this == obj)  {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (this.getClass() != obj.getClass()) {
                return false;
            }

            Key key = (Key) obj;

            if (this.name.equals(key.getName()) && this.getBodyType() == (key.getBodyType())) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.getBodyType();
        }
    }
}
