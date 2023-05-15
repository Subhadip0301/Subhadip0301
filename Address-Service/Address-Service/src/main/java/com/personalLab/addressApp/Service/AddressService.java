package com.personalLab.addressApp.Service;

import com.personalLab.addressApp.AddressRepo.AddressRepo;
import com.personalLab.addressApp.AddressResponse.AddressResponse;
import com.personalLab.addressApp.Entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private ModelMapper modelmaper;
    @Autowired
    AddressRepo addressRepo;

    public AddressResponse findAddressByEmployeeId(int employeeId) {
        Address address = addressRepo.findAddressByEmployeeId(employeeId);
        AddressResponse addressResponse = modelmaper.map(address, AddressResponse.class);
        return addressResponse;
    }
}
