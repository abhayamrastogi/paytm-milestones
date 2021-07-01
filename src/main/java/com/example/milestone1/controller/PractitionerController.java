package com.example.milestone1.controller;

import com.example.milestone1.common.BaseController;
import com.example.milestone1.constants.ResponseCode;
import com.example.milestone1.error.UserAlreadyExistException;
import com.example.milestone1.error.UserNotFoundException;
import com.example.milestone1.entity.Education;
import com.example.milestone1.entity.Practitioner;
import com.example.milestone1.service.EducationService;
import com.example.milestone1.service.KafkaProducerService;
import com.example.milestone1.service.PractitionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "api/v1/practitioner")
public class PractitionerController extends BaseController {

    private PractitionerService practitionerService;
    private EducationService educationService;
    private final KafkaProducerService producerService;

    @Autowired
    public PractitionerController(PractitionerService practitionerService, EducationService educationService, KafkaProducerService producerService) {
        this.practitionerService = practitionerService;
        this.educationService = educationService;
        this.producerService = producerService;
    }

    @GetMapping
    public List<Practitioner> getAllPractitioners() {
        return  practitionerService.getAllPractitioners();
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producerService.sendMessage(message);
    }

    @PostMapping
    public  ResponseEntity<Practitioner> addPractitioner(@RequestBody Practitioner practitioner) {

        if(practitionerService.isUserAlreadyExist(practitioner.getEmail_id(),practitioner.getUser_name(),practitioner.getMobile_number())){
            ResponseCode code = ResponseCode.CONFLICT;
            throw new UserAlreadyExistException(code);
        }

        ResponseEntity<Practitioner> response = ResponseEntity.ok(practitioner);
        practitionerService.addPractitioner(practitioner);
        producerService.saveCreatedPractitionerLog(practitioner);
        return response;
    }

    @GetMapping(path = "{id}")
    public Practitioner selectPractitionerByID(@PathVariable("id") Long practitionerID) {

        if(practitionerID.equals("")){
            ResponseCode code = ResponseCode.RESOURCE_NOT_EXIST;
            throw new UserNotFoundException(code);
        }

        return practitionerService.selectPractitionerByID(practitionerID).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public Practitioner deletePractitionerByID(@PathVariable("id") Long practitionerID) {

        Optional<Practitioner> practitioner = practitionerService.selectPractitionerByID(practitionerID);
        if(!practitioner.isPresent()) {
            ResponseCode code = ResponseCode.RESOURCE_NOT_EXIST;
            throw new UserNotFoundException(code);
        }

        practitionerService.deletePractitionerByID(practitionerID);
        return  practitioner.orElse(null);
    }

    @PutMapping("{id}")
    public Practitioner updatePractitioner(@PathVariable("id") Long practitionerID,@RequestBody Practitioner practitioner) {
        if(!(practitionerService.selectPractitionerByID(practitionerID).isPresent())) {
            ResponseCode code = ResponseCode.RESOURCE_NOT_EXIST;
            throw new UserNotFoundException(code);
        }
        practitionerService.updatePractitionerByID(practitionerID, practitioner);
        return practitioner;
    }

    @PostMapping("/{practitioner_id}/education")
    public Practitioner addEducationForPractitionerID(@PathVariable Long practitioner_id, @RequestBody Education education){
        Optional<Practitioner> practitioner = practitionerService.selectPractitionerByID(practitioner_id);

        if(!practitioner.isPresent()) {
            ResponseCode code = ResponseCode.RESOURCE_NOT_EXIST;
            throw new UserNotFoundException(code);
        }

        return educationService.createEducationForPractitioner(practitioner.get(), education);
    }

    @GetMapping("/{practitioner_id}/education")
    public List<Education> getEducationsByPractitionerID(@PathVariable Long practitioner_id){
        Optional<Practitioner> practitioner = practitionerService.selectPractitionerByID(practitioner_id);

        if(!practitioner.isPresent()) {
            ResponseCode code = ResponseCode.RESOURCE_NOT_EXIST;
            throw new UserNotFoundException(code);
        }
        return educationService.getAllEducationsForPractitioner(practitioner.get());
    }
}
