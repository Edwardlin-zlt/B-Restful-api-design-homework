package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository = new GroupRepository();
    private final StudentRepository studentRepository = new StudentRepository();

    public List<Group> randomlyGroupStudents() {
        // TODO should I use studentRepository in this place? or I should use studentService in groupController and pass students data to this method
        List<Student> students = studentRepository.getStudents();
        List<Group> groups = groupRepository.findAll();
        groups.forEach(group -> group.setStudents(new ArrayList<>()));
        Collections.shuffle(students);
        for (int i = 0; i < students.size(); i++) {
            groups.get(i % groups.size()).getStudents().add(students.get(i));
        }
        groups.forEach(groupRepository::update);
        return groups;
    }
}
