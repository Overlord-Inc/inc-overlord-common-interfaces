/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.overlord.common;

/**
 *
 * @author achelian
 */
public interface Precondition<T> {
  boolean fulfilled(T input);
}
