package com.mycompany.app.myapp;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.*;

import hudson.util.AbstractTaskListener;
import jenkins.model.Jenkins;
import org.apache.tools.ant.taskdefs.Parallel;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.jvnet.hudson.test.JenkinsRule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by ehenkan on 1/13/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldBuilderTest {

    private static final String NAME = "TestName";
    private static  final String PROJECT_NAME = "test_job1";

    private HelloWorldBuilder builder;

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Rule
    public JenkinsRule j = new JenkinsRule();

    @Before
    public void setUp() {
        builder = new HelloWorldBuilder(NAME);
    }

    @Test
    public void testPerform() throws Exception {

        FilePath filePath = new FilePath(tmpFolder.getRoot());
        Launcher launcher = mock(Launcher.class);
        TaskListener listener = j.createTaskListener();
        AbstractBuild build = mock(AbstractBuild.class);

        builder.perform(build, filePath, launcher, listener);
        Thread.sleep(4000);

        TopLevelItem project = j.getInstance().getItem(PROJECT_NAME);
        assertNotNull(project);
        assertTrue(project instanceof FreeStyleProject);
        assertNotNull(((FreeStyleProject)project).getLastBuild());
    }
}
