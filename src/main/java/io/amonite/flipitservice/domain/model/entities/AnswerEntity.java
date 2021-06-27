package io.amonite.flipitservice.domain.model.entities;

import io.amonite.flipitservice.domain.enums.AnswerType;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "answers")
public class AnswerEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false, targetEntity = QuestionEntity.class, fetch = FetchType.LAZY)
    private QuestionEntity questionEntity;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "is_correct", nullable = false)
    private Boolean isCorrect;

    @Column(name = "type", nullable = false)
    private AnswerType answerType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AnswerEntity that = (AnswerEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 748908716;
    }

    @Override
    public String toString() {
        //@formatter:off
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "answer = " + answer + ", " +
                "isCorrect = " + isCorrect + ", " +
                "answerType = " + answerType + ")";
        //@formatter:on
    }
}
