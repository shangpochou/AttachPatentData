/*
*Class for containing patent data
 * 
 */
import java.util.*;
/**
 * @author ShangpoChou
 *
 */
public class Patent {
	public int intID;
	public String ID;
	public int nOfCite;
	public int nOfBlocking;
	public int nOfInventors;
	public String grandtedDate;
	public Date grantedDateObj;
	public ArrayList<String> inventors;
	public int nOfClaims;
	public int nOfassignee;
	public int nOfLawyers;
	public int nOfBackCite;
	public int hasForeignInventor;
	public String OneOfInventor;
}
