package io.amonite.flipitservice.domain.model.entities;

import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

/**
 * <Class description>
 *
 * @author Luís Alves
 */
@Entity
@Table(name = "scores")
public class ScoreEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = DeckEntity.class, fetch = FetchType.LAZY, optional = false)
    private DeckEntity deckEntity;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY, optional = false)
    private UserEntity userEntity;

    @Column(name = "value")
    private Double value;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "submission_date")
    private Date timestamp;

    public Long getId() {
        return id;
    }

    public DeckEntity getDeckEntity() {
        return deckEntity;
    }

    public void setDeckEntity(DeckEntity deckEntity) {
        this.deckEntity = deckEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ScoreEntity that = (ScoreEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1929780147;
    }

    @Override
    public String toString() {
        //@formatter:off
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "value = " + value + ", " +
                "timestamp = " + timestamp + ")";
        //@formatter:on
    }
}
