package com.example.finaltest02.impl;/*Welcome to my show !

@author: NgKhanh
Date: 6/26/2023
Time: 7:31 PM

ProjectName: finalTest02*/

import com.example.finaltest02.JpaExecutors;
import com.example.finaltest02.annotation.Column;
import com.example.finaltest02.annotation.Entity;
import com.example.finaltest02.annotation.Id;
import com.example.finaltest02.config.DBConnection;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JpaExecuterImpl<T> implements JpaExecutors<T> {
    private Class<T> clazz;
    private String className;
    private String tableName;

    public JpaExecuterImpl(Class<T> clazz){
        this.clazz = clazz;
        this.className = clazz.getSimpleName();
        this.tableName = (clazz.getAnnotation(Entity.class) != null) ? clazz.getAnnotation(Entity.class).tablename() :
                this.className.toLowerCase();
    }

    public List<T> entityParser(ResultSet rs){
        List<T> entitys = new ArrayList<>();
        try {
            while(rs.next()){
                T entity = clazz.getDeclaredConstructor().newInstance();
                for(Field f : entity.getClass().getDeclaredFields()){
                    String columnName = f.getName();
                    if (f.isAnnotationPresent(Column.class) && !StringUtils.isEmpty(f.getAnnotation(Column.class).name())) {
                        Column columnInfo = f.getAnnotation(Column.class);
                        //todo: chưa lấy ra được id
                        columnName = columnInfo.name();
                        f.setAccessible(true);
                        switch (columnInfo.dataType()) {
                            case INTEGER:
                                f.set(entity, rs.getInt(columnName));
                                break;
                            case TEXT:
                                f.set(entity, rs.getString(columnName));
                                break;
                            case BIG_INTEGER:
                                f.set(entity, rs.getInt(columnName));
                                break;
                            case SMALL_INTEGER:
                                f.set(entity, rs.getInt(columnName));
                                break;
                            case DATE:
                                f.set(entity, rs.getDate(columnName));
                                break;
                            case FLOAT:
                                f.set(entity, rs.getFloat(columnName));
                                break;
                            case DOUBLE:
                                f.set(entity, rs.getInt(columnName));
                                break;
                            // todo : Làm tiếp tục với các kiểu dữ liệu còn lại
                            // fixme: Fix nốt đê
                        }
                    }
                    if (f.isAnnotationPresent(Id.class) && !StringUtils.isEmpty(f.getAnnotation(Id.class).name())){
                        Id id = f.getAnnotation(Id.class);
                        f.setAccessible(true);
                        f.set(entity, rs.getInt(id.name()));
                        System.err.println(entity);
                    }
                }
                entitys.add(entity);
            }
        }
        catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            throw new RuntimeException();
        }

        return entitys;
    }
    public List<T> findall(){
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM employee");

            ResultSet rs = preparedStatement.executeQuery();
            return entityParser(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn!=null && !conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void createNew(String fullname, String birthDate, String position, String address, String department) throws SQLException {
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO employee(fullName, address, birthDay, position, department) VALUE("
                + "'" + fullname + "'" + "," + "'" + birthDate + "'" + "," + "'" + address + "'" + "," + "'" + position + "'" + "," + "'" + department + "'" + ")");

        preparedStatement.executeUpdate();
        System.out.println(preparedStatement);
    }

    public T getById(String id){
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM employee WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = preparedStatement.executeQuery();
            return entityParser(rs).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(String id){
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement("DELETE FROM employee WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateId(String id, String fullname, String address, String position, String birthDate, String department){
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement("UPDATE employee SET fullName = " + "'" + fullname + "'" + "," + "address = " + "'" + address + "'" + "," + "birthDay = " + "'" + birthDate + "'" + "," + "position = " + "'" + position + "'" + "," + "department = " + "'" + department + "'" + " WHERE id = " + id);
            System.err.println(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
