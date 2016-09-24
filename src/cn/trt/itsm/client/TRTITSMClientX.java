package cn.trt.itsm.client;

import javax.xml.rpc.ParameterMode;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.log4j.Logger;

public class TRTITSMClientX {

	private String url;
	private static Logger logger = Logger.getLogger(TRTITSMClientX.class);

	public String createUser(String uid, String code, String userName,
			String tel, String post, String deptName, String province,
			String city, String address, String linkPhone, String dnName,
			String email) {
		logger.debug("执行create方法，开始进行ITSM用户创建......");
		System.out.println("create >>uid:" + uid + "———code:" + code + "——userName:"
				+ userName +  "——tel:" + tel + "——post:"+ post + "——deptName:" + deptName +"——province:"
				+ province + "——city" + city + "——address" + address + "——linkPhone:"
				+ linkPhone + "——dnName:" + dnName + "——email:" + email);
		String returnCode = "";
		int enabled = 1;
		Service service = new Service();
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("createUserInfo");
			// �ӿڲ���
			call.addParameter("uid", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("code", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("userName", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("tel", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("post", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("deptName", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("province", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("city", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("address", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("linkPhone", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("dnName", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("email", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("enabled", XMLType.XSD_INT, ParameterMode.IN);
			 System.out.println("create》》》接收参数");
			// ���÷�������
			call.setReturnType(XMLType.XSD_STRING);
			returnCode = (String) call.invoke(new Object[] { uid, code,
					userName,  tel, post, deptName, 
					 province, city, address, linkPhone, dnName,
					email,enabled });
			System.out.println("create的返回参数：" + returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnCode;
	}

	/**
	 * 修改用户
	 * 
	 * @param uid
	 *            雇员编号 必填
	 * @param code
	 *            登录用户名 必填
	 * @param userName
	 *            显示用户名 必填
	 * @return
	 */
	public String modifyUser(String uid, String code, String userName,
			String tel, String post, String deptName, String province,
			String city, String address, String linkPhone, String dnName,
			String email) {
		logger.debug("执行modifyUser方法，开始进行考勤用户修改......");
		System.out.println("modifyUser >>uid:" + uid + "———code:" + code + "——userName:"
				+ userName +  "——tel:" + tel + "——post:"+ post + "——deptName:" + deptName +"——province:"
				+ province + "——city" + city + "——address" + address + "——linkPhone:"
				+ linkPhone + "——dnName:" + dnName + "——email:" + email);
		String returnCode = "";
		Service service = new Service();
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("editUserInfo");
			call.addParameter("uid", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("code", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("userName", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("tel", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("post", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("deptName", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("province", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("city", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("address", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("linkPhone", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("dnName", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("email", XMLType.XSD_STRING, ParameterMode.IN);
			logger.debug("modifyUser》 》 》接收参数...");
			// 设置返回类型
			call.setReturnType(XMLType.XSD_STRING);
			// 给方法传递参数，并且调用方法
			returnCode = (String) call.invoke(new Object[] { uid, code,
					userName, tel, post, deptName, province, city, address, 
					linkPhone, dnName,email });
			System.out.println("modify返回的参数："+returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnCode;
	}

	/**
	 * 禁用 用户
	 * 
	 * @param uid
	 *            雇员编号
	 * @return
	 */
	public String disableUser(String uid) {
		logger.debug("执行disableUser方法，开始进行考勤用户禁用......");
		 System.out.println("HISWSClient disableUser request parm>>>>>uid:"
		 +uid );
		String returnCode = "";
		Service service = new Service();
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("disableUserInfo");
			// 接口参数
			call.addParameter("uid", XMLType.XSD_STRING, ParameterMode.IN);
			logger.debug("disableUser�� �� �����ղ���...");
			// 设置返回类型
			call.setReturnType(XMLType.XSD_STRING);
			// 给方法传递参数，并且调用方法
			returnCode = (String) call.invoke(new Object[] { uid });
			System.out.println("disable 返回参数》》"+returnCode);
		} catch (Exception e) {
			logger.debug("disableUser》 》 》异常...");
			e.printStackTrace();
		}
		logger.debug("disableUser》 》 》返回参数...");
		return returnCode;
	}

	/**
	 * 启用 用户
	 * 
	 * @param uid
	 *            雇员编号
	 * @return
	 */
	public String enableUser(String uid) {
		logger.debug("执行enableUser方法，开始进行考勤用户启用......");
		 System.out.println("HISWSClient enableUser request parm>>>>>account:"
		 + uid );
		String returnCode = "";
		Service service = new Service();
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("enableUserInfo");
			// 接口的参数
			logger.debug("enableUser》 》 》接收参数...");
			call.addParameter("uid", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回类型
			call.setReturnType(XMLType.XSD_STRING);
			returnCode = (String) call.invoke(new Object[] { uid });
			System.out.println("enable返回参数》》》"+returnCode);
		} catch (Exception e) {
			logger.debug("enableUser》 》 》异常...");
			e.printStackTrace();
		}
		logger.debug("enableUser》 》 》返回参数...");
		return returnCode;
	}

	public TRTITSMClientX(String url) {

		this.url = url;
	}

	public TRTITSMClientX() {

		 this.url = "http://202.108.145.61/services/userSynWebService.jws?wsdl";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static void main(String args[]) throws Exception {
		TRTITSMClientX wc = new TRTITSMClientX();
		wc.createUser("54211331231", "wangsanfdk234", "北京你好3", "北京你好3", "北京你好4", "北京你好5", "北京你好51", "北京你好51", "北京你好51", "北京你好15", "北京你好51", "北京你好51");
		wc.createUser("20000002", "wangsan1", "包磊1", "", "", "", "", "北京1","", "", "", "");
				wc.modifyUser("54211331231", "wangsanfdk345", "北京你好4", "北京你好3", "北京你好4", "北京你好5", "北京你好51", "北京你好51", "北京你好51", "北京你好15", "北京你好51", "北京你好51");
		wc.disableUser("20000002");
		wc.enableUser("20000002");
	}
}
