package io.amonite.flipitservice.domain.model.entities;

import io.amonite.flipitservice.domain.enums.TargetType;
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
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = UserEntity.class, optional = false, fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @Column(name = "target_id", nullable = false)
    private Long targetId;

    @Enumerated(EnumType.STRING)
    @Column(name = "target_type", nullable = false, length = 16)
    private TargetType targetType;

    @Column(name = "value", nullable = false, length = 1000)
    private String value;

    public Long getId() {
        return id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CommentEntity commentEntity = (CommentEntity) o;

        return Objects.equals(id, commentEntity.id);
    }

    @Override
    public int hashCode() {
        return 860659860;
    }

    @Override
    public String toString() {
        //@formatter:off
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "targetId = " + targetId + ", " +
                "targetType = " + targetType + ", " +
                "value = " + value + ")";
        //@formatter:on
    }
}
