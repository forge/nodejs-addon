/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.project;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.forge.addon.projects.Project;
import org.jboss.forge.addon.projects.ProjectFactory;
import org.jboss.forge.furnace.container.simple.lifecycle.SimpleContainer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
@RunWith(Arquillian.class)
public class NodeJSProjectTest
{
   private ProjectFactory projectFactory;
   private NodeJSBuildSystem buildSystem;

   @Before
   public void setUp()
   {
      projectFactory = SimpleContainer.getServices(getClass().getClassLoader(), ProjectFactory.class).get();
      buildSystem = SimpleContainer.getServices(getClass().getClassLoader(), NodeJSBuildSystem.class).get();
   }

   @Test
   public void testNodeJSProject()
   {
      Project project = projectFactory.createTempProject(buildSystem);
      Assert.assertThat(project, instanceOf(NodeJSProject.class));
   }
}
