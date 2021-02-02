package by.epam.maven.task4.entity.imp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.epam.maven.task4.entity.PartOfText;

public class CodeBlock implements PartOfText, Serializable {

	private static final long serialVersionUID = 4367409561858511813L;

	private List<String> codeBlock = new ArrayList<String>();

	public CodeBlock(List<String> codeBlock) {
		this.codeBlock = codeBlock;
	}

	public CodeBlock(String str) {
		this.codeBlock.add(str);
	}

	public void addCodeBlock(String code) {
		codeBlock.add(code);
	}

	public void removeCodeBlock(String code) {
		codeBlock.remove(code);
	}

	public List<String> getCodeBlock() {
		return codeBlock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeBlock == null) ? 0 : codeBlock.hashCode());
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
		CodeBlock other = (CodeBlock) obj;
		if (codeBlock == null) {
			if (other.codeBlock != null)
				return false;
		} else if (!codeBlock.equals(other.codeBlock))
			return false;
		return true;
	}

	public String toString() {

		String code = "";
		StringBuilder buffer = new StringBuilder();

		for (String str : codeBlock) {
			buffer.append(str);
		}

		code = buffer.toString();

		return code;
	}
}