package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.AddressDto;
import edu.miu.courseregistrationsystem.entity.Address;
import edu.miu.courseregistrationsystem.repository.AddressRepository;
import edu.miu.courseregistrationsystem.service.AddressAdapter;
import edu.miu.courseregistrationsystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDto getAddressById(long id) {
        Address address = addressRepository.findById(id).get();
        AddressDto addressDto = AddressAdapter.getAddressDtoFromAddress(address);
        return addressDto;
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = AddressAdapter.getAddressFromAddressDto(addressDto);
        addressRepository.save(address);
        return addressDto;
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto) {
        Address address = AddressAdapter.getAddressFromAddressDto(addressDto);
        addressRepository.save(address);
        return addressDto;
    }

    @Override
    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }

}
