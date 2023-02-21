package com.faqcodes.challengue.adapters.presenters;

import com.faqcodes.challengue.models.UserInputModel;
import com.faqcodes.challengue.models.UserOutputModel;
import com.faqcodes.challengue.models.ResponseMessage;

public class CreateUserPresenter implements Presenter<UserInputModel, UserOutputModel> {

  @Override
  public ResponseMessage<UserOutputModel> successResponse(String message, UserOutputModel outputModel) {
    return new ResponseMessage<>(message, outputModel);
  }

  @Override
  public ResponseMessage<UserOutputModel> errorResponse(String message, UserInputModel inputModel) {
    return new ResponseMessage<>(message, null);
  }
  
}
