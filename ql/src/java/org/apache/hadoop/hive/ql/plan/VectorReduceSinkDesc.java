/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.plan;

/**
 * VectorReduceSinkDesc.
 *
 * Extra parameters beyond ReduceSinkDesc just for the VectorReduceSinkOperator.
 *
 * We don't extend ReduceSinkDesc because the base OperatorDesc doesn't support
 * clone and adding it is a lot work for little gain.
 */
public class VectorReduceSinkDesc extends AbstractVectorDesc  {

  private static long serialVersionUID = 1L;

  public static enum ReduceSinkKeyType {
    NONE,
    LONG,
    STRING,
    MULTI_KEY
  }

  private ReduceSinkKeyType reduceSinkKeyType;

  private VectorReduceSinkInfo vectorReduceSinkInfo;

  public VectorReduceSinkDesc() {
    reduceSinkKeyType = ReduceSinkKeyType.NONE;
    vectorReduceSinkInfo = null;
  }

  public ReduceSinkKeyType reduceSinkKeyType() {
    return reduceSinkKeyType;
  }

  public void setReduceSinkKeyType(ReduceSinkKeyType reduceSinkKeyType) {
    this.reduceSinkKeyType = reduceSinkKeyType;
  }

  public void setVectorReduceSinkInfo(VectorReduceSinkInfo vectorReduceSinkInfo) {
    this.vectorReduceSinkInfo = vectorReduceSinkInfo;
  }

  public VectorReduceSinkInfo getVectorReduceSinkInfo() {
    return vectorReduceSinkInfo;
  }
}
