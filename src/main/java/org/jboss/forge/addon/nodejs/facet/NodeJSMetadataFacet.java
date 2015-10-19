/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.facet;

import java.util.Map;

import org.jboss.forge.addon.dependencies.Dependency;
import org.jboss.forge.addon.facets.constraints.FacetConstraint;
import org.jboss.forge.addon.nodejs.project.NodeJSBuildSystem;
import org.jboss.forge.addon.projects.ProjectProvider;
import org.jboss.forge.addon.projects.facets.AbstractProjectFacet;
import org.jboss.forge.addon.projects.facets.MetadataFacet;
import org.jboss.forge.furnace.container.simple.lifecycle.SimpleContainer;

/**
 *
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
@FacetConstraint(NodeJSFacet.class)
public class NodeJSMetadataFacet extends AbstractProjectFacet implements MetadataFacet
{
   @Override
   public ProjectProvider getProjectProvider()
   {
      return SimpleContainer.getServices(getClass().getClassLoader(), NodeJSBuildSystem.class).get();
   }

   @Override
   public boolean install()
   {
      return true;
   }

   @Override
   public boolean isInstalled()
   {
      return true;
   }

   @Override
   public String getProjectName()
   {
      return null;
   }

   @Override
   public MetadataFacet setProjectName(String name)
   {
      return null;
   }

   @Override
   public String getProjectGroupName()
   {
      return null;
   }

   @Override
   public MetadataFacet setProjectGroupName(String groupId)
   {
      return null;
   }

   @Override
   public String getProjectVersion()
   {
      return null;
   }

   @Override
   public MetadataFacet setProjectVersion(String version)
   {
      return null;
   }

   @Override
   public Dependency getOutputDependency()
   {
      return null;
   }

   @Override
   public Map<String, String> getEffectiveProperties()
   {
      return null;
   }

   @Override
   public Map<String, String> getDirectProperties()
   {
      return null;
   }

   @Override
   public String getEffectiveProperty(String name)
   {
      return null;
   }

   @Override
   public String getDirectProperty(String name)
   {
      return null;
   }

   @Override
   public MetadataFacet setDirectProperty(String name, String value)
   {
      return null;
   }

   @Override
   public String removeDirectProperty(String name)
   {
      return null;
   }

   @Override
   public boolean isValid()
   {
      return false;
   }

   @Override
   public String getTopLevelPackage()
   {
      return getProjectGroupName();
   }

   @Override
   public MetadataFacet setTopLevelPackage(String groupId)
   {
      return setProjectGroupName(groupId);
   }
}
