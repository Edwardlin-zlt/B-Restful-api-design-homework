package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository = new GroupRepository();
    private final StudentRepository studentRepository = new StudentRepository();

    public List<Group> randomlyGroupStudents() {
        List<Student> students = studentRepository.getStudents();
        List<Group> groups = groupRepository.findAll();
        Collections.shuffle(students);
        for (int i = 0; i < students.size(); i++) {
            groups.get(i % groups.size()).getStudents().add(students.get(i));
        }
        groups.forEach(groupRepository::update);
        return groups;
    }
}
