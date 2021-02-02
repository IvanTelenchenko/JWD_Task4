package by.epam.maven.task4.entity.imp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.epam.maven.task4.entity.PartOfText;

public class Text implements Serializable {

	private static final long serialVersionUID = -9066235478970477515L;

	private List<PartOfText> text = new ArrayList<PartOfText>();

	public void addPartOfText(PartOfText part) {
		text.add(part);
	}

	public void addPartOfText(List<PartOfText> list) {
		text.addAll(list);
	}

	public void removePartOfText(PartOfText part) {
		text.remove(part);
	}

	public List<PartOfText> getText() {
		return text;
	}

	public List<Sentence> getSentences() {

		List<Sentence> list = new ArrayList<Sentence>();

		for (PartOfText part : text) {
			if (part instanceof Sentence) {
				list.add((Sentence) part);
			}
		}
		return list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Text other = (Text) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {

		String text = "";

		for (PartOfText part : this.text) {
			if (part instanceof Sentence) {
				text = text + part.toString() + " ";
			}
		}
		return text;
	}
}