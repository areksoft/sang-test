package com.test.demo.util.model;

import com.test.demo.model.Comment;

public class ModelRequestComment {
Meta meta;
Comment data;
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
public Comment getData() {
	return data;
}
public void setData(Comment data) {
	this.data = data;
}


}
