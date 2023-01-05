/*
 * Copyright 2023 David Berry <dgb37@cam.ac.uk>, Joe Isaacs <josi2@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, E.C. Worth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.ecw66.game_of_life;

import java.util.AbstractList;

class PackedLong extends AbstractList<Boolean> {
  public long getLong() {
    return packed;
  }

  public void setLong(long packed) {
    this.packed = packed;
  }

  private long packed;
  /**
   * Unpack the nth bit from the packed number and return it
   * @param position the position of the bit we are interested in from 0 to 63 inclusive
   * @return the value of the position'th bit
   */

  @Override
  public Boolean get(int position) {
    return ((packed >>> position) & 1) == 1;
  }

  /**
   * Set the nth bit in the packed number to the value given and return the new packed number
   *
   * @param position the position of the bit of interest
   * @param value the value to set the bit to
   * @return the new packed number
   */
  public void set(int position, boolean value) {
    if (value) {
      packed |= 1L << position;
    } else {
      packed &= ~(1L << position);
    }
  }

  // No instances
  public PackedLong(long packed) {
    this.packed = packed;
  }

  public PackedLong() {
    this(0L);
  }

  @Override
  public int size() {
    return 64;
  }
}
