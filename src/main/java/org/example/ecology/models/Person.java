package org.example.ecology.models;

public class Person {
    private final int id;
    private final String name;
    private final int waterCountDay;
    private final int waterCountNight;
    private final int gasCount;
    private final int electroCountDay;
    private final int electroCountNight;

    public Person(int id, String name, int waterCountDay, int waterCountNight, int gasCount, int electroCountDay, int electroCountNight) {
        this.id = id;
        this.name = name;
        this.waterCountDay = waterCountDay;
        this.waterCountNight = waterCountNight;
        this.gasCount = gasCount;
        this.electroCountDay = electroCountDay;
        this.electroCountNight = electroCountNight;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", waterCountDay=" + waterCountDay +
                ", waterCountNight=" + waterCountNight +
                ", gasCount=" + gasCount +
                ", electroCountDay=" + electroCountDay +
                ", electroCountNight=" + electroCountNight +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getWaterCountDay() {
        return waterCountDay;
    }

    public int getWaterCountNight() {
        return waterCountNight;
    }

    public int getGasCount() {
        return gasCount;
    }

    public int getElectroCountDay() {
        return electroCountDay;
    }

    public int getElectroCountNight() {
        return electroCountNight;
    }
}
