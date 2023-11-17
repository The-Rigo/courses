package com.diplomado.courses.service.implement;

import com.diplomado.courses.domain.entities.Enrollment;
import com.diplomado.courses.repositories.EnrollmentRepository;
import com.diplomado.courses.service.EnrollmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public List<Enrollment> getEnrollmentByStudentId(Integer studentId) {
        return enrollmentRepository.findAllByStudent_IdOrderById(studentId);
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }
}
