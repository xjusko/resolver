/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.shrinkwrap.api.gradle.archive.importer.embedded;

import java.io.File;

/**
 * @author <a href="mailto:mmatloka@gmail.com">Michal Matloka</a>
 */
public interface ConfigurationStage extends BuildStage {

    ConfigurationStage useGradleUserHomeDir(File gradleUserHomeDir);

    /**
     * Set tasks which will be executed during build. Default: [build].
     *
     * @param tasks
     *            List of tasks to be executed.
     */
    ConfigurationStage forTasks(String... tasks);

    /**
     * Sets argument which will be used during build. Default: "--exclude-task test".
     *
     * @param arguments
     *            Arguments to be used
     */
    ConfigurationStage withArguments(String... arguments);

    /**
     * Java home directory.
     *
     * @param javaHome
     *            JDK home
     */
    ConfigurationStage setJavaHome(File javaHome);

    /**
     * @param jvmArguments
     *            JVM arguments
     */
    ConfigurationStage setJvmArguments(String... jvmArguments);
}
