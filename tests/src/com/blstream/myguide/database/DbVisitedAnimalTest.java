
package com.blstream.myguide.database;

import android.test.AndroidTestCase;

import com.blstream.myguide.zoolocations.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 2014-05-19.
 */
public class DbVisitedAnimalTest extends AndroidTestCase {

	public void testIsNotVisitedAnimal() {
		DbDataManager dbManager = DbDataManager.getInstance(mContext);
		List<Animal> mAnimalsList = new ArrayList<Animal>();
		Animal animal1 = new Animal();
		animal1.setId(100);
		mAnimalsList.add(animal1);

		dbManager.insertAnimalsListToDb(mAnimalsList);
		dbManager.getIsAnimalVisited(new DbDataManager.OnCheckVisitAnimalListener() {
            @Override
            public void onCheckLoaded(boolean isVisited) {
                assertFalse(isVisited);
            }
        }, mAnimalsList.get(0).getId());
	}
}
