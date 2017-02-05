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
public class ToLogException extends Exception {

    /**
     * Creates a new instance of <code>ToLogException</code> without detail
     * message.
     */
    public ToLogException() {
    }

    /**
     * Constructs an instance of <code>ToLogException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ToLogException(String msg) {
        super(msg);
    }
}
