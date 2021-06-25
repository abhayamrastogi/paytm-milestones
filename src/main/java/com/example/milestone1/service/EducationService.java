package com.example.milestone1.service;

import com.example.milestone1.model.Education;
import com.example.milestone1.model.Practitioner;
import com.example.milestone1.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EducationService {

    private EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<Education> getAllEducationsForPractitioner(Practitioner practitioner){
        return (List<Education>) practitioner.getEducations();
    }

    public Practitioner createEducationForPractitioner(Practitioner practitioner, Education education) {
        List<Education> educationSet = practitioner.getEducations();
        educationSet.add(education);
        practitioner.setEducations(educationSet);
        return practitioner;
    }

    public Practitioner deleteEducationFromPractitioner(Education education, Practitioner practitioner){
        List<Education> educationSet = practitioner.getEducations();
        educationSet.remove(education);
        practitioner.setEducations(educationSet);
        return  practitioner;
    }

    public void updateEducation(Education education, Practitioner practitioner) {
        List<Education> educationSet = practitioner.getEducations();
    }

    public Optional<Education> selectEducationByEducationID(Long ID) {
        return educationRepository.findById(ID);
    }

}
