package com.faqcodes.challengue.adapters.presenters;

import com.faqcodes.challengue.models.ResponseMessage;

public interface Presenter<T, U> {
  ResponseMessage<U> successResponse(String message, U outputModel);
  ResponseMessage<U> errorResponse(String message, T inputModel);
}
