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

import java.beans.PropertyChangeListener;
import javax.enterprise.deploy.model.*;
import javax.enterprise.deploy.spi.exceptions.ConfigurationException;
import javax.enterprise.deploy.spi.exceptions.BeanNotFoundException;

/**
 * The DConfigBean is a deployment configuration bean (DConfigBean)
 * that is associated with one or more deployment descriptor beans, 
 * (DDBean). A DConfigBean represents a logical grouping of deployment 
 * configuration data to be presented to the Deployer.  A DConfigBean
 * provides zero or more XPaths that identifies the XML information 
 * it requires.  A DConfigBean may contain other DConfigBeans and 
 * regular JavaBeans.  The top most DConfigBean is a DConfigBeanRoot 
 * object which represents a single XML instance document.
 * 
 * <p>
 * A DConfigBean is created by calling DConfigBean.getDConfigBean(DDBean)
 * method, where DConfigBean is the object that provided the XPath which 
 * the DDBean represents.
 * 
 * <p>
 * A DConfigBean is a JavaBean component that presents the dynamic 
 * deployment configuration information for a Jakarta EE plugin to the deployer.
 * It is a JavaBean.  The JavaBean architecture was chosen because
 * of its versatility in providing both simple and complex components.
 * JavaBeans also enable the development of property sheets and property
 * editors, as well as sophisticated customization wizards.
 * 
 * <p>
 * It is expected that a plugin vendor will provide a Property Editor 
 * for any complex datatype in a DConfigBean that a deployer needs to edit
 * through a property sheet.  The Property Editor should be implemented 
 * and made available to a tool according to the guidelines defined in the 
 * JavaBeans API Specification version 1.01.
 */
public interface DConfigBean 
{
        
   /**
    * Return the JavaBean containing the deployment
    * descriptor XML text associated with this DConfigBean.
    * @return The bean class containing the XML text for
    *       this DConfigBean.
    */   
   public DDBean getDDBean();
   
    /**
     * Return a list of XPaths designating the deployment descriptor
     * information this DConfigBean requires.
     *
     * A given server vendor will need to specify some server-specific
     * information.  Each String returned by this method is an XPath
     * describing a certain portion of the standard deployment descriptor
     * for which there is corresponding server-specific configuration.
     *
     * @return a list of XPath Strings representing XML data to be retrieved
     *        or 'null' if there are none.
     */    
    public String[] getXpaths();
    
    /**
     * Return the JavaBean containing the server-specific deployment 
     * configuration information based upon the XML data provided 
     * by the DDBean.
     *
     * @return The DConfigBean to display the server-specific properties 
     *         for the standard bean.
     * @param bean The DDBean containing the XML data to be 
     *        evaluated.
     * @throws ConfigurationException reports errors in generating
     *           a configuration bean. This DDBean is considered
     *           undeployable to this server until this exception
     *           is resolved.  
     *           A suitably descriptive message is required so the user 
     *           can diagnose the error.
     */    
    public DConfigBean getDConfigBean(DDBean bean) 
               throws ConfigurationException;

    /** 
     * Remove a child DConfigBean from this bean.
     *
     * @param bean The child DConfigBean to be removed.
     * @throws BeanNotFoundException the bean provided 
     *         is not in the child list of this bean.
     */
    public void removeDConfigBean(DConfigBean bean)
           throws BeanNotFoundException;


    /** 
     * A notification that the DDBean provided in the
     * event has changed and this bean or its child beans need 
     * to reevaluate themselves.
     *
     * @param event an event containing a reference to the
     *        DDBean which has changed. 
     */
	public void notifyDDChange(XpathEvent event);
    
    /** 
     * Register a property listener for this bean.
     * @param pcl PropertyChangeListener to add
     */
   public void addPropertyChangeListener(PropertyChangeListener pcl);

   /** 
    * Unregister a property listener for this bean.
    * @param pcl Listener to remove.
    */
   public void removePropertyChangeListener(PropertyChangeListener pcl);

}
