package io.amonite.flipitservice.domain.model.entities;

import io.amonite.flipitservice.domain.enums.DifficultyLevel;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

/**
 * <Class description>
 *
 * @author Luís Alves
 */
@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = DeckEntity.class, fetch = FetchType.LAZY, optional = false)
    private DeckEntity deck;

    @Column(name = "question", nullable = false, columnDefinition = "TEXT")
    private String question;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level", nullable = false)
    private DifficultyLevel difficultyLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeckEntity getDeck() {
        return deck;
    }

    public void setDeck(DeckEntity deck) {
        this.deck = deck;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        QuestionEntity that = (QuestionEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 104819025;
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
