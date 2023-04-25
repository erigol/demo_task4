package com.capgemini.training.api.repository.model;

import static java.time.ZoneOffset.UTC;

import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntity implements Serializable {

  protected static final long serialVersionUID = 7418251777718397333L;

  @Getter
  @Setter
  private ZonedDateTime creationDate;

  @Getter private ZonedDateTime updatedDate;


  @PrePersist
  protected void prePersist() {

    if (creationDate == null) {
      creationDate = ZonedDateTime.now(UTC);
    }

    if (updatedDate == null) {
      updatedDate = ZonedDateTime.now(UTC);
    }
  }

  @PreUpdate
  protected void preUpdate() {
    updatedDate = ZonedDateTime.now(UTC);
  }


}
