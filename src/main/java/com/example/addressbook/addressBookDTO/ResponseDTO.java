package com.example.addressbook.addressBookDTO;

import com.example.addressbook.model.AddressBookData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
   private String message;
   private Object Data;

}
