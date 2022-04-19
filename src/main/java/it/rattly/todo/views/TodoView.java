package it.rattly.todo.views;

import it.rattly.todo.db.generated.tables.daos.TodosDao;
import it.rattly.todo.db.generated.tables.pojos.Todos;

import java.util.List;

public class TodoView {
    private final List<Todos> todos;

    public TodoView(TodosDao todosDao) {
        this.todos = todosDao.findAll();
    }

    public List<Todos> getTodos() {
        return todos;
    }

    /**
     * The code down here is for dividing cards into groups of three
     */

    boolean hasDone;
    boolean end;

    int i = 0;
    int max = 4;

    public boolean shouldAddRow() {
        if (!hasDone) {
            hasDone = true;
            return true;
        }

        i += 1;

        if (i == max) {
            i = 0;
            return true;
        } else {
            if (i == (max - 1)) {
                end = true;
            }

            return false;
        }
    }

    public boolean shouldEndRow() {
        if (end) {
            end = false;
            return true;
        } else {
            return false;
        }
    }
}
