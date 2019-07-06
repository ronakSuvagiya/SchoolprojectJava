package com.SchoolManagement.common;

public class setResult {

  public ResponesDto setResponse(int code, String msg) {
    ResponesDto res = new ResponesDto();
    res.setCode(code);
    res.setMessage(msg);
    return res;
  }
}
