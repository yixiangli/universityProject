package com.shopping.li.vo;

public class GoodsManageVo {
	private int pagecount; // 页面总数通過計算出來
	private int pagesize; // 一页显示多少条数据
	private int nowpage; // 当前页跳转时传进来
	private int numcount; // 总记录数
	private int previouspage;// 上一页
	private int nextpage; // 下一页
	private int lastpage; // 最后一页
	private int firstpage; // 第一页

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount() {
		if (this.numcount % this.pagesize == 0) {
			this.pagecount = this.numcount / this.pagesize;
		} else {
			this.pagecount = this.numcount / this.pagesize + 1;
		}
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getNowpage() {
		return nowpage;
	}

	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}

	public int getNumcount() {
		return numcount;
	}

	public void setNumcount(int numcount) {
		this.numcount = numcount;
	}

	public int getPreviouspage() {
		return previouspage;
	}

	public void setPreviouspage() {
		if (this.nowpage != 0) {
			this.previouspage = this.nowpage - 1;
		} else {
			this.previouspage = this.nowpage;
		}

	}

	public int getNextpage() {
		return nextpage;
	}

	public void setNextpage() {
		this.nextpage = this.nowpage + 1;
	}

	public int getLastpage() {
		return lastpage;
	}

	public void setLastpage() {
		if (this.numcount % this.pagesize == 0) {
			this.lastpage = this.numcount / this.pagesize - 1;
		} else {
			this.lastpage = this.numcount / this.pagesize;
		}
	}

	public int getFirstpage() {
		return firstpage;
	}

	public void setFirstpage(int firstpage) {
		this.firstpage = firstpage;
	}
}
