package com.mattoffe.Eccomerce.controllers;

import com.mattoffe.Eccomerce.dtos.DetailsDTO;
import com.mattoffe.Eccomerce.dtos.PurchaseDTO;
import com.mattoffe.Eccomerce.model.Details;
import com.mattoffe.Eccomerce.model.Person;
import com.mattoffe.Eccomerce.model.Product;
import com.mattoffe.Eccomerce.model.PurchaseOrder;
import com.mattoffe.Eccomerce.model.enums.PaymentMethod;
import com.mattoffe.Eccomerce.repositories.DetailRepository;
import com.mattoffe.Eccomerce.repositories.PersonRepository;
import com.mattoffe.Eccomerce.repositories.ProductRepository;
import com.mattoffe.Eccomerce.repositories.PurchaseRepository;
import com.mattoffe.Eccomerce.utils.TicketGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DetailRepository detailsRepository;
    @GetMapping("/byClient")
    public List<PurchaseDTO> findByPerson(Authentication authentication) {
        Person person =  personRepository.findByEmail(authentication.getName());
        return purchaseRepository.findByPerson(person).stream().map(PurchaseDTO::new).collect(toList());
    }
    @Transactional
    @PostMapping("/newPurchase")
    public ResponseEntity<Object> newPurchase(@RequestBody DetailsDTO details, Authentication authentication) {
        Person person =  personRepository.findByEmail(authentication.getName());
        if (person == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        double total=0;
        PurchaseOrder purchase = new PurchaseOrder();
        Details newDetails = new Details();
        for (long idProduct: details.getIdProduct()) {
            Product product = productRepository.findById(idProduct).orElse(null);
            if (product == null) {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }
            newDetails.setQuatity(details.getQuatity());
            newDetails.setPrice(details.getPrice());
            newDetails.setProduct(product);
            newDetails.setPurchaseOrder(purchase);
            product.setStock(product.getStock() - details.getQuatity());
            productRepository.save(product);
            detailsRepository.save(newDetails);
            total+=product.getPrice()*details.getQuatity();
        }
        String ticket;
        do {
            ticket = TicketGenerator.getRandomTicket();
        }while (purchaseRepository.existsByTicket(ticket));
        purchase.setPerson(person);
        purchase.setTotal(total);
        purchase.setDate(LocalDateTime.now());
        purchase.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        purchase.setTicket(ticket);
        purchaseRepository.save(purchase);
        purchase.addDetails(newDetails);
        return new ResponseEntity<>("Purchase created", HttpStatus.OK);
    }
}
