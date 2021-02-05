package com.vaadin.tutorial.crm.backend.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Rick Qin (rickqinj@gmail.com)
 */
@Entity
public class Contact extends AbstractEntity implements Cloneable {

    public enum Status {
        IMPORTEDLEAD, NOTCONTACTED, CONTACTED, CUSTOMER, CLOSEDLOST
    }
    
    @NotNull
    @NotEmpty
    private String firstName = "";
    
    @NotNull
    @NotEmpty
    private String lastName = "";
    
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;
    
    @Email
    @NotNull
    @NotEmpty
    private String email = "";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
