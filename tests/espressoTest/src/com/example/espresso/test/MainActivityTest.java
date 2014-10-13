package com.example.espresso.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

import com.example.espresso.MainActivity;
import com.example.espresso.R;

import android.test.ActivityInstrumentationTestCase2;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		// Espresso will not launch our activity for us, we must launch it via
		// getActivity().
		getActivity();
	}

	public void testEmptyId() {
		// IDを空のままログインボタンをクリック
		onView(withId(R.id.button1)).perform(click());
		// ステータス用のTextViewにメッセージが表示されるかチェック
		onView(withId(R.id.textView3)).check(matches(withText("IDが入力されていません")));
	}

	public void testEmptyPassword() {
		// IDを入力
		onView(withId(R.id.editText1)).perform(typeText("yanzm"));
		// Passwordを空のままログインボタンをクリック
		onView(withId(R.id.button1)).perform(click());
		// ステータス用のTextViewにメッセージが表示されるかチェック
		onView(withId(R.id.textView3)).check(
				matches(withText("Passwordが入力されていません")));
	}

	public void testLogin() {
		// IDを入力
		onView(withId(R.id.editText1)).perform(typeText("yanzm"));
		// Passwordを入力
		onView(withId(R.id.editText2)).perform(typeText("1234567890"));
		// ログインボタンをクリック
		onView(withId(R.id.button1)).perform(click());
		// Welcome画面に表示されるかチェック
		onView(withId(R.id.textView1)).check(matches(withText("ようこそyanzmさん")));
	}
}
