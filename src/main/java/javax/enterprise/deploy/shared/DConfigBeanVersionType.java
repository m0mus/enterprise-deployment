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
 * Class DConfigBeanVersionTypes defines enumeration values for the J2EE
 * Platform verion number.
 *
 * @author  rsearls
 */
public class DConfigBeanVersionType 
{
	private int value; // This enumeration value's int value

	/**
     * J2EE Platform version 1.3
	 */
    public static final DConfigBeanVersionType V1_3 = 
		new DConfigBeanVersionType(0);

	/**
     * J2EE Platform version 1.3.1
     * THIS CONSTANT SHOULD NEVER BE USED.  Use V1_3 instead.
	 */
    public static final DConfigBeanVersionType V1_3_1 = 
		new DConfigBeanVersionType(1);

    /**
     * J2EE Platform version 1.4
     */
    public static final DConfigBeanVersionType V1_4 =
        new DConfigBeanVersionType(2);

    /**
     * Java EE Platform version 5
     */
    public static final DConfigBeanVersionType V5 =
            new DConfigBeanVersionType(3);

	private static final String[] stringTable = {
	"V1_3",
	"V1_3_1",
	"V1_4",
        "V5"
	};

	private static final DConfigBeanVersionType[] enumValueTable = {
	V1_3,
	V1_3_1,
	V1_4,
        V5
	};


    /**
     * Construct a new enumeration value with the given integer value.
     *
     * @param  value  Integer value.
     */
    protected DConfigBeanVersionType(int value) 
    {   this.value = value;
    }

    /**
     * Returns this enumeration value's integer value.
     * @return the value
     */
    public int getValue()
    {   return value;
    }

       
	/**
	 * Returns the string table for class DConfigBeanVersionType
	 */
	protected String[] getStringTable()
	{
		return stringTable;
	}

	/**
	 * Returns the enumeration value table for class DConfigBeanVersionType
	 */
	protected DConfigBeanVersionType[] getEnumValueTable()
	{
		return enumValueTable;
	}

    /**
     * Return an object of the specified value.
     * @param value a designator for the object.
     */
    public static DConfigBeanVersionType getDConfigBeanVersionType(int value)
    {   return enumValueTable[value];
    }

    /**
     * Return the string name of this DConfigBeanVersionType or the
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
