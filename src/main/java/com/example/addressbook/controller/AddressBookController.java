package com.example.addressbook.controller;
import com.example.addressbook.addressBookDTO.AddressBookDTO;
import com.example.addressbook.addressBookDTO.ResponseDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.services.AddressBookServices;
import com.example.addressbook.services.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AddressBookController {

    @Autowired
    IAddressBookService iAddressBookService;
    @GetMapping("get")
    public String gettingAllData(){
        return "HEllo";
    }

    @GetMapping("/getAllData")
        public ResponseEntity<ResponseDTO> getAllData()
    {
       List<AddressBookData>addressBookData= iAddressBookService.getAllData();
        ResponseDTO responseDTO=new ResponseDTO("Getting all the Data of AddressBook",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int id) {
        Optional<AddressBookData> addressBookDataData= iAddressBookService.getContactById(id);
        ResponseDTO respDTO= new ResponseDTO("Get Call For ID Successful", addressBookDataData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
    @GetMapping("/getByCity/{city}")
    public ResponseEntity<ResponseDTO> getContactByCity(@PathVariable String city)
    {
        List<AddressBookData> addressBookData=iAddressBookService.getContactByCity(city);
        ResponseDTO responseDTO=new ResponseDTO("Get call For City Successful",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/getByState/{state}")
    public ResponseEntity<ResponseDTO> getContactByState(@PathVariable String state)
    {
        List<AddressBookData> addressBookData=iAddressBookService.getContactByState(state);
        ResponseDTO responseDTO=new ResponseDTO("Get call For State Successful",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> sortContactByCity()
    {
        List<AddressBookData> addressBookData=iAddressBookService.sortByCity();
        ResponseDTO responseDTO=new ResponseDTO("Get call For Sort By City Successful",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDTO> sortContactByState()
    {
        List<AddressBookData> addressBookData=iAddressBookService.sortByState();
        ResponseDTO responseDTO=new ResponseDTO("Get call For Sort By State Successful",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData=iAddressBookService.createAddressBook(addressBookDTO);
        ResponseDTO responseDTO=new ResponseDTO("Contact Added Successfully",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBookRecord(@PathVariable int id,@RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData=iAddressBookService.updateAddressBookRecord(id,addressBookDTO);
        ResponseDTO responseDTO=new ResponseDTO("Record Updated Successfully",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deletingAddressBookRecord(@PathVariable int id){
        iAddressBookService.deleteAddressBookRecord(id);
        ResponseDTO responseDTO=new ResponseDTO("Record Deleted Successfully ","Contact ID ="+id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

}
