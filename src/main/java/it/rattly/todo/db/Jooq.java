package it.rattly.todo.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static it.rattly.todo.db.generated.tables.Todos.TODOS_;

public class Jooq {
    private final DefaultConfiguration settings = new DefaultConfiguration();

    private final String host;
    private final int port;
    private final String database;

    public Jooq(String host, int port, String database, String user, String password) {
        this.host = host;
        this.port = port;
        this.database = database;

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(jdbcURL());
        config.setDriverClassName("org.postgresql.Driver");
        config.setUsername(user);
        config.setPassword(password);
        config.setPoolName("TodoPool");

        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        config.setMaximumPoolSize(20);

        ExecutorService executorService = Executors.newCachedThreadPool();
        settings.set(executorService);
        settings.set(SQLDialect.POSTGRES);
        settings.set(new HikariDataSource(config));

        get().createTableIfNotExists(TODOS_).executeAsync();
    }

    public DSLContext get() {
        return DSL.using(settings);
    }

    public Configuration settings() {
        return settings;
    }

    private String jdbcURL() {
        return String.format("jdbc:mysql://%s:%s/%s",
                host,
                port,
                database);
    }
}