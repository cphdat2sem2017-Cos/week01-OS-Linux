/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk
 */
public class UserFeedbackException extends Exception {

    /**
     * Creates a new instance of <code>UserFeedbackException</code> without
     * detail message.
     */
    public UserFeedbackException() {
    }

    /**
     * Constructs an instance of <code>UserFeedbackException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UserFeedbackException(String msg) {
        super(msg);
    }
}
