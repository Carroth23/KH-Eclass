package exams;

import java.io.FileInputStream;
import java.util.Scanner;

import javazoom.jl.player.Player;

public class Exam_03_MP3_Player {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("== 쥬크 박스 ==");
		System.out.println("1. Piano");
		System.out.println("2. 종 료");
		
		int menu = Integer.parseInt(sc.nextLine());
		
		String musicName = null;
		if (menu == 1) {
			musicName = "piano.mp3";
		} else if (menu == 2) {
			System.exit(0);
		}
		
		try{
		    FileInputStream fis = new FileInputStream(musicName);
		    Player playMP3 = new Player(fis);
		    playMP3.play();
		}
		catch(Exception exc){
		    exc.printStackTrace();
		    System.out.println("Failed to play the file.");
		}
		
	}
}
