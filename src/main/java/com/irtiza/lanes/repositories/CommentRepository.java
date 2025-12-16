package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.Comment;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

@NullMarked
public interface CommentRepository extends JpaRepository<Comment, String> {
}
