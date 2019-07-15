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

/*
 * Configurator.java
 *
 * Created on May 14, 2001, 4:25 PM
 */

package javax.enterprise.deploy.spi;

import javax.enterprise.deploy.model.*;
import javax.enterprise.deploy.spi.exceptions.ConfigurationException;
import javax.enterprise.deploy.spi.exceptions.BeanNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * An interface that defines a container for all the 
 * server-specific configuration information for a 
 * single top-level Jakarta EE module.  The DeploymentConfiguration
 * object could represent a single stand alone module or an 
 * EAR file that contains several sub-modules.
 *
 * @author gfink
 * @version 0.1
 */
public interface DeploymentConfiguration {
    
    /**
	 * Returns an object that provides access to
     * the deployment descriptor data and classes
     * of a Java EE module.
     * @return DeployableObject
     */
    public DeployableObject getDeployableObject();
        
    /**
     * Returns the top level configuration bean, DConfigBeanRoot,
     * associated with the deployment descriptor represented by
     * the designated DDBeanRoot bean.
     *
     * @param bean The top level bean that represents the 
     *       associated deployment descriptor.
     * @return the DConfigBeanRoot for editing the server-specific 
     *           properties required by the module.
     * @throws ConfigurationException reports errors in generating 
     *           a configuration bean
     */    
    public DConfigBeanRoot getDConfigBeanRoot(DDBeanRoot bean) 
           throws ConfigurationException;
    
    /**
     * Remove the root DConfigBean and all its children.
     *
     * @param bean the top leve DConfigBean to remove.
     * @throws BeanNotFoundException  the bean provides is
     *      not in this beans child list.
     */    
	public void removeDConfigBean(DConfigBeanRoot bean)
        throws BeanNotFoundException;

    /**
	 * Restore from disk to instantated objects all the DConfigBeans 
     * associated with a specific deployment descriptor. The beans
     * may be fully or partially configured.
     * @param inputArchive The input stream for the file from which the 
     *         DConfigBeans should be restored.
     * @param bean The DDBeanRoot bean associated with the 
     *         deployment descriptor file.
     * @return The top most parent configuration bean, DConfigBeanRoot
     * @throws ConfigurationException reports errors in generating 
     *           a configuration bean
     */    
    public DConfigBeanRoot restoreDConfigBean(InputStream inputArchive, 
           DDBeanRoot bean) throws ConfigurationException;
    
    /**
     * Save to disk all the configuration beans associated with 
     * a particular deployment descriptor file.  The saved data  
     * may be fully or partially configured DConfigBeans. The 
     * output file format is recommended to be XML.
     * @param outputArchive The output stream to which the DConfigBeans 
     *        should be saved.
     * @param bean The top level bean, DConfigBeanRoot, from which to be save.
     * @throws ConfigurationException reports errors in generating 
     *           a configuration bean
     */    
    public void saveDConfigBean(OutputStream outputArchive,DConfigBeanRoot bean)
            throws ConfigurationException;
    
    /** 
	 * Restore from disk to a full set of configuration beans previously
     * stored.
     * @param inputArchive The input stream from which to restore 
     *       the Configuration.
     * @throws ConfigurationException reports errors in generating 
     *           a configuration bean
     */    
     public void restore(InputStream inputArchive) throws 
            ConfigurationException;
    
    /** 
	 * Save to disk the current set configuration beans created for
     * this deployable module. 
     * It is recommended the file format be XML.
     *
     * @param outputArchive The output stream to which to save the 
     *        Configuration.
     * @throws ConfigurationException
     */    
    public void save(OutputStream outputArchive) throws 
            ConfigurationException;
    
}

