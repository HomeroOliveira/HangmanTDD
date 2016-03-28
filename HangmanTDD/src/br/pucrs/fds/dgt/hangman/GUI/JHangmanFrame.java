package br.pucrs.fds.dgt.hangman.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.pucrs.fds.dgt.hangman.Engine.Hangman;
import br.pucrs.fds.dgt.hangman.Engine.HangmanState;
import br.pucrs.fds.dgt.hangman.Engine.WordsBank;

public class JHangmanFrame extends JFrame {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 477162628901682495L;
    private JPanel contentPane;
    private JTextField txtfldGuess;
    private Hangman game;
    private JLabel lblTriesValue;
    private JLabel lblHangman;
    private WordsBank wordsBank;
    private JLabel lblMissesValue;
    private JLabel lblWordValue;
    private JLabel lblLengthValue;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    JHangmanFrame frame = new JHangmanFrame();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public JHangmanFrame() {
	// wordsBank = new
	// WordsBank(Paths.get("/br/pucrs/fds/dgt/hangman/words.txt"));
	// game = new Hangman(wordsBank.getWord());
	game = new Hangman("hangman");
	initComponents();
    }

    private void initComponents() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 552, 347);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JPanel pnlInfo = new JPanel();

	JPanel pnlImage = new JPanel();
	pnlImage.setForeground(Color.WHITE);
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane
		.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(pnlImage, GroupLayout.PREFERRED_SIZE, 280,
						GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED).addComponent(pnlInfo,
						GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
		.addGap(24)));
	gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addContainerGap()
			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
				.addComponent(pnlInfo, Alignment.LEADING, 0, 0, Short.MAX_VALUE).addComponent(pnlImage,
					Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
			.addContainerGap(19, Short.MAX_VALUE)));

	lblHangman = new JLabel("");
	lblHangman.setForeground(Color.WHITE);
	lblHangman.setBackground(Color.WHITE);
	lblHangman.setIcon(createHangamanImage(0));
	GroupLayout gl_pnlImage = new GroupLayout(pnlImage);
	gl_pnlImage.setHorizontalGroup(
		gl_pnlImage.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnlImage.createSequentialGroup()
			.addContainerGap(36, Short.MAX_VALUE).addComponent(lblHangman).addContainerGap()));
	gl_pnlImage.setVerticalGroup(
		gl_pnlImage.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlImage.createSequentialGroup()
			.addContainerGap().addComponent(lblHangman).addContainerGap(27, Short.MAX_VALUE)));
	pnlImage.setLayout(gl_pnlImage);

	JLabel lblWord = new JLabel("Word:");

	JLabel lblGuess = new JLabel("Guess:");

	JLabel lblMisses = new JLabel("Misses");

	JLabel lblTries = new JLabel("Tries");

	JButton btnTry = new JButton("Try Letter");
	btnTry.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		btnTry_actionPerformed(e);
	    }
	});

	txtfldGuess = new JTextField();
	txtfldGuess.setColumns(10);

	lblMissesValue = new JLabel("");

	lblTriesValue = new JLabel("6");
	lblTriesValue.setHorizontalAlignment(SwingConstants.CENTER);

	lblWordValue = new JLabel("");
	lblWordValue.setText(game.getWord());

	JLabel lblLength = new JLabel("Length:");

	JButton btnTryWord = new JButton("Try Word");
	btnTryWord.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		btnTryWord_actionPerformed(e);
	    }
	});

	lblLengthValue = new JLabel("");
	lblLengthValue.setHorizontalAlignment(SwingConstants.CENTER);
	lblLengthValue.setText(Integer.toString(game.getSecret().length()));

	GroupLayout gl_pnlInfo = new GroupLayout(pnlInfo);
	gl_pnlInfo
		.setHorizontalGroup(
			gl_pnlInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(
					gl_pnlInfo.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlInfo
							.createParallelGroup(
								Alignment.TRAILING)
							.addGroup(
								gl_pnlInfo.createSequentialGroup()
									.addGroup(
										gl_pnlInfo
											.createParallelGroup(
												Alignment.LEADING)
											.addComponent(lblWord)
											.addComponent(lblTries)
											.addComponent(lblMisses)
											.addComponent(lblGuess))
									.addPreferredGap(
										ComponentPlacement.RELATED)
				.addGroup(gl_pnlInfo.createParallelGroup(Alignment.LEADING)
					.addComponent(lblMissesValue, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addGroup(gl_pnlInfo.createSequentialGroup().addGap(10)
						.addGroup(gl_pnlInfo.createParallelGroup(Alignment.LEADING)
							.addComponent(txtfldGuess, GroupLayout.DEFAULT_SIZE, 149,
								Short.MAX_VALUE)
						.addComponent(lblWordValue, GroupLayout.DEFAULT_SIZE, 149,
							Short.MAX_VALUE).addComponent(lblTriesValue,
								GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))))
			.addGroup(gl_pnlInfo.createSequentialGroup().addComponent(lblLength).addGap(12).addComponent(
				lblLengthValue, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
			.addGroup(gl_pnlInfo.createSequentialGroup().addComponent(btnTry)
				.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
				.addComponent(btnTryWord))).addContainerGap()));
	gl_pnlInfo.setVerticalGroup(gl_pnlInfo.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_pnlInfo.createSequentialGroup().addContainerGap()
			.addGroup(gl_pnlInfo.createParallelGroup(Alignment.BASELINE).addComponent(lblWord)
				.addComponent(lblWordValue, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
		.addGap(2)
		.addGroup(gl_pnlInfo.createParallelGroup(Alignment.BASELINE).addComponent(lblLength)
			.addComponent(lblLengthValue))
		.addGap(2)
		.addGroup(gl_pnlInfo.createParallelGroup(Alignment.BASELINE)
			.addComponent(lblGuess, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
			.addComponent(txtfldGuess, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
				GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(ComponentPlacement.RELATED)
		.addGroup(gl_pnlInfo.createParallelGroup(Alignment.LEADING).addComponent(lblMisses)
			.addComponent(lblMissesValue, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(ComponentPlacement.RELATED)
		.addGroup(gl_pnlInfo.createParallelGroup(Alignment.LEADING).addComponent(lblTriesValue)
			.addComponent(lblTries)).addGap(41)
		.addGroup(gl_pnlInfo.createParallelGroup(Alignment.BASELINE).addComponent(btnTryWord)
			.addComponent(btnTry)).addContainerGap(119, Short.MAX_VALUE)));
	pnlInfo.setLayout(gl_pnlInfo);
	contentPane.setLayout(gl_contentPane);
    }

    private ImageIcon createHangamanImage(int num) {
	return new ImageIcon(
		JHangmanFrame.class.getResource("/br/pucrs/fds/dgt/hangman/GUI/images/Hangman-" + num + ".png"));
    }

    protected void btnTry_actionPerformed(ActionEvent e) {
	String word = txtfldGuess.getText();
	if (word.isEmpty() || word.length() > 1) {
	    JOptionPane.showMessageDialog(this, "Entrada invalida");
	    return;
	}

	if (game.onGame()) {
	    try {
		game.setGuess(word.charAt(0));
		updateInfo();
		lblWordValue.setText(game.getWord());
	    } catch (IllegalArgumentException ex) {
		JOptionPane.showMessageDialog(this, ex.getMessage());
	    }
	}
	txtfldGuess.setText("");

	resultGame();
    }

    protected void btnTryWord_actionPerformed(ActionEvent e) {

    }

    private void resultGame() {
	if (game.getState() == HangmanState.WIN) {
	    int dialog = JOptionPane.showConfirmDialog(this, "Você Ganho\nQuer continuar?");
	    if (JOptionPane.OK_OPTION == dialog) {
		JOptionPane.showMessageDialog(this, "teste");
	    } else {
		System.exit(0);
	    }

	}
    }

    private void updateInfo() {
	int tries = game.getTries();
	if (tries != Integer.parseInt(lblTriesValue.getText())) {
	    lblTriesValue.setText(Integer.toString(tries));
	    lblHangman.setIcon(createHangamanImage(6 - tries));
	    lblMissesValue.setText(game.getMisses());
	}
    }

}
