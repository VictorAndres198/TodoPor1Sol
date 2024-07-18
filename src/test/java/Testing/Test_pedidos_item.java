
package Testing;


import DAO.DAOItems;


public class Test_pedidos_item {
    public static void main(String[] args) {
        DAOItems daoItems = new DAOItems();
        long id=2;
        System.out.println("items con id de pedido "+id+" tenemos "+daoItems.FindById(id)); 
        
    }
    
}
