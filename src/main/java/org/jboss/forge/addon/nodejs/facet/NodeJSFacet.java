/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.facet;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.jboss.forge.addon.nodejs.resource.NodeJSModelResource;
import org.jboss.forge.addon.projects.ProvidedProjectFacet;
import org.jboss.forge.addon.projects.facets.AbstractProjectFacet;
import org.jboss.forge.addon.resource.Resource;

/**
 * NodeJS Package manager
 * 
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
public class NodeJSFacet extends AbstractProjectFacet implements ProvidedProjectFacet
{
   public NodeJSModelResource getModelResource()
   {
      return getPackageJsonResource().reify(NodeJSModelResource.class);
   }

   private Resource<?> getPackageJsonResource()
   {
      return getFaceted().getRoot().getChild("package.json");
   }

   @Override
   public boolean install()
   {
      if (!isInstalled())
      {
         NodeJSModelResource packageJson = getModelResource();
         if (!packageJson.createNewFile())
            throw new IllegalStateException("Could not create POM file.");
         packageJson.setContents(createDefaultPackageJson());
      }
      return isInstalled();
   }

   private JsonObject createDefaultPackageJson()
   {
      try (JsonReader reader = Json.createReader(getClass().getResourceAsStream("package.json.ftl")))
      {
         return reader.readObject();
      }
   }

   @Override
   public boolean isInstalled()
   {
      return getPackageJsonResource().exists();
   }
}
