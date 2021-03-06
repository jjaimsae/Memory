package window1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @author 손휘진
 * 회원가입에 사용되는 GUI창
 */
@SuppressWarnings("serial")
public class GUI_Join extends JFrame {

	private JPanel contentPane;
	private JTextField tf_id;
	private JTextField tf_email;
	private JTextField tf_name;
	private JTextField tf_pwAnswer;
	private JPasswordField pf_pw;
	private JPasswordField pf_pwCheck;
	JComboBox<String> cb_pwQuestion;

	private String id, pw, pwCheck, email, name, pwAnswer;
	private int pwQuestion;

	public GUI_Join() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("rsc\\logo_icon.png"));
		setTitle("회원가입");
		setBounds(100, 100, 403, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		

		tf_id = new JTextField();
		tf_id.setBackground(new Color(102, 211, 222));
		tf_id.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tf_id.setForeground(Color.WHITE);
		tf_id.setColumns(10);
		tf_id.setBounds(144, 128, 145, 24);
		contentPane.add(tf_id);

		tf_email = new JTextField();
		tf_email.setBackground(new Color(102, 211, 222));
		tf_email.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tf_email.setForeground(Color.WHITE);
		tf_email.setColumns(10);
		tf_email.setBounds(144, 255, 217, 24);
		contentPane.add(tf_email);

		tf_name = new JTextField();
		tf_name.setBackground(new Color(102, 211, 222));
		tf_name.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tf_name.setForeground(Color.WHITE);
		tf_name.setColumns(10);
		tf_name.setBounds(144, 295, 145, 24);
		contentPane.add(tf_name);

		tf_pwAnswer = new JTextField();
		tf_pwAnswer.setBackground(new Color(102, 211, 222));
		tf_pwAnswer.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tf_pwAnswer.setForeground(Color.WHITE);
		tf_pwAnswer.setColumns(10);
		tf_pwAnswer.setBounds(144, 378, 145, 24);
		contentPane.add(tf_pwAnswer);

		pf_pw = new JPasswordField();
		pf_pw.setBackground(new Color(102, 211, 222));
		pf_pw.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pf_pw.setForeground(Color.WHITE);
		pf_pw.setBounds(144, 172, 145, 24);
		contentPane.add(pf_pw);

		pf_pwCheck = new JPasswordField();
		pf_pwCheck.setBackground(new Color(102, 211, 222));
		pf_pwCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pf_pwCheck.setForeground(Color.WHITE);
		pf_pwCheck.setBounds(144, 214, 145, 24);
		contentPane.add(pf_pwCheck);

		JButton btn_join = new JButton("");
		btn_join.setIcon(new ImageIcon("rsc\\icon\\btn_post.PNG"));
		btn_join.setBorderPainted(false);
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				join();
			}
		});
		btn_join.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_join.setBounds(125, 455, 167, 35);
		contentPane.add(btn_join);

		cb_pwQuestion = new JComboBox<String>();
		cb_pwQuestion.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		cb_pwQuestion.setForeground(Color.WHITE);
		cb_pwQuestion.setBackground(new Color(102, 211, 222));
		cb_pwQuestion.addItem("나의 장래희망은?");
		cb_pwQuestion.addItem("나의 보물 1호는?");
		cb_pwQuestion.addItem("가장 기억에 남는 선생님 성함은?");
		cb_pwQuestion.addItem("가장 기억에 남는 장소는?");
		cb_pwQuestion.addItem("나의 어머니의 성함은?");
		cb_pwQuestion.addItem("나의 아버지의 성함은?");
		cb_pwQuestion.setBounds(144, 336, 217, 24);
		contentPane.add(cb_pwQuestion);
		
		try{
			JLabel lb_background = new JLabel(new ImageIcon(ImageIO.read(new File("rsc\\join.png"))));
			lb_background.setBackground(Color.WHITE);
			lb_background.setBounds(0, 0, 400, 550);
			contentPane.add(lb_background);
		}
		catch(IOException s){
			s.printStackTrace();
		}
	}

	/**
	 * 유저 정보를 입력받고 회원가입을 하게 해주는 메소드
	 */
	public void join(){
		DB.getDBInfo();
		
		id = tf_id.getText();
		pw = String.valueOf(pf_pw.getPassword());
		pwCheck = String.valueOf(pf_pwCheck.getPassword());
		email = tf_email.getText();
		name = tf_name.getText();
		pwQuestion = cb_pwQuestion.getSelectedIndex();
		pwAnswer = tf_pwAnswer.getText();

		///////////// id ///////////////
		if(id.length() < 4 || id.length() > 12){ // 아이디의 길이가 짧거나 길면
			JOptionPane.showMessageDialog(Frame.frame_join, "아이디는 4~12자의 영문, 숫자만 사용 가능합니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		for(char c : id.toCharArray()){ 
			if(!Character.isAlphabetic(c) && !Character.isDigit(c)){ // 아이디가 영어 또는 숫자가 아니면
				JOptionPane.showMessageDialog(Frame.frame_join, "아이디는 4~12자의 영문, 숫자만 사용 가능합니다.", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		for(int i = 0; i < DB.userInfo_vector.size(); i++){
			if(DB.userInfo_vector.get(i).id.equals(id)){ // 아이디가 중복되면
				JOptionPane.showMessageDialog(Frame.frame_join, "이미 존재하는 아이디입니다.", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		///////////// pw ///////////////
		if(pw.length() < 4 || pw.length() > 12){ // 비밀번호의 길이가 짧거나 길면
			JOptionPane.showMessageDialog(Frame.frame_join, "비밀번호는 4~12자의 영문, 숫자만 사용 가능합니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		for(char c : pw.toCharArray()){ 
			if(!Character.isAlphabetic(c) && !Character.isDigit(c)){ // 비밀번호가 영어 또는 숫자가 아니면
				JOptionPane.showMessageDialog(Frame.frame_join, "비밀번호는 4~12자의 영문, 숫자만 사용 가능합니다.", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(!pw.equals(pwCheck)){ // 비밀번호랑 비밀번호확인이랑 다르면
			JOptionPane.showMessageDialog(Frame.frame_join, "비밀번호가 일치하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		///////////// email ///////////////
		int AtNum = 0, DotNum = 0; // @이랑 .의 개수

		for(char c : email.toCharArray()){
			if(c == '@') AtNum++;
			if(c == '.') DotNum++;
		}
		if(AtNum != 1 || DotNum != 1 || email.length() <= 5){
			JOptionPane.showMessageDialog(Frame.frame_join, "올바른 형식의 이메일이 아닙니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}


		///////////// name ///////////////
		if(name.length() == 0){
			JOptionPane.showMessageDialog(Frame.frame_join, "이름을 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}


		///////////// pwAnswer ///////////////
		if(pwAnswer.length() == 0){
			JOptionPane.showMessageDialog(Frame.frame_join, "비밀번호 찾기 답을 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		///////////// DB에 데이터 입력 ///////////////
		DB.insertUserInfo(getTrimmedUserInfo());
		DB.getDBInfo();
		JOptionPane.showMessageDialog(Frame.frame_join, "회원가입이 정상적으로 완료되었습니다.", "회원가입 완료", JOptionPane.INFORMATION_MESSAGE);
		Frame.frame_join.setVisible(false);
	}
	
	/**
	 * 사용자가 입력한 정보를 id|pw|email|name|pwQuestion|pwAnswer||||||| 형식으로 만들어서 반환한다.
	 * (회원가입을 위한 메소드이므로 introduce, followerNum 등은 포함하지 않는다.)
	 * @return
	 */
	private String getTrimmedUserInfo(){
		StringBuilder sb = new StringBuilder("");
		sb.append(id + "|");
		sb.append(pw + "|");
		sb.append(email + "|");
		sb.append(name + "|");
		sb.append(pwQuestion + "|");
		sb.append(pwAnswer + "|||||||");
		return sb.toString();
	}
	
	/**
	 * 모든 입력란의 내용을 지워주는 메소드
	 */
	void reset(){
		tf_id.setText("");
		pf_pw.setText("");
		pf_pwCheck.setText("");
		tf_email.setText("");
		tf_name.setText("");
		cb_pwQuestion.setSelectedIndex(0);
		tf_pwAnswer.setText("");
	}
}