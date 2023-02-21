package com.faqcodes.challengue.usecases;

import java.util.ArrayList;
import java.util.UUID;

import com.faqcodes.challengue.adapters.gateways.SaveUser;
import com.faqcodes.challengue.adapters.presenters.Presenter;
import com.faqcodes.challengue.entities.CreatePhone;
import com.faqcodes.challengue.entities.CreateUser;
import com.faqcodes.challengue.entities.Phone;
import com.faqcodes.challengue.models.PhoneModel;
import com.faqcodes.challengue.models.ResponseMessage;
import com.faqcodes.challengue.models.UserInputModel;
import com.faqcodes.challengue.models.UserModel;
import com.faqcodes.challengue.models.UserOutputModel;

public class CreateUserUseCase implements UseCase<UserInputModel, UserOutputModel> {

  private final CreateUser createUser;
  private final CreatePhone createPhone;
  private final SaveUser repository;
  private final Presenter<UserInputModel, UserOutputModel> presenter;

  public CreateUserUseCase(
      CreateUser createUser,
      CreatePhone createPhone,
      SaveUser repository,
      Presenter<UserInputModel, UserOutputModel> presenter) {
    this.createUser = createUser;
    this.createPhone = createPhone;
    this.repository = repository;
    this.presenter = presenter;
  }

  @Override
  public ResponseMessage<UserOutputModel> execute(UserInputModel inputModel) {
    // Get ID
    final var id = UUID.randomUUID().toString();

    // Get Token
    //
    final var token = "token";

    // Create Phone Entity: map phone model to phone entity
    final var phones = new ArrayList<Phone>();
    inputModel.getPhones().forEach(
        phone -> phones.add(
            createPhone.create(
                phone.getNumber(),
                phone.getCitycode(),
                phone.getCountrycode())));

    // Create User Entity
    final var user = createUser.create(
        id,
        token,
        inputModel.getName(),
        inputModel.getEmail(),
        inputModel.getPassword(),
        phones);

    // -----------------------------------------------
    // Validate User Entity Business Rules
    // -----------------------------------------------

    // -----------------------------------------------
    // Validate User Application Rules
    // -----------------------------------------------

    // Create Phone Data: map phone model to phone data
    final var phoneModel = new ArrayList<PhoneModel>();
    inputModel.getPhones().forEach(
        phone -> phoneModel.add(
            new PhoneModel(
                phone.getNumber(),
                phone.getCitycode(),
                phone.getCountrycode())));

    // Create User Data
    final var userData = new UserModel(
        id,
        user.getCreated(),
        user.getModified(),
        user.getLastlogin(),
        token,
        user.getName(),
        user.getEmail(),
        phoneModel,
        user.getPassword(),
        user.isActive());

    try {
      // Save User
      repository.save(userData);
    } catch (Exception e) {
      // Return error information
      return presenter.errorResponse(e.getMessage(), null);
    }

    // Create output Data
    final var outputModel = new UserOutputModel(
        id,
        user.getCreated(),
        user.getModified(),
        user.getLastlogin(),
        token,
        user.isActive());

    // Return success information
    return presenter.successResponse("El usuario se ha creado satisfactoriamente", outputModel);
  }

}
