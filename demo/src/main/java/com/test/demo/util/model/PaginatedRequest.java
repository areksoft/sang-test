package com.test.demo.util.model;

import java.util.List;

import com.test.demo.model.Post;

public class PaginatedRequest<T> {

Meta meta;
List<Post> data;
public Meta getMeta() {
	return meta;
}
public void setMeta(Meta meta) {
	this.meta = meta;
}


//public DataModel getData() {
//	return data;
//}
//public void setData(DataModel data) {
//	this.data = data;
//}
public List<Post> getData() {
	return data;
}
public void setData(List<Post> data) {
	this.data = data;
}

	public void print() {
		 data.stream().map(r->r).forEach(r->{System.out.println(r);});
	
}
}
