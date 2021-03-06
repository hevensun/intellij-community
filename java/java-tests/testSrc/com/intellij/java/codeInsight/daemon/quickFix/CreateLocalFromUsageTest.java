/*
 * Copyright 2000-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.java.codeInsight.daemon.quickFix;

import com.intellij.application.options.CodeStyle;
import com.intellij.codeInsight.daemon.quickFix.LightQuickFixParameterizedTestCase;
import com.intellij.psi.codeStyle.JavaCodeStyleSettings;

/**
 * @author ven
 */
public class CreateLocalFromUsageTest extends LightQuickFixParameterizedTestCase {

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    CodeStyle.getSettings(getProject()).getCustomSettings(JavaCodeStyleSettings.class).GENERATE_FINAL_LOCALS =
      getTestName(true).contains("final");
  }

  @Override
  protected void tearDown() throws Exception {
    try {
      CodeStyle.getSettings(getProject()).getCustomSettings(JavaCodeStyleSettings.class).GENERATE_FINAL_LOCALS = false;
    }
    finally {
      super.tearDown();
    }
  }

  public void test() { doAllTests(); }

  @Override
  protected String getBasePath() {
    return "/codeInsight/daemonCodeAnalyzer/quickFix/createLocalFromUsage";
  }
}
