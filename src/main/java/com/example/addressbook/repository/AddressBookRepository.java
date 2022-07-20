package com.example.addressbook.repository;
import com.example.addressbook.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {
    @Query(value="SELECT * FROM addressbook.address_book_data where city=:city", nativeQuery= true)
    List<AddressBookData> findByCity(String city);

    @Query(value="SELECT * FROM addressbook.address_book_data where state=:state", nativeQuery= true)
    List<AddressBookData> findByState(String state);

    @Query(value="SELECT * FROM addressbook.address_book_data order by city asc;",nativeQuery = true)
    List<AddressBookData> sortByCity();

    @Query(value = "SELECT * FROM addressbook.address_book_data order by state asc;",nativeQuery = true)
    List<AddressBookData> sortByState();
}
