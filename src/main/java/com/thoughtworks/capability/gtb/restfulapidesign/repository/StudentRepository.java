package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Exceptions.StudentNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentRepository {
    private static Integer id = 0;
    private final static Map<Integer, Student> studentMap = new HashMap<>();
    static {
        for (int i = 0; i < 9; i++) {
            studentMap.put(++id, new Student(id, String.format("student %s", id), Gender.MALE, "haha"));
        }
    }

    public List<Student> getStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public Student addStudent(Student student) {
        student.setId(++id);
        studentMap.put(id, student);
        return student;
    }

    public void deleteById(int id) {
        studentMap.remove(id);
    }

    public List<Student> getByGender(Gender gender) {
        return studentMap.values().stream()
                .filter(student -> student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public Optional<Student> findById(int id) {
        return studentMap.values().stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    public void update(Student student) {
        studentMap.put(student.getId(), student);
    }
}
