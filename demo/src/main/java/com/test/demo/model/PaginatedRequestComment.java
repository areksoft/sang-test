package com.test.demo.model;

import java.util.List;

import com.test.demo.util.model.Meta;
import com.test.demo.util.model.User;

public class PaginatedRequestComment {
	Meta meta;
	List<Comment> data;
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	//public DataModel getData() {
//		return data;
	//}
	//public void setData(DataModel data) {
//		this.data = data;
	//}
	public List<Comment> getData() {
		return data;
	}
	public void setData(List<Comment> data) {
		this.data = data;
	}

		public void print() {
			 data.stream().map(r->r).forEach(r->{System.out.println(r);});
		}
}
