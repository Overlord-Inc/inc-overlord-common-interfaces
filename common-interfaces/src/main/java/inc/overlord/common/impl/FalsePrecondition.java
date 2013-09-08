/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.overlord.common.impl;

import inc.overlord.common.Precondition;

/**
 *
 * @author achelian
 */
public class FalsePrecondition<T> implements Precondition<T> {

  public boolean fulfilled(T input) {
    return false;
  }

  private static final FalsePrecondition SINGLETON = new FalsePrecondition();

  public static <T> FalsePrecondition<T> singleton() {
    return (FalsePrecondition<T>) SINGLETON;
  }
}
