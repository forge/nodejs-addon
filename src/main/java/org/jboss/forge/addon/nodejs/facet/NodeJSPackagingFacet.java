/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.facet;

import org.jboss.forge.addon.facets.constraints.FacetConstraint;
import org.jboss.forge.addon.projects.building.BuildResult;
import org.jboss.forge.addon.projects.building.ProjectBuilder;
import org.jboss.forge.addon.projects.facets.AbstractProjectFacet;
import org.jboss.forge.addon.projects.facets.PackagingFacet;
import org.jboss.forge.addon.resource.Resource;

/**
 *
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
@FacetConstraint(NodeJSFacet.class)
public class NodeJSPackagingFacet extends AbstractProjectFacet implements PackagingFacet
{

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
   public void setPackagingType(String type)
   {
   }

   @Override
   public String getPackagingType()
   {
      return "js";
   }

   @Override
   public Resource<?> getFinalArtifact()
   {
      return null;
   }

   @Override
   public ProjectBuilder createBuilder()
   {
      return null;
   }

   @Override
   public Resource<?> executeBuild(String... args)
   {
      return null;
   }

   @Override
   public String getFinalName()
   {
      return null;
   }

   @Override
   public void setFinalName(String finalName)
   {
   }

   @Override
   public BuildResult getBuildResult()
   {
      return null;
   }

}
