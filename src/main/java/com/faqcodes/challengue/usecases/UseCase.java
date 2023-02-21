package com.faqcodes.challengue.usecases;

import com.faqcodes.challengue.models.ResponseMessage;

public interface UseCase<T, U> {
  ResponseMessage<U> execute(T inputModel);
}
