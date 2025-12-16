package com.irtiza.lanes.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "labels")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String color;

    @ManyToOne
    private Project project;

    @ManyToMany(mappedBy = "labels")
    private Set<Issue> issues;

    public void add(Issue issue) {
        if(issues == null) {
            issues = new HashSet<>();
        }
        issues.add(issue);
        issue.getLabels().add(this);
    }
}
