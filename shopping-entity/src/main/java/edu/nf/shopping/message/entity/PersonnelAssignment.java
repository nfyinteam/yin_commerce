package edu.nf.shopping.message.entity;

import lombok.Data;

import java.util.Collection;

/**
 * @author Bull fighters
 * @date 2020/4/9
 */
public class PersonnelAssignment implements Comparable<PersonnelAssignment> {
    private String customerServiceId;
    private int sum;

    public PersonnelAssignment(){
        super();
    }

    public PersonnelAssignment(String customerServiceId,int sum){
        super();
        this.customerServiceId=customerServiceId;
        this.sum=sum;
    }

    public String getCustomerServiceId() {
        return customerServiceId;
    }

    public void setCustomerServiceId(String customerServiceId) {
        this.customerServiceId = customerServiceId;
    }

    @Override
    public int compareTo(PersonnelAssignment o) {
        return sum - o.sum;
    }


    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "PersonnelAssignment{" +
                "customerService='" + customerServiceId + '\'' +
                ", sum=" + sum +
                '}';
    }
}