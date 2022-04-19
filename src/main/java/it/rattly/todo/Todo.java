package it.rattly.todo;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.rendering.template.JavalinJte;
import it.rattly.todo.controllers.TodoController;
import it.rattly.todo.db.Jooq;
import it.rattly.todo.db.generated.tables.daos.TodosDao;
import it.rattly.todo.views.TodoView;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Collections;

import static io.javalin.apibuilder.ApiBuilder.crud;

public class Todo {
    public static final boolean IS_DEV = System.getenv("PROD") == null;

    public static void main(String[] args) throws URISyntaxException {
        String host;
        int port;
        String username;
        String password;
        String database;

        if (IS_DEV) {
            host = "localhost";
            port = 3306;
            username = "root";
            password = "";
            database = "todos";
        } else {
            var dbUri = new URI(System.getenv("DATABASE_URL"));

            username = dbUri.getUserInfo().split(":")[0];
            password = dbUri.getUserInfo().split(":")[1];
            database = dbUri.getPath().replace("/", "");
            host = dbUri.getHost();
            port =  dbUri.getPort();
        }

        Jooq jooq = new Jooq(host, port, database, username, password);
        TodosDao todosDao = new TodosDao(jooq.settings());

        JavalinJte.configure(createTemplateEngine());
        Javalin app = Javalin.create(config -> {
            config.enableWebjars();
            config.enableCorsForAllOrigins();
            config.enableDevLogging();

            config.addStaticFiles(staticFiles -> {
                staticFiles.hostedPath = "/assets";
                staticFiles.directory = "assets/";
                staticFiles.location = Location.CLASSPATH;
            });
        }).start(getHerokuAssignedPort());

        app.before(ctx -> {
            ctx.res.setCharacterEncoding("UTF-8");
            ctx.header("X-Author", "Rattly");
        });

        app.routes(() -> crud("todos/{id}", new TodoController(todosDao, jooq)));
        app.get("/", ctx -> ctx.render("index.jte", Collections.singletonMap("todoView", new TodoView(todosDao))));
    }

    private static TemplateEngine createTemplateEngine() {
        if (IS_DEV) {
            DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "jte"));
            return TemplateEngine.create(codeResolver, ContentType.Html);
        } else {
            return TemplateEngine.createPrecompiled(Path.of("jte-classes"), ContentType.Html);
        }
    }

    private static int getHerokuAssignedPort() {
        String herokuPort = System.getenv("PORT");
        if (herokuPort != null) {
            return Integer.parseInt(herokuPort);
        }
        return 7000;
    }
}
