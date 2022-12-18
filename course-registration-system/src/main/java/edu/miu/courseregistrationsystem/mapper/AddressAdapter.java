package edu.miu.courseregistrationsystem.mapper;

import edu.miu.courseregistrationsystem.dto.AddressDto;
import edu.miu.courseregistrationsystem.entity.Address;

public class AddressAdapter {
    public static Address getAddressFromAddressDto(AddressDto addressDto) {
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setPostalCode(addressDto.getPostalCode());
        address.setPostalCode(addressDto.getStateProvince());
        address.setCountryRegion(addressDto.getCountryRegion());
        return address;
    }
    public static AddressDto getAddressDtoFromAddress(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setStateProvince(address.getStateProvince());
        addressDto.setCountryRegion(address.getCountryRegion());
        return addressDto;
    }
}
