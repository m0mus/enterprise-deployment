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
 * An interface that represents the root of a standard deployment 
 * descriptor.  A DDBeanRoot is a type of DDBean.
 *
 * @author gfink
 */
public interface DDBeanRoot extends DDBean {
    
    /**
     * Return the ModuleType of deployment descriptor.
     *
     * @return The ModuleType of deployment descriptor
     */   
   public ModuleType getType();
   
   /**
    * Return the containing DeployableObject
    * @return The DeployableObject that contains this
    *           deployment descriptor
    */   
   public DeployableObject getDeployableObject();
   
   /**
    * A convenience method to return the DTD version number.
    * The DeployableObject has this information.
    * @return a string containing the DTD version number
    *
    * This method is being deprecated. Two DD data formats
    * are being used, DTD and XML Schema.  DDBeanRoot.getDDBeanRootVersion
    * should be used in its place.
    *
    * @deprecated As of version 1.1 replaced by 
    * DDBeanRoot.getDDBeanRootVersion()
    */
   public String getModuleDTDVersion();

   /** 
    * Returns the version number of an XML instance document.
    * This method is replacing the methods DDBeanRoot.getModuleDTDVersion 
    * and DeployableObject.getModuleDTDVersion. This method returns 
    * the version number of any Jakarta EE XML instance document.
    *
    * @return a string that is the version number of the XML instance 
    *   document. Null is returned if no version number can be found. 
    */ 
   public String getDDBeanRootVersion(); 

    /**
     * Return the XPath for this standard bean.
     * The root XPath is "/".
     * @return "/" this is the root standard bean.
     */
    public String getXpath();

    /**
     * Returns the filename relative to the root of the module 
     * of the XML instance document this DDBeanRoot represents. 
     *
     * @return String the filename relative to the root of the module 
     */ 
   public String getFilename(); 
}

