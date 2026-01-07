package se.lexicon.model;

public class ParkingSpot {

    private Integer id;
    private Integer areaCode;
    private boolean occupied;

    public ParkingSpot(Integer id, Integer areaCode) {
        this.id = id;
        this.areaCode = areaCode;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public boolean isOccupied() {
        return occupied;
    }


    /**
     * Marks the parking spot as occupied
     */
    public void occupy() {
        this.occupied = true;
    }

    /**
     * Marks the parking spot as available
     */
    public void vacate() {
        this.occupied = false;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", areaCode=" + areaCode +
                ", occupied=" + occupied +
                '}';
    }
}
