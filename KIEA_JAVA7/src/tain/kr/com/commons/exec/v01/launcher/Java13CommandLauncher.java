/* 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package tain.kr.com.commons.exec.v01.launcher;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import tain.kr.com.commons.exec.v01.CommandLine;
import tain.kr.com.commons.exec.v01.environment.EnvironmentUtils;

/**
 * A command launcher for JDK/JRE 1.3 (and higher). Uses the built-in
 * Runtime.exec() command
 *
 * @version $Id: Java13CommandLauncher.java 1557338 2014-01-11 10:34:22Z sebb $
 */
public class Java13CommandLauncher extends CommandLauncherImpl {

    /**
     * Constructor
     */
    public Java13CommandLauncher() {
    }

    /**
     * Launches the given command in a new process, in the given working
     * directory
     * 
     * @param cmd
     *            the command line to execute as an array of strings
     * @param env
     *            the environment to set as an array of strings
     * @param workingDir
     *            the working directory where the command should run
     * @throws IOException
     *             probably forwarded from Runtime#exec
     */
    @Override
    public Process exec(final CommandLine cmd, final Map<String, String> env,
            final File workingDir) throws IOException {

        final String[] envVars = EnvironmentUtils.toStrings(env);

        return Runtime.getRuntime().exec(cmd.toStrings(),
                envVars, workingDir);
    }
}
