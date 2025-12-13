package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.Label;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

@NullMarked
public interface LabelRepository extends JpaRepository<Label, String> {
}
