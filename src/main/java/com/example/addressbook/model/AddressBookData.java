package com.example.addressbook.model;

import com.example.addressbook.addressBookDTO.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddressBookData {
    @Id
    @GeneratedValue
    int id;
    String fullName;
    String phoneNumber;
    String address;
    String city;
    String state;
    int zipCode;


    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.fullName=addressBookDTO.fullName;
        this.phoneNumber=addressBookDTO.phoneNumber;
        this.address =addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipCode = addressBookDTO.zipCode;

    }
}
