package se.lexicon.dao;

import se.lexicon.model.ParkingSpot;

import java.util.Collection;
import java.util.Optional;

public interface ParkingSpotDao {
    ParkingSpot persist(ParkingSpot parkingSpot);
    Optional<ParkingSpot> findBySpotNumber(Integer spotNumber);
    Collection<ParkingSpot> findAll();
    Collection<ParkingSpot> findByAreaCode(Integer areaCode);
    void remove(Integer spotNumber);
}
