/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.nodejs.facet;

import java.util.List;

import org.jboss.forge.addon.dependencies.Coordinate;
import org.jboss.forge.addon.dependencies.Dependency;
import org.jboss.forge.addon.dependencies.DependencyQuery;
import org.jboss.forge.addon.dependencies.DependencyRepository;
import org.jboss.forge.addon.projects.facets.AbstractProjectFacet;
import org.jboss.forge.addon.projects.facets.DependencyFacet;

/**
 *
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
public class NodeJSDependencyFacet extends AbstractProjectFacet implements DependencyFacet
{
   @Override
   public boolean install()
   {
      return false;
   }

   @Override
   public boolean isInstalled()
   {
      return false;
   }

   @Override
   public void addDirectDependency(Dependency dep)
   {
   }

   @Override
   public void addManagedDependency(Dependency managedDependency)
   {
   }

   @Override
   public void addDirectManagedDependency(Dependency dep)
   {
   }

   @Override
   public void addRepository(String name, String url)
   {
   }

   @Override
   public List<Dependency> getDependencies()
   {
      return null;
   }

   @Override
   public List<Dependency> getDependenciesInScopes(String... scopes)
   {
      return null;
   }

   @Override
   public Dependency getDirectDependency(Dependency dependency)
   {
      return null;
   }

   @Override
   public List<Dependency> getEffectiveDependencies()
   {
      return null;
   }

   @Override
   public List<Dependency> getEffectiveDependenciesInScopes(String... scopes)
   {
      return null;
   }

   @Override
   public Dependency getEffectiveDependency(Dependency dependency)
   {
      return null;
   }

   @Override
   public Dependency getEffectiveManagedDependency(Dependency manDep)
   {
      return null;
   }

   @Override
   public List<Dependency> getManagedDependencies()
   {
      return null;
   }

   @Override
   public Dependency getDirectManagedDependency(Dependency managedDependency)
   {
      return null;
   }

   @Override
   public List<DependencyRepository> getRepositories()
   {
      return null;
   }

   @Override
   public boolean hasDirectDependency(Dependency dependency)
   {
      return false;
   }

   @Override
   public boolean hasEffectiveDependency(Dependency dependency)
   {
      return false;
   }

   @Override
   public boolean hasEffectiveManagedDependency(Dependency managedDependency)
   {
      return false;
   }

   @Override
   public boolean hasDirectManagedDependency(Dependency managedDependency)
   {
      return false;
   }

   @Override
   public boolean hasRepository(String url)
   {
      return false;
   }

   @Override
   public void removeDependency(Dependency dependency)
   {
   }

   @Override
   public void removeManagedDependency(Dependency managedDependency)
   {
   }

   @Override
   public DependencyRepository removeRepository(String url)
   {
      return null;
   }

   @Override
   public List<Coordinate> resolveAvailableVersions(Dependency dep)
   {
      return null;
   }

   @Override
   public List<Coordinate> resolveAvailableVersions(String gavs)
   {
      return null;
   }

   @Override
   public List<Coordinate> resolveAvailableVersions(DependencyQuery query)
   {
      return null;
   }

   @Override
   public Dependency resolveProperties(Dependency dependency)
   {
      return null;
   }

}
