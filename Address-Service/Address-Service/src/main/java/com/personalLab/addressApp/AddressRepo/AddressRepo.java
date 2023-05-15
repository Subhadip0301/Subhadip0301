package com.personalLab.addressApp.AddressRepo;

import com.personalLab.addressApp.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<Address,Integer> {
    @Query(nativeQuery = true,value="SELECT ea.id, ea.addressline1, ea.addressline2, ea.state, ea.zip from address ea\n" +
            "join employee e\n" +
            "on e.employeeid =ea.employeeId\n" +
            "where ea.employeeId= :employeeId;")
     Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
