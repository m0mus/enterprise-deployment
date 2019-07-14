/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package javax.enterprise.deploy.model;

import javax.enterprise.deploy.shared.ModuleType;

/**
 * J2eeApplicationObject is an interface that represents a Jakarta EE
 * application (EAR); it maintains a DeployableObject for each 
 * module in the archive.
 */
public interface J2eeApplicationObject extends DeployableObject {
    
    /**
     * Return the DeployableObject of the specified URI designator.
     * @param uri Describes where to get the module from.
     * @return the DeployableObject describing the j2ee module at this uri
     *        or 'null' if there is not match.
     */
    public DeployableObject getDeployableObject(String uri);
    
    /**
     * Return the all DeployableObjects of the specified type.
     * @param type The type of module to return.
     * @return the list of DeployableObjects describing the j2ee module 
     *         at this uri or 'null' if there are no matches.
     */
    public DeployableObject[] getDeployableObjects(ModuleType type);
    
    /**
     * Return the all DeployableObjects in this application.
     * @return the DeployableObject describing the j2ee module at this uri
     *          or 'null' if there are no matches.
     */
    public DeployableObject[] getDeployableObjects();
        
    /**
     * Return the list of URIs of the designated module type.
     * @param type The type of module to return.
     * @return the Uris of the contained modules or 'null' if there
     *       are no matches.
     */
    public String[] getModuleUris(ModuleType type);
    
    /**
     * Return the list of URIs for all modules in the application.
     * @return the Uris of the contained modules or 'null' if there
     *       are no matches.
     */
    public String[] getModuleUris();
    
    /**
     * Return a list of DDBean based upon an XPath; all
     * deployment descriptors of the specified type are searched.
     *
     * @param type The type of deployment descriptor to query.
     * @param xpath An XPath string referring to a location in the
     *         deployment descriptor
     * @return The list of DDBeans or 'null' of there are no matches.
     */   
   public DDBean[] getChildBean(ModuleType type, String xpath);
   
   /**
    * Return the text value from the XPath; search only the 
    * deployment descriptors of the specified type. 
    *
    * @param type The type of deployment descriptor to query.
    * @param xpath An xpath string referring to a location in the
    *             deployment descriptor
    * @return The text values of this xpath or 'null' if there are no
    *          matches.
    */   
   public String[] getText(ModuleType type, String xpath);
   
   /**
    * Register a listener for changes in XPath that are related
    * to this deployableObject.
    *
    * @param type The type of deployment descriptor to query.
    * @param xpath The xpath to listen for.
    * @param xpl The listener.
    */   
   public void addXpathListener(ModuleType type, String xpath, 
		XpathListener xpl);
   
   /** 
    * Unregister the listener for an XPath.
    *
    * @param type The type of deployment descriptor to query.
    * @param xpath he XPath to listen for
    * @param xpl The listener
    */   
   public void removeXpathListener(ModuleType type, String xpath, 
		XpathListener xpl);
   
}

