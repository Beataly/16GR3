/**
 * 
 */
package com.qhit.lh.gr3.beataly.sbm.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.beataly.sbm.user.bean.User;
import com.qhit.lh.gr3.beataly.sbm.user.service.UserService;
import com.qhit.lh.gr3.beataly.sbm.user.service.impl.UserServiceImpl;

/**
 * @author 李芳园
 *TODO
 * 2017年12月7日下午5:16:35
 */
public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	private User user;
	private List<User> users = new ArrayList<>();
	
	private File userPhoto;
	private String userPhotoFileName;
	private String userPhotoContentType;
	
	public String login(){
		boolean isLogin = false;
		user = userService.doLogin(user.getUserName(), user.getUserPassword());
		if(user != null){
			//登陸成功
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		}else{
			super.addFieldError("loginFail", "账户名密码有误！");
		}
		return "loginSuccess";
	}
	
	public String uploadPhoto(){
		if(userPhoto!=null){
			try {
				InputStream is = new FileInputStream(userPhoto);
				String path = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				//头像的相对路径
				String pic = "upload/"+userPhotoFileName;
				//设置到user对象中，方便添加用户的时候插入数据
				user.setPic(pic);
				File file = new File(path);
				if(!file.exists()){
					file.mkdirs();
				}
				OutputStream os = new FileOutputStream(path+"/"+userPhotoFileName);
				byte[] b = new byte[8096];
				int len=0;
				try {
					while((len=is.read(b))!=-1){
						os.write(b, 0, len);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					os.flush();
					os.close();
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "uploadPfotoSuccess";
	}
	
	public String add(){
		int row = userService.addUser(user);
		if(row > 0){
			return "addSuccess";
		}else{
			super.addFieldError("addFail", "用户添加失败!");
		
		return "addFile";
		}
	}
	public String getAll() throws Exception{
		users = userService.getAll();
		return "listUser";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public File getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(File userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getUserPhotoFileName() {
		return userPhotoFileName;
	}
	public void setUserPhotoFileName(String userPhotoFileName) {
		this.userPhotoFileName = userPhotoFileName;
	}
	public String getUserPhotoContentType() {
		return userPhotoContentType;
	}
	public void setUserPhotoContentType(String userPhotoContentType) {
		this.userPhotoContentType = userPhotoContentType;
	}
	
}
