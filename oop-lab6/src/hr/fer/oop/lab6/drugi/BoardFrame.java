package hr.fer.oop.lab6.drugi;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * The class BoardFrame
 * @author Luka
 *
 */
public class BoardFrame extends JFrame implements BoardListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int ROWS=30;
	private final int COLUMNS=30;
	
	private JToggleButton[][] grid;
	private Board board;
	private CalculationInGame calculationInGame;
	private Thread gameThread;
	
	@Override
	public void boardChanged(Board board) {
		for(int i=0; i<ROWS; i++) {
			for(int j=0; j<COLUMNS; j++) {
				grid[i][j].setSelected(board.isCellAlive(i, j));
			}
		}
		
	}
	
	/**
	 * Instantiates a new BoardFrame
	 */
	
	public BoardFrame() {
		board=new Board(ROWS, COLUMNS);
		board.addListener(this);
		
		JButton start=new JButton("Start");
		JButton stop=new JButton("Stop");
		JButton oneIteration=new JButton("One Iteration");
		
		JPanel mainPanel=new JPanel();
		JPanel gridPanel=new JPanel();
		JPanel startPanel=new JPanel();
		JPanel titlePanel=new JPanel();
		
		gridPanel.setLayout(new GridLayout(ROWS, COLUMNS));
		
		grid=new JToggleButton[ROWS][COLUMNS];
		
		for(int i=0; i<ROWS; i++) {
			for(int j=0; j<COLUMNS; j++) {
				int r=i;
				int c=j;
				grid[r][c]=new JToggleButton();
				grid[r][c].addActionListener(e -> {
					board.setCell(r, c, grid[r][c].isSelected());
				});
				gridPanel.add(grid[i][j]);
			}
		}
		
		stop.setEnabled(false);
		
		start.addActionListener(e -> {
			start.setEnabled(false);
			stop.setEnabled(true);
			oneIteration.setEnabled(false);
			
			calculationInGame=new CalculationInGame();
			gameThread=new Thread(calculationInGame);
			gameThread.start();
			
		});
		
		stop.addActionListener(e -> {
			stop.setEnabled(false);
			start.setEnabled(true);
			oneIteration.setEnabled(true);
			
			calculationInGame.stop();
			
		});
		
		oneIteration.addActionListener(e -> {
			board.playOneIteration();
			
		});
		
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(gridPanel, BorderLayout.CENTER);
		mainPanel.add(startPanel, BorderLayout.PAGE_START);
		mainPanel.add(titlePanel, BorderLayout.NORTH);
		
		startPanel.add(start);
		startPanel.add(stop);
		startPanel.add(oneIteration);
		
		setTitle("Conway's Game of Life");
		setSize(720, 720);
		setLocationRelativeTo(null);
		add(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	/**
	 * The class CalculationInGame
	 */
	private class CalculationInGame implements Runnable {
		
		private volatile boolean running=true;

		@Override
		public void run() {
			while(running) {
				try {
					board.playOneIteration();
					Thread.sleep(500);
				} catch (InterruptedException exc) {
					running=false;
					System.out.println(exc.getMessage());
					exc.printStackTrace();
				}
			}
		}
		
		/**
		 * stops the method run
		 */
		
		public void stop() {
			running=false;
		}
		
	}
}
