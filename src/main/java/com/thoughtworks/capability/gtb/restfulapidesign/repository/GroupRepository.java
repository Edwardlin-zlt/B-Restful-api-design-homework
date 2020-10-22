package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    private static Integer groupId = 0;
    private static final List<Group> groups = new ArrayList<>();

    static {
        for (int i = 0; i < 6; i++) {
            groups.add(new Group(++groupId, String.format("Team %s", groupId), new ArrayList<>(), ""));
        }
    }

    public List<Group> findAll() {
        return new ArrayList<>(groups);
    }
}
