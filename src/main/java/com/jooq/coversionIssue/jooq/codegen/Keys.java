/*
 * This file is generated by jOOQ.
 */
package com.jooq.coversionIssue.jooq.codegen;


import com.jooq.coversionIssue.jooq.codegen.tables.Testtable;
import com.jooq.coversionIssue.jooq.codegen.tables.records.TesttableRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<TesttableRecord> TESTTABLE_PKEY = Internal.createUniqueKey(Testtable.TESTTABLE, DSL.name("testtable_pkey"), new TableField[] { Testtable.TESTTABLE.ID }, true);
}
