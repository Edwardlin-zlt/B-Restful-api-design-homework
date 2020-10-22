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

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public List<Student> getStudentsByGender(Gender gender) {
        return  studentRepository.getByGender(gender);
    }

    public Student getStudentById(int id) throws StudentNotExistException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotExistException("用户不存在"));
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student updateStudent(int id, Student student) throws StudentNotExistException {
        Student findStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotExistException("用户不存在"));

        findStudent.setName(student.getName());
        findStudent.setGender(student.getGender());
        findStudent.setNote(student.getNote());
        studentRepository.update(findStudent);
        return findStudent;
    }
}