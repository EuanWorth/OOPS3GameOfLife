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

public final class TinyWorld implements World {
  TinyWorld() {}

  @Override
  public int width() {
    throw new UnsupportedOperationException();
  }

  @Override
  public int height() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean cellAlive(int col, int row) {
    throw new UnsupportedOperationException();
  }

  @Override
  public TinyWorld withCellAliveness(int col, int row, boolean b) {
    throw new UnsupportedOperationException();
  }
}
