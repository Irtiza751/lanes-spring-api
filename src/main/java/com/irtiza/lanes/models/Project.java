package com.irtiza.lanes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "projects")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String key;
    private String description;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "project")
    private List<ProjectMember> projectMembers;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sprint> sprints;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Status> statuses;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Label> labels;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void add(ProjectMember projectMember) {
        if(projectMembers == null) {
            projectMembers = new ArrayList<>();
        }
        projectMembers.add(projectMember);
        projectMember.setProject(this);
    }

    public void add(Sprint sprint) {
        if(sprints == null) {
            sprints = new ArrayList<>();
        }
        sprints.add(sprint);
        sprint.setProject(this);
    }

    public void add(Status status) {
        if(statuses == null) {
            statuses = new ArrayList<>();
        }
        statuses.add(status);
        status.setProject(this);
    }

    public void add(Label label) {
        if(labels == null) {
            labels = new ArrayList<>();
        }
        labels.add(label);
        label.setProject(this);
    }
}
