package by.epam.maven.task4.editor.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import by.epam.maven.task4.editor.Task;
import by.epam.maven.task4.entity.PartOfSentence;
import by.epam.maven.task4.entity.imp.Sentence;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.entity.imp.Word;

/*Найти наибольшее количество предложений текста, в которых есть одинаковые слова.*/

public class Task1 implements Task {

	public String run(Text text) {

		String result = "";

		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		Integer count;
		String word;

		for (Sentence sent : text.getSentences()) {
			for (PartOfSentence part : sent.getSentence()) {
				if (part instanceof Word) {
					word = ((Word) part).getWord();
					count = hm.get(word);
					hm.put(word, (count == null) ? 1 : count + 1);
				}
			}
		}

		ArrayList<String> words = findWordOccusMoreTimes(hm);

		StringBuilder buffer = new StringBuilder();
		for (String str : words) {
			buffer.append("Для слова \"" + str + "\"\n");
			for (Sentence sent : text.getSentences()) {
				for (PartOfSentence part : sent.getSentence()) {
					if (part instanceof Word) {
						word = ((Word) part).getWord();
						if (word.compareTo(str) == 0) {
							buffer.append(sent).append("\n");
							break;
						}
					}
				}
			}
		}
		result = buffer.toString();
		return result;
	}

	// find the word that occurs more times
	public static ArrayList<String> findWordOccusMoreTimes(HashMap<String, Integer> hm) {

		ArrayList<String> buffer = new ArrayList<String>();
		int count = 0;

		for (Map.Entry<String, Integer> item : hm.entrySet()) {
			if (item.getValue().intValue() > count) {
				count = item.getValue().intValue();
			}
		}

		for (Map.Entry<String, Integer> item : hm.entrySet()) {
			if (item.getValue().intValue() == count) {
				buffer.add(item.getKey());
			}
		}

		return buffer;
	}
}
