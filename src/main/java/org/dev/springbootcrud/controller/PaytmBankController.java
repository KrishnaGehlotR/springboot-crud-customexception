package org.dev.springbootcrud.controller;

import java.util.List;

import org.dev.springbootcrud.customexception.BussinessException;
import org.dev.springbootcrud.customexception.ControllerException;
import org.dev.springbootcrud.entities.PaytmBank;
import org.dev.springbootcrud.service.PaytmBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class PaytmBankController {

	@Autowired
	private PaytmBankService paytmBankService;

	@PostMapping("/payment/add")
	public ResponseEntity<?> addPayment(@RequestBody PaytmBank paytmBank) {
		try {
			PaytmBank addPayment = paytmBankService.addPayment(paytmBank);
			return new ResponseEntity<PaytmBank>(addPayment, HttpStatus.CREATED);
		} catch (BussinessException e) {
			return new ResponseEntity<ControllerException>(
					new ControllerException(e.getErrorCode(), e.getErrorMessages()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<ControllerException>(
					new ControllerException("611", "Something went wrong in controller while adding payment"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/payment/all")
	public ResponseEntity<List<PaytmBank>> getAllPayments() {
		List<PaytmBank> listOfPayments = paytmBankService.getAllPayments();
		return new ResponseEntity<List<PaytmBank>>(listOfPayments, HttpStatus.OK);
	}

	@GetMapping("/payment/{id}")
	public ResponseEntity<?> getPaymentById(@PathVariable("id") Long idL) {
		try {
			PaytmBank paymentRetrieved = paytmBankService.getPaymentById(idL);
			return new ResponseEntity<PaytmBank>(paymentRetrieved, HttpStatus.OK);
		} catch (BussinessException e) {
			return new ResponseEntity<ControllerException>(
					new ControllerException(e.getErrorCode(), e.getErrorMessages()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<ControllerException>(
					new ControllerException("612", "Something went wrong in controller while fetching a payment"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/payment/update")
	public ResponseEntity<?> updatePayment(@RequestBody PaytmBank paytmBank) {
		try {
			PaytmBank addPayment = paytmBankService.addPayment(paytmBank);
			return new ResponseEntity<PaytmBank>(addPayment, HttpStatus.CREATED);
		} catch (BussinessException e) {
			return new ResponseEntity<ControllerException>(
					new ControllerException(e.getErrorCode(), e.getErrorMessages()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<ControllerException>(
					new ControllerException("613", "Something went wrong in controller while adding payment"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/payment/{id}")
	public ResponseEntity<?> deletePaymentById(@PathVariable("id") Long idL) {
		try {
			paytmBankService.deletePaymentById(idL);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} catch (BussinessException e) {
			return new ResponseEntity<ControllerException>(
					new ControllerException(e.getErrorCode(), e.getErrorMessages()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<ControllerException>(
					new ControllerException("614", "Something went wrong in controller while adding payment"),
					HttpStatus.BAD_REQUEST);
		}
	}

}
