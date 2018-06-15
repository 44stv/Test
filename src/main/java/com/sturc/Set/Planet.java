package com.sturc.Set;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, bodyType.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == bodyType.MOON) {
            return super.addSatellite(moon);
        } else
            return false;
    }
}
