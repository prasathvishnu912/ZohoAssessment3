package com.assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DungeonGameQ4 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("Enter Trigger row and column!");
		int tI = sc.nextInt();
		int tJ = sc.nextInt();
		
		System.out.println("Enter Gold row and column!");
		int gI = sc.nextInt();
		int gJ = sc.nextInt();
		
		
		int monsMinSteps = getMonsMinSteps(row, col, mI, mJ, gI, gJ);
		int advMinStepsToG = getAdvMinStepsToGold(row, col, aI, aJ, gI, gJ);
		int advMinStepsToTrig = getAdvMinStepsToTrigger(row, col, aI, aJ, tI, tJ);
		int advMinSteps = advMinStepsToTrig<monsMinSteps ? advMinStepsToG<monsMinSteps ? advMinStepsToG : advMinStepsToTrig: advMinStepsToG;
		
		if(monsMinSteps<advMinSteps) {
			System.out.println("Minimum number of steps: "+advMinSteps);
		}else {
			System.out.println("Minimum Number of stps taken: "+advMinSteps);
		}
	}

	
	
	private static int getAdvMinStepsToTrigger(int row, int col, int aI, int aJ, int gI, int gJ) {

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



	private static int getAdvMinStepsToGold(int row, int col, int aI, int aJ, int gI, int gJ) {
		// TODO Auto-generated method stub
		
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

	
}
