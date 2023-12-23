package com.assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DungeonGameQ7 {

	static 	List<List<Integer>> pillList = new ArrayList<>(); 
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter row and column!");
		int row = sc.nextInt();
		int col = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter adventure row and column!");
		int aI = sc.nextInt();
		int aJ = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Monster row and column!");
		int mI = sc.nextInt();
		int mJ = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Trigger row and column!");
		int tI = sc.nextInt();
		int tJ = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Gold row and column!");
		int gI = sc.nextInt();
		int gJ = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter number of pills");
		int nP = sc.nextInt();
		
		getPills(nP);

		int advMinStepsToG = getMinSteps(row, col, aI, aJ, gI, gJ, nP);
		int monsMinSteps = getMonsMinSteps(row, col, mI,  mJ, gI, gJ);
		int advMinStepsToT = getMinSteps(row, col, aI, aJ, tI, tJ, nP);
		int advMinSteps = advMinStepsToT<advMinStepsToG ? advMinStepsToT : advMinStepsToG;
		if(advMinStepsToG==-1||advMinSteps>monsMinSteps) {
			System.out.println("No possible solution");
		}else {
			int trigToGold = getMinSteps(row, col, tI, tJ, gI, gJ, nP);
			System.out.println("Minimum number of steps: "+(advMinSteps+trigToGold));
		}
		
	}

	private static void getPills(int nP) {
		for(int i=0; i<nP; i++) {
			System.out.println("Enter Dead pills row and col:");
			List<Integer> pL = new ArrayList<>();
			pL.add(sc.nextInt());
			pL.add(sc.nextInt());
			pillList.add(pL);
			sc.nextLine();
		}
		
	}

	private static int getMonsMinSteps(int row, int col, int mI, int mJ, int gI, int gJ) {
		// TODO Auto-generated method stub
		int maxStep = row + col -1;
		int i=0;
		
		int cI = mI;
		int cJ = mJ;
		
		while(i<=maxStep) {
			if(cI==gI&&cJ==gJ) {
				break;
			}else {
				if(cJ==gJ) {
					if(cI>gI) {
						cI--;
					}else {
						cI++;
					}
					i++;
				}
				else if(cJ<gJ) {
					cJ++;
					i++;
				}else {
					cJ--;
					i++;
				}
			}
		}
		return i;
		
	}
	
	private static int getMinSteps(int row, int col, int aI, int aJ, int gI, int gJ, int nP) {
		
		int maxStep = row + col -1;
		int i=0;
		
		int cI = aI;
		int cJ = aJ;

		while(i<=maxStep) {
			if(cI==gI&&cJ==gJ) {
				break;
			}else {
				if(cJ==gJ) {
					if(cI>gI) {
						if(checkDeadPills(cI-1, cJ)) {
							if(cJ+1<=col&&!checkDeadPills(cI, cJ+1)) {
								cJ++;
								i++;
							}else if(cJ-1>0&&!checkDeadPills(cI, cJ-1)) {
								cJ--;
								i++;
							}else if(cI+1>=row&&!checkDeadPills(cI+1, cJ)) {
								cI++;
								i++;
							}else {
								return -1;
							}
							
						}
						else {
							  cI--;	
							  i++;
						}
					}
					else {
						if(checkDeadPills(cI+1, cJ)) {
							if(cJ+1<=col&&!checkDeadPills(cI, cJ+1)) {
								cJ++;
								i++;
							}else if(cJ-1>0&&!checkDeadPills(cI, cJ-1)) {
								cJ--;
								i++;
							}else if(cI-1>0&&!checkDeadPills(cI-1, cJ)) {
								cI--;
								i++;
							}else {
								return -1;
							}
							
						}
						else {
							  cI++;	
							  i++;
						}
					}
					
				}
				else if(cJ<gJ) {
					if(checkDeadPills(cI, cJ+1)){
						if(cI>=gI) {
							if(cI-1>0!=checkDeadPills(cI-1, cJ)) {
								cI--;
								i++;
							}else if(cI+1<=row&&!checkDeadPills(cI+1, cJ)) {
								cI++;
								i++;
							}else if(cJ-1>0&&!checkDeadPills(cI, cJ-1)) {
								cJ--;
								i++;
							}else {
								return -1;
							}
						}else {
							if(cI+1<=row!=checkDeadPills(cI+1, cJ)) {
								cI++;
								i++;
							}else if(cI-1>0&&!checkDeadPills(cI-1, cJ)) {
								cI--;
								i++;
							}else if(cJ-1>0&&!checkDeadPills(cI, cJ-1)) {
								cJ--;
								i++;
							}else {
								return -1;
							}
						}
						
					}else {
						cJ++;
						i++;	
					}
				}else {
					if(checkDeadPills(cI, cJ-1)){
						if(cI>=gI) {
							if(cI-1>0!=checkDeadPills(cI-1, cJ)) {
								cI--;
								i++;
							}else if(cI+1<=row&&!checkDeadPills(cI+1, cJ)) {
								cI++;
								i++;
							}else if(cJ+1>0&&!checkDeadPills(cI, cJ+1)) {
								cJ++;
								i++;
							}else {
								return -1;
							}
						}else {
							if(cI+1<=row!=checkDeadPills(cI+1, cJ)) {
								cI++;
								i++;
							}else if(cI-1>0&&!checkDeadPills(cI-1, cJ)) {
								cI--;
								i++;
							}else if(cJ+1>0&&!checkDeadPills(cI, cJ+1)) {
								cJ++;
								i++;
							}else {
								return -1;
							}
						}
						
					}else {
						cJ--;
						i++;	
					}
				}
			}
		}
		
		return i;
	}

	private static boolean checkDeadPills(int cI, int cJ) {
		for(List<Integer> list: pillList) {
			if(list.get(0)==cI&&list.get(1)==cJ) {
				return true;
			}
		}
		return false;
	}

	

}
