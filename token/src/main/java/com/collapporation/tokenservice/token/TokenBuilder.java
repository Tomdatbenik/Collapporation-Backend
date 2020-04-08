package com.collapporation.tokenservice.token;

public interface TokenBuilder {
    String getNewToken(String uid, String userName, String pfp);
}
