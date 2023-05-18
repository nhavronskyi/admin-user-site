# **adminUserSite**

## TECHNOLOGIES

1. servlets
2. tomcat 10
3. jdbc
4. postgresql

## QUICKSTART

### STEP 1

You need to create database postgres with table users:

**db name: postgres**

**db password: rootroot**

```sql
create table if not exists users
(
    id serial constraint pk_users primary key,
    uname varchar(100) not null,
    upass varchar(100) not null,
    utype varchar(100) not null
);
```

### STEP 2

Configure your tomcat and start server

### STEP 3

You can reach this site with this url: http://localhost:8080/adminUserSite/
