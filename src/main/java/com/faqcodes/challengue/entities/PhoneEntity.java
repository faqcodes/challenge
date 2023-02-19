package com.faqcodes.challengue.entities;

public class PhoneEntity implements Phone {

  private final int number;
  private final int cityCode;
  private final int countryCode;

  public PhoneEntity(int number, int cityCode, int countryCode) {
    this.number = number;
    this.cityCode = cityCode;
    this.countryCode = countryCode;
  }

  @Override
  public int getNumber() {
    // TODO Auto-generated method stub
    return number;
  }

  @Override
  public int getCityCode() {
    // TODO Auto-generated method stub
    return cityCode;
  }

  @Override
  public int getCountryCode() {
    // TODO Auto-generated method stub
    return countryCode;
  }

}
