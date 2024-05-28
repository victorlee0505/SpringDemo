package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.ValueChange;

import com.example.demo.model.PersonProfile;

public class PersonProfileComparator {

    public static List<String> updatePersonProfile(PersonProfile existingProfile, PersonProfile updatedProfile) {

        Javers javers = JaversBuilder.javers().build();
        Diff diff = javers.compare(existingProfile, updatedProfile);

        List<ValueChange> valueChanges = diff.getChangesByType(ValueChange.class);

        List<String> changedProperties = new ArrayList<>();
        valueChanges.forEach(change -> {
            changedProperties.add(change.getPropertyName() + " from " + change.getLeft() + " -> " + change.getRight());
        });
        return changedProperties;
    }
}

