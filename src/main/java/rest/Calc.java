package rest;

import java.util.ArrayList;
import java.util.List;

public class Calc {
	
	List<Object> resultList;
	
	public Calc(int top){
		resultList = new ArrayList<Object>();
		int x = 0, y = 1, z = 1;
		resultList.add(y);
		resultList.add(z);
        do{
            x = y;
            y = z;
            z = x + y;
            System.out.println(z);
            if(z<=top&&z>0)resultList.add(z);
        }while (z < top&&z > 0);
        
	}
	//response value for http call
	public List<Object> getResultList(){
        return resultList;
	}

}
