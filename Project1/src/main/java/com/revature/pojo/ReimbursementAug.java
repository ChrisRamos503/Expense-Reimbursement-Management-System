package com.revature.pojo;

public class ReimbursementAug extends Reimbursement{

	private String boss;
	private long boss_id;
	
	public ReimbursementAug(){
		
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "boss=" + boss + " boss_id = " + boss_id;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	public long getBoss_id() {
		return boss_id;
	}

	public void setBoss_id(long boss_id) {
		this.boss_id = boss_id;
	}
	
	
	
	
	
	
}
