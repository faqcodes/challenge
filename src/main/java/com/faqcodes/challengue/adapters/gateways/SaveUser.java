package com.faqcodes.challengue.adapters.gateways;

import com.faqcodes.challengue.adapters.gateways.db.UserDataModel;

public interface SaveUser {
  boolean save(UserDataModel data);
}
