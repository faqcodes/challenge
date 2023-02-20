package com.faqcodes.challengue.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.faqcodes.challengue.adapters.gateways.SaveUser;
import com.faqcodes.challengue.adapters.gateways.SaveUserGateway;
import com.faqcodes.challengue.adapters.gateways.db.UserRepository;
import com.faqcodes.challengue.entities.CreatePhone;
import com.faqcodes.challengue.entities.CreatePhoneEntity;
import com.faqcodes.challengue.entities.CreateUser;
import com.faqcodes.challengue.entities.CreateUserEntity;
import com.faqcodes.challengue.models.UserInputModel;
import com.faqcodes.challengue.models.UserOutputModel;
import com.faqcodes.challengue.usecases.CreateUserUseCase;
import com.faqcodes.challengue.usecases.UseCase;

@Configuration
public class CreateUserConfiguration {

  @Bean
  CreateUser createUser() {
    return new CreateUserEntity();
  }

  @Bean
  CreatePhone createPhone() {
    return new CreatePhoneEntity(); 
  }

  @Bean
  SaveUser saveUser(UserRepository repository) {
    return new SaveUserGateway(repository);
  }

  @Bean
  UseCase<UserInputModel, UserOutputModel> createUserUseCase(
      CreateUser createUser,
      CreatePhone createPhone,
      SaveUser saveUser) {
    return new CreateUserUseCase(createUser, createPhone, saveUser);
  }

}
