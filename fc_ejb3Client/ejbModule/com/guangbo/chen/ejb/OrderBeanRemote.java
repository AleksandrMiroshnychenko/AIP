package com.guangbo.chen.ejb;

import java.util.List;
import javax.ejb.Remote;
import com.guangbo.chen.jpa.Order;
import com.guangbo.chen.jpa.Orderline;

/**
 * this is remote interface for Order EJB bean
 * @author guangbo
 */
@Remote
public interface OrderBeanRemote {
	
	//searching and getting methods
	public double getGrandTotal(List<Orderline> ols);
	public Order findOrderByOrderNumAndSurname(String orderNum, String surname);
	
	
	//admin methods
	public List<Order> findOutstandingOrders();
	public Order findOrderByOrderNumber(String orderNumber);
	public void updateOrderStatus(String orderNumber, String status);
	
	//supplier methods
	public List<Order> findPaidOrders();
	public boolean updatePaidOrder(String orderNumber, String status);

}
