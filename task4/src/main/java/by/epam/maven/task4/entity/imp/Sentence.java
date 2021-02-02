package by.epam.maven.task4.entity.imp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.epam.maven.task4.entity.PartOfSentence;
import by.epam.maven.task4.entity.PartOfText;

public class Sentence implements PartOfText, Serializable {

	private static final long serialVersionUID = 5068663672813895393L;

	private List<PartOfSentence> sentence = new ArrayList<PartOfSentence>();

	public Sentence(List<PartOfSentence> sentence) {
		this.sentence = sentence;
	}

	public Sentence() {

	}

	public void addPart(PartOfSentence part) {
		this.sentence.add(part);
	}

	public void removePart(PartOfSentence part) {
		this.sentence.remove(part);
	}

	public List<PartOfSentence> getSentence() {
		return sentence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sentence == null) ? 0 : sentence.hashCode());
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
		Sentence other = (Sentence) obj;
		if (sentence == null) {
			if (other.sentence != null)
				return false;
		} else if (!sentence.equals(other.sentence))
			return false;
		return true;
	}

	@Override
	public String toString() {

		String line = "";
		StringBuilder buffer = new StringBuilder();

		for (PartOfSentence part : sentence) {
			if (part instanceof Word) {
				buffer.append(part.toString()).append(" ");
			} else {
				buffer.delete(buffer.length() - 1, buffer.length());
				buffer.append(part.toString()).append(" ");
			}
		}

		line = buffer.delete(buffer.length() - 1, buffer.length()).toString() + ".";
		return line;
	}
}