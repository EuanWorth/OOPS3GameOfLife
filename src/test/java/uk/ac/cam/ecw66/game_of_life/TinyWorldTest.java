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
import static uk.ac.cam.ecw66.game_of_life.WorldStringUtils.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TinyWorldTest {

  @Test
  public void width_returns8() {
    // ARRANGE
    TinyWorld tinyWorld = new TinyWorld();

    // ACT
    int width = tinyWorld.width();

    // ASSERT
    assertThat(width).isEqualTo(8);
  }

  @Test
  public void heigth_returns8() {
    // ARRANGE
    TinyWorld tinyWorld = new TinyWorld();

    // ACT
    int width = tinyWorld.height();

    // ASSERT
    assertThat(width).isEqualTo(8);
  }

  @Test
  public void cellAlive_returnsFalse_whenOutOfRange() {
    // ARRANGE
    TinyWorld tinyWorld = new TinyWorld();

    // ACT
    boolean cellAlive = tinyWorld.cellAlive(-1, 0);

    // ASSERT
    assertThat(cellAlive).isFalse();
  }

  @Test
  public void withCellAliveness_doesNotChangeOriginal() {
    // ARRANGE
    TinyWorld tinyWorld = new TinyWorld();

    // ACT
    tinyWorld.withCellAliveness(0, 0, true);

    // ASSERT
    assertThat(worldToString(tinyWorld))
        .isEqualTo(
            lines(
                "________",
                "________",
                "________",
                "________",
                "________",
                "________",
                "________",
                "________"));
  }

  @Test
  public void withCellAliveness_createsCorrectChanges() {
    // ARRANGE
    TinyWorld tinyWorld = new TinyWorld();

    // ACT
    TinyWorld newWorld = tinyWorld.withCellAliveness(0, 0, true);

    // ASSERT
    assertThat(worldToString(newWorld))
            .isEqualTo(
                    lines(
                            "#_______",
                            "________",
                            "________",
                            "________",
                            "________",
                            "________",
                            "________",
                            "________"));
  }

  @Test
  public void getFromLong() {
    //ARRANGE
    long myLong = 0x8000000000000000L;

    //ACT
    TinyWorld tinyWorld = TinyWorld.fromLong(myLong);

    //ASSERT
    assertThat(worldToString(tinyWorld))
            .isEqualTo(
                    lines(
                            "________",
                            "________",
                            "________",
                            "________",
                            "________",
                            "________",
                            "________",
                            "_______#"));
  }

  @Test
  public void getFromPackedLong() {
    //ARRANGE
    PackedLong myLong = new PackedLong(0x8000000000000000L);

    //ACT
    TinyWorld tinyWorld = TinyWorld.fromPackedLong(myLong);

    //ASSERT
    assertThat(worldToString(tinyWorld))
            .isEqualTo(
                    lines(
                            "________",
                            "________",
                            "________",
                            "________",
                            "________",
                            "________",
                            "________",
                            "_______#"));
  }

  @Test
  public void cellAlive_returnsFalse_whenDeadCell() {
    // ARRANGE
    TinyWorld tinyWorld = new TinyWorld();

    // ACT
    boolean cellAlive = tinyWorld.cellAlive(7, 7);

    // ASSERT
    assertThat(cellAlive).isFalse();
  }

  @Test
  public void cellAlive_returnsTrue_whenAliveCell() {
    // ARRANGE
    TinyWorld tinyWorld = TinyWorld.fromLong(0x8000000000000000L);

    // ACT
    boolean cellAlive = tinyWorld.cellAlive(7, 7);

    // ASSERT
    assertThat(cellAlive).isTrue();
  }

  @Test
  public void stringToWorldWorks() {
    //ARRANGE
    TinyWorld tinyWorld = TinyWorld.fromLong(0x8000000000000000L);
    //ACT
    TinyWorld tinyWorld1 = (TinyWorld) stringToWorld(
            new TinyWorld(),
            "________",
            "________",
            "________",
            "________",
            "________",
            "________",
            "________",
            "_______#");
    boolean equal = tinyWorld.equals(tinyWorld1);

    //ASSERT
    assertThat(equal).isTrue();
  }

  @Test
  public void cloneAndEqualsIsTrue() {
    //ARRANGE
    TinyWorld tinyWorld = TinyWorld.fromLong(0x1517815615615123L);

    //ACT
    TinyWorld clone = tinyWorld.clone();
    boolean equal = clone.equals(tinyWorld);

    //ASSERT
    assertThat(equal).isTrue();
  }

  @Test
  public void clonesHaveEqualHash() {
    //ARRANGE
    TinyWorld tinyWorld = TinyWorld.fromLong(0x1517815615615123L);

    //ACT
    TinyWorld clone = tinyWorld.clone();
    int hash1 = tinyWorld.hashCode();
    int hash2 = tinyWorld.hashCode();
    boolean equal = hash1 == hash2;

    //ASSERT
    assertThat(equal).isTrue();
  }
}
