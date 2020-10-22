package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository {
    private static Integer groupId = 0;
    private static final Map<Integer, Group> GROUP_MAP = new HashMap<>();

    static {
        for (int i = 0; i < 6; i++) {
            GROUP_MAP.put(++groupId, new Group(groupId, String.format("Team %s", groupId), new ArrayList<>(), ""));
        }
    }

    public List<Group> findAll() {
        return new ArrayList<>(GROUP_MAP.values());
    }

    public void update(Group group) {
        GROUP_MAP.put(group.getId(), group);
    }
}
