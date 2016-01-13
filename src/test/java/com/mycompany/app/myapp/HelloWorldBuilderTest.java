package com.mycompany.app.myapp;

import jenkins.model.Jenkins;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jvnet.hudson.test.JenkinsRule;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by ehenkan on 1/13/16.
 */


@RunWith(MockitoJUnitRunner.class)
public class HelloWorldBuilderTest {

    private static final String NAME = "TestName";

    @Rule public JenkinsRule j = new JenkinsRule();

    private HelloWorldBuilder builder = new HelloWorldBuilder(NAME);

    @Test
    public void nameShouldBeTest_1(){
        builder.perform(null,null,null,null);

    }
}
