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

import java.util.Objects;

public final class TinyWorld implements World, Cloneable {
  private PackedLong cells;

  TinyWorld() {
    cells = new PackedLong();
  }

  @Override
  public int width() {
    return 8;
  }

  @Override
  public int height() {
    return 8;
  }

  @Override
  public boolean cellAlive(int col, int row) {
    if (0 <= col && col < width() && 0 <= row && row < height()) {
      return cells.get(8 * col + row);
    } else return false;
  }

  public static TinyWorld fromLong(long aLong) {
    TinyWorld tw = new TinyWorld();
    tw.cells = new PackedLong(aLong);
    return tw;
  }

  public static TinyWorld fromPackedLong(PackedLong aPackedLong) {
    TinyWorld tw = new TinyWorld();
    tw.cells = aPackedLong.clone();
    return tw;
  }

  @Override
  public TinyWorld withCellAliveness(int col, int row, boolean b) {
    TinyWorld clone = this.clone();
    clone.cells.set(8 * col + row, b);
    return clone;
  }

  @Override
  public TinyWorld clone() {
    return TinyWorld.fromPackedLong(this.cells);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TinyWorld tinyWorld = (TinyWorld) o;
    for (int i = 0; i < width(); ++i) {
      for (int j = 0; j < height(); ++j) {
        if (this.cellAlive(i,j) != tinyWorld.cellAlive(i,j)) return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cells);
  }
}
