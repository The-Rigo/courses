package com.diplomado.courses.web.rest;

import com.diplomado.courses.domain.entities.Book;
import com.diplomado.courses.domain.entities.Enrollment;
import com.diplomado.courses.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/students/{studentId}/enrollments")
public class StudentEnrollmentController {
    private final EnrollmentService enrollmentService;

    public StudentEnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> listBooks(@PathVariable final Integer studentId){
        return ResponseEntity.ok().body(enrollmentService.getEnrollmentByStudentId(studentId));
    }

    @PostMapping
    public ResponseEntity<Enrollment> creat(@RequestBody final Enrollment enrollment) throws URISyntaxException {
        if(enrollment.getId() != null){
            throw new IllegalArgumentException("I new enrollment cannot already have an id. ");
        }
        enrollment.setCreatedAt(LocalDateTime.now());

        Enrollment enrollmentDB = enrollmentService.save(enrollment);
        return ResponseEntity.created(new URI("/v1/students/"+enrollmentDB.getId()+"/enrollment/"+enrollmentDB.getId()))
                .body(enrollmentDB);
    }
}
