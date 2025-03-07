/*
 * This file is generated by jOOQ.
 */
package com.jooq.coversionIssue.jooq.codegen.routines;


import com.jooq.coversionIssue.jooq.codegen.Public;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.DefaultDataType;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.postgres.extensions.bindings.CitextBinding;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Citext2 extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.citext.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", DefaultDataType.getDefaultDataType("\"public\".\"citext\""), false, false, new CitextBinding());

    /**
     * The parameter <code>public.citext._1</code>.
     */
    public static final Parameter<Boolean> _1 = Internal.createParameter("_1", SQLDataType.BOOLEAN, false, true);

    /**
     * Create a new routine call instance
     */
    public Citext2() {
        super("citext", Public.PUBLIC, DefaultDataType.getDefaultDataType("\"public\".\"citext\""), new CitextBinding());

        setReturnParameter(RETURN_VALUE);
        addInParameter(_1);
        setOverloaded(true);
    }

    /**
     * Set the <code>_1</code> parameter IN value to the routine
     */
    public void set__1(Boolean value) {
        setValue(_1, value);
    }

    /**
     * Set the <code>_1</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void set__1(Field<Boolean> field) {
        setField(_1, field);
    }
}
