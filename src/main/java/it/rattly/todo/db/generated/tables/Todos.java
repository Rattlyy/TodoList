/*
 * This file is generated by jOOQ.
 */
package it.rattly.todo.db.generated.tables;


import it.rattly.todo.db.generated.Keys;
import it.rattly.todo.db.generated.tables.records.TodosRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Todos extends TableImpl<TodosRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>todos.todos</code>
     */
    public static final Todos TODOS_ = new Todos();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TodosRecord> getRecordType() {
        return TodosRecord.class;
    }

    /**
     * The column <code>todos.todos.id</code>.
     */
    public final TableField<TodosRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>todos.todos.value</code>.
     */
    public final TableField<TodosRecord, String> VALUE = createField(DSL.name("value"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>todos.todos.done</code>.
     */
    public final TableField<TodosRecord, Byte> DONE = createField(DSL.name("done"), SQLDataType.TINYINT.nullable(false), this, "");

    private Todos(Name alias, Table<TodosRecord> aliased) {
        this(alias, aliased, null);
    }

    private Todos(Name alias, Table<TodosRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>todos.todos</code> table reference
     */
    public Todos(String alias) {
        this(DSL.name(alias), TODOS_);
    }

    /**
     * Create an aliased <code>todos.todos</code> table reference
     */
    public Todos(Name alias) {
        this(alias, TODOS_);
    }

    /**
     * Create a <code>todos.todos</code> table reference
     */
    public Todos() {
        this(DSL.name("todos"), null);
    }

    public <O extends Record> Todos(Table<O> child, ForeignKey<O, TodosRecord> key) {
        super(child, key, TODOS_);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : it.rattly.todo.db.generated.Todos.TODOS;
    }

    @Override
    public Identity<TodosRecord, Integer> getIdentity() {
        return (Identity<TodosRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TodosRecord> getPrimaryKey() {
        return Keys.KEY_TODOS_PRIMARY;
    }

    @Override
    public Todos as(String alias) {
        return new Todos(DSL.name(alias), this);
    }

    @Override
    public Todos as(Name alias) {
        return new Todos(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Todos rename(String name) {
        return new Todos(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Todos rename(Name name) {
        return new Todos(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Byte> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
