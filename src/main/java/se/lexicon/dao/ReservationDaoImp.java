package se.lexicon.dao;

import se.lexicon.model.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ReservationDaoImp implements ReservationDao{

    List<Reservation> reservations;

    public ReservationDaoImp() {
        this.reservations = new ArrayList<>();
    }
    @Override
    public Reservation persist(Reservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Reservation was null");
        for(Reservation r : reservations){
            if(r.getReservationId().equals(reservation.getReservationId())){
                throw new IllegalArgumentException("Reservation with id " + reservation.getReservationId() + " already exists");
            }
        }
        reservations.add(reservation);
        return reservation;
    }

    @Override
    public Optional<Reservation> findById(String id) {
        if(id == null || id.isEmpty()) throw new IllegalArgumentException("Id was null or empty");
        for(Reservation reservation : reservations){
            if(reservation.getReservationId().equals(id)){
                return Optional.of(reservation);
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<Reservation> findAll() {
        return new ArrayList<>(reservations);
    }

    @Override
    public void remove(String id) {
        if(id == null || id.isEmpty()) throw new IllegalArgumentException("Id was null or empty");
        reservations.removeIf(reservation -> reservation.getReservationId().equals(id));

    }
}
