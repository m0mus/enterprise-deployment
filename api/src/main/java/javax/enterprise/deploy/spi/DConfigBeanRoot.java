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

package javax.enterprise.deploy.spi;

import javax.enterprise.deploy.model.DDBeanRoot;

/**
 * A Jakarta EE component module consists of one or more deployment
 * descriptor files and zero or more non-deployment descriptor 
 * XML instance documents.  A module must contain a component-specific 
 * deployment descriptor file (see the component specification for 
 * details). It may contain one or more secondary deployment descriptor 
 * files that define extra functionality on the component and zero or more 
 * non-deployment descriptor XML instance documents (see the Web Services 
 * specification).
 *
 * <p>
 * The DConfigBeanRoot object is a deployment configuration bean 
 * (DConfigBean) that is associated with the root of the component's 
 * deployment descriptor. It must be created by calling the 
 * DeploymentConfiguration.getDConfigBean(DDBeanRoot) method, where 
 * DDBeanRoot represents the component's deployment descriptor.
 *
 * <p>
 * A DConfigBean object is associated with a deployment descriptor 
 * that extends a component's functionality.  It must be created by 
 * calling the DConfigBeanRoot.getDConfigBean(DDBeanRoot) method. This 
 * DConfigBean object is a child of the compontent's DConfigBeanRoot 
 * object.  The DDBeanRoot argument represents the secondary deployment 
 * descriptor.  Deployment  descriptor files  such as webservice.xml and 
 * webserviceclient.xml are examples of secondary deployment descriptor 
 * files.
 *
 * <p>
 * The server plugin must request a DDBeanRoot object for any non-deployment 
 * descriptor XML instance document data it requires.  The plugin must 
 * call method DeployableObject.getDDBeanRoot(String) where String is the 
 * full path name from the root of the module to the file to be represented. 
 * A WSDL file is an example of a non-deployment descriptor XML instance 
 * document.
 *
 * @author  gfink
 */
public interface DConfigBeanRoot extends DConfigBean {

    /**
     * Return a DConfigBean for a deployment descriptor that is not 
     * the module's primary deployment descriptor.   Web services 
     * provides a deployment descriptor in addition to the module's 
     * primary deployment descriptor.  Only the DDBeanRoot for this 
     * catagory of secondary deployment descriptors are to be passed 
     * as arguments through this method.  
     *
     * Web service has two deployment descriptor files, one that defines 
     * the web service and one that defines a client of a web service.
     * See the Web Service specificiation for the details.

     *
     * @param ddBeanRoot represents the root element of a deployment 
     *    descriptor file. 
     *
     * @return a DConfigBean to be used for processing this deployment 
     *   descriptor data. Null may be returned if no DConfigBean is 
     *   required for this deployment descriptor. 
     */ 
     public DConfigBean getDConfigBean(DDBeanRoot ddBeanRoot); 
}

