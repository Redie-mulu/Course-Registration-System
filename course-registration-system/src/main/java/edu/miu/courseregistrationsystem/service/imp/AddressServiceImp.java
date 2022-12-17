package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.AddressDto;
import edu.miu.courseregistrationsystem.entity.Address;
import edu.miu.courseregistrationsystem.repository.AddressRepository;
import edu.miu.courseregistrationsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDto getAddressById(String id) {
//        Address address = addressRepository.findById(id).get();
        return null;
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public void deleteAddress(String id) {

    }

}
