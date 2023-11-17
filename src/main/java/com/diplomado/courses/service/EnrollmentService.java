package com.diplomado.courses.service;

import com.diplomado.courses.domain.entities.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> getEnrollmentByStudentId(Integer studentId);
    Enrollment save(Enrollment enrollment);
}
