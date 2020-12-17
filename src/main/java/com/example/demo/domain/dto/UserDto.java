package com.example.demo.domain.dto;

import com.example.demo.validation.PasswordMatches;
import com.example.demo.validation.ValidEmail;
import com.example.demo.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
@Getter
@Setter
public class UserDto {
    @NotNull
    @Size(min = 1, message = "{Size.userDto.firstName}")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "{Size.userDto.lastName}")
    private String lastName;

    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

    @NotNull
    private String phoneNo;

    @NotNull
    private String customerType;

    /*
        Individual Customers
     */
    private String driverLicence_no;

    private String insuranceCompany;

    private String insurancePolicyNo;

    /*
        Corporation Customers
     */
    private String employeeId;

    private String corporationName;

    private boolean isUsing2FA;

    private Integer role;

    /*
        Address
     */
    private String state;

    private String city;

    private String street;

    private String zipcode;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("UserDto [firstName=")
                .append(firstName)
                .append(", lastName=")
                .append(lastName)
                .append(", email=")
                .append(email)
                .append(", isUsing2FA=")
                .append(isUsing2FA)
                .append(", role=")
                .append(role).append("]");
        return builder.toString();
    }
}