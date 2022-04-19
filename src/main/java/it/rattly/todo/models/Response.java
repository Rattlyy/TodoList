package it.rattly.todo.models;

import java.io.Serializable;

public record Response(boolean ok, Object value) implements Serializable {

}
