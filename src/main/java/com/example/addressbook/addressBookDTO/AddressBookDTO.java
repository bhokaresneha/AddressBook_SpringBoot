package com.example.addressbook.addressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {
    @NotEmpty(message = "Contact name Required")
    @Pattern(regexp = "^([A-Z]{1}[a-z]{2,}\\s{0,1})+$", message = "Invalid Contact Name Invalid")
    public String fullName;
    @NotEmpty(message = "Contact No Required")
    @Pattern(regexp = "^([+0-9]{1,3}\\s{0,1}[1-9]{10})$")
    public String phoneNumber;
    public String address;
    public String city;
    public String state;
    public int zipCode;
}
