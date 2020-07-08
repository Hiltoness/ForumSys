package javabean;

public class LevelUpgrade {
	public void up(int uid){
		mysql_getint obj=new mysql_getint();
		mysql_operate obj1=new mysql_operate();
		int level=obj.level(uid);
		int p=obj.point(uid);
		int t=Math.round(p/50);
		int l;
		if(p<0){
			
		}else{
			if(p<50)
				 l=1;
			else{
				l=((t-(p/50)<0)?(t):t+1);
				
			}
			if(l>level){
				obj1.update_DBInt11("user", level+1, "level", uid, "uid");
			}else if(l<level){
				obj1.update_DBInt11("user", level-1, "level", uid, "uid");

			}
		}
	}
}
