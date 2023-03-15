package org.dev.springbootcrud.service;

import java.util.List;

import org.dev.springbootcrud.entities.PaytmBank;

public interface PaytmBankService {

	PaytmBank addPayment(PaytmBank paytmBank);

	List<PaytmBank> getAllPayments();

	PaytmBank getPaymentById(Long id);

	void deletePaymentById(Long idL);

}
