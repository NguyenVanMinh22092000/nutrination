package com.galaxy.repository;

import com.galaxy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
//    @Query(nativeQuery =false, value = "update Customer c set c.isStatus = 0 where c.id = :id")
//    void deleteCustomerById(@Param("id") Long id);
}
