package com.example.milestone1.service;

import com.example.milestone1.entity.Practitioner;
import com.example.milestone1.repository.PractitionerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PractitionerService {

    private PractitionerRepository repository;

    public PractitionerService(PractitionerRepository repository) {
        this.repository = repository;
    }

    public List<Practitioner> getAllPractitioners() {
       return repository.findAll();
    }

    public  void addPractitioner(Practitioner practitioner) {
        repository.save(practitioner);
    }

    public void  deletePractitionerByID(Long ID) {
        repository.deleteById(ID);
    }

    public Optional<Practitioner> selectPractitionerByID(Long ID) {
    return  repository.findById(ID);
    }

    public void  updatePractitionerByID(Long ID, Practitioner practitioner) {
        practitioner.setID(ID);
        repository.save(practitioner);
    }

    /**
     * Returns boolean value if user is already present in db
     *
     * @param emailID - EmailID of the user
     * @param username - Username of the user
     * @param mobileNo - Mobile number of the user
     * @return - Boolean value
     */
    public boolean isUserAlreadyExist(String emailID, String username, String mobileNo) {
        boolean userInDb = true;

        //Adding this additional condition to test custom query in repository layer.
        if((repository.findByEmailIDAndMobileNumber(emailID,mobileNo) == null) &&
                (repository.findByEmailIDAndUsername(emailID, username) == null)){
            userInDb = false;
        }

        return  userInDb;
    }
}
