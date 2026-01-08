package se.lexicon.dao;

import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImp implements CustomerDao{

    private List<Customer> customers;

    public CustomerDaoImp() {
        this.customers = new ArrayList<>();
    }

    @Override
    public Customer persist(Customer customer) {
        if(customer == null) throw new IllegalArgumentException("Customer was null");
        return customer;
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        if(id == null || id <= 0) throw new IllegalArgumentException("Id was null or less than or equal to zero");
        for(Customer customer : customers){
            if(customer.getId().equals(id)){
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<Customer> findAll() {
        return  customers;
    }

    @Override
    public void remove(Integer id) {

        if(id == null || id <= 0) throw new IllegalArgumentException("Id was null or less than or equal to zero");
        customers.removeIf(customer -> customer.getId().equals(id));
    }
}
