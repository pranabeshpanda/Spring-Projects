package com.motocart.shoppingcart.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.motocart.shoppingcart.dao.TransactionDAO;
import com.motocart.shoppingcart.dao.ProductDAO;
import com.motocart.shoppingcart.entity.Transaction;
import com.motocart.shoppingcart.entity.TransactionDetails;
import com.motocart.shoppingcart.entity.Product;
import com.motocart.shoppingcart.model.CartInfo;
import com.motocart.shoppingcart.model.CartLineInfo;
import com.motocart.shoppingcart.model.CustomerInfo;
import com.motocart.shoppingcart.model.TransactionDetailInfo;
import com.motocart.shoppingcart.model.TransactionInfo;
import com.motocart.shoppingcart.model.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
 
//Transactional for Hibernate
@Transactional
public class TransactionDAOImpl implements TransactionDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    @Autowired
    private ProductDAO productDAO;
 
    private int getMaxTransactionNum() {
        String sql = "Select max(o.TX_ID) from " + Transaction.class.getName() + " o ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        Integer value = (Integer) query.uniqueResult();
        if (value == null) {
            return 0;
        }
        return value;
    }
 
    @Override
    public void saveTransaction(CartInfo cartInfo) {
        Session session = sessionFactory.getCurrentSession();
 
        int transactionNum = this.getMaxTransactionNum() + 1;
        Transaction transaction = new Transaction();
 
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setTransactionNum(transactionNum);
        transaction.setTransactionDate(new Date());
        transaction.setAmount(cartInfo.getAmountTotal());
 
        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        transaction.setCustomerName(customerInfo.getName());
        transaction.setCustomerEmail(customerInfo.getEmail());
        transaction.setCustomerPhone(customerInfo.getPhone());
        transaction.setCustomerAddress(customerInfo.getAddress());
 
        session.persist(transaction);
 
        List<CartLineInfo> lines = cartInfo.getCartLines();
 
        for (CartLineInfo line : lines) {
        	TransactionDetails detail = new TransactionDetails();
            detail.setTransactionId(UUID.randomUUID().toString());
            detail.setTransaction(transaction);
            detail.setAmount(line.getAmount());
            detail.setPrice(line.getProductInfo().getProductPrice());
            detail.setQuanity(line.getQuantity());
 
            String code = line.getProductInfo().getProductCode();
            Product product = this.productDAO.findProduct(code);
            detail.setProduct(product);
 
            session.persist(detail);
        }
 
        // Set OrderNum for report.
       
        cartInfo.setOrderNum(transactionNum);
    }
 
    // @page = 1, 2, ...
    @Override
    public PaginationResult<TransactionInfo> listTransactionInfo(int page, int maxResult, int maxNavigationPage) {
        String sql = "Select new " + TransactionInfo.class.getName()//
                + "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
                + " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
                + Transaction.class.getName() + " ord "//
                + " order by ord.orderNum desc";
        Session session = this.sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
 
        return new PaginationResult<TransactionInfo>(query, page, maxResult, maxNavigationPage);
    }
 
    public Transaction findTransaction(String transactionId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Transaction.class);
        crit.add(Restrictions.eq("id", transactionId));
        return (Transaction) crit.uniqueResult();
    }
 
    @Override
    public TransactionInfo getTransactionInfo(String transactionId) {
        Transaction transaction = this.findTransaction(transactionId);
        if (transaction == null) {
            return null;
        }
        return new TransactionInfo(transaction.getTransactionId(), transaction.getTransactionDate(), //
        		transaction.getTransactionNum(), transaction.getTransactionAmount(), transaction.getCustomerName(), //
        		transaction.getCustomerAddress(), transaction.getCustomerEmail(), transaction.getCustomerPhone());
    }
 
    @Override
    public List<TransactionDetailInfo> listTransactionDetailInfos(String transactionId) {
        String sql = "Select new " + TransactionDetailInfo.class.getName() //
                + "(d.id, d.MOTOCART_PRODUCTS.code, d.MOTOCART_PRODUCTS.name , d.quanity,d.price,d.amount) "//
                + " from " + TransactionDetails.class.getName() + " d "//
                + " where d.MOTOCART_TRANSACTION.tx_id = :transactionId ";
 
        Session session = this.sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
        query.setParameter("transactionId", transactionId);
 
        return query.list();
    }
 
}