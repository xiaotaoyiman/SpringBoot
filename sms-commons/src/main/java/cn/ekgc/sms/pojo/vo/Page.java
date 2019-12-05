package cn.ekgc.sms.pojo.vo;

import cn.ekgc.sms.util.ConstantUtil;

import java.io.Serializable;
import java.util.List;

public class Page<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pageNum;                 // 当前页码
	private Integer pageSize;                // 每页显示数量
	private Integer draw;                    // DataTables组件确认信息
	private Integer begin;					 // 开始的下标
	private Integer size;					 // 连续显示数量
	private List<E> list;					 // 分页列表
	private Long totalNum;					 // 总数量
	private Long totalPage;					 // 总页码

	public Page() {}
	public Page(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}

		this.begin = (this.pageNum - 1) * this.pageSize;
		this.size = this.pageSize;
	}

	public Page(Integer pageNum, Integer pageSize, Integer draw) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}

		this.begin = (this.pageNum - 1) * this.pageSize;
		this.size = this.pageSize;
		this.draw = draw;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public void setTotalPage() {
		this.totalPage = (this.totalNum % this.pageSize == 0) ?(this.totalNum / this.pageSize) : (this.totalNum / this.pageSize) + 1;
	}
}
