package org.dev.springbootcrud.repositories;

import org.dev.springbootcrud.entities.PaytmBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaytmBankRepositories extends JpaRepository<PaytmBank, Long> {

}
