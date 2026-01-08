package se.lexicon.dao;

import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ParkingSpotDaoImp implements ParkingSpotDao{

    List<ParkingSpot> parkingSpots;

    public ParkingSpotDaoImp() {
        this.parkingSpots = new ArrayList<>();
    }

    @Override
    public ParkingSpot persist(ParkingSpot parkingSpot) {
        if(parkingSpot == null) throw new IllegalArgumentException("ParkingSpot was null");

        if(parkingSpots.contains(parkingSpot)) {
            throw new IllegalArgumentException("ParkingSpot already exists");
        }
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    @Override
    public Optional<ParkingSpot> findBySpotNumber(Integer spotNumber) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getId().equals(spotNumber)) {
                return Optional.of(spot);
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<ParkingSpot> findAll() {
        return new ArrayList<>(parkingSpots);
    }

    @Override
    public Collection<ParkingSpot> findByAreaCode(Integer areaCode) {
        if(areaCode == null) throw new IllegalArgumentException("Area code was null");

        List<ParkingSpot> spotsInArea = new ArrayList<>();
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getAreaCode().equals(areaCode)) {
                spotsInArea.add(spot);
            }
        }
        return spotsInArea;
    }

    @Override
    public void remove(Integer spotNumber) {

    }
}
