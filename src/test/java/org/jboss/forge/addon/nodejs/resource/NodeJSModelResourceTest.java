/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.resource;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.forge.addon.resource.Resource;
import org.jboss.forge.addon.resource.ResourceFactory;
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
public class NodeJSModelResourceTest
{
   private ResourceFactory resourceFactory;

   @Before
   public void setUp()
   {
      resourceFactory = SimpleContainer.getServices(getClass().getClassLoader(), ResourceFactory.class).get();
   }

   @Test
   public void testResource() throws Exception
   {
      Path tmpDir = Files.createTempDirectory("tmp");
      File packageJson = new File(tmpDir.toFile(), "package.json");
      Resource<File> resource = resourceFactory.create(packageJson);
      Assert.assertThat(resource, instanceOf(NodeJSModelResource.class));
   }
}
