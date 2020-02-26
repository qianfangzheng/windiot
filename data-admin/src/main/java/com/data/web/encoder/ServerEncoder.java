package com.data.web.encoder;
 
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
 

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
 
/**
 * definition for our encoder
 * 
 * @编写人: 夏小雪 日期:2015年6月14日 时间:上午11:58:23
 */
public class ServerEncoder implements Encoder.Text<Object> {
 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
 
	}
 
	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
 
	}
 

	@Override
	public String encode(Object object) throws EncodeException {
		try {
			String jsonObject = JSON.toJSONString(object); 
			return jsonObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
 
}