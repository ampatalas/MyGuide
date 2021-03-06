
package com.blstream.myguide;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GastronomyDescriptionTab extends Fragment implements Parcelable {

	private View mView;
	private TextView mDescription;
	private ImageView mImage;
	private String mText;
	private int mTextID;
	private int mImageID;

	public static GastronomyDescriptionTab newInstance() {
		return new GastronomyDescriptionTab();
	}

	public static GastronomyDescriptionTab newInstance(int image, int text) {
		GastronomyDescriptionTab mTabs = new GastronomyDescriptionTab();

		Bundle bundle = new Bundle();
		bundle.putInt(BundleConstants.TAB_TEXT_ID, text);
		bundle.putInt(BundleConstants.TAB_IMAGE_ID, image);
		mTabs.setArguments(bundle);

		return mTabs;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Bundle bundle = getArguments();
		mView = View.inflate(getActivity(), R.layout.tabs, null);

		if (bundle != null) {
			mTextID = bundle.getInt(BundleConstants.TAB_TEXT_ID);
			mImageID = bundle.getInt(BundleConstants.TAB_IMAGE_ID);

			mDescription = (TextView) mView.findViewById(R.id.textDescription);
			mDescription.setMovementMethod(new ScrollingMovementMethod());
			mImage = (ImageView) mView.findViewById(R.id.animal_image);

			mImage.setImageResource(mImageID);
			mText = getResources().getString(mTextID);
			mDescription.setText(mText);
		}

		return mView;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {

	}
}
