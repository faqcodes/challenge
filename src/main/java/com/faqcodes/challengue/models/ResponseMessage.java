package com.faqcodes.challengue.models;

public class ResponseMessage<T> {
  private final String message;
  private final T data;

  public String getMessage() {
    return message;
  }

  public T getData() {
    return data;
  }

  public ResponseMessage(String message, T data) {
    this.message = message;
    this.data = data;
  }
}
