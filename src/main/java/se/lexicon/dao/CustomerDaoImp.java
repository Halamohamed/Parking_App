package se.lexicon.dao;

import se.lexicon.model.Customer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImp implements CustomerDao{
    @Override
    public Customer persist(Customer customer) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Collection<Customer> findAll() {
        return List.of();
    }

    @Override
    public void remove(Integer id) {

    }
}
