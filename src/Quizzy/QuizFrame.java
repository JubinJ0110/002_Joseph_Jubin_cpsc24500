package Quizzy;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class QuizFrame extends JFrame{
    private String question;
    private ArrayList<String> choices = new ArrayList<String>();
    private ArrayList<Question> theQuiz = new ArrayList<Question>();
    private String theRightChoice;

    public void setUpMenu(){
        JMenuBar quizBar = new JMenuBar();
        setJMenuBar(quizBar);
        JMenu qFile = new JMenu("File");
        JMenuItem loadQuiz = new JMenuItem("Load Questions");
        quizBar.add(qFile);
        qFile.add(loadQuiz);
        loadQuiz.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fancyFileChooser = new JFileChooser();
                    if (fancyFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                        theQuiz = Question.importQuiz(fancyFileChooser.getSelectedFile());
                        JLabel canStart = new JLabel("The questions have been read. Select Quiz >> Start to begin.");
                        GridLayout grid = new GridLayout(20,1);
                        JPanel quizData = new JPanel(grid);

                        JLabel intro = new JLabel("Welcome to Quizzy, the object-oriented programming quiz tool.");
                        JLabel moreIntro = new JLabel("Select File >> Load Questions to begin.");
                        quizData.add(intro);
                        quizData.add(moreIntro);
                        Container quiz = new Container();
                        quiz.add(quizData,BorderLayout.NORTH);
                        
                        if (theQuiz==null){
                            JOptionPane.showMessageDialog(null, "The quiz could not be loaded.");
                        }
                    }
                }
                
            }
        );
        JMenu startQuiz = new JMenu("Quiz");
        JMenuItem start = new JMenuItem("Start");
        JMenuItem stop = new JMenuItem("Stop");
        quizBar.add(startQuiz);
        startQuiz.add(start);
        start.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    
                }
                
            }
        );
        startQuiz.add(stop);
        stop.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {

                    System.exit(0);
                }
                
            }
        );
        
    }
    public void setupGUI(){
        setTitle("Quizzy");
        setBounds(100,100,500,500);
        setUpMenu();
        Container quiz = getContentPane();
        BorderLayout border = new BorderLayout();
        quiz.setLayout(border);
        JPanel textNButtons = new JPanel();
        JLabel ans = new JLabel("Your answer:");
        JTextField tAns = new JTextField(3);
        
        JButton submit = new JButton("Submit answer");
        JButton next = new JButton("Next question");
        tAns.addKeyListener(
				new KeyListener() {
                    @Override
					public void keyPressed(KeyEvent e) {
						String text = tAns.getText().trim();
						if (text.isBlank()) {
							submit.setEnabled(false);
						} else {
							submit.setEnabled(true);
						}
					}
                    @Override
					public void keyReleased(KeyEvent e) {
						
					}
                    @Override
					public void keyTyped(KeyEvent e) {
						
					}
				}
		);
        textNButtons.setLayout(new FlowLayout());
        textNButtons.add(ans);
        textNButtons.add(tAns);
        textNButtons.add(submit);
        textNButtons.add(next);
        quiz.add(textNButtons,BorderLayout.SOUTH);

        GridLayout grid = new GridLayout(20,1);
        JPanel quizData = new JPanel(grid);

        JLabel intro = new JLabel("Welcome to Quizzy, the object-oriented programming quiz tool.");
        JLabel moreIntro = new JLabel("Select File >> Load Questions to begin.");
        quizData.add(intro);
        quizData.add(moreIntro);
        quiz.add(quizData,BorderLayout.NORTH);
    }    
    

    public QuizFrame(){
        setupGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
