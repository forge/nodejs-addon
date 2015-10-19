/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.project;

import org.jboss.forge.addon.projects.AbstractProject;
import org.jboss.forge.addon.projects.ProjectFacet;
import org.jboss.forge.addon.resource.DirectoryResource;
import org.jboss.forge.addon.resource.Resource;

/**
 * A Node package manager project
 * 
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
public class NodeJSProject extends AbstractProject
{
   private final Resource<?> root;

   public NodeJSProject(Resource<?> projectRoot)
   {
      this.root = projectRoot;
   }

   @Override
   public DirectoryResource getRootDirectory()
   {
      if (root instanceof DirectoryResource)
         return (DirectoryResource) root;
      throw new IllegalStateException("Project root [" + root + "] is not an instance of DirectoryResource");
   }

   @Override
   public Resource<?> getRoot()
   {
      return root;
   }

   @Override
   public <F extends ProjectFacet> boolean supports(F facet)
   {
      return true;
   }

   @Override
   public String toString()
   {
      return root.toString();
   }

}
