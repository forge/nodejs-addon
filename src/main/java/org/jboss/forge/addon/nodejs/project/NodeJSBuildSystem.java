/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.project;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.jboss.forge.addon.facets.FacetFactory;
import org.jboss.forge.addon.nodejs.facet.NodeJSFacet;
import org.jboss.forge.addon.nodejs.facet.NodeJSMetadataFacet;
import org.jboss.forge.addon.nodejs.facet.NodeJSPackagingFacet;
import org.jboss.forge.addon.projects.Project;
import org.jboss.forge.addon.projects.ProjectProvider;
import org.jboss.forge.addon.projects.ProvidedProjectFacet;
import org.jboss.forge.addon.resource.Resource;
import org.jboss.forge.furnace.container.simple.lifecycle.SimpleContainer;

/**
 * Node package manager
 * 
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
public class NodeJSBuildSystem implements ProjectProvider
{
   @Override
   public String getType()
   {
      return "npm";
   }

   @Override
   public Iterable<Class<? extends ProvidedProjectFacet>> getProvidedFacetTypes()
   {
      Set<Class<? extends ProvidedProjectFacet>> result = new HashSet<>();
      result.add(NodeJSFacet.class);
      result.add(NodeJSMetadataFacet.class);
      result.add(NodeJSPackagingFacet.class);
      return Collections.unmodifiableSet(result);
   }

   @Override
   public Project createProject(Resource<?> target)
   {
      Project project = new NodeJSProject(target);
      FacetFactory factory = SimpleContainer.getServices(getClass().getClassLoader(), FacetFactory.class).get();
      try
      {
         factory.install(project, NodeJSFacet.class);
         factory.install(project, NodeJSMetadataFacet.class);
         factory.install(project, NodeJSPackagingFacet.class);
         // factory.install(project, NodeJSDependencyFacet.class);
      }
      catch (RuntimeException e)
      {
         throw new IllegalStateException("Could not install NodeJS into Project located at ["
                  + target.getFullyQualifiedName() + "]", e);
      }

      return project;
   }

   @Override
   public boolean containsProject(final Resource<?> target)
   {
      if (target.exists())
      {
         Resource<?> packageJson = target.getChild("package.json");
         return packageJson != null && packageJson.exists();
      }
      return false;
   }

   @Override
   public int priority()
   {
      return Integer.MAX_VALUE;
   }

}
