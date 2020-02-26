import com.data.common.biz.util.PropertiesUtil;
import com.data.common.biz.util.TrendDBUtil;

import TrendDB.API;
import TrendDB.DB_Exception;
import TrendDB.DB_Time;
import TrendDB.DB_Value;


public class Test {
	private static String connId = PropertiesUtil.getValue("connId");
	public static void insertDataMore() {
        TrendDBUtil.createConnection();
		Integer[] num = {1,2,3,4,5,6};

		String[] sys_vars = { "cabinT","cabinAngle","oilT","lowt","hight","oilPressure","acVoltage","fanOutput","fanOutputFrequency","fanFactor","instantaneousPower","rotateSpeed" };
		String windSpeed = "wind.speed";
		String windDirection  = "wind.direction";
		String tmp = "fan.";
		int N = num.length;//风机个数
		String[] names = new String[sys_vars.length*N+2];
		DB_Value[] values = new DB_Value[names.length];
		DB_Time tNow = API.TimeNow();
		for (int i = 0; i < num.length; i++) {
			//风机在风机id数组中的位置

			for(int j = 0; j < sys_vars.length; j++) {
				int k = i*sys_vars.length+j;
				names[k]=tmp+sys_vars[j]+"."+num[i];
				values[k] = new DB_Value();
				values[k].time = new DB_Time();
				values[k].time.hours = tNow.hours;
				values[k].time.usecs = tNow.usecs;
				values[k].status = 3;
				values[k].value = (float) (10+Math.random()*(20-10+1));
			}
		}


		names[names.length-2] = windSpeed;
		values[names.length-2] = new DB_Value();
		values[names.length-2].time = new DB_Time();
		values[names.length-2].time.hours = tNow.hours;
		values[names.length-2].time.usecs = tNow.usecs;
		values[names.length-2].status = 3;
		values[names.length-2].value = (float) (10+Math.random()*(20-10+1));
		names[names.length-1] = windDirection;
		values[names.length-1] = new DB_Value();
		values[names.length-1].time = new DB_Time();
		values[names.length-1].time.hours = tNow.hours;
		values[names.length-1].time.usecs = tNow.usecs;
		values[names.length-1].status = 3;
		values[names.length-1].value = (float) (10+Math.random()*(20-10+1));

		long tBegin = System.currentTimeMillis();
		API.TimeAdd(tNow, 1, 0);


		try {
			API.UpdateValueByName(connId, names, values);
		} catch (DB_Exception ex) {
			System.out.println("UpdateValueByName failed due to:" + ex.GetErrMsg() + ", error: " + ex.errno);
		}
		try {
			API.FlushConnectionBuffer(connId);
		} catch (DB_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long tDuration = System.currentTimeMillis() - tBegin;
		System.out.println("5 millions tags: " + tDuration + " ms");
		TrendDBUtil.closeConnection();
	}
}
