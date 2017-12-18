package com.garyhu.util;

import com.garyhu.model.Result;

public class ResponseUtil {

	public static Result success(Object o){
		int code = o==null?300:200;
		String msg = o==null?"暂无数据":"请求成功";
		Result<Object> r = new Result<Object>();
		r.setCode(code);
		r.setMsg(msg);
		r.setResult(o);
		return r;
	}
	
	
	public static Result warn(String msg,int code){
		Result r = new Result();
		r.setCode(code);
		r.setMsg(msg);
		return r;
	}
}
