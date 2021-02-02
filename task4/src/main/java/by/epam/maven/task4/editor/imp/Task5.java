package by.epam.maven.task4.editor.imp;

import java.util.TreeSet;

import by.epam.maven.task4.editor.Task;
import by.epam.maven.task4.entity.PartOfSentence;
import by.epam.maven.task4.entity.imp.Sentence;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.entity.imp.Word;

/*Напечатать слова текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать с красной строки.*/

public class Task5 implements Task {

	@Override
	public String run(Text text) {

		String result = "";

		StringBuilder buffer = new StringBuilder();

		TreeSet<String> listWords = new TreeSet<String>();

		for (Sentence sent : text.getSentences()) {
			for (PartOfSentence part : sent.getSentence()) {
				if (part instanceof Word) {
					listWords.add(((Word) part).getWord().trim());
				}
			}
		}

		char ch = listWords.first().charAt(0);

		for (String str : listWords) {
			if (ch == str.charAt(0)) {
				buffer.append(str).append(", ");
			} else {
				ch = str.charAt(0);
				buffer.append("\n\t").append(str).append(", ");
			}
		}

		result = buffer.toString();
		return result;
	}
}