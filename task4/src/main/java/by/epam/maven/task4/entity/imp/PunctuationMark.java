
package by.epam.maven.task4.entity.imp;

import java.io.Serializable;

import by.epam.maven.task4.entity.PartOfSentence;

public class PunctuationMark implements PartOfSentence, Serializable {

	private static final long serialVersionUID = -5262913376776758233L;

	private char mark;

	public PunctuationMark(char mark) {
		this.mark = mark;
	}

	public char getMark() {
		return mark;
	}

	public void setMark(char mark) {
		this.mark = mark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mark;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PunctuationMark other = (PunctuationMark) obj;
		if (mark != other.mark)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + mark;
//		return "";
	}
}