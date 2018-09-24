package com.jc.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HelloDto {
    private long timestamp;
    private String greetings;
    private String injectedHeaders;
//
//    public HelloDto() {
//    }
//
//    public long getTimestamp() {
//        return this.timestamp;
//    }
//
//    public String getGreetings() {
//        return this.greetings;
//    }
//
//    public void setTimestamp(final long timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public void setGreetings(final String greetings) {
//        this.greetings = greetings;
//    }
//
//    public String getInjectedHeaders() {
//        return injectedHeaders;
//    }
//
//    public void setInjectedHeaders(final String injectedHeaders) {
//        this.injectedHeaders = injectedHeaders;
//    }
}
