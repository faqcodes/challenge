package com.faqcodes.challengue.usecases;

public interface UseCase<T, U> {
  U execute(T inputModel);
}
