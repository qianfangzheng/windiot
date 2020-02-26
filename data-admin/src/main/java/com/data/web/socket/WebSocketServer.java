package com.data.web.socket;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.data.biz.domain.BizWindData;
import com.data.biz.mapper.BizFanMapper;
import com.data.biz.service.IBizFanService;
import com.data.common.biz.util.TrendDBUtil;
import com.data.web.encoder.ServerEncoder;

@ServerEndpoint(value = "/websocket/{sid}",encoders = {ServerEncoder.class})
@Component
public class WebSocketServer {
	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;
	//concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
	//用来存放每个客户端对应的WebSocketServer对象
	private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<String, WebSocketServer>();

	private static String clientPort = null;// 记录其端口
	
	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	//接收sid
	private String sid="";


	static IBizFanService iBizFanService;

	@Autowired
	public void setIBizFanService(IBizFanService iBizFanService){
		WebSocketServer.iBizFanService = iBizFanService;
	}
	public List<Integer> fanCodeList;
	/**
	 * 连接建立成功调用的方法*/
	@OnOpen
	public void onOpen(Session session,@PathParam("sid") String sid) {
		this.session = session;
		webSocketSet.add(this);     //加入set中
		webSocketMap.put("id", this);// 新增一个id数
		addOnlineCount();           //在线数加1
		// 建立连接时启动对trenddb的连接
		TrendDBUtil.createConnection();
		this.sid=sid;
		// 查询数据库风机编号信息
		// 进行查询风机数量(25565窗口代表风机矩阵)
		fanCodeList = iBizFanService.listFanCode(1);
		if (sid.equals("25565")) {
			// 如果访问的客户端是风机矩阵,给传递的后台窗体为null(没有风机编号)
			clientPort = null;
		}else{
			// 如果访问的客户端是风机详情,根据id查询出风机的基本参数(sid即风机id)
			clientPort = sid;
		}
		System.out.println(fanCodeList);
		try {
			sendMessage("连接成功");
		} catch (IOException e) {
			System.out.println("websocket IO异常");
		}
	}

	

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);  //从set中删除
		subOnlineCount();           //在线数减1
		// 关闭对trenddb数据库的连接
		TrendDBUtil.closeConnection();
		System.out.println("TrendDB连接关闭!");
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息*/
	@OnMessage
	public void onMessage(String message, Session session) {
		//群发消息
		for (WebSocketServer item : webSocketSet) {
			try {
				item.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 出錯
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}


	/**
	 * 实现服务器主动推送
	 */
	public void sendMessage(String message) throws IOException {
//		System.out.println("准备发送消息给客户端");
//		System.out.println("收到消息了!!!");
//		this.session.getBasicRemote().sendText("我收到了你的消息");
	}


	/**
	 * 群发自定义消息
	 * */
	public static void sendInfo(String message,@PathParam("sid") String sid) throws IOException {
		for (WebSocketServer item : webSocketSet) {
			try {
				// 这里可以设定只推送给这个sid的，为null则全部推送
				if(sid==null) {
					item.sendMessage(message);
				}else if(item.sid.equals(sid)){
					item.sendMessage(message);
				}
			} catch (IOException e) {
				continue;
			}
		}
	}

	public static Integer getClientPort() {
		if (null == clientPort) return 0;
		return Integer.valueOf(clientPort);
	}
	public List<Integer> getFanCodeList(){
		return fanCodeList;
	}
	public static ConcurrentHashMap<String,WebSocketServer> getWebSocketMap() {
		return webSocketMap;
	}

	public Session getSession() {
		return session;
	}
	
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketServer.onlineCount--;
	}
}
