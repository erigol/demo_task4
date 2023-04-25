package com.capgemini.training.api.repository.model;

import com.capgemini.training.api.model.DocumentType;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

  @Id
  @Column(name = "customer_id", nullable = false)
  private String customerId;

  @Column(name = "document_type", nullable = false)
  private DocumentType documentType;

  @Column(name = "document_number", nullable = false)
  private String documentNumber;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "surname", nullable = false)
  private String surname;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "country", nullable = false)
  private String country;

  @Column(name = "telephone")
  private Integer telephone;


  @OneToMany(mappedBy = "customer",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  private Set<PaymentEntity> payments;

}
