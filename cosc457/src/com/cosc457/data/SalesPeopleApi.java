package com.cosc457.data;

import com.cosc457.models.SalesPeople;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class SalesPeopleApi {
    private static Database database = Database.getInstance();

    public static void saveSalesPeople(SalesPeople s){
        String values ="'"+s.getFirstName() + "', '" + s.getLastName()+"', '"+s.getSalary() + "', '" + s.getDob()+"', '"+s.getHireDate() + "', '" + s.getPhone()+"', '"+s.getEmail() + "'";
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO SalesPeople(FirstName, LastName, Salary, DateofBirth, HireDate, PhoneNumber, Email) VALUES("+values+");");
        try {
            database.insert(query.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void updateSalespeople(SalesPeople c){
        String query = String.format("UPDATE SalesPeople SET FirstName = '%s' , LastName = '%s' , Salary = '%s', DateofBirth = '%s', HireDate = '%s', PhoneNumber = '%s' , Email = '%s' WHERE `Employee ID` = '%s'; ", c.getFirstName(), c.getLastName(), c.getSalary(), c.getDob(), c.getHireDate(), c.getPhone(), c.getEmail(), c.getID());
        try {
            database.insert(query);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


    public static void deleteSalesPeople(SalesPeople s){
        int id = s.getID();
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM SalesPeople WHERE `Employee ID` ='"+id+"';");
        try {
            database.insert(query.toString());
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static ArrayList<SalesPeople> getAllEmployees(){
        ArrayList<SalesPeople> result = new ArrayList<SalesPeople>();
        String query = "SELECT * FROM SalesPeople";
        try {
            for(Object o : database.retrieve(query, SalesPeople.class)){
               result.add((SalesPeople)o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
