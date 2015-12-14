/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.resource;

import java.io.File;

import org.jboss.forge.addon.parser.json.resource.AbstractJsonResource;
import org.jboss.forge.addon.resource.Resource;
import org.jboss.forge.addon.resource.ResourceFactory;

/**
 * The package.json file
 * 
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
public class NodeJSModelResource extends AbstractJsonResource
{
   public NodeJSModelResource(final ResourceFactory factory, final File file)
   {
      super(factory, file);
   }

   @Override
   public Resource<File> createFrom(File file)
   {
      return new NodeJSModelResource(getResourceFactory(), file);
   }
}
