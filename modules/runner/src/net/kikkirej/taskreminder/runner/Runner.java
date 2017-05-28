package net.kikkirej.taskreminder.runner;

import java.lang.reflect.Method;

public class Runner {

	public static void main(String[] args) {
		try {
			Class<?> klasse = Class.forName("net.kikkirej.taskreminder.Taskreminder");
			Object instance = klasse.newInstance();
			Method method = klasse.getMethod("run");
			method.invoke(instance);
		} catch (Exception e) {
			System.err.println("Start ist fehlgeschlagen... Liegt die Core-Klasse im Classpath?");
			e.printStackTrace();
		}
	}

}
