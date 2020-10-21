package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Exceptions.StudentNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository = new StudentRepository();

    public StudentService() {
    }

    public List<Student> getStudents(Gender gender) {
        return gender == null ? studentRepository.getStudents() : studentRepository.getByGender(gender);
    }

    public Student getStudentById(int id) throws StudentNotExistException {
        return studentRepository.findById(id);
    }

    public void deleteStudentById(int id) throws StudentNotExistException {
        studentRepository.deleteById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student updateStudent(int id, Student student) throws StudentNotExistException {
        return studentRepository.updateById(id, student);
    }
}