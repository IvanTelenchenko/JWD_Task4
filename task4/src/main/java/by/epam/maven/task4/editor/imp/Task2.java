package by.epam.maven.task4.editor.imp;

import java.util.HashMap;
import java.util.Map;

import by.epam.maven.task4.editor.Task;
import by.epam.maven.task4.entity.PartOfSentence;
import by.epam.maven.task4.entity.imp.Sentence;
import by.epam.maven.task4.entity.imp.Text;
import by.epam.maven.task4.entity.imp.Word;

/*Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.*/

public class Task2 implements Task {

	public String run(Text text) {

		String result = "";

		HashMap<Sentence, Integer> hm = new HashMap<Sentence, Integer>();

		int count;

		for (Sentence sent : text.getSentences()) {
			count = 0;
			for (PartOfSentence part : sent.getSentence()) {
				if (part instanceof Word) {
					count++;
				}
			}
			hm.put(sent, count);
		}

		int max = 0;
		// find max Value
		for (Map.Entry<Sentence, Integer> item : hm.entrySet()) {
			if (item.getValue().intValue() > max) {
				max = item.getValue().intValue();
			}
		}

		int min = max;

		for (Map.Entry<Sentence, Integer> item : hm.entrySet()) {
			if (item.getValue().intValue() < min) {
				min = item.getValue().intValue();
			}
		}

		StringBuilder buffer = new StringBuilder();

		for (; min <= max; min++) {
			for (Map.Entry<Sentence, Integer> item : hm.entrySet()) {
				if (item.getValue().intValue() == min) {
					buffer.append(item.getKey() + "\n");
				}
			}
		}
		result = buffer.toString();

		return result;
	}
}