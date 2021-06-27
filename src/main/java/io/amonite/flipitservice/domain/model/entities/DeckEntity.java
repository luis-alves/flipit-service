package io.amonite.flipitservice.domain.model.entities;

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
@Table(name = "decks")
public class DeckEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false, length = 300)
    private String name;

    @Column(name = "subject")
    private String subject;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DeckEntity that = (DeckEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1715576477;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "subject = " + subject + ")";
    }
}
