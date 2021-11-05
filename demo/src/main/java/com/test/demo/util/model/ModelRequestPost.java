package com.test.demo.util.model;

import com.test.demo.model.Post;

public class ModelRequestPost {
Meta meta;
Post data;
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
public Post getData() {
	return data;
}
public void setData(Post data) {
	this.data = data;
}


}
