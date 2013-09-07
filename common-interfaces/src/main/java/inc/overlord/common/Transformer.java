/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.overlord.common;

/**
 *
 * @author Anand Chelian <achelian@yahoo.com>
 */
public interface Transformer<T0, T1> {
    /**
     * Transform the input into another type.
     * @param input
     * @return The transformed data.
     */
    T1 transform(T0 input);
}
