package 回溯思想;

public class Pattern {
	char[] pattern;
	int pL;
	boolean f=false;
	public Pattern(char[] pattern,int pL){
		this.pattern=pattern;
		this.pL=pL;
	}
	public boolean match(char[] text,int tL){
		f=false;
		singleMatch(0,0,text,tL);
		return f;
	}
	private void singleMatch(int ti,int pi,char[] text,int tL) {
		// TODO Auto-generated method stub
		if(f){     //已经匹配了就不用递归了
			return ;
		}
		if(pi==pL){ //正则表达式是否到达结尾
			if(ti==tL){ //文本串也到达结尾
				f=true;
				return;
			}
		}
		if(pattern[pi]=='*'){ //上面已经判断正则表达式是否到达结尾
			for(int i=0;i<tL-ti;i++){
				singleMatch(ti+i,pi+1,text,tL);//*---任意长度字符
			}
		}else if(pattern[pi]=='?'){            //?--0或者1个字符
			singleMatch(ti,pi+1,text,tL);
			singleMatch(ti+1,pi+1,text,tL);
		}else if(ti<tL&&pattern[pi]==text[ti]){      //不是通配符
			singleMatch(ti+1,pi+1,text,tL);
		}
		
	}

}
