/*
 * This file is generated by jOOQ.
 */
package com.jooq.coversionIssue.jooq.codegen.tables.records;


import com.jooq.coversionIssue.jooq.codegen.tables.Testtable;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TesttableRecord extends UpdatableRecordImpl<TesttableRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.testtable.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.testtable.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.testtable.name_varchar</code>.
     */
    public void setNameVarchar(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.testtable.name_varchar</code>.
     */
    public String getNameVarchar() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.testtable.name_text</code>.
     */
    public void setNameText(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.testtable.name_text</code>.
     */
    public String getNameText() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.testtable.name_citext</code>.
     */
    public void setNameCitext(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.testtable.name_citext</code>.
     */
    public String getNameCitext() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TesttableRecord
     */
    public TesttableRecord() {
        super(Testtable.TESTTABLE);
    }

    /**
     * Create a detached, initialised TesttableRecord
     */
    public TesttableRecord(Integer id, String nameVarchar, String nameText, String nameCitext) {
        super(Testtable.TESTTABLE);

        setId(id);
        setNameVarchar(nameVarchar);
        setNameText(nameText);
        setNameCitext(nameCitext);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised TesttableRecord
     */
    public TesttableRecord(com.jooq.coversionIssue.jooq.codegen.tables.pojos.Testtable value) {
        super(Testtable.TESTTABLE);

        if (value != null) {
            setId(value.getId());
            setNameVarchar(value.getNameVarchar());
            setNameText(value.getNameText());
            setNameCitext(value.getNameCitext());
            resetChangedOnNotNull();
        }
    }
}
