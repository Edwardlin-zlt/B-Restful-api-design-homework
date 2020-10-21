package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Exceptions.StudentNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository {
    private static Integer id = 0;
    private final List<Student> students = new ArrayList<Student>() {
        {
            add(new Student(1, "stu1", Gender.MALE, "haha"));
            add(new Student(2, "stu2", Gender.MALE, "heihei"));
            add(new Student(3, "stu3", Gender.FEMALE, "huohuo"));
        }
    };

    public List<Student> getStudents() {
        return students;
    }

    public Student addStudent(Student student) {
        student.setId(++id);
        students.add(student);
        return student;
    }

    public void deleteById(int id) throws StudentNotExistException {
        students.remove(findById(id));
    }

    public List<Student> getByGender(Gender gender) {
        return students.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Student findById(int id) throws StudentNotExistException {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst()
                .orElseThrow(() -> new StudentNotExistException("用户不存在"));
    }

    public Student updateById(int id, Student student) throws StudentNotExistException {
        Student studentFindById = findById(id);
        students.remove(studentFindById);
        studentFindById.setName(student.getName());
        studentFindById.setGender(student.getGender());
        studentFindById.setNote(student.getNote());
        students.add(studentFindById);
        return studentFindById;
    }

    public List<Student> getShuffledStudents() {
        ArrayList<Student> newStudents = new ArrayList<>(this.students);
        Collections.shuffle(newStudents);
        return newStudents;
    }
}
