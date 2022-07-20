package com.example.addressbook.services;

import com.example.addressbook.addressBookDTO.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    AddressBookData createAddressBook(AddressBookDTO addressBookDTO);
    void deleteAddressBookRecord(int id);
    AddressBookData updateAddressBookRecord(int id, AddressBookDTO addressBookDTO);
    List<AddressBookData> getAllData();
    Optional<AddressBookData> getContactById(int id);
    List<AddressBookData> getContactByCity(String city);
    List<AddressBookData> getContactByState(String state);
    List<AddressBookData> sortByCity();
    List<AddressBookData> sortByState();
}
