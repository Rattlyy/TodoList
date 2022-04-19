/*
 * This file is generated by jOOQ.
 */
package it.rattly.todo.db.generated;


import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Todos extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>todos</code>
     */
    public static final Todos TODOS = new Todos();

    /**
     * The table <code>todos.todos</code>.
     */
    public final it.rattly.todo.db.generated.tables.Todos TODOS_ = it.rattly.todo.db.generated.tables.Todos.TODOS_;

    /**
     * No further instances allowed
     */
    private Todos() {
        super("todos", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            it.rattly.todo.db.generated.tables.Todos.TODOS_
        );
    }
}
