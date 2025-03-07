/*
 * This file is generated by jOOQ.
 */
package com.jooq.coversionIssue.jooq.codegen.tables;


import com.jooq.coversionIssue.jooq.codegen.Keys;
import com.jooq.coversionIssue.jooq.codegen.Public;
import com.jooq.coversionIssue.jooq.codegen.tables.records.TesttableRecord;

import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultDataType;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.postgres.extensions.bindings.CitextBinding;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Testtable extends TableImpl<TesttableRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.testtable</code>
     */
    public static final Testtable TESTTABLE = new Testtable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TesttableRecord> getRecordType() {
        return TesttableRecord.class;
    }

    /**
     * The column <code>public.testtable.id</code>.
     */
    public final TableField<TesttableRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.testtable.name_varchar</code>.
     */
    public final TableField<TesttableRecord, String> NAME_VARCHAR = createField(DSL.name("name_varchar"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.testtable.name_text</code>.
     */
    public final TableField<TesttableRecord, String> NAME_TEXT = createField(DSL.name("name_text"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.testtable.name_citext</code>.
     */
    public final TableField<TesttableRecord, String> NAME_CITEXT = createField(DSL.name("name_citext"), DefaultDataType.getDefaultDataType("\"public\".\"citext\""), this, "", new CitextBinding());

    private Testtable(Name alias, Table<TesttableRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Testtable(Name alias, Table<TesttableRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.testtable</code> table reference
     */
    public Testtable(String alias) {
        this(DSL.name(alias), TESTTABLE);
    }

    /**
     * Create an aliased <code>public.testtable</code> table reference
     */
    public Testtable(Name alias) {
        this(alias, TESTTABLE);
    }

    /**
     * Create a <code>public.testtable</code> table reference
     */
    public Testtable() {
        this(DSL.name("testtable"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<TesttableRecord> getPrimaryKey() {
        return Keys.TESTTABLE_PKEY;
    }

    @Override
    public Testtable as(String alias) {
        return new Testtable(DSL.name(alias), this);
    }

    @Override
    public Testtable as(Name alias) {
        return new Testtable(alias, this);
    }

    @Override
    public Testtable as(Table<?> alias) {
        return new Testtable(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Testtable rename(String name) {
        return new Testtable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Testtable rename(Name name) {
        return new Testtable(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Testtable rename(Table<?> name) {
        return new Testtable(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Testtable where(Condition condition) {
        return new Testtable(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Testtable where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Testtable where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Testtable where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Testtable where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Testtable where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Testtable where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Testtable where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Testtable whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Testtable whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
