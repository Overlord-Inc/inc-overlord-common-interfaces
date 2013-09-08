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
public class TruePrecondition<T> implements Precondition<T> {

  public boolean fulfilled(T input) {
    return true;
  }

  private static final TruePrecondition SINGLETON = new TruePrecondition();

  public static <T> TruePrecondition<T> singleton() {
    return (TruePrecondition<T>) SINGLETON;
  }
}
