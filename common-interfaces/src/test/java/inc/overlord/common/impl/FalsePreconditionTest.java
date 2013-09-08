/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.overlord.common.impl;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author achelian
 */
public class FalsePreconditionTest {
  
  /**
   * Test of fulfilled method, of class FalsePrecondition.
   */
  @Test
  public void testFulfilled() {
    FalsePrecondition<Void> instance = FalsePrecondition.singleton();
    assertNotNull(instance);
    assertFalse(instance.fulfilled(null));
  }

  /**
   * Test of singleton method, of class FalsePrecondition.
   */
  @Test
  public void testSingleton() {
    FalsePrecondition instance = FalsePrecondition.singleton();
    FalsePrecondition instance2 = FalsePrecondition.singleton();
    assertSame(instance, instance2);
  }
}