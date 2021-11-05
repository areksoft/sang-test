package com.test.demo.model;

import java.util.List;

import com.test.demo.util.model.Meta;
import com.test.demo.util.model.User;

public class PaginatedRequestUser {
	Meta meta;
	List<User> data;
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
	public List<User> getData() {
		return data;
	}
	public void setData(List<User> data) {
		this.data = data;
	}

		public void print() {
			 data.stream().map(r->r).forEach(r->{System.out.println(r);});
		}
}
