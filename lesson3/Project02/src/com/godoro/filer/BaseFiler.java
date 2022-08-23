package com.godoro.filer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseFiler<E> {
	protected String path;
	public final static String DELIMETER = ";";

	public BaseFiler(String path) {
		this.path = path;
	}

	public BaseFiler() {
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void store(List<E> entityList) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		for (E entity : entityList) {
			bw.write(format(entity));
			bw.write("\r\n");
		}
		bw.close();
	}

	public List<E> load() throws IOException {
		List<E> entityList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = null;

		while ((line = br.readLine()) != null) {
			E entity = parse(line);
			entityList.add(entity);
		}
		br.close();
		return entityList;
	}

	protected abstract E parse(String line);

	protected abstract String format(E entity);

}
