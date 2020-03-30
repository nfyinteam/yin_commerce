package edu.nf.shopping.util;

import java.util.List;

public class PageBean<T> {
	/**
	 * 当前�?
	 */
	private Integer pageNum;
	/**
	 * 每页显示记录�?
	 */
	private Integer pageSize;
	/**
	 * 总页�?
	 */
	private Integer pageCount;
	/**
	 * 总记录数
	 */
	private Integer total;
	/**
	 * 分页数据
	 */
	private List<T> list;
	
	/**
	 * 构�?�方法传入当前页以及每页显示记录�?
	 * @param pageNum
	 * @param pageSize
	 */
	public PageBean(Integer pageNum, Integer pageSize) {
			this.pageNum = pageNum;
			this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 计算总页�?
	 * 
	 * @return
	 */
	public Integer getPageCount() {
		return this.pageCount;
	}
	
	/**
	 * 下一页从第几条开始查
	 * @return
	 */
	public Integer getNextPageRow() {
		return (pageNum-1) * pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	/**
	 * 设置总记录数，同时计算出总页�?
	 * @param total
	 */
	public void setTotal(Integer total) {
		this.total = total;
		//计算总页�?
		this.pageCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
