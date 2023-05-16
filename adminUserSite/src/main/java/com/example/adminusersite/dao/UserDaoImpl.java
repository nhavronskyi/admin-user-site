package com.example.adminusersite.dao;

import com.example.adminusersite.user.User;
import lombok.SneakyThrows;
import org.postgresql.ds.PGSimpleDataSource;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final PGSimpleDataSource dataSource = new PGSimpleDataSource();

    public UserDaoImpl() {
        dataSource.setURL("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUser("postgres");
        dataSource.setPassword("rootroot");
    }

    @SneakyThrows
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (var connection = dataSource.getConnection()) {
            try (var statement = connection.createStatement()) {
                var resultSet = statement.executeQuery("select * from users where utype not like 'admin'");
                while (resultSet.next()) {
                    var id = resultSet.getInt("id");
                    var name = resultSet.getString("uname");
                    var pass = resultSet.getString("upass");
                    var type = resultSet.getString("utype");
                    users.add(new User(id, name, pass, type));
                }
            }
        }
        return users;
    }

    @SneakyThrows
    public User findUser(String uname, String upass) {
        User user = new User();
        try (var connection = dataSource.getConnection()) {
            try (var statement = connection.createStatement()) {
                String query = "select * from users where uname like '%s' and upass like '%s'";
                var resultSet = statement.executeQuery(String.format(query, uname, upass));
                while (resultSet.next()) {
                    var id = resultSet.getInt("id");
                    var name = resultSet.getString("uname");
                    var pass = resultSet.getString("upass");
                    var type = resultSet.getString("utype");
                    user = new User(id, name, pass, type);
                }
            }
        }
        return user;
    }

    @SneakyThrows
    public void createUser(String uname, String upass) {
        try (var connection = dataSource.getConnection()) {
            try (var statement = connection.createStatement()) {
                String query = "insert into users (uname, upass, utype) values ('%s', '%s', 'user')";
                statement.executeUpdate(String.format(query, uname, upass));
            }
        }
    }

    @SneakyThrows
    public void deleteUser(int id) {
        try (var connection = dataSource.getConnection()) {
            try (var statement = connection.createStatement()) {
                String query = "delete from users where id = " + id;
                statement.executeUpdate(query);
            }
        }
    }

    @SneakyThrows
    public void updateUser(String uname, String upass, int id) {
        try (var connection = dataSource.getConnection()) {
            try (var statement = connection.createStatement()) {
                String query = "update users set uname = '%s', upass = '%s' where id = " + id;
                statement.executeUpdate(String.format(query, uname, upass));
            }
        }
    }
}
