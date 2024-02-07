  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;



/**
 *
 * @author apple
 */
public class Tables {
    public static void main(String[] args) {
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            //st.executeUpdate("Create table appuser(appuser_pk int AUTO_INCREMENT primary key,UserRole varchar(50),name varchar(100), dob varchar(50), MobileNumber varchar(10), Email varchar(50), Username varchar(50), Password varchar(50), Address varchar(50)) ");
           // st.executeUpdate("Insert into appuser(UserRole,name,dob,MobileNumber,Email,Username,Password,Address) values('Admin','Admin','03-07-2002','7023012435','admin@email.com','admin','admin','Bhilwara, Rajasthan')");
            //st.executeUpdate("Create table medicine(medicine_pk int AUTO_INCREMENT primary key,uniqueId varchar(50),name varchar(100), companyName varchar(50), quantity bigint, price bigint) ");
            st.executeUpdate("Create table bill(bill_pk int AUTO_INCREMENT primary key,billId varchar(50),billDate varchar(100), totalPaid bigint, generatedBy varchar(50))");

            JOptionPane.showMessageDialog(null,"Tabe created successfuly");
        }
        catch (Exception e ){
                    JOptionPane.showMessageDialog(null,e);

        }
    }
}
