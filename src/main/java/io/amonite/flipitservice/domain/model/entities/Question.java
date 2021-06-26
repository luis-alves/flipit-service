package io.amonite.flipitservice.domain.model.entities;

import io.amonite.flipitservice.domain.enums.DifficultyLevel;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * <Class description>
 *
 * @author Luís Alves
 */
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "question", nullable = false, columnDefinition = "TEXT")
    private String question;

    @Column(name = "difficulty_level", nullable = false)
    private DifficultyLevel difficultyLevel;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Question question = (Question) o;

        return Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return 1344421622;
    }

    @Override
    public String toString() {
        //@formatter:off
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "question = " + question + ", " +
                "difficultyLevel = " + difficultyLevel + ")";
        //@formatter:on
    }
}
