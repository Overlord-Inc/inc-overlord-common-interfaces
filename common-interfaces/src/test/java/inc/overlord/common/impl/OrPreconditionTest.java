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
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 *
 * @author achelian
 */
public class OrPreconditionTest {
  OrPrecondition<Void> or;
  @Mock
  Precondition<Void> mockFalse;
  @Mock
  Precondition<Void> mockTrue;

  @Before
  public void setUp() {
    or = new OrPrecondition<Void>();
    initMocks(this);
    stub(mockFalse.fulfilled(any(Void.class))).toReturn(Boolean.FALSE);
    stub(mockTrue.fulfilled(any(Void.class))).toReturn(Boolean.TRUE);
  }

  /**
   * Test of fulfilled method, of class OrPrecondition.
   */
  @Test
  public void testFulfilled() {
    List<Precondition<Void>> preconditions = Collections.singletonList(mockFalse);
    or.setPreconditions(preconditions);
    assertFalse(or.fulfilled(null));
    preconditions = Collections.singletonList(mockTrue);
    or.setPreconditions(preconditions);
    assertTrue(or.fulfilled(null));
  }

  /**
   * Test of setPreconditions method, of class OrPrecondition.
   */
  @Test
  public void testSetPreconditions() {
    List<Precondition<Void>> preconditions = Collections.singletonList(mockFalse);
    or.setPreconditions(preconditions);
    assertNotNull(or.getPreconditions());
    assertFalse(or.getPreconditions().isEmpty());
    assertSame(or.getPreconditions().get(0), mockFalse);
  }

  @Test
  public void testShortCutting() {
    List<Precondition<Void>> preconditions = Arrays.asList(mockFalse, mockTrue);
    or.setPreconditions(preconditions);
    assertTrue(or.fulfilled(null));
    verify(mockFalse, times(1)).fulfilled(any(Void.class));
    verify(mockTrue, times(1)).fulfilled(any(Void.class));
    preconditions = Arrays.asList(mockTrue, mockFalse);
    or.setPreconditions(preconditions);
    assertTrue(or.fulfilled(null));
    verify(mockTrue, times(2)).fulfilled(any(Void.class));
    verify(mockFalse, times(1)).fulfilled(any(Void.class));
  }
}