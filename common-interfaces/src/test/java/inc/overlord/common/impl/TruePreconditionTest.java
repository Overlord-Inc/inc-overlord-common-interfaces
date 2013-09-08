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
public class TruePreconditionTest {

  /**
   * Test of fulfilled method, of class TruePrecondition.
   */
  @Test
  public void testFulfilled() {
    TruePrecondition instance = TruePrecondition.singleton();
    assertNotNull(instance);
    assertTrue(instance.fulfilled(null));
  }

  /**
   * Test of singleton method, of class TruePrecondition.
   */
  @Test
  public void testSingleton() {
    TruePrecondition instance = TruePrecondition.singleton();
    TruePrecondition instance2 = TruePrecondition.singleton();
    assertSame(instance, instance2);
  }
}