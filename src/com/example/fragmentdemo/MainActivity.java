package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;

/**
 * 項目的主Activity，所有的Fragment都嵌入在這裡。
 * 
 * @author guolin
 */
public class MainActivity extends Activity implements OnClickListener {

	/**
	 * 用於展示消息的Fragment
	 */
	private MessageFragment messageFragment;

	/**
	 * 用於展示聯繫人的Fragment
	 */
	private ContactsFragment contactsFragment;

	/**
	 * 用於展示動態的Fragment
	 */
	private NewsFragment newsFragment;

	/**
	 * 用於展示設置的Fragment
	 */
	private SettingFragment settingFragment;

	/**
	 * 消息界面佈局
	 */
	private View messageLayout;

	/**
	 * 聯繫人界面佈局
	 */
	private View contactsLayout;

	/**
	 * 動態界面佈局
	 */
	private View newsLayout;

	/**
	 * 設置界面佈局
	 */
	private View settingLayout;

	/**
	 * 在Tab佈局上顯示消息圖標的控件
	 */
	private ImageView messageImage;

	/**
	 * 在Tab佈局上顯示聯繫人圖標的控件
	 */
	private ImageView contactsImage;

	/**
	 * 在Tab佈局上顯示動態圖標的控件
	 */
	private ImageView newsImage;

	/**
	 * 在Tab佈局上顯示設置圖標的控件
	 */
	private ImageView settingImage;

	/**
	 * 在Tab佈局上顯示消息標題的控件
	 */
	private TextView messageText;

	/**
	 * 在Tab佈局上顯示聯繫人標題的控件
	 */
	private TextView contactsText;

	/**
	 * 在Tab佈局上顯示動態標題的控件
	 */
	private TextView newsText;

	/**
	 * 在Tab佈局上顯示設置標題的控件
	 */
	private TextView settingText;

	/**
	 * 用於對Fragment進行管理
	 */
	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		// 初始化佈局元素
		initViews();
		fragmentManager = getFragmentManager();
		// 第一次啟動時選中第0個tab
		setTabSelection(0);
	}

	/**
	 * 在這裡獲取到每個需要用到的控件的實例，並給它們設置好必要的點擊事件。
	 */
	private void initViews() {
		messageLayout = findViewById(R.id.message_layout);
		contactsLayout = findViewById(R.id.contacts_layout);
		newsLayout = findViewById(R.id.news_layout);
		settingLayout = findViewById(R.id.setting_layout);
		messageImage = (ImageView) findViewById(R.id.message_image);
		contactsImage = (ImageView) findViewById(R.id.contacts_image);
		newsImage = (ImageView) findViewById(R.id.news_image);
		settingImage = (ImageView) findViewById(R.id.setting_image);
		messageText = (TextView) findViewById(R.id.message_text);
		contactsText = (TextView) findViewById(R.id.contacts_text);
		newsText = (TextView) findViewById(R.id.news_text);
		settingText = (TextView) findViewById(R.id.setting_text);
		messageLayout.setOnClickListener(this);
		contactsLayout.setOnClickListener(this);
		newsLayout.setOnClickListener(this);
		settingLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.message_layout:
			// 當點擊了消息tab時，選中第1個tab
			setTabSelection(0);
			break;
		case R.id.contacts_layout:
			// 當點擊了聯繫人tab時，選中第2個tab
			setTabSelection(1);
			break;
		case R.id.news_layout:
			// 當點擊了動態tab時，選中第3個tab
			setTabSelection(2);
			break;
		case R.id.setting_layout:
			// 當點擊了設置tab時，選中第4個tab
			setTabSelection(3);
			break;
		default:
			break;
		}
	}

	/**
	 * 根據傳入的index參數來設置選中的tab頁。
	 * 
	 * @param index
	 *            每個tab頁對應的下標。0表示消息，1表示聯繫人，2表示動態，3表示設置。
	 */
	private void setTabSelection(int index) {
		// 每次選中之前先清楚掉上次的選中狀態
		clearSelection();
		// 開啟一個Fragment事務
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 先隱藏掉所有的Fragment，以防止有多個Fragment顯示在界面上的情況
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 當點擊了消息tab時，改變控件的圖片和文字顏色
			messageImage.setImageResource(R.drawable.message_selected);
			messageText.setTextColor(Color.WHITE);
			if (messageFragment == null) {
				// 如果MessageFragment為空，則創建一個並添加到界面上
				messageFragment = new MessageFragment();
				transaction.add(R.id.content, messageFragment);
			} else {
				// 如果MessageFragment不為空，則直接將它顯示出來
				transaction.show(messageFragment);
			}
			break;
		case 1:
			// 當點擊了聯繫人tab時，改變控件的圖片和文字顏色
			contactsImage.setImageResource(R.drawable.contacts_selected);
			contactsText.setTextColor(Color.WHITE);
			if (contactsFragment == null) {
				// 如果ContactsFragment為空，則創建一個並添加到界面上
				contactsFragment = new ContactsFragment();
				transaction.add(R.id.content, contactsFragment);
			} else {
				// 如果ContactsFragment不為空，則直接將它顯示出來
				transaction.show(contactsFragment);
			}
			break;
		case 2:
			// 當點擊了動態tab時，改變控件的圖片和文字顏色
			newsImage.setImageResource(R.drawable.news_selected);
			newsText.setTextColor(Color.WHITE);
			if (newsFragment == null) {
				// 如果NewsFragment為空，則創建一個並添加到界面上
				newsFragment = new NewsFragment();
				transaction.add(R.id.content, newsFragment);
			} else {
				// 如果NewsFragment不為空，則直接將它顯示出來
				transaction.show(newsFragment);
			}
			break;
		case 3:
		default:
			// 當點擊了設置tab時，改變控件的圖片和文字顏色
			settingImage.setImageResource(R.drawable.setting_selected);
			settingText.setTextColor(Color.WHITE);
			if (settingFragment == null) {
				// 如果SettingFragment為空，則創建一個並添加到界面上
				settingFragment = new SettingFragment();
				transaction.add(R.id.content, settingFragment);
			} else {
				// 如果SettingFragment不為空，則直接將它顯示出來
				transaction.show(settingFragment);
			}
			break;
		}
		transaction.commit();
	}

	/**
	 * 清除掉所有的選中狀態。
	 */
	private void clearSelection() {
		messageImage.setImageResource(R.drawable.message_unselected);
		messageText.setTextColor(Color.parseColor("#82858b"));
		contactsImage.setImageResource(R.drawable.contacts_unselected);
		contactsText.setTextColor(Color.parseColor("#82858b"));
		newsImage.setImageResource(R.drawable.news_unselected);
		newsText.setTextColor(Color.parseColor("#82858b"));
		settingImage.setImageResource(R.drawable.setting_unselected);
		settingText.setTextColor(Color.parseColor("#82858b"));
	}

	/**
	 * 將所有的Fragment都置為隱藏狀態。
	 * 
	 * @param transaction
	 *            用於對Fragment執行操作的事務
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (messageFragment != null) {
			transaction.hide(messageFragment);
		}
		if (contactsFragment != null) {
			transaction.hide(contactsFragment);
		}
		if (newsFragment != null) {
			transaction.hide(newsFragment);
		}
		if (settingFragment != null) {
			transaction.hide(settingFragment);
		}
	}
}
