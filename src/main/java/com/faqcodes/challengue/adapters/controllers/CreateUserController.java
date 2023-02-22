package com.faqcodes.challengue.adapters.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faqcodes.challengue.models.ResponseMessage;
import com.faqcodes.challengue.models.UserInputModel;
import com.faqcodes.challengue.models.UserOutputModel;
import com.faqcodes.challengue.usecases.UseCase;

@Controller
@RequestMapping("/api")
public class CreateUserController {

  private static final Logger logger = LogManager.getLogger();

  @Value("${validation.passwordRegex}")
  String passwordRegex;

  UseCase<UserInputModel, UserOutputModel> createUserUseCase;

  public CreateUserController(UseCase<UserInputModel, UserOutputModel> createUserUseCase) {
    this.createUserUseCase = createUserUseCase;
  }

  @PostMapping("/signup")
  public ResponseMessage<UserOutputModel> signup(@RequestBody UserInputModel userInputModel) {
    logger.info(userInputModel);

    // Se asigna validación de password Regex
    userInputModel.setPasswordRegex(passwordRegex);

    return createUserUseCase.execute(userInputModel);
  }

}
