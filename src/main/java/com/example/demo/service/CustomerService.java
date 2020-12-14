package com.example.demo.service;

import com.example.demo.domain.Customer;
import com.example.demo.domain.IndividualCustomer;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.IndividualCustomerRepository;
import com.example.demo.utils.Constants;
import com.example.demo.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashSet;

@Transactional
@Service
@Slf4j
public class CustomerService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IndividualCustomerRepository individualCustomerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @PostConstruct
    protected void initialize() {
        getSuperUser();
    }

    public Customer createCustomer(Customer customer) {
        IndividualCustomer individualCustomer = new IndividualCustomer(customer);
        individualCustomer.setInsurance_company("admin");
        individualCustomer.setInsurance_policy_no("11");
        individualCustomer.setDriver_licence_no("11");
        individualCustomer.setPassword(passwordEncoder.encode(individualCustomer.getPassword()));
        return individualCustomerRepository.save(individualCustomer);

    }

    public Customer getSuperUser() {
        Customer customer = customerRepository.findByEmail(Constants.DEFAULT_ADMIN_EMAIL);

        if (customer == null) {
            customer = createCustomer(new Customer(
                    "admin",
                    "admin",
                    Constants.DEFAULT_ADMIN_EMAIL,
                    (long)1000000,
                    addressRepository.getOne((long)100000),
                    Constants.DEFAULT_ADMIN_PASSWORD,
                    new HashSet<>()
            ));
        }

        return customer;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username);
        if(customer == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        User user = createSpringUser(customer);
        return user;
    }

    public Customer currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            return null;
        }

        String email = ((User) auth.getPrincipal()).getUsername();

        return customerRepository.findByEmail(email);
    }

    public boolean changePassword(Customer customer, String password, String newPassword) {
        if (Utils.isStringEmpty(password) || Utils.isStringEmpty(password)) {
            return false;
        }
        boolean match = passwordEncoder.matches(password, customer.getPassword());
        if (!match) return false;

        customer.setPassword(passwordEncoder.encode(newPassword));
        customerRepository.save(customer);

        log.info("Customer @{} changed password", customer.getEmail());

        return true;
    }

    private User createSpringUser(Customer customer) {
        User user = new User(
                customer.getEmail(),
                customer.getPassword(),
                Collections.singleton(createAuthority(customer)));
        return user;
    }

    private GrantedAuthority createAuthority(Customer customer) {
        return new SimpleGrantedAuthority(Customer.ROLE_ADMIN);
    }
}
