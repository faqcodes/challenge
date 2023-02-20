package com.faqcodes.challengue.adapters.gateways.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "phones")
public class PhoneDataModel {
  @Id
  @Column(name = "number")
  private int number;

  @Column(name = "citycode")
  private int citycode;

  @Column(name = "countrycode")
  private int countrycode;
}
