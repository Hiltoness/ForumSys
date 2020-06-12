package javabean;
//帖子类（热门列表的一些属性，包括回复数）
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class postlist {
	private String uid; 
	private String aid;  
	private String title;
	private String atime;
	private int num;        //回复数
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAtime() {
		return atime;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

}
