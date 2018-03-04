package com.sturc.Set;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, bodyType.PLANET);
    }

    @Override
    public boolean addSatellites(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == bodyType.MOON) {
            return super.addSatellites(moon);
        } else
            return false;
    }
}
