package models;

import java.util.Arrays;

public class Planet {
    private String name;
    private Integer rotation_period;
    private Integer orbital_period;
    private Integer diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private Integer surface_water;
    private long population;
    private String[] residents;
    private String[] films;
    private String created;
    private String edited;
    private String url;


    public Planet() {

    }

    public Planet(String name, Integer rotation_period, Integer orbital_period, Integer diameter, String climate,
                  String gravity, String terrain, String surface_water, long population, String[] residents,
                  String[] films, String created, String edited, String url) {
        this.name = name;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        if (surface_water.equals("unknown")) {
            this.surface_water = 0;
        } else {
            this.surface_water = Integer.parseInt(surface_water);
        }
        this.population = population;
        this.residents = residents;
        this.films = films;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", rotation_period=" + rotation_period +
                ", orbital_period=" + orbital_period +
                ", diameter=" + diameter +
                ", climate='" + climate + '\'' +
                ", gravity='" + gravity + '\'' +
                ", terrain='" + terrain + '\'' +
                ", surface_water=" + surface_water +
                ", population=" + population +
                ", residents=" + Arrays.toString(residents) +
                ", films=" + Arrays.toString(films) +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(Integer rotation_period) {
        this.rotation_period = rotation_period;
    }

    public Integer getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(Integer orbital_period) {
        this.orbital_period = orbital_period;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public Integer getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(String surface_water) {
        if (surface_water.equals("unknown")) {
            this.surface_water = 0;
        } else {
            this.surface_water = Integer.parseInt(surface_water);
        }
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String[] getResidents() {
        return residents;
    }

    public void setResidents(String[] residents) {
        this.residents = residents;
    }

    public String[] getFilms() {
        return films;
    }

    public void setFilms(String[] films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
