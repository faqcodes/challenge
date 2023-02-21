package com.faqcodes.challengue.adapters.gateways;

import com.faqcodes.challengue.models.UserModel;

public interface SaveUser {
  boolean save(UserModel model) throws Exception;
}
