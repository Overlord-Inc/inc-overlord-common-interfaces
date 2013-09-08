/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.overlord.common.impl;

import inc.overlord.common.Precondition;
import java.util.List;

/**
 *
 * @author achelian
 */
public class OrPrecondition<T> implements Precondition<T> {
  List<Precondition<T>> preconditions;

  public OrPrecondition() { }
  public OrPrecondition(List<Precondition<T>> preconditions) {
    this.preconditions = preconditions;
  }

  public boolean fulfilled(T input) {
    for (Precondition precondition: preconditions) {
      if (precondition.fulfilled(input)) {
        return true;
      }
    }
    return false;
  }

  public void setPreconditions(List<Precondition<T>> value) {
    this.preconditions = value;
  }
  public List<Precondition<T>> getPreconditions() {
    return preconditions;
  }
}
