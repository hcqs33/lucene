/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.lucene.codecs.lucene93;

import org.apache.lucene.codecs.Codec;
import org.apache.lucene.codecs.KnnVectorsFormat;
import org.apache.lucene.tests.index.BaseKnnVectorsFormatTestCase;
import org.apache.lucene.tests.util.TestUtil;

public class TestLucene93HnswVectorsFormat extends BaseKnnVectorsFormatTestCase {
  @Override
  protected Codec getCodec() {
    return TestUtil.getDefaultCodec();
  }

  public void testToString() {
    Lucene93Codec customCodec =
        new Lucene93Codec() {
          @Override
          public KnnVectorsFormat getKnnVectorsFormatForField(String field) {
            return new Lucene93HnswVectorsFormat(10, 20);
          }
        };
    String expectedString =
        "Lucene93HnswVectorsFormat(name=Lucene93HnswVectorsFormat, maxConn=10, beamWidth=20)";
    assertEquals(expectedString, customCodec.getKnnVectorsFormatForField("bogus_field").toString());
  }
}
