package it.rattly.todo.controllers;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import it.rattly.todo.db.Jooq;
import it.rattly.todo.db.generated.tables.daos.TodosDao;
import it.rattly.todo.models.Response;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static it.rattly.todo.db.generated.Tables.TODOS_;

public record TodoController(TodosDao todosDao, Jooq jooq) implements CrudHandler {
    @Override
    public void create(@NotNull Context ctx) {
        String value = ctx.queryParamAsClass("value", String.class).check(Objects::nonNull,
                "Required query parameter \"value\"").get();

        ctx.status(300).json(
                new Response(true,
                        jooq.get()
                                .transactionResult(configuration -> {
                                    configuration.dsl()
                                            .insertInto(TODOS_)
                                            .values(0, value, false)
                                            .execute();

                                    return configuration.dsl().lastID();
                                }).intValue()
                )
        );
    }

    @Override
    public void delete(@NotNull Context ctx, @NotNull String s) {
        Integer id = ctx.pathParamAsClass("id", Integer.class).check(Objects::nonNull,
                "Required path parameter \"id\"").get();

        todosDao.deleteById(id);
        ctx.status(200).json(new Response(true, "Deleted"));
    }

    @Override
    public void getAll(@NotNull Context ctx) {
        ctx.status(200).json(new Response(true, todosDao.findAll()));
    }

    @Override
    public void getOne(@NotNull Context ctx, @NotNull String s) {
        Integer id = ctx.pathParamAsClass("id", Integer.class).check(Objects::nonNull,
                "Necessario path parameter \"id\"").get();

        ctx.status(200).json(new Response(true, todosDao.fetchOneById(id)));
    }

    @Override
    public void update(@NotNull Context ctx, @NotNull String s) {
        Integer id = ctx.pathParamAsClass("id", Integer.class).check(Objects::nonNull,
                "Required path parameter \"id\"").get();

        Integer done = ctx.queryParamAsClass("done", Integer.class).check(i -> i == 0 || i == 1,
                "\"done\" can only be 1 or 0.").get();

        jooq.get()
                .update(TODOS_)
                .set(TODOS_.DONE, done.byteValue())
                .where(TODOS_.ID.eq(id))
                .execute();

        ctx.status(200).json(new Response(true, "Updated"));
    }
}
