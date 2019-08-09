package com.timbuchalka;



import java.util.HashSet;
import java.util.Set;


public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {

        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }


    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSetelites(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }


    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public static Key makeKey(String name, BodyTypes bodyTypes) {
        return new Key(name, bodyTypes);
    }

    public Key getKey() {
        return key;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
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
                "key=" + key +
                ", orbitalPeriod=" + orbitalPeriod +
                ", satellites=" + satellites +
                '}';
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyTypes;

        private Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyTypes = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.bodyTypes == key.getBodyTypes());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": "+ this.bodyTypes;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyTypes.hashCode() + 57;
        }

    }
}


