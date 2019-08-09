package com.timbuchalka;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.timbuchalka.HeavenlyBody.BodyTypes.PLANET;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 22584);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 1);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon1", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSetelites(tempMoon);

        tempMoon = new Moon("Moon1", 20);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSetelites(tempMoon);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Moon3", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSetelites(tempMoon);

        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getKey());
        }

        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Earth", PLANET));
        System.out.println("Moons of " + body.getKey());
        for (HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getKey());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getKey());
        }

        for (HeavenlyBody planet : planets) {
            System.out.println(planet);
        }


//        HeavenlyBody tempMoon1 = new HeavenlyBody("Moon", 22, "moon");
//        HeavenlyBody tempMoon2 = new HeavenlyBody("Moon", 22, "moon");
//
//        HeavenlyBody temp1 = new HeavenlyBody("Mercury", 88, "planet");
//        HeavenlyBody temp2 = new HeavenlyBody("Mercury", 88, "planet");
//
//        temp1.addMoon(tempMoon1);
//        temp2.addMoon(tempMoon2);
//
//        System.out.println(temp1.equals(temp2));


    }
}
