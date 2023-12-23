package com.assessment;

import java.util.Scanner;

public class DungeonGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter row and column!");
		int row = sc.nextInt();
		int col = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter adventure row and column!");
		int aI = sc.nextInt();
		int aJ = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Gold row and column!");
		int gI = sc.nextInt();
		int gJ = sc.nextInt();
		
		
		int minSteps = getMinSteps(row, col, aI, aJ, gI, gJ);
		System.out.println(minSteps);
		
	}

	private static int getMinSteps(int row, int col, int aI, int aJ, int gI, int gJ) {
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
