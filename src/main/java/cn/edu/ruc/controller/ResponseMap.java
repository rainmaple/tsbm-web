package cn.edu.ruc.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author fasape
 *
 */
public class ResponseMap {
	public static Map<String,Object> okMap(Object obj) {
		Map<String,Object> statusMap=new HashMap<>();
		statusMap.put("code", 0);
		statusMap.put("data", obj);
		statusMap.put("count", 10000);
		statusMap.put("msg", "");
		return statusMap;
	}
}
