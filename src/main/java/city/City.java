package city;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding (Building building){
        if (building.getArea() + areaOfAllBuildings() <= fullArea){
            buildings.add(building);
        }
        else throw new IllegalArgumentException("City can't be larger than " + fullArea);
    }

    public long areaOfAllBuildings(){
        long area = 0;
        for (Building b: buildings){
            area += b.getArea();
        }
        return area;
    }

    public Building findHighestBuilding(){
        Building highest = buildings.get(0);
        for (Building b: buildings){
            if (b.getLevels() > highest.getLevels()){
                highest = b;
            }
        }
        return highest;
    }

    public List<Building> findBuildingsByStreet(String street){
        List<Building> buildingsInStreet = new ArrayList<>();
        for (Building b: buildings){
            if (b.getAddress().getStreet().equals(street)){
                buildingsInStreet.add(b);
            }
        }
        return buildingsInStreet;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople){
        for (Building b: buildings){
            if (b.calculateNumberOfPeopleCanFit() > numberOfPeople){
                return true;
            }
        }
        return false;
    }
}
