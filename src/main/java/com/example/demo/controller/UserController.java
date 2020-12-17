package com.example.demo.controller;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;
import com.example.demo.domain.dto.UserDto;
import com.example.demo.error.UserAlreadyExistException;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.utils.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping("/user/registration")
    public GenericResponse registerUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {
        if (emailExists(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + accountDto.getEmail());
        }

        final Customer customer = new Customer();
        final Address address = new Address();

        //set USA as default country
        address.setCountry("USA");
        address.setState(accountDto.getState());
        address.setCity(accountDto.getCity());
        address.setStreet(accountDto.getStreet());
        address.setZipcode(accountDto.getZipcode());

        final Address savedAddress = addressRepository.save(address);

        customer.setEmail(accountDto.getEmail());
        customer.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        customer.setPhone_no(Long.valueOf(accountDto.getPhoneNo()));
        customer.setFirst_name(accountDto.getFirstName());
        customer.setLast_name(accountDto.getLastName());
        customer.setAddress(savedAddress);

        final Customer registed = customerRepository.save(customer);
        if (registed != null) {
//            Authentication authentication = new UsernamePasswordAuthenticationToken(registed, null, Customer.ROLE_USER);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registed, request.getLocale(), getAppUrl(request)));
        }
        log.debug("Registering user account with information: {}", accountDto);
        return new GenericResponse("success");
    }

    private boolean emailExists(final String email) {
        return customerRepository.findByEmail(email) != null;
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}
