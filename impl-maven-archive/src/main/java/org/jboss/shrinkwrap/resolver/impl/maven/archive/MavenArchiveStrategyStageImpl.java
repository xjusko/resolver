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
package org.jboss.shrinkwrap.resolver.impl.maven.archive;

import java.util.Collection;

import org.jboss.shrinkwrap.resolver.api.maven.archive.MavenArchiveFormatStage;
import org.jboss.shrinkwrap.resolver.api.maven.archive.MavenArchiveStrategyStage;
import org.jboss.shrinkwrap.resolver.impl.maven.MavenStrategyStageBaseImpl;
import org.jboss.shrinkwrap.resolver.impl.maven.MavenWorkingSession;
import org.sonatype.aether.artifact.Artifact;

/**
 * Implementation of {@link MavenArchiveStrategyStage}
 *
 * @author <a href="mailto:alr@jboss.org">Andrew Lee Rubinger</a>
 */
class MavenArchiveStrategyStageImpl extends
    MavenStrategyStageBaseImpl<MavenArchiveStrategyStage, MavenArchiveFormatStage> implements MavenArchiveStrategyStage {

    MavenArchiveStrategyStageImpl(final MavenWorkingSession session) {
        super(session);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.jboss.shrinkwrap.resolver.impl.maven.MavenStrategyStageBaseImpl#getActualClass()
     */
    @Override
    protected Class<MavenArchiveStrategyStage> getActualClass() {
        return MavenArchiveStrategyStage.class;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.jboss.shrinkwrap.resolver.impl.maven.MavenStrategyStageBaseImpl#createFormatStage(java.util.Collection)
     */
    @Override
    protected MavenArchiveFormatStage createFormatStage(final Collection<Artifact> filteredArtifacts) {
        return new MavenArchiveFormatStageImpl(filteredArtifacts);
    }

}