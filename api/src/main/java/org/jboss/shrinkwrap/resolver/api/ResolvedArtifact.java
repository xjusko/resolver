/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
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
package org.jboss.shrinkwrap.resolver.api;

import java.io.File;
import java.io.InputStream;

/**
 * Representation of resolved artifact
 *
 * @author <a href="mailto:kpiwko@redhat.com">Karel Piwko</a>
 *
 * @param <RESOLVEDTYPE> The resolved type
 */
public interface ResolvedArtifact<RESOLVEDTYPE extends ResolvedArtifact<RESOLVEDTYPE>> {

    /**
     * Returns resolved artifact, optionally cast to the subtype of {@link ResolvedArtifact}
     *
     * @return The resolved artifact.
     */
    RESOLVEDTYPE asResolvedArtifact();

    /**
     * Returns resolved artifact as a {@link File}
     *
     * @return The resolved artifact as a {@link File}.
     */
    File asFile();

    /**
     * Returns resolved artifact as an {@link InputStream}. It is a responsibility of the caller to close stream
     * afterwards.
     *
     * @return The resolved artifact as an {@link InputStream}.
     */
    InputStream asInputStream();

    /**
     * Returns resolved artifact formatted to {@code returnTypeClass}.
     * <p>
     * See {@code FormatProcessor} to register additional format.
     *
     * @param <RETURNTYPE> The return type
     * @param returnTypeClass The return type class.
     * @return The resolved artifact formatted to {@code returnTypeClass}.
     * @throws IllegalArgumentException If the type is not specified
     * @throws UnsupportedOperationException If the type is not supported
     */
    <RETURNTYPE> RETURNTYPE as(Class<RETURNTYPE> returnTypeClass) throws IllegalArgumentException,
            UnsupportedOperationException;

}
