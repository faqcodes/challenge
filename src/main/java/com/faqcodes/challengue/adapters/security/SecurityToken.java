package com.faqcodes.challengue.adapters.security;

import java.util.Map;

public interface SecurityToken {
  String generateToken(Map<String, Object> claims, String subject);
}
