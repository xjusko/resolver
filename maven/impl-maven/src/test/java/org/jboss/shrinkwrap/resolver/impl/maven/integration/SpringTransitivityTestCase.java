package org.jboss.shrinkwrap.resolver.impl.maven.integration;

import java.io.File;

import org.hamcrest.CoreMatchers;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This is a reproducer for <a href="https://issues.redhat.com/browse/SHRINKRES-232">SHRINKRES-232</a> - Resolve from pom.xml: old version is picked
 *
 * @author <a href="mailto:mjobanek@redhat.com">Matous Jobanek</a>
 */
public class SpringTransitivityTestCase {

    @Test
    public void testVersionOfAOP() {
        File[] libs =
            Maven.resolver().loadPomFromFile("target/poms/test-spring.xml")
                .importCompileAndRuntimeDependencies()
                .resolve()
                .withTransitivity()
                .asFile();

        boolean found = false;
        for (File file : libs){
            if (file.getName().startsWith("spring-aop")) {
                assertThat(file.getName(), CoreMatchers.containsString("4.2.1.RELEASE"));
                found = true;
                break;
            }
        }

        Assert.assertTrue("The transitive dependency spring-aop should have been found", found);
    }
}
