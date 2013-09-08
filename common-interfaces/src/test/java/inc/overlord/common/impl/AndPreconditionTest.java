/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.overlord.common.impl;

import inc.overlord.common.Precondition;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import org.mockito.Mock;

/**
 *
 * @author achelian
 */
public class AndPreconditionTest {
  AndPrecondition<Void> and;
  @Mock
  Precondition<Void> mockFalse;
  @Mock
  Precondition<Void> mockTrue;
  
  @Before
  public void setUp() {
    and = new AndPrecondition<Void>();
    initMocks(this);
    stub(mockFalse.fulfilled(any(Void.class))).toReturn(Boolean.FALSE);
    stub(mockTrue.fulfilled(any(Void.class))).toReturn(Boolean.TRUE);
  }

  /**
   * Test of fulfilled method, of class AndPrecondition.
   */
  @Test
  public void testFulfilled() {
    List<Precondition<Void>> preconditions = Collections.singletonList(mockFalse);
    and.setPreconditions(preconditions);
    assertFalse(and.fulfilled(null));
    preconditions = Collections.singletonList(mockTrue);
    and.setPreconditions(preconditions);
    assertTrue(and.fulfilled(null));
  }

  /**
   * Test of setPreconditions method, of class AndPrecondition.
   */
  @Test
  public void testSetPreconditions() {
    List<Precondition<Void>> preconditions = Collections.singletonList(mockFalse);
    and.setPreconditions(preconditions);
    assertNotNull(and.getPreconditions());
    assertFalse(and.getPreconditions().isEmpty());
    assertSame(and.getPreconditions().get(0), mockFalse);
  }

  @Test
  public void testShortCutting() {
    List<Precondition<Void>> preconditions = Arrays.asList(mockFalse, mockTrue);
    and.setPreconditions(preconditions);
    assertFalse(and.fulfilled(null));
    verify(mockFalse, times(1)).fulfilled(any(Void.class));
    verify(mockTrue, times(0)).fulfilled(any(Void.class));
    preconditions = Arrays.asList(mockTrue, mockFalse);
    and.setPreconditions(preconditions);
    assertFalse(and.fulfilled(null));
    verify(mockTrue, times(1)).fulfilled(any(Void.class));
    verify(mockFalse, times(2)).fulfilled(any(Void.class));
  }
}