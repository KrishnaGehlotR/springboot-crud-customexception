package org.dev.springbootcrud.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.dev.springbootcrud.customexception.BussinessException;
import org.dev.springbootcrud.entities.PaytmBank;
import org.dev.springbootcrud.repositories.PaytmBankRepositories;
import org.dev.springbootcrud.service.PaytmBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaytmBankServiceImpl implements PaytmBankService {

	@Autowired
	PaytmBankRepositories paytmBankRepositories;

	@Override
	public PaytmBank addPayment(PaytmBank paytmBank) {
		if (paytmBank.getName().isEmpty() || paytmBank.getName().length() == 0) {
			throw new BussinessException("601", "Please send proper name, It cannot be blank");
		}

		try {
			return paytmBankRepositories.save(paytmBank);
		} catch (IllegalArgumentException e) {
			throw new BussinessException("602", "Given is employee is null" + e.getMessage());
		} catch (Exception e) {
			throw new BussinessException("603",
					"Something went wrong in service layer while adding payment" + e.getMessage());
		}
	}

	@Override
	public List<PaytmBank> getAllPayments() {
		List<PaytmBank> paytmBanks = null;

		try {
			paytmBanks = paytmBankRepositories.findAll();
		} catch (Exception e) {
			throw new BussinessException("604",
					"Something went wrong in service layer while fetching all payments" + e.getMessage());
		}

		if (paytmBanks.isEmpty() || paytmBanks == null) {
			throw new BussinessException("605", "We do not have payment to show, add some payment to records");
		}

		return paytmBanks;
	}

	@Override
	public PaytmBank getPaymentById(Long id) {
		try {
			return paytmBankRepositories.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BussinessException("606",
					"Given payment id is null, please send some id to search " + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BussinessException("607", "Given id does not exist in our record " + e.getMessage());
		} catch (Exception e) {
			throw new BussinessException("608",
					"Something went wrong in service layer while fetching a payment " + e.getMessage());
		}
	}

	@Override
	public void deletePaymentById(Long idL) {
		try {
			paytmBankRepositories.deleteById(idL);
		} catch (IllegalArgumentException e) {
			throw new BussinessException("609",
					"Given payment id is null, please send some id to be deleted" + e.getMessage());
		} catch (Exception e) {
			throw new BussinessException("610",
					"Something went wrong in service layer while fetching a payment " + e.getMessage());
		}
	}

}
