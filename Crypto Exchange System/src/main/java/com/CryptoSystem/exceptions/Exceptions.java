package com.CryptoSystem.exceptions;

public class Exceptions {
    public  static  class  OptionNotFoundException extends RuntimeException {
        public OptionNotFoundException(String message) {
            super(message);
        }
    }
    public static class OptionNotMatchException extends RuntimeException {
        public OptionNotMatchException(String message) {
            super(message);
        }
    }
    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public static class FondosInsuficientesException extends RuntimeException {
        public FondosInsuficientesException(String message) {
            super(message);
        }
    }

    public static class TransactionNotFoundException extends RuntimeException {
        public TransactionNotFoundException(String message) {
            super(message);
        }
    }
}
