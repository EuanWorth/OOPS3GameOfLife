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
public class WorldAliveNeighbourCountTest {

  @Test
  public void aliveNeighbourCount_excludesCentre() {
    // ARRANGE
    boolean[][] cells =
        new boolean[][] {
          {false, false, false},
          {false, true, false},
          {false, false, false},
        };
    World w =
        new StubWorld() {
          @Override
          public boolean cellAlive(int col, int row) {
            return cells[row][col];
          }

          @Override
          public int width() {return 3;}

            @Override
            public int height() {return 3;}
        };

    // ACT
    int neighbourCount = w.aliveNeighbourCount(1, 1);

    // ASSERT
    assertThat(neighbourCount).isEqualTo(0);
  }

  @Test
    public void aliveNeighbourCount_countsCorrectly() {
        // ARRANGE
        boolean[][] cells =
                new boolean[][] {
                        {true, false, false},
                        {false, true, true},
                        {false, true, false},
                };
        World w =
                new StubWorld() {
                    @Override
                    public boolean cellAlive(int col, int row) {
                        return cells[row][col];
                    }

                    @Override
                    public int width() {return 3;}

                    @Override
                    public int height() {return 3;}
                };

        // ACT
        int neighbourCount = w.aliveNeighbourCount(1, 1);

        // ASSERT
        assertThat(neighbourCount).isEqualTo(3);
    }

    @Test
    public void aliveNeighbourCount_dealsWithEdges() {
        // ARRANGE
        boolean[][] cells =
                new boolean[][] {
                        {true, true, false},
                        {false, true, true},
                        {false, true, false},
                };
        World w =
                new StubWorld() {
                    @Override
                    public boolean cellAlive(int col, int row) {
                        return cells[row][col];
                    }

                    @Override
                    public int width() {return 3;}

                    @Override
                    public int height() {return 3;}
                };

        // ACT
        int neighbourCount = w.aliveNeighbourCount(0, 0);

        // ASSERT
        assertThat(neighbourCount).isEqualTo(2);
    }
}
