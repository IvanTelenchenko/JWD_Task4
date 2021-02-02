package by.epam.maven.task4.editor.imp;

import java.util.ArrayList;
import java.util.List;

import by.epam.maven.task4.editor.Task;
import by.epam.maven.task4.entity.PartOfSentence;
import by.epam.maven.task4.entity.imp.Sentence;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.entity.imp.Word;

/* Найти такое слово в первом предложении, которого нет ни в одном из остальных предложений.*/

public class Task3 implements Task {

	public String run(Text text) {

		String result = "";

		List<String> wordsOfFirstSentence = new ArrayList<String>();
		List<String> wordsOfOtherSentences = new ArrayList<String>();

		List<Sentence> otherSentences = new ArrayList<Sentence>();

		for (Sentence sent : text.getSentences()) {
			if (sent == text.getSentences().get(0)) {
				wordsOfFirstSentence = getWordsOfFirstSentence(sent);
			} else {
				otherSentences.add(sent);
			}
		}

		wordsOfOtherSentences = getWordsOfOtherSentences(otherSentences);

		boolean isTrue = true;

		StringBuilder buffer = new StringBuilder();

		for (String word : wordsOfFirstSentence) {
			isTrue = true;
			for (String otherWord : wordsOfOtherSentences) {
				if (word.compareToIgnoreCase(otherWord) == 0) {
					isTrue = false;
					break;
				}
			}
			if (isTrue) {
				buffer.append(word).append(", ");
			}
		}

		if (buffer.length() == 0) {
			result = "word not found";
		} else {
			result = buffer.toString();
		}
		return result;
	}

	public static ArrayList<String> getWordsOfFirstSentence(Sentence sent) {

		ArrayList<String> list = new ArrayList<String>();

		for (PartOfSentence part : sent.getSentence()) {
			if (part instanceof Word) {
				list.add(((Word) part).getWord().trim());
			}
		}
		return list;
	}

	public static ArrayList<String> getWordsOfOtherSentences(List<Sentence> listSent) {

		ArrayList<String> list = new ArrayList<String>();

		for (Sentence sent : listSent) {
			for (PartOfSentence part : sent.getSentence()) {
				if (part instanceof Word) {
					list.add(((Word) part).getWord().trim());
				}
			}
		}
		return list;
	}
}