/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.overlord.common.interfaces;

/**
 *
 * @author Anand Chelian <achelian@yahoo.com>
 */
public interface Collector<I, C> {
    void collect(I input, C context);
}
