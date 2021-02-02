package by.epam.maven.task4.entity.imp;

import java.io.Serializable;

import by.epam.maven.task4.entity.PartOfSentence;

public class Word implements PartOfSentence, Serializable {

	private static final long serialVersionUID = -2653678540909024118L;

	private String word;

	public Word(String word) {
		this.word = word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	public String toString() {
		return word;
	}
}