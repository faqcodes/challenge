package com.faqcodes.challengue.usecases;

import java.util.ArrayList;

import com.faqcodes.challengue.entities.CreatePhone;
import com.faqcodes.challengue.entities.CreateUser;
import com.faqcodes.challengue.entities.Phone;
import com.faqcodes.challengue.models.UserInputModel;
import com.faqcodes.challengue.models.UserOutputModel;

public class CreateUserUseCase implements UseCase<UserInputModel, UserOutputModel> {

  private final CreateUser createUser;
  private final CreatePhone createPhone;

  public CreateUserUseCase(CreateUser createUser, CreatePhone createPhone) {
    this.createUser = createUser;
    this.createPhone = createPhone;
  }

  @Override
  public UserOutputModel execute(UserInputModel inputModel) {
    // Get ID
    final var id = "1";

    // Get Token
    final var token = "token";

    // Map phone model to phone entity 
    final var phones = new ArrayList<Phone>();
    inputModel.getPhones().forEach(phone -> {
      phones.add(createPhone.create(phone.getNumber(), phone.getCitycode(), phone.getCountrycode()));
    });

    // Create User Entity
    final var user = createUser.create(id, token, inputModel.getName(), inputModel.getEmail(), inputModel.getPassword(),
        phones);

    return new UserOutputModel(id, user.getCreated(), user.getModified(), user.getLastlogin(), token, user.isActive());
  }

}
