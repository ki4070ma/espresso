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
		// ID����̂܂܃��O�C���{�^�����N���b�N
		onView(withId(R.id.button1)).perform(click());
		// �X�e�[�^�X�p��TextView�Ƀ��b�Z�[�W���\������邩�`�F�b�N
		onView(withId(R.id.textView3)).check(matches(withText("ID�����͂���Ă��܂���")));
	}

	public void testEmptyPassword() {
		// ID�����
		onView(withId(R.id.editText1)).perform(typeText("yanzm"));
		// Password����̂܂܃��O�C���{�^�����N���b�N
		onView(withId(R.id.button1)).perform(click());
		// �X�e�[�^�X�p��TextView�Ƀ��b�Z�[�W���\������邩�`�F�b�N
		onView(withId(R.id.textView3)).check(
				matches(withText("Password�����͂���Ă��܂���")));
	}

	public void testLogin() {
		// ID�����
		onView(withId(R.id.editText1)).perform(typeText("yanzm"));
		// Password�����
		onView(withId(R.id.editText2)).perform(typeText("1234567890"));
		// ���O�C���{�^�����N���b�N
		onView(withId(R.id.button1)).perform(click());
		// Welcome��ʂɕ\������邩�`�F�b�N
		onView(withId(R.id.textView1)).check(matches(withText("�悤����yanzm����")));
	}
}
