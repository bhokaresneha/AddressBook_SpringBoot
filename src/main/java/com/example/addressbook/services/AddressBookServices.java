package com.example.addressbook.services;

import com.example.addressbook.addressBookDTO.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookServices {
    @Autowired
    AddressBookRepository addressBookRepository;


    public AddressBookData createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData=new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    public void deleteAddressBookRecord(int id) {
        addressBookRepository.deleteById(id);
    }

    public AddressBookData updateAddressBookRecord(int id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData=addressBookRepository.findById(id).orElse(null);
        if(addressBookDTO!=null)
        {
            addressBookData.setFullName(addressBookDTO.getFullName());
            addressBookData.setPhoneNumber(addressBookDTO.getPhoneNumber());
            addressBookData.setAddress(addressBookDTO.getAddress());
            addressBookData.setCity(addressBookDTO.getCity());
            addressBookData.setState(addressBookDTO.getState());
            addressBookData.setZipCode(addressBookDTO.getZipCode());
            addressBookRepository.save(addressBookData);
             return addressBookData;
        }else
            return null;
    }


    public List<AddressBookData> getAllData() {
         return addressBookRepository.findAll();
    }

    public Optional<AddressBookData> getContactById(int id) {
        return addressBookRepository.findById(id);
    }

    public List<AddressBookData> getContactByCity(String city) {
        return addressBookRepository.findByCity(city);
    }
    public List<AddressBookData> getContactByState(String state) {
        return addressBookRepository.findByState(state);
    }

    public List<AddressBookData> sortByCity(){
        return addressBookRepository.sortByCity();
    }

    public List<AddressBookData> sortByState() {
        return addressBookRepository.sortByState();
    }
}
