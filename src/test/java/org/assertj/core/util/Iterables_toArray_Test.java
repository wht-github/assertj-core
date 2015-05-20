/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.core.util;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Tests for <code>{@link Iterables#toArray(Iterable)}</code>.
 * 
 * @author Jean-Christophe Gay
 */
public class Iterables_toArray_Test {

  private final ArrayList<String> values = newArrayList("one", "two");

  @Test
  public void should_return_null_when_given_iterable_is_null() {
    assertThat(Iterables.toArray(null)).isNull();
    assertThat(Iterables.toArray(null, Object.class)).isNull();
  }

  @Test
  public void should_return_an_object_array_with_given_iterable_elements() {
    Object[] objects = Iterables.toArray(values);
    assertThat(objects).containsExactly("one", "two");
    String[] strings = Iterables.toArray(values, String.class);
    assertThat(strings).containsExactly("one", "two");
  }

  @Test
  public void should_return_empty_array_when_given_iterable_is_empty() {
    assertThat(Iterables.toArray(emptyList())).isEmpty();
    assertThat(Iterables.toArray(emptyList(), Object.class)).isEmpty();
  }

  @Test
  public void should_return_an_array_of_given_iterable_type_with_given_iterable_elements() {
    CharSequence[] result = Iterables.toArray(values, CharSequence.class);

    assertThat(result).containsExactly("one", "two");
  }
}
