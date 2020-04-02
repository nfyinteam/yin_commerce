package edu.nf.shopping.message.dao;

import edu.nf.shopping.message.entity.Receive;

/**
 * @author Bull fighters
 * @date 2020/4/1
 */
public interface ReceiveDao {

    void addReceive(Receive receive);

    void updateReceive(Receive receive);
}