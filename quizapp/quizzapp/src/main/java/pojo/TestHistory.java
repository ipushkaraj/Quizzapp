package pojo;

import org.springframework.stereotype.Component;

@Component
public class TestHistory {

	private int userId, testID, score;
	private int questionId[] = new int[10], answerId[] = new int[10];
	private String status, name;

		
	
	public TestHistory() {
	}

	public TestHistory(int userId, int testID, int score, int[] questionId, int[] answerId, String status,
			String name) {
		this.userId = userId;
		this.testID = testID;
		this.score = score;
		this.questionId = questionId;
		this.answerId = answerId;
		this.status = status;
		this.name = name;
	}

	public TestHistory(int userId, int testID, int score, String status, String name) {
		this.userId = userId;
		this.testID = testID;
		this.score = score;
		this.status = status;
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int[] getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int[] questionId) {
		this.questionId = questionId;
	}

	public int[] getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int[] answerId) {
		this.answerId = answerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}