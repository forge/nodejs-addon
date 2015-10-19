/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.project;

import java.util.Arrays;

import org.jboss.forge.addon.nodejs.facet.NodeJSFacet;
import org.jboss.forge.addon.nodejs.facet.NodeJSMetadataFacet;
import org.jboss.forge.addon.nodejs.facet.NodeJSPackagingFacet;
import org.jboss.forge.addon.nodejs.ui.NodeJSExpressWizardStep;
import org.jboss.forge.addon.projects.AbstractProjectType;
import org.jboss.forge.addon.projects.ProjectFacet;
import org.jboss.forge.addon.ui.wizard.UIWizardStep;

/**
 *
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
public class NodeJSProjectType extends AbstractProjectType
{

   @Override
   public String getType()
   {
      return "NodeJS";
   }

   @Override
   public Class<? extends UIWizardStep> getSetupFlow()
   {
      return NodeJSExpressWizardStep.class;
   }

   @Override
   public Iterable<Class<? extends ProjectFacet>> getRequiredFacets()
   {
      return Arrays.<Class<? extends ProjectFacet>> asList(NodeJSFacet.class, NodeJSMetadataFacet.class,
               NodeJSPackagingFacet.class);
   }

   @Override
   public int priority()
   {
      return 100;
   }

   @Override
   public String toString()
   {
      return "nodejs";
   }

}
