package se.lexicon.dao;

import se.lexicon.model.Reservation;

import java.util.Collection;
import java.util.Optional;

public interface ReservationDao {
    Reservation persist(Reservation reservation);
    Optional<Reservation> findById(String id);
    Collection<Reservation> findAll();
    void remove(String id);
}
