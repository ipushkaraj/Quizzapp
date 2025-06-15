package dao;

import org.springframework.stereotype.Component;

@Component
public class ErrorProvider {
	private String error;
	private int row;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public ErrorProvider(String error, int row) {
		this.error = error;
		this.row = row;
	}

	public ErrorProvider() {
	}

}
