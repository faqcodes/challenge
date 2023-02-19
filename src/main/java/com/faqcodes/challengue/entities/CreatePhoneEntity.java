package com.faqcodes.challengue.entities;

public class CreatePhoneEntity implements CreatePhone {

  @Override
  public Phone create(int number, int cityCode, int countryCode) {
    return new PhoneEntity(number, cityCode, countryCode);
  }

}
