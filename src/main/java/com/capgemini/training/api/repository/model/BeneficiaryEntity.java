package com.capgemini.training.api.repository.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "beneficiary")
public class BeneficiaryEntity extends BaseEntity{

  @Id
  @Column(name = "beneficiary_id", nullable = false)
  private String beneficiaryId;

}
