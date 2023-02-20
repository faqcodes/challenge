package com.faqcodes.challengue.adapters.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faqcodes.challengue.models.UserInputModel;
import com.faqcodes.challengue.models.UserOutputModel;
import com.faqcodes.challengue.usecases.UseCase;

@RestController
@RequestMapping("/api")
public class CreateUserController {

  private static final Logger logger = LogManager.getLogger();

  UseCase<UserInputModel, UserOutputModel> createUserUseCase;

  public CreateUserController(UseCase<UserInputModel, UserOutputModel> createUserUseCase) {
    this.createUserUseCase = createUserUseCase;
  }

  @PostMapping("/signup")
  public UserOutputModel signup(@RequestBody UserInputModel userInputModel) {
    logger.info(userInputModel);

    return createUserUseCase.execute(userInputModel);
  }

}
