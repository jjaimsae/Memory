package window1;
/**
 * @author ������
 * ȸ�� ���� �ý��ۿ� �ʿ��� �ʵ���� ������ Ŭ����
 */
public class UserInfo {
	String id, pw, email, name, pwAnswer, introduce, followee, follower;
	int animal, followerNum, postNum, pwQuestion;
	
	public UserInfo(){};
	
	public UserInfo(String id, String pw, String email, String name, int pwQuestion,
			String pwAnswer, String introduce, int animal, int followerNum, int postNum,
			String followee, String follower){
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.name = name;
		this.pwQuestion = pwQuestion;
		this.pwAnswer = pwAnswer;
		this.introduce = introduce;
		this.animal = animal;
		this.followerNum = followerNum;
		this.postNum = postNum;
		this.followee = followee;
		this.follower = follower;
	}
}