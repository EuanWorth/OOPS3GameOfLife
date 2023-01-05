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

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PackedLongTest {

  @Test
  public void set_onlyChangesAffectedPosition() {
    // ARRANGE
    PackedLong packedLong = new PackedLong(0xF00000000000000FL);

    // ACT
    packedLong.set(4, true);

    // ASSERT
    assertThat(packedLong.getLong()).isEqualTo(0xF00000000000001FL);
  }

  @Test
  public void clear_onlyChangesAffectedPosition() {
    // ARRANGE
    PackedLong packedLong = new PackedLong(0xF00000000000000FL);

    // ACT
    packedLong.set(4, false);

    // ASSERT
    assertThat(packedLong.getLong()).isEqualTo(0xF00000000000000FL);
  }

  @Test
  public void set_setsHighestBit_atPosition63() {
    // ARRANGE
    PackedLong packedLong = new PackedLong(0x000000000000000FL);

    // ACT
    packedLong.set(63, true);

    // ASSERT
    assertThat(packedLong.getLong()).isEqualTo(0x800000000000000FL);
  }

  @Test
  public void get_getsHighestBit_whenPosition63IsSet() {
    // ARRANGE
    PackedLong packedLong = new PackedLong(0x8000000000000000L);

    // ACT
    boolean value = packedLong.get(63);

    // ASSERT
    assertThat(value).isTrue();
  }

  @Test
  public void get_getsHighestBit_whenPosition63IsClear() {
    // ARRANGE
    PackedLong packedLong = new PackedLong(0x7000000000000000L);

    // ACT
    boolean value = packedLong.get(63);

    // ASSERT
    assertThat(value).isFalse();
  }


  @Test
  public void get_packedLongWorks() {
    //ARRANGE
    PackedLong packedLong = new PackedLong(0x7000000000000000L);

    //ACT
    long packedLongsLong = packedLong.getLong();

    //ASSERT
    assertThat(packedLongsLong).isEqualTo(0x7000000000000000L);

  }

  @Test
  public void set_packedLongWorks() {
    //ARRANGE
    PackedLong packedLong = new PackedLong();

    //ACT
    packedLong.setLong(0x8000000000000000L);
    long packedLongsLong = packedLong.getLong();

    //ASSERT
    assertThat(packedLongsLong).isEqualTo(0x8000000000000000L);

  }

  @Test
  public void sizeWorks() {
    //ARRANGE
    PackedLong pl = new PackedLong();

    //ACT
    int size = pl.size();

    //ASSERT
    assertThat(pl.size()).isEqualTo(64);
  }
}
