
package com.blstream.myguide.zoolocations;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class contains animal names (in various languages), descriptions for
 * adult and child and animal's location in the zoo.
 */
public class Animal extends XmlObject implements Serializable, Comparable<Animal> {

	private int mId;
	private HashMap<String, String> mNames;
	private Node mNode;
	private Description mDescriptionAdult;
	private Description mDescriptionChild;
	private HashMap<String, String> mInfoWebName;
	private boolean mVisited;

	public Animal() {
		mNames = new HashMap<String, String>();
		mInfoWebName = new HashMap<String, String>();
	}

	@Override
	public void addName(String lang, String name) {
		mNames.put(lang, name);
	}

	public void setNames(HashMap<String, String> names) {
		mNames = names;
	}

	public void setNode(Node node) {
		mNode = node;
	}

	public void setDescriptionChild(Description description) {
		mDescriptionChild = description;
	}

	public void setDescriptionAdult(Description description) {
		mDescriptionAdult = description;
	}

	public void setId(int id) {
		mId = id;
	}

	@Override
	public String getName() {
		return mNames.get(Language.DEFAULT);
	}

	public String getName(String language) {
		String name = mNames.get(language);
		if (name == null) { return this.getName(); }
		return name;
	}

	@Override
	public Node getNode() {
		return mNode;
	}

	public Description getDescriptionChild() {
		return mDescriptionChild;
	}

	public Description getDescriptionAdult() {
		return mDescriptionAdult;
	}

	public int getId() {
		return mId;
	}

	public void setVisited(boolean visited) {
		mVisited = visited;
	}

	public boolean getVisited() {
		return mVisited;
	}

	@Override
	public boolean equals(Object other) {
		return ((Animal) other).mId == this.mId;
	}

	@Override
	public int compareTo(Animal another) {
		return -(another.getName().compareTo(getName()));
	}

	public void addInfoWeb(String lang, String text) {
		mInfoWebName.put(lang, text);
	}

	public String getInfoWeb() {
		return mInfoWebName.get(Language.DEFAULT);
	}

	public String getInfoWeb(String language) {
		String infoWeb = mInfoWebName.get(language);
		if (infoWeb == null) { return this.getInfoWeb(); }
		return infoWeb;
	}

	public void setInfoWeb(HashMap<String, String> infoWeb) {
		mInfoWebName = infoWeb;
	}
}
