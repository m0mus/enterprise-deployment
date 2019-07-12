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

package javax.enterprise.deploy.shared;

/**
 * Class CommandTypes defines enumeration values for the 
 * DeploymentStatus object.
 *
 * @author  rsearls
 */
public class CommandType
{
	private int value; // This enumeration value's int value

	/**
     * The DeploymentManger action operation being processed
     * is distribute.
     */
	public static final CommandType DISTRIBUTE = new CommandType(0);
	/**
     * The DeploymentManger action operation being processed is start.
     */
    public static final CommandType START = new CommandType(1);
	/**
     * The DeploymentManger action operation being processed is stop.
     */
    public static final CommandType STOP = new CommandType(2);
	/**
     * The DeploymentManger action operation being processed is undeploy.
     */
    public static final CommandType UNDEPLOY = new CommandType(3);
	/**
     * The DeploymentManger action operation being processed is redeploy.
     */
    public static final CommandType REDEPLOY = new CommandType(4);


	private static final String[] stringTable = {
	"distribute",
	"start",
	"stop",
	"undeploy",
	"redeploy",
	};

	private static final CommandType[] enumValueTable = {
	DISTRIBUTE,
	START,
	STOP,
	UNDEPLOY,
	REDEPLOY,
	};
    
    /**
     * Construct a new enumeration value with the given integer value.
     *
     * @param  value  Integer value.
     */
    protected CommandType(int value) 
    {
		this.value = value;
    }
       
    /**
     * Returns this enumeration value's integer value.
     * @return the value
     */
    public int getValue()
    {   return value;
    }

	/**
	 * Returns the string table for class CommandType
	 */
	protected String[] getStringTable()
	{
		return stringTable;
	}

	/**
	 * Returns the enumeration value table for class CommandType
	 */
	protected CommandType[] getEnumValueTable()
	{
		return enumValueTable;
	}

    /**
     * Return an object of the specified value.
     * @param value a designator for the object.
     */
    public static CommandType getCommandType(int value)
    {   return enumValueTable[value];
    }

    /**
     * Return the string name of this CommandType or the
     * integer value if outside the bounds of the table
     */
    public String toString()
    {
        String[] strTable = getStringTable();
        int index = value - getOffset();
        if (strTable != null && index >= 0 && index < strTable.length)
            return strTable[index];
        else
            return Integer.toString (value);
    }

    /**
     * Returns the lowest integer value used by this enumeration value's
     * enumeration class.
     * <P>
     * The default implementation returns 0.
     * @return the offset of the lowest enumeration value.
     */
    protected int getOffset()
    {   return 0;
    }

}
