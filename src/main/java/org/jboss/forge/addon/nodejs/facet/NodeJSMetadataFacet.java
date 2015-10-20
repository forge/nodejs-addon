/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.facet;

import java.util.Map;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.jboss.forge.addon.dependencies.Dependency;
import org.jboss.forge.addon.facets.constraints.FacetConstraint;
import org.jboss.forge.addon.nodejs.project.NodeJSBuildSystem;
import org.jboss.forge.addon.nodejs.resource.NodeJSModelResource;
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
      NodeJSFacet nodeJS = getFaceted().getFacet(NodeJSFacet.class);
      JsonObject jsonObject = nodeJS.getModelResource().getJsonObject();
      return jsonObject.getString("name");
   }

   @Override
   public MetadataFacet setProjectName(String name)
   {
      NodeJSFacet nodeJS = getFaceted().getFacet(NodeJSFacet.class);
      NodeJSModelResource modelResource = nodeJS.getModelResource();
      JsonObjectBuilder job = modelResource.getJsonObjectBuilder();
      job.add("name", name);
      modelResource.setContents(job.build());
      return this;
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
      NodeJSFacet nodeJS = getFaceted().getFacet(NodeJSFacet.class);
      JsonObject jsonObject = nodeJS.getModelResource().getJsonObject();
      return jsonObject.getString("version");
   }

   @Override
   public MetadataFacet setProjectVersion(String version)
   {
      NodeJSFacet nodeJS = getFaceted().getFacet(NodeJSFacet.class);
      NodeJSModelResource modelResource = nodeJS.getModelResource();
      JsonObjectBuilder job = modelResource.getJsonObjectBuilder();
      job.add("version", version);
      modelResource.setContents(job.build());
      return this;
   }

   @Override
   public Dependency getOutputDependency()
   {
      return null;
   }

   @SuppressWarnings({ "rawtypes", "unchecked" })
   @Override
   public Map<String, String> getEffectiveProperties()
   {
      NodeJSFacet nodeJS = getFaceted().getFacet(NodeJSFacet.class);
      Map jsonObject = nodeJS.getModelResource().getJsonObject();
      return jsonObject;
   }

   @SuppressWarnings({ "rawtypes", "unchecked" })
   @Override
   public Map<String, String> getDirectProperties()
   {
      NodeJSFacet nodeJS = getFaceted().getFacet(NodeJSFacet.class);
      Map jsonObject = nodeJS.getModelResource().getJsonObject();
      return jsonObject;
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
      return true;
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
